package View;

import Controller.ControllerClients;
import Tools.Path;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import BDDManager.BDDManager2;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class Clients {

    private final Group root;
    private final ControllerClients controllerClients;

    private TextField textFieldNomClient;
    private Text textNomClient;
    private TextField textFieldPrenomClient;
    private Text textPrenomClient;
    private TextField textFieldTelClient;
    private Text texttelClient;
    private Text titreFormulaire;

    private ComboBox boxGenreFilm;

    private Button buttonValider;
    private Button buttonRetour;
    private ImageView quitter;

    public Clients(Group root, ViewHandler vh) {

        this.root = root;
        this.controllerClients = new ControllerClients(this, vh);

        initTextField();
        initButton();
        initCombobox();

    }

    private void initTextField() {
        // Titre
        titreFormulaire = new Text("Ajout client");
        titreFormulaire.setTranslateX(10);
        titreFormulaire.setTranslateY(40);

        // Nom du client
        textFieldNomClient = new TextField();
        textFieldNomClient.setTranslateX(100);
        textFieldNomClient.setTranslateY(100);

        textNomClient = new Text("Nom : ");
        textNomClient.setTranslateX(10);
        textNomClient.setTranslateY(110);
        textNomClient.setFill(Color.rgb(140, 128, 113));

        // Prénom du client
        textFieldPrenomClient = new TextField();
        textFieldPrenomClient.setTranslateX(100);
        textFieldPrenomClient.setTranslateY(140);

        textPrenomClient = new Text("Prénom : ");
        textPrenomClient.setTranslateX(10);
        textPrenomClient.setTranslateY(150);
        textPrenomClient.setFill(Color.rgb(140, 128, 113));

        // Téléphone du client
        textFieldTelClient = new TextField();
        textFieldTelClient.setTranslateX(100);
        textFieldTelClient.setTranslateY(180);

        texttelClient = new Text("Téléphone : ");
        texttelClient.setTranslateX(10);
        texttelClient.setTranslateY(190);
        texttelClient.setFill(Color.rgb(140, 128, 113));

    }

    public void initCombobox() {

        /************* BDD **************/

        BDDManager2 bdd = new BDDManager2();
        bdd.start("jdbc:mysql://localhost:3306/concession?characterEncoding=utf8", "root", "");
        //String queryGenre = ("SELECT Libelle_Genre FROM genre");
        String queryFilm = ("SELECT nom FROM client");
        String queryGenre = ("SELECT * FROM client");

        System.out.println(bdd.select(queryFilm));
        System.out.println(bdd.select(queryGenre));


        /************* VOITURE **************/

        // Une liste de string
        ArrayList<ArrayList<String>> resultatDeMaRequete = new ArrayList<ArrayList<String>>(bdd.select(queryGenre));

        //boxGenre = new ComboBox(FXCollections.observableArrayList(bdd.select(queryGenre)));

        // méthode hashmap <key, value>
        HashMap<String, Integer> tableGenre = new HashMap<>();
        boxGenreFilm = new ComboBox();
        boxGenreFilm.setTranslateX(500);
        boxGenreFilm.setTranslateY(140);

        // Je parcours ma liste de string pour l'ajouter au hashmap
        for (int i = 0; i < resultatDeMaRequete.size(); i++) {

            // j'ai besoin de passer l'id en integer
            int id = Integer.parseInt(resultatDeMaRequete.get(i).get(0));
            tableGenre.put(resultatDeMaRequete.get(i).get(1), id);
        }

        // j'ajoute dans la combobox les clés hashmap qui correspond au libellé
        boxGenreFilm.getItems().addAll(tableGenre.keySet());


        bdd.stop();
    }

    public void initButton() {

        buttonValider = new Button("Valider");
        buttonValider.setTranslateX(100);
        buttonValider.setTranslateY(310);
        buttonValider.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                BDDManager2 insert = new BDDManager2();
                insert.start("jdbc:mysql://localhost:3306/concession?characterEncoding=utf8","root","");
                String queryPrenom = ("INSERT INTO film (`Id_Film`, `Nom_Film`, `Annee_Film`, `Note_Film`, `Resume_film`, `Image_Film`) VALUES (null, \""
                        + textFieldNomClient.getText() + "\",  " + textFieldPrenomClient.getText() + ",  " + textFieldTelClient.getText() + "\" );");
                insert.insert(queryPrenom);
                insert.stop();


            }

        });



        buttonRetour = new Button("Retour");
        buttonRetour.setTranslateY(310);
        buttonRetour.setTranslateX(180);
        buttonRetour.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }

        });

        quitter = new ImageView(Path.buttonQuitter);
        quitter.setTranslateY(10);
        quitter.setTranslateX(10);
        quitter.setCursor(Cursor.HAND);

    }

    public void setVueClients() {
        root.getChildren().clear();

        root.getChildren().add(titreFormulaire);
        root.getChildren().add(textFieldNomClient);
        root.getChildren().add(textNomClient);
        root.getChildren().add(textFieldPrenomClient);
        root.getChildren().add(textPrenomClient);
        root.getChildren().add(textFieldTelClient);
        root.getChildren().add(texttelClient);

        root.getChildren().add(boxGenreFilm);

        root.getChildren().add(buttonValider);
        root.getChildren().add(buttonRetour);
        root.getChildren().add(quitter);
    }

}
