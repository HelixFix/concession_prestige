package View;

import Controller.ControllerClients;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import BDDManager.BDDManager2;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class Clients {

    private final Group root;
    private final ControllerClients controllerClients;

    private TextField textFieldNomFilm;
    private Text textNomFilm;
    private TextField textFieldAnneeFilm;
    private Text textAnneeFilm;
    private TextField textFieldNoteFilm;
    private Text textNoteFilm;
    private TextField textFieldResumeFilm;
    private Text textResumeFilm;
    private Text titreFormulaire;

    private ComboBox boxGenreFilm;

    private Button buttonValider;
    private Button buttonRetour;

    public Clients(Group root, ViewHandler vh) {

        this.root = root;
        this.controllerClients = new ControllerClients(this, vh);

        initTextField();
        initButton();
        initCombobox();

    }

    private void initTextField() {
        // Titre
        titreFormulaire = new Text("Edition film");
        titreFormulaire.setTranslateX(10);
        titreFormulaire.setTranslateY(40);

        // Nom du film
        textFieldNomFilm = new TextField();
        textFieldNomFilm.setTranslateX(100);
        textFieldNomFilm.setTranslateY(100);

        textNomFilm = new Text("Nom : ");
        textNomFilm.setTranslateX(10);
        textNomFilm.setTranslateY(110);
        textNomFilm.setFill(Color.rgb(140, 128, 113));

        // Annee du film
        textFieldAnneeFilm = new TextField();
        textFieldAnneeFilm.setTranslateX(100);
        textFieldAnneeFilm.setTranslateY(140);

        textAnneeFilm = new Text("Annee : ");
        textAnneeFilm.setTranslateX(10);
        textAnneeFilm.setTranslateY(150);
        textAnneeFilm.setFill(Color.rgb(140, 128, 113));

        // Note du film
        textFieldNoteFilm = new TextField();
        textFieldNoteFilm.setTranslateX(100);
        textFieldNoteFilm.setTranslateY(180);

        textNoteFilm = new Text("Note : ");
        textNoteFilm.setTranslateX(10);
        textNoteFilm.setTranslateY(190);
        textNoteFilm.setFill(Color.rgb(140, 128, 113));

        // Resume du film
        textFieldResumeFilm = new TextField();
        textFieldResumeFilm.setTranslateX(100);
        textFieldResumeFilm.setTranslateY(220);

        textResumeFilm = new Text("Résumé : ");
        textResumeFilm.setTranslateX(10);
        textResumeFilm.setTranslateY(230);

        textResumeFilm.setFill(Color.rgb(140, 128, 113));


    }

    public void initCombobox() {

        /************* BDD **************/

        BDDManager2 bdd = new BDDManager2();
        bdd.start("jdbc:mysql://localhost:3306/dvdtheque?characterEncoding=utf8", "root", "");
        //String queryGenre = ("SELECT Libelle_Genre FROM genre");
        String queryFilm = ("SELECT Nom_Film FROM film");
        String queryGenre = ("SELECT * FROM genre");

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
                        + textFieldNomFilm.getText() + "\",  " + textFieldAnneeFilm.getText() + ",  " + textFieldNoteFilm.getText() + ",  \"" + textFieldResumeFilm.getText() + "\",  \"\" );");
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

    }

    public void setVueClients() {
        root.getChildren().clear();

        root.getChildren().add(titreFormulaire);
        root.getChildren().add(textFieldNomFilm);
        root.getChildren().add(textNomFilm);
        root.getChildren().add(textFieldAnneeFilm);
        root.getChildren().add(textAnneeFilm);
        root.getChildren().add(textFieldNoteFilm);
        root.getChildren().add(textNoteFilm);
        root.getChildren().add(textFieldResumeFilm);
        root.getChildren().add(textResumeFilm);

        root.getChildren().add(boxGenreFilm);

        root.getChildren().add(buttonValider);
        root.getChildren().add(buttonRetour);
    }

}
