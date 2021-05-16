package View;

import Controller.ControllerClients;
import Tools.Path;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import BDDManager.BDDManager2;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ViewClients {

    private final Group root;
    private final ControllerClients controllerClients;

    private Button bgNav;
    private Integer posX = 70;
    private Integer posy = 190;

    private TextField textFieldNomClient;
    private Text textNomClient;
    private TextField textFieldPrenomClient;
    private Text textPrenomClient;
    private TextField textFieldTelClient;
    private Text texttelClient;
    private Text titreFormulaire;
    private TextField textFieldVoiture;
    private Text textVoiture;

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

    private Button tabClient;
    private Button tabVoiture;

    private ImageView retour;
    private ImageView background;

   private TableView<ArrayList<String>> table;


    public ViewClients(Group root, ViewHandler vh) {

        this.root = root;
        this.controllerClients = new ControllerClients(this, vh);

        initBackground();
        initBackGroundNav();
        initTextField();
        initButton();
        //initCombobox();
        //initTable();
        initTab();

    }

    private void initBackground() {
        background = new ImageView(Path.fondClient);

    }

    private void initBackGroundNav(){
        bgNav = new Button();
        bgNav.setTranslateX(70);
        bgNav.setTranslateY(220);
        bgNav.setMinWidth(420);
        bgNav.setMinHeight(400);
        bgNav.setStyle("-fx-background-color: rgba(116,201,190, 0.8);");}

    private void initTextField() {
        // Titre
        titreFormulaire = new Text("Ajout client");
        titreFormulaire.setTranslateX(posX+10);
        titreFormulaire.setTranslateY(posy+40);

        // Nom du client
        textFieldNomClient = new TextField();
        textFieldNomClient.setTranslateX(posX+100);
        textFieldNomClient.setTranslateY(posy+100);

        textNomClient = new Text("Nom : ");
        textNomClient.setTranslateX(posX+10);
        textNomClient.setTranslateY(posy+110);
        textNomClient.setFill(Color.rgb(140, 128, 113));

        // Prénom du client
        textFieldPrenomClient = new TextField();
        textFieldPrenomClient.setTranslateX(posX+100);
        textFieldPrenomClient.setTranslateY(posy+140);

        textPrenomClient = new Text("Prénom : ");
        textPrenomClient.setTranslateX(posX+10);
        textPrenomClient.setTranslateY(posy+150);
        textPrenomClient.setFill(Color.rgb(140, 128, 113));

        // Téléphone du client
        textFieldTelClient = new TextField();
        textFieldTelClient.setTranslateX(posX+100);
        textFieldTelClient.setTranslateY(posy+180);

        texttelClient = new Text("Téléphone : ");
        texttelClient.setTranslateX(posX+10);
        texttelClient.setTranslateY(posy+190);
        texttelClient.setFill(Color.rgb(140, 128, 113));

        // Voiture
        textFieldVoiture = new TextField();
        textFieldVoiture.setTranslateX(posX+100);
        textFieldVoiture.setTranslateY(posy+220);

        textVoiture = new Text("ID voiture : ");
        textVoiture.setTranslateX(posX+10);
        textVoiture.setTranslateY(posy+230);
        textVoiture.setFill(Color.rgb(140, 128, 113));

    }





    private <table> void initTable(){

        /************* BDD **************/

        BDDManager2 bdd = new BDDManager2();
        bdd.start("jdbc:mysql://localhost:3306/concession?characterEncoding=utf8", "root", "");
        String queryVoiture = ("SELECT vendeur, libelle_constructeur, libelle_model, annee, kilometrage, chevaux, nombre_de_porte, vitesse_max\n" +
                "FROM voiture\n" +
                "INNER JOIN model ON model.id_modele = voiture.id_modele\n" +
                "INNER JOIN constructeur ON constructeur.id_constructeur = voiture.id_constructeur\n" +
                "WHERE stock > 0");

        ArrayList<ArrayList<String>> resultatDeMaRequete = new ArrayList<ArrayList<String>>(bdd.select(queryVoiture));


        table = new TableView<>();
        table.setLayoutX(445);
        table.setLayoutY(131);
        table.setPrefHeight(669);
        table.setPrefWidth(782);

        TableColumn<ArrayList<String>, String> column1 = new TableColumn<>("ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("ID"));
        column1.setPrefWidth(20);

        /*

        TableColumn<table, String> column2 = new TableColumn<>("constructeur");
        column2.setCellValueFactory(new PropertyValueFactory<>("constructeur"));
        column2.setPrefWidth(100);

        TableColumn<table, String> column3 = new TableColumn<>("modele");
        column3.setCellValueFactory(new PropertyValueFactory<>("modele"));
        column3.setPrefWidth(100);

        TableColumn<table, String> column4 = new TableColumn<>("annee");
        column4.setCellValueFactory(new PropertyValueFactory<>("annee"));
        column4.setPrefWidth(69);

        TableColumn<table, String> column5 = new TableColumn<>("kilometrage");
        column5.setCellValueFactory(new PropertyValueFactory<>("kilometrage"));
        column5.setPrefWidth(150);

        TableColumn<table, String> column6 = new TableColumn<>("chevaux");
        column6.setCellValueFactory(new PropertyValueFactory<>("chevaux"));
        column6.setPrefWidth(100);

        TableColumn<table, String> column7 = new TableColumn<>("nb de porte");
        column7.setCellValueFactory(new PropertyValueFactory<>("nb de porte"));
        column7.setPrefWidth(100);

        TableColumn<table, String> column8 = new TableColumn<>("vitesse");
        column8.setCellValueFactory(new PropertyValueFactory<>("vitesse"));
        column8.setPrefWidth(100);

        */


        table.getColumns().add(column1);



        for (int i = 0; i < resultatDeMaRequete.size() ; i++) {
             //constructeur = new Text(resultatDeMaRequete.get(i).get(1));




            table.getItems().add(resultatDeMaRequete.get(i));





        }

    }



    public void initButton() {

        buttonValider = new Button("Valider");
        buttonValider.setTranslateX(posX+100);
        buttonValider.setTranslateY(posy+310);
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

        retour = new ImageView(Path.buttonRetour);
        retour.setTranslateY(10);
        retour.setTranslateX(10);
        retour.setCursor(Cursor.HAND);
        retour.setOnMouseClicked(controllerClients);

    }

    public void initTab() {
        tabClient = new Button("Clients");
        tabClient.setTranslateX(445);
        tabClient.setTranslateY(100);

        tabVoiture = new Button("Voitures");
        tabVoiture.setTranslateX((500));
        tabVoiture.setTranslateY(100);
    }

    public void setVueClients() {
        root.getChildren().clear();

        root.getChildren().add(background);

        root.getChildren().add(bgNav);

        root.getChildren().add(titreFormulaire);
        root.getChildren().add(textFieldNomClient);
        root.getChildren().add(textNomClient);
        root.getChildren().add(textFieldPrenomClient);
        root.getChildren().add(textPrenomClient);
        root.getChildren().add(textFieldTelClient);
        root.getChildren().add(texttelClient);
        root.getChildren().add(textFieldVoiture);
        root.getChildren().add(textVoiture);


        //root.getChildren().addAll(table);

        root.getChildren().addAll(tabClient);
        root.getChildren().addAll(tabVoiture);
        //root.getChildren().addAll(Text);
        //root.getChildren().addAll(TableView);
        

        //root.getChildren().add(boxVoiture);

        root.getChildren().add(buttonValider);
        //root.getChildren().add(buttonRetour);

        root.getChildren().add(retour);

    }
    public ImageView getRetour() { return retour; }


}
