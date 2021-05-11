package View;

import Controller.ControllerCrud;
import Controller.ControllerMenu;
import Tools.Path;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ViewGestion_Crud {
    private final Group root;
    private final ControllerCrud controllerGestionCrud;
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

    public ViewGestion_Crud(Group root, ViewHandler vh) {
        this.root = root;
        this.controllerGestionCrud = new ControllerCrud(this, vh);
        initBackground();
        initBackGroundNav();
        initButtons();
    }

    private void initBackGroundNav() {
        bgNav = new Button();
        bgNav.setTranslateY(80);
        bgNav.setTranslateX(70);
        bgNav.setMinWidth(1120);
        bgNav.setMinHeight(650);
        bgNav.setStyle("-fx-background-color: rgba(127,159,81, 0.9);");

    }


    private void initButtons() {

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

        annee = new Text("Années :");
        annee.setTranslateY(200);
        annee.setTranslateX(660);
        annee.setFill(Color.WHITE);
        annee.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");

        couleur = new Text("Années :");
        couleur.setTranslateY(300);
        couleur.setTranslateX(660);
        couleur.setFill(Color.WHITE);
        couleur.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");


        nombreDePorte = new Text("Années :");
        nombreDePorte.setTranslateY(300);
        nombreDePorte.setTranslateX(660);
        nombreDePorte.setFill(Color.WHITE);
        nombreDePorte.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");

    }




    private void initBackground() {
        background = new ImageView(Path.fondMenu);

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




    }
}
