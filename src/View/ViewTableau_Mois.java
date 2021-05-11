package View;

import Controller.ControllerTableauVenteMois;
import Tools.Path;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class ViewTableau_Mois {



    private final Group root;

    private final ControllerTableauVenteMois controllerTableauVenteMois;

    private ImageView retour;
    private ImageView background;
    private Text titre;
    private Button bgNav;


    private TableView table;
    private TableColumn Vendeur;
    private  Button semaine;

    private Button annee;


    public ViewTableau_Mois(Group root, ViewHandler vh ) {

        this.root = root;
        this.controllerTableauVenteMois = new ControllerTableauVenteMois(this, vh);
        initButtons();
        initBackGroundNav();
        initBackground();
        initTable();
        inittitre();
    }

    private void initButtons() {

        retour = new ImageView(Path.buttonQuitter);
        retour.setTranslateY(10);
        retour.setTranslateX(10);
        retour.setCursor(Cursor.HAND);
        retour.setOnMouseClicked(controllerTableauVenteMois);


        semaine = new Button("Semaine");
        semaine.setTranslateY(320);
        //buttonGarage.setTranslateX(primaryScreenBounds.getWidth() / 2 - 880);
        semaine.setPadding(new Insets(20));
        semaine.setMinWidth(400);
        semaine.setCursor(Cursor.HAND);
        semaine.setOnMouseEntered(t -> semaine.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3.5em;-fx-font-weight: bold;"));
        semaine.setOnMouseExited(t -> semaine.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3em;-fx-font-weight: bold;"));
        semaine.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3em;-fx-font-weight: bold;");
        semaine.setOnMouseClicked(controllerTableauVenteMois);


        annee = new Button("Année");
        annee.setTranslateY(520);
        //buttonClient.setTranslateX(primaryScreenBounds.getWidth() / 2 - 880);
        annee.setPadding(new Insets(20));
        annee.setMinWidth(400);
        annee.setCursor(Cursor.HAND);
        annee.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3em;-fx-font-weight: bold;");
        annee.setOnMouseEntered(t -> annee.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3.5em;-fx-font-weight: bold;"));
        annee.setOnMouseExited(t -> annee.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3em;-fx-font-weight: bold;"));
        annee.setOnMouseClicked(controllerTableauVenteMois);



    }

    private void inittitre(){
        titre = new Text("Vente du mois");
        titre.setFill(Color.RED);
        titre.setTranslateY(60);
        titre.setTranslateX(600);
        titre.setFont(Font.font("Arial",32));


    }

    private void initBackground() {
        background = new ImageView(Path.fondVente);
        background.setFitHeight(1200);
        background.setFitWidth(1280);

    }
    private void initBackGroundNav() {
        bgNav = new Button();
        bgNav.setTranslateY(227);
        bgNav.setTranslateX(15);
        bgNav.setMinWidth(420);
        bgNav.setMinHeight(400);
        bgNav.setStyle("-fx-background-color: rgba(116,201,190, 0.8);");

    }

    private <table> void initTable(){

        table = new TableView();
        table.setLayoutX(470);
        table.setLayoutY(131);
        table.setPrefHeight(669);
        table.setPrefWidth(782);

        TableColumn<table, String> column1 = new TableColumn<>("Vendeur");
        column1.setCellValueFactory(new PropertyValueFactory<>("Vendeur"));
        column1.setPrefWidth(175);

        TableColumn<table, String> column2 = new TableColumn<>("constructeur");
        column2.setCellValueFactory(new PropertyValueFactory<>("constructeur"));
        column2.setPrefWidth(193);

        TableColumn<table, String> column3 = new TableColumn<>("modele");
        column3.setCellValueFactory(new PropertyValueFactory<>("modele"));
        column3.setPrefWidth(161);

        TableColumn<table, String> column4 = new TableColumn<>("prix");
        column4.setCellValueFactory(new PropertyValueFactory<>("prix"));
        column4.setPrefWidth(69);

        TableColumn<table, String> column5 = new TableColumn<>("annee");
        column5.setCellValueFactory(new PropertyValueFactory<>("annee"));
        column5.setPrefWidth(183);

        table.getColumns().add(column1);
        table.getColumns().add(column2);
        table.getColumns().add(column3);
        table.getColumns().add(column4);
        table.getColumns().add(column5);
    }


    // LA VUE
    public void setVueTableauMois() {
        root.getChildren().clear();

        root.getChildren().add(background);
        root.getChildren().add(titre);
        root.getChildren().add(retour);
        root.getChildren().add(bgNav);
        root.getChildren().add(table);
        root.getChildren().add(semaine);
        root.getChildren().add(annee);

    }

    public ImageView getRetour() {
        return retour; }

    public Button getSemaine() {
        return semaine;
    }



    public Button getAnnee() {
        return annee;
    }


}
