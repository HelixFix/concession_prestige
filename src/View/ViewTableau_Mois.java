package View;

import BDDManager.BDDManager2;
import Controller.ControllerTableauMois;
import Model.Vente;
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

import java.util.ArrayList;

public class ViewTableau_Mois {

    private final Group root;
    private final ControllerTableauMois controllerTableauMois;


    private ImageView retour;
    private ImageView background;
    private Text titre;
    private Button bgNav;
    private Button moin;



    private  Button jour;
    private Button annee;
    private TableView<Vente> table;




    public ViewTableau_Mois(Group root, ViewHandler vh) {

        this.root = root;
        this.controllerTableauMois = new ControllerTableauMois(this, vh);

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
        retour.setOnMouseClicked(controllerTableauMois);


        jour = new Button("Jour");
        jour.setTranslateY(320);
        jour.setPadding(new Insets(20));
        jour.setMinWidth(400);
        jour.setCursor(Cursor.HAND);
        jour.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3em;-fx-font-weight: bold;");
        jour.setOnMouseEntered(t -> jour.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3.5em;-fx-font-weight: bold;"));
        jour.setOnMouseExited(t -> jour.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3em;-fx-font-weight: bold;"));
        jour.setOnMouseClicked(controllerTableauMois);

        annee = new Button("Année");
        annee.setTranslateY(520);
        //buttonClient.setTranslateX(primaryScreenBounds.getWidth() / 2 - 880);
        annee.setPadding(new Insets(20));
        annee.setMinWidth(400);
        annee.setCursor(Cursor.HAND);
        annee.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3em;-fx-font-weight: bold;");
        annee.setOnMouseEntered(t -> annee.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3.5em;-fx-font-weight: bold;"));
        annee.setOnMouseExited(t -> annee.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3em;-fx-font-weight: bold;"));
        annee.setOnMouseClicked(controllerTableauMois);



    }

    private void inittitre(){
        titre = new Text("Vente du Mois");
        titre.setFill(Color.WHITE);
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


    private void initTable() {

        table = new TableView<Vente>();
        table.setLayoutX(470);
        table.setLayoutY(131);
        //table.setPrefHeight(669);
        //table.setPrefWidth(782);

        BDDManager2 bdd = new BDDManager2();
        bdd.start("jdbc:mysql://localhost:3306/concession?characterEncoding=utf8", "root", "");
        String queryVoiture =("SELECT vendeur,libelle_constructeur,libelle_modele ,prix,annee,date FROM voiture \n" +
                "INNER JOIN model \n" +
                "ON model.id_modele = voiture.id_modele  \n" +
                " INNER JOIN constructeur \n" +
                "ON constructeur.id_constructeur = model.id_modele\n" +
                " INNER JOIN acheter \n" +
                "ON voiture.id_voiture = acheter.id_voiture WHERE MONTH(date) = MONTH(CURDATE())");




        ArrayList<ArrayList<String>> resultatDeMaRequete = new ArrayList<>(bdd.select(queryVoiture));




        TableColumn<Vente, String> column0 = new TableColumn<>("Vendeur");
        column0.setCellValueFactory(new PropertyValueFactory<>("vendeur"));
        column0.setPrefWidth(175);

        TableColumn<Vente, String> column1 = new TableColumn<>("libelle_constructeur");
        column1.setCellValueFactory(new PropertyValueFactory<>("libelle_constructeur"));
        column1.setPrefWidth(161);

        TableColumn<Vente, String> column2 = new TableColumn<>("libelle_modele");
        column2.setCellValueFactory(new PropertyValueFactory<>("libelle_modele"));
        column2.setPrefWidth(161);

        TableColumn<Vente, String> column3 = new TableColumn<>("prix");
        column3.setCellValueFactory(new PropertyValueFactory<>("prix"));
        column3.setPrefWidth(69);


        TableColumn<Vente, String> column4 = new TableColumn<>("annee");
        column4.setCellValueFactory(new PropertyValueFactory<>("annee"));
        column4.setPrefWidth(100);

        TableColumn<Vente, String> column5 = new TableColumn<>("date_achat");
        column5.setCellValueFactory(new PropertyValueFactory<>("date"));
         column5.setPrefWidth(90);


        table.getColumns().add(column0);
        table.getColumns().add(column1);
        table.getColumns().add(column2);
        table.getColumns().add(column3);
        table.getColumns().add(column4);
        table.getColumns().add(column5);


        // table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        System.out.println(resultatDeMaRequete);
        System.out.println(bdd.select(queryVoiture));

        for (int i = 0; i < resultatDeMaRequete.size(); i++) {





            table.getItems().add(new Vente (resultatDeMaRequete.get(i).get(0), resultatDeMaRequete.get(i).get(1), resultatDeMaRequete.get(i).get(2), resultatDeMaRequete.get(i).get(3),resultatDeMaRequete.get(i).get(4),resultatDeMaRequete.get(i).get(5)));



        }
    }



    // LA VUE

    public void setVueMois() {
        root.getChildren().clear();
        root.getChildren().add(background);
        root.getChildren().add(bgNav);
        root.getChildren().add(titre);
        root.getChildren().add(retour);
        root.getChildren().add(jour);
        root.getChildren().add(annee);
        root.getChildren().add(table);







    }

    public ImageView getRetour() {
        return retour; }

    public Button getJour() {
        return jour;
    }

    public Button getAnnee() {
        return annee;
    }
}
