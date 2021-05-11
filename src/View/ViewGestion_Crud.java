package View;

import BDDManager.BDDManager2;
import Controller.ControllerCrud;
import Tools.Path;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ViewGestion_Crud {
    private final Group root;
    private Text kilometre;
    private ComboBox<String> comboBoxModel;
    private ComboBox comboBoxConstructeur;
    private final ControllerCrud controllerCrud;
    private ImageView background;
    private Text prix;
    private Text vMax;
    private Text chevaux;
    private Text annee;
    private Text couleur;
    private Text nombreDePorte;
    private Button bgNav;
    private Text constructeur;
    private Text model;
    private ImageView retour;
    private ArrayList<ArrayList<String>> listeModel;
    private ArrayList<ArrayList<String>> listeConstructeur;
    private TextField textFieldAnnee;
    private TextField textFieldVMax;
    private TextField textFieldNbChevaux;
    private TextField textFieldNbPorte;
    private TextField textFieldCouleur;
    private TextField textFieldPrix;
    private TextField textFieldKilometres;
    private Text stock;
    private Button valider;
    private TextField textFieldStock;

    public ViewGestion_Crud(Group root, ViewHandler vh) {
        this.root = root;
        this.controllerCrud = new ControllerCrud(this, vh);
        initBackground();
        initBackGroundNav();
        initButtons();
        initComboBoxModel();
        initComboBoxConstructeur();
    }

    private void initBackground() {
        background = new ImageView(Path.fondGestion_Ajout);

    }


    private void initBackGroundNav() {
        bgNav = new Button();
        bgNav.setTranslateY(80);
        bgNav.setTranslateX(70);
        bgNav.setMinWidth(1120);
        bgNav.setMinHeight(650);
        bgNav.setStyle("-fx-background-color: rgba(61,74,89, 0.9);");

    }


    private void initButtons() {
        retour = new ImageView(Path.buttonRetour);
        retour.setTranslateY(10);
        retour.setTranslateX(10);
        retour.setCursor(Cursor.HAND);
        retour.setOnMouseClicked(controllerCrud);


        constructeur = new Text("Constructeur :");
        constructeur.setTranslateY(200);
        constructeur.setTranslateX(100);
        constructeur.setFill(Color.WHITE);
        constructeur.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");


        model = new Text("Modèle :");
        model.setTranslateY(300);
        model.setTranslateX(100);
        model.setFill(Color.WHITE);
        model.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");



        prix = new Text("Prix :");
        prix.setTranslateY(400);
        prix.setTranslateX(100);
        prix.setFill(Color.WHITE);
        prix.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");


        vMax = new Text("Vitesse Max :");
        vMax.setTranslateY(500);
        vMax.setTranslateX(100);
        vMax.setFill(Color.WHITE);
        vMax.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");

        chevaux = new Text("Chevaux :");
        chevaux.setTranslateY(600);
        chevaux.setTranslateX(100);
        chevaux.setFill(Color.WHITE);
        chevaux.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");

        annee = new Text("Année :");
        annee.setTranslateY(400);
        annee.setTranslateX(600);
        annee.setFill(Color.WHITE);
        annee.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");

        couleur = new Text("Couleur :");
        couleur.setTranslateY(300);
        couleur.setTranslateX(600);
        couleur.setFill(Color.WHITE);
        couleur.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");


        nombreDePorte = new Text("Nombre de portes :");
        nombreDePorte.setTranslateY(200);
        nombreDePorte.setTranslateX(600);
        nombreDePorte.setFill(Color.WHITE);
        nombreDePorte.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");

        kilometre = new Text("Kilométrage :");
        kilometre.setTranslateY(500);
        kilometre.setTranslateX(600);
        kilometre.setFill(Color.WHITE);
        kilometre.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");

        stock = new Text("Stock :");
        stock.setTranslateY(600);
        stock.setTranslateX(600);
        stock.setFill(Color.WHITE);
        stock.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");


        textFieldPrix = new TextField();
        textFieldPrix.setTranslateY(374);
        textFieldPrix.setTranslateX(320);
        textFieldPrix.setMinWidth(230);

        textFieldVMax = new TextField();
        textFieldVMax.setTranslateY(474);
        textFieldVMax.setTranslateX(320);
        textFieldVMax.setMinWidth(230);

        textFieldNbChevaux = new TextField();
        textFieldNbChevaux.setTranslateY(574);
        textFieldNbChevaux.setTranslateX(320);
        textFieldNbChevaux.setMinWidth(230);

        textFieldNbPorte = new TextField();
        textFieldNbPorte.setTranslateY(174);
        textFieldNbPorte.setTranslateX(890);
        textFieldNbPorte.setMinWidth(230);

        textFieldCouleur = new TextField();
        textFieldCouleur.setTranslateY(274);
        textFieldCouleur.setTranslateX(890);
        textFieldCouleur.setMinWidth(230);

        textFieldAnnee = new TextField();
        textFieldAnnee.setTranslateY(374);
        textFieldAnnee.setTranslateX(890);
        textFieldAnnee.setMinWidth(230);

        textFieldKilometres = new TextField();
        textFieldKilometres.setTranslateY(474);
        textFieldKilometres.setTranslateX(890);
        textFieldKilometres.setMinWidth(230);

        textFieldStock = new TextField();
        textFieldStock.setTranslateY(574);
        textFieldStock.setTranslateX(890);
        textFieldStock.setMinWidth(230);


        valider = new Button("Valider");
        valider.setTranslateY(650);
        valider.setTranslateX(550);
        valider.setMinWidth(150);
        valider.setMinHeight(50);
        valider.setStyle("-fx-background-color: rgba(82,157,193, 0.9); -fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");
        valider.setOnMouseEntered(t -> valider.setStyle("-fx-background-color: rgba(82,157,193, 1); ; -fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;"));
        valider.setOnMouseExited(t -> valider.setStyle("-fx-background-color: rgba(82,157,193, 0.9) ; -fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;"));
        valider.setCursor(Cursor.HAND);

    }



    public void initComboBoxModel() {
        comboBoxModel = new ComboBox();
        comboBoxModel.setTranslateX(320);
        comboBoxModel.setTranslateY(274);
        comboBoxModel.setMinWidth(230);
        comboBoxModel.setPrefHeight(28);

        BDDManager2 bddManager2 = new BDDManager2();
        bddManager2.start("jdbc:mysql://localhost:3306/concession", "root", "");
        listeModel = bddManager2.select("SELECT Libelle_model FROM model;");
        bddManager2.stop();
        for (int i = 0; i < listeModel.size(); i++) {
            comboBoxModel.getItems().addAll(listeModel.get(i));
        }


    }


    public void initComboBoxConstructeur() {
        comboBoxConstructeur = new ComboBox();
        comboBoxConstructeur.setTranslateX(320);
        comboBoxConstructeur.setTranslateY(174);
        comboBoxConstructeur.setMinWidth(230);
        comboBoxConstructeur.setPrefHeight(28);

        BDDManager2 bddManager2 = new BDDManager2();
        bddManager2.start("jdbc:mysql://localhost:3306/concession", "root", "");
        listeConstructeur = bddManager2.select("SELECT Libelle_constructeur FROM constructeur;");
        bddManager2.stop();
        for (int i = 0; i < listeConstructeur.size(); i++) {
            comboBoxConstructeur.getItems().addAll(listeConstructeur.get(i));
        }

    }


    public ImageView getRetour() {
            return retour;
        }





    public void setVueCompleteCrud() {
        root.getChildren().clear();
        root.getChildren().add(background);
        root.getChildren().add(bgNav);
        root.getChildren().add(prix);
        root.getChildren().add(vMax);
        root.getChildren().add(annee);
        root.getChildren().add(chevaux);
        root.getChildren().add(model);
        root.getChildren().add(constructeur);
        root.getChildren().add(retour);
        root.getChildren().add(couleur);
        root.getChildren().add(nombreDePorte);
        root.getChildren().add(kilometre);
        root.getChildren().add(stock);
        root.getChildren().add(comboBoxModel);
        root.getChildren().add(comboBoxConstructeur);
        root.getChildren().add(textFieldPrix);
        root.getChildren().add(textFieldVMax);
        root.getChildren().add(textFieldNbChevaux);
        root.getChildren().add(textFieldNbPorte);
        root.getChildren().add(textFieldCouleur);
        root.getChildren().add(textFieldAnnee);
        root.getChildren().add(textFieldKilometres);
        root.getChildren().add(textFieldStock);
        root.getChildren().add(valider);





    }
}
