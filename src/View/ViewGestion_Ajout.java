package View;

import BDDManager.BDDManager2;
import Controller.ControllerAjout;
import Tools.Path;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ViewGestion_Ajout {
    private ViewGestion_Ajout vga;
    private final Group root;
    private ViewHandler vh;
    private ControllerAjout controllerAjout;
    private ImageView background;
    private ImageView retour;
    private Text constructeur;
    private Text model;
    private Button bgNav;
    private TextField fieldModel;
    private TextField fieldConstructeur;
    private Button valider;
    private Button valider2;



    public ImageView getRetour() {
        return retour;
    }

    public ViewGestion_Ajout(Group root, ViewHandler vh) {
        this.root = root;
        this.controllerAjout = new ControllerAjout(this, vh);

        initBackground();
        initButtons();
        initBackGroundNav();
    }

    private void initBackground() {
        background = new ImageView(Path.fondGestion_Ajout);

    }


    private void initBackGroundNav() {
        bgNav = new Button();
        bgNav.setTranslateY(195);
        bgNav.setTranslateX(70);
        bgNav.setMinWidth(1120);
        bgNav.setMinHeight(450);
        bgNav.setStyle("-fx-background-color: rgba(127,159,81, 0.9);");

    }
    private void initButtons() {

        retour = new ImageView(Path.buttonRetourGestionAjout);
        retour.setTranslateY(10);
        retour.setTranslateX(10);
        retour.setCursor(Cursor.HAND);
        retour.setOnMouseClicked(controllerAjout);

        constructeur = new Text(" Ajouter un Constructeur :");
        constructeur.setTranslateY(377);
        constructeur.setTranslateX(100);
        constructeur.setFill(Color.WHITE);
        constructeur.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3em;-fx-font-weight: bold;");


        model = new Text("Ajouter un Modèle :");
        model.setTranslateY(477);
        model.setTranslateX(230);
        model.setFill(Color.WHITE);
        model.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3em;-fx-font-weight: bold;");





        fieldModel = new TextField();
        fieldModel.setTranslateY(350);
        fieldModel.setTranslateX(700);
        fieldModel.setMinWidth(330);

        fieldConstructeur = new TextField();
        fieldConstructeur.setTranslateY(450);
        fieldConstructeur.setTranslateX(700);
        fieldConstructeur.setMinWidth(330);


        valider = new Button("Valider");
        valider.setTranslateY(350);
        valider.setTranslateX(1028);
        valider.setMinWidth(80);
        valider.setMinHeight(20);
        valider.setStyle("-fx-background-color: rgba(249,212,35, 0.9); -fx-text-fill: white ;-fx-font-size: 1em;-fx-font-weight: bold;");
        valider.setOnMouseEntered(t -> valider.setStyle("-fx-background-color: rgba(249,212,35, 1); ; -fx-text-fill: white ;-fx-font-size: 1em;-fx-font-weight: bold;"));
        valider.setOnMouseExited(t -> valider.setStyle("-fx-background-color: rgba(249,212,35, 0.9) ; -fx-text-fill: white ;-fx-font-size: 1em;-fx-font-weight: bold;"));
        valider.setCursor(Cursor.HAND);
        valider.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                BDDManager2 bddManager2 = new BDDManager2();
                bddManager2.start("jdbc:mysql://localhost:3306/concession", "root", "");
                bddManager2.insert("INSERT INTO `constructeur` (`id_constructeur`, `libelle_constructeur`) VALUES (NULL, \""+ fieldModel.getText() + "\");");
                bddManager2.stop();
            }
        });


        valider2 = new Button("Valider");
        valider2.setTranslateY(450);
        valider2.setTranslateX(1028);
        valider2.setMinWidth(80);
        valider2.setMinHeight(20);
        valider2.setStyle("-fx-background-color: rgba(249,212,35, 0.9); -fx-text-fill: white ;-fx-font-size: 1em;-fx-font-weight: bold;");
        valider2.setOnMouseEntered(t -> valider2.setStyle("-fx-background-color: rgba(249,212,35, 1); ; -fx-text-fill: white ;-fx-font-size: 1em;-fx-font-weight: bold;"));
        valider2.setOnMouseExited(t -> valider2.setStyle("-fx-background-color: rgba(249,212,35, 0.9) ; -fx-text-fill: white ;-fx-font-size: 1em;-fx-font-weight: bold;"));
        valider2.setCursor(Cursor.HAND);
        valider2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                BDDManager2 bddManager2 = new BDDManager2();
                bddManager2.start("jdbc:mysql://localhost:3306/concession", "root", "");
                bddManager2.insert("INSERT INTO `model` (`id_modele`, `libelle_model`) VALUES (NULL, \""+ fieldModel.getText() + "\");");
                bddManager2.stop();
            }
        });




    }


    public void setVueCompletAjout() {
        root.getChildren().clear();
        root.getChildren().add(background);
        root.getChildren().add(bgNav);
        root.getChildren().add(retour);
        root.getChildren().add(constructeur);
        root.getChildren().add(model);
        root.getChildren().add(fieldModel);
        root.getChildren().add(fieldConstructeur);
        root.getChildren().add(valider2);
        root.getChildren().add(valider);


    }


}
