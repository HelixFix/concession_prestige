package View;

import Controller.ControllerClients;
import Tools.Path;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import BDDManager.BDDManager2;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;

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

    private Text constructeur;
    private Text modele;
    private Text annee;
    private Text kilometrage;
    private Text chevaux;
    private Text nbPorte;
    private Text vitesse;

    private ComboBox boxVoiture;

    private Button buttonValider;
    private Button buttonRetour;

    private ImageView quitter;
    private ImageView background;
    private Object Text;

    public Clients(Group root, ViewHandler vh) {

        this.root = root;
        this.controllerClients = new ControllerClients(this, vh);

        initBackground();
        initTextField();
        initButton();
        initCombobox();

    }

    private void initBackground() {
        background = new ImageView(Path.fondClient);

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
        String queryVoiture = ("SELECT id_voiture, libelle_constructeur, libelle_model, annee, kilometrage, chevaux, nombre_de_porte, vitesse_max\n" +
                "FROM voiture\n" +
                "INNER JOIN model ON model.id_modele = voiture.id_modele\n" +
                "INNER JOIN constructeur ON constructeur.id_constructeur = voiture.id_constructeur\n" +
                "WHERE stock > 0");

        System.out.println(bdd.select(queryVoiture));


        /************* VOITURE **************/


        // Une liste de string
        ArrayList<ArrayList<String>> resultatDeMaRequete = new ArrayList<ArrayList<String>>(bdd.select(queryVoiture));
/*
        //boxGenre = new ComboBox(FXCollections.observableArrayList(bdd.select(queryGenre)));

        // méthode hashmap <key, value>
        HashMap<String, Integer> tableVoiture = new HashMap<>();
        boxVoiture = new ComboBox();
        boxVoiture.setTranslateX(500);
        boxVoiture.setTranslateY(140);

        // Je parcours ma liste de string pour l'ajouter au hashmap
        for (int i = 0; i < resultatDeMaRequete.size(); i++) {

            // j'ai besoin de passer l'id en integer
            int id = Integer.parseInt(resultatDeMaRequete.get(i).get(0));
            tableVoiture.put(resultatDeMaRequete.get(i).get(1), id);
        }

        // j'ajoute dans la combobox les clés hashmap qui correspond au libellé
        boxVoiture.getItems().addAll(tableVoiture.keySet());
*/

        int posYConstructeur = 140;
        int posYModele = 140;
        int posYAnnee = 140;
        int posYKilometrage = 140;
        int posYChevaux = 140;
        int posYnbPorte = 140;
        int posYVitesse = 140;

        constructeur = new Text(500,posYConstructeur,"Constructeur");


        for (int i = 0; i < resultatDeMaRequete.size() ; i++) {
            Text constructeur = new Text(500,posYConstructeur+=20,resultatDeMaRequete.get(i).get(1));

            constructeur = new Text(500,posYConstructeur+=20,resultatDeMaRequete.get(i).get(1));
            modele = new Text(550,posYModele+=20,resultatDeMaRequete.get(i).get(2));
            annee = new Text(600,posYAnnee+=20,resultatDeMaRequete.get(i).get(3));
            kilometrage = new Text(650,posYKilometrage+=20,resultatDeMaRequete.get(i).get(4));
            chevaux = new Text(700,posYChevaux+=20,resultatDeMaRequete.get(i).get(5));
            nbPorte = new Text(750,posYnbPorte+=20,resultatDeMaRequete.get(i).get(6));
            vitesse = new Text(800,posYVitesse+=20,resultatDeMaRequete.get(i).get(7));

            //System.out.println(resultatDeMaRequete.get(i).get(2));

        }

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
                String queryClient = ("INSERT INTO client (`id_client`, `nom`, `prenom`, `telephone`) VALUES (null, \""
                        + textFieldNomClient.getText() + "\",  \"" + textFieldPrenomClient.getText() + "\",  " + textFieldTelClient.getText() + "  );");
                insert.insert(queryClient);
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

        root.getChildren().add(background);

        root.getChildren().add(titreFormulaire);
        root.getChildren().add(textFieldNomClient);
        root.getChildren().add(textNomClient);
        root.getChildren().add(textFieldPrenomClient);
        root.getChildren().add(textPrenomClient);
        root.getChildren().add(textFieldTelClient);
        root.getChildren().add(texttelClient);

        root.getChildren().add(constructeur);
        root.getChildren().add(modele);
        root.getChildren().add(annee);
        root.getChildren().add(kilometrage);
        root.getChildren().add(chevaux);
        root.getChildren().add(nbPorte);
        root.getChildren().add(vitesse);
        //root.getChildren().addAll(Text);
        

        //root.getChildren().add(boxVoiture);

        root.getChildren().add(buttonValider);
        root.getChildren().add(buttonRetour);

        root.getChildren().add(quitter);

    }

}
