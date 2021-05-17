package View;

import BDDManager.BDDManager2;
import Controller.ControllerGarage;
import Model.Garage;
import Tools.Path;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Screen;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class   ViewGarage {

    private final Group root;
    private final ControllerGarage controllerGarage;

    private Button retour;

    private Button btnValider;
    private TextField t1;

    private static final Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds();

    private static final String boutons = "-fx-background-color: rgb(50,50,50,0.5);" +
            "-fx-font-size: 2em;" +
            "-fx-border-insets: -1 -1 -1 -1;" +
            "-fx-border-color: -fx-text-box-border; " +
            "-fx-border-width: 2; " +
            "-fx-border-radius: 10px; " +
            "-fx-color: black; " +
            "-fx-font-family: Impact, \"Arial Black\", Arial, Verdana, sans-serif;";
    private ImageView background;
    private Button bgNav;
    private Text txtModel;
    private Text txtConstructeur;

    private ComboBox<Object> comboConstructeur;
    private ComboBox<Object> comboModel;
    private ArrayList<ArrayList<String>> listeConstructeur;
    private ArrayList<ArrayList<String>> listeModel;
    private Button validerConstructeur;
    private int idConstructeur;
    private TableView<Garage> tableVoiture;



    // OnCreate

    public ViewGarage(Group root, ViewHandler vh) {

        this.root = root;
        this.controllerGarage = new ControllerGarage(this, vh);

        initButtons();
        initChamp();
        initBackground();
        initBackGroundNav();
        initText();
        initCombobox();
        initComboboxModel();
        // initTableVoiture();

    }

    private void initCombobox() {
        //  BDDManager2 bdd = new BDDManager2();
        // bdd.start("jdbc:mysql://localhost:3306/concession?characterEncoding=utf8", "root", "");
        // String queryVoiture = ("SELECT  libelle_constructeur  FROM constructeur ");
        // String queryVoiture2= ("SELECT  libelle_modele FROM model");
        // ArrayList<ArrayList<String>> resultatDeMaRequete = bdd.select(queryVoiture);
        comboConstructeur = new ComboBox<>();
        comboConstructeur.setLayoutX(100);
        comboConstructeur.setLayoutY(250);


        BDDManager2 bddManager2 = new BDDManager2();
        bddManager2.start("jdbc:mysql://localhost:3306/concession?characterEncoding=utf8", "root", "");
        listeConstructeur = bddManager2.select("SELECT * FROM constructeur;");
        bddManager2.stop();
        for (int i = 0; i < listeConstructeur.size(); i++) {
            comboConstructeur.getItems().addAll(listeConstructeur.get(i).get(1));


        }






    }
    private void initTableVoiture() {

        /************* BDD **************/

        BDDManager2 bdd = new BDDManager2();
        bdd.start("jdbc:mysql://localhost:3306/concession?characterEncoding=utf8", "root", "");
        String queryVoiture = ("SELECT id_voiture ,annee,kilometrage,chevaux, nombre_de_porte, couleur, vitesse_max, prix \n" +
                "FROM voiture\n" +
                "INNER JOIN model ON model.id_modele = voiture.id_modele\n" +
                "INNER JOIN constructeur ON model.id_constructeur = constructeur.id_constructeur\n" +

                "WHERE stock > 0\n" +
                "AND libelle_modele=" + comboModel.getValue());
        System.out.println(bdd.select(queryVoiture));

        ArrayList<ArrayList<String>> resultatDeMaRequete = new ArrayList<>(bdd.select(queryVoiture));


        /************* TableView **************/

        tableVoiture = new TableView<Garage>();
        tableVoiture.setLayoutX(445);
        tableVoiture.setLayoutY(131);
        tableVoiture.setPrefHeight(669);
        tableVoiture.setPrefWidth(782);

        TableColumn<Garage, String> column1 = new TableColumn<>("ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));
        column1.setPrefWidth(20);

        TableColumn<Garage, String> column2 = new TableColumn<>("couleur");
        column2.setCellValueFactory(new PropertyValueFactory<>("constructeur"));
        column2.setPrefWidth(100);

        TableColumn<Garage, String> column3 = new TableColumn<>("vitesse_max");
        column3.setCellValueFactory(new PropertyValueFactory<>("modele"));
        column3.setPrefWidth(100);

        TableColumn<Garage, String> column4 = new TableColumn<>("annee");
        column4.setCellValueFactory(new PropertyValueFactory<>("annee"));
        column4.setPrefWidth(69);

        TableColumn<Garage, String> column5 = new TableColumn<>("kilometrage");
        column5.setCellValueFactory(new PropertyValueFactory<>("kilometrage"));
        column5.setPrefWidth(150);

        TableColumn<Garage, String> column6 = new TableColumn<>("chevaux");
        column6.setCellValueFactory(new PropertyValueFactory<>("chevaux"));
        column6.setPrefWidth(100);

        TableColumn<Garage, String> column7 = new TableColumn<>("nb de porte");
        column7.setCellValueFactory(new PropertyValueFactory<>("nbPorte"));
        column7.setPrefWidth(100);



        tableVoiture.getColumns().add(column1);
        tableVoiture.getColumns().add(column2);
        tableVoiture.getColumns().add(column3);
        tableVoiture.getColumns().add(column4);
        tableVoiture.getColumns().add(column5);
        tableVoiture.getColumns().add(column6);
        tableVoiture.getColumns().add(column7);



        for (int i = 0; i < resultatDeMaRequete.size(); i++) {


            System.out.println("test1" + resultatDeMaRequete.get(i));

            tableVoiture.getItems().add(new Garage(resultatDeMaRequete.get(i).get(0), resultatDeMaRequete.get(i).get(1), resultatDeMaRequete.get(i).get(2), resultatDeMaRequete.get(i).get(3), resultatDeMaRequete.get(i).get(4), resultatDeMaRequete.get(i).get(5), resultatDeMaRequete.get(i).get(6) ));

            System.out.println("nb de porte : " + resultatDeMaRequete.get(i).get(6));
        }

        // TODO: 12/05/2021
        // Récupéré l'ID au clique et l'insérer dans le champ dédié
        // Changer de tableau via les Tabs
        // update stock -1 quand vendu
    }
    private void initComboboxModel() {
        comboModel = new ComboBox<>();
        comboModel.setLayoutX(100);
        comboModel.setLayoutY(450);


        }







        private void initText() {
        txtConstructeur = new Text("CONSTRUCTEUR :");
        txtConstructeur.setTranslateX(100);
        txtConstructeur.setTranslateY(250);


        txtModel = new Text("MODELE:" );
        txtModel.setLayoutX(100);
        txtModel.setLayoutY(450);
        txtModel.setStyle("-fx-background-color: rgba(50,150,25, 0.8);");
    }

    private void initBackGroundNav(){
        bgNav = new Button();
        bgNav.setTranslateY(220);
        bgNav.setTranslateX(70);
        bgNav.setMinWidth(420);
        bgNav.setMinHeight(400);
        bgNav.setStyle("-fx-background-color: rgba(116,201,190, 0.8);");}

    private void initBackground() {
        background = new ImageView(Path.fondGarage);

    }

    private void initButtons() {

        validerConstructeur = new Button("Valider");
        validerConstructeur.setTranslateY(250);
        validerConstructeur.setTranslateX(275);
        validerConstructeur.setMinWidth(80);
        validerConstructeur.setMinHeight(20);
        validerConstructeur.setStyle("-fx-background-color: rgba(82,157,193, 0.9); -fx-text-fill: white ;-fx-font-size: 1em;-fx-font-weight: bold;");
        validerConstructeur.setOnMouseEntered(t -> validerConstructeur.setStyle("-fx-background-color: rgba(82,157,193, 1); ; -fx-text-fill: white ;-fx-font-size: 1em;-fx-font-weight: bold;"));
        validerConstructeur.setOnMouseExited(t -> validerConstructeur.setStyle("-fx-background-color: rgba(82,157,193, 0.9) ; -fx-text-fill: white ;-fx-font-size: 1em;-fx-font-weight: bold;"));
        validerConstructeur.setCursor(Cursor.HAND);

        validerConstructeur.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                BDDManager2 bddManager2 = new BDDManager2();
                bddManager2.start("jdbc:mysql://localhost:3306/concession?characterEncoding=utf8", "root", "");
                listeModel = bddManager2.select("SELECT * FROM model;");
                bddManager2.stop();
                comboModel.getItems().clear();


                for (int i = 0; i < listeConstructeur.size(); i++) {
                    if (listeConstructeur.get(i).get(1) == comboConstructeur.getValue()) {

                        idConstructeur = parseInt(listeConstructeur.get(i).get(0));

                    }


                }

                for (int i = 0; i < listeModel.size(); i++) {

                    if (parseInt(listeModel.get(i).get(2)) == idConstructeur) {
                        comboModel.getItems().addAll(listeModel.get(i).get(1));
                    }
                }
            }
        });

        retour = new Button("Retour");
        retour.setTranslateY(10);
        retour.setTranslateX(10);
        retour.setStyle(boutons);
        retour.setPadding(new Insets(20));
        retour.setMinWidth(100);
        retour.setOnMouseClicked(controllerGarage);


        btnValider = new Button("Valider");
        btnValider.setTranslateY(510);
        btnValider.setTranslateX(200);
        btnValider.setStyle(boutons);
        btnValider.setPadding(new Insets(10));








        btnValider.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               initTableVoiture();

                root.getChildren().add(tableVoiture);

            }
        });
    }

    private void initChamp(){

        //t1 = new TextField("Nationalité");
       // t1.setTranslateY(primaryScreenBounds.getHeight() / 2 - 100);
       // t1.setTranslateX(primaryScreenBounds.getWidth() / 2 - 100);
       // t1.setFont(Font.font(15));
    }

    // LA VUE

    public void setVueNationalite() {
        root.getChildren().clear();
        root.getChildren().add(background);
        root.getChildren().add(bgNav);
        root.getChildren().add(retour);
        root.getChildren().add(btnValider);
      //  root.getChildren().add(t1);
        root.getChildren().add(txtModel);
        root.getChildren().add(txtConstructeur);
        root.getChildren().add(comboConstructeur);
        root.getChildren().add(comboModel);
        root.getChildren().add(validerConstructeur);
        // root.getChildren().add(tableVoiture);




    }

    public Button getRetour() { return retour; }
}