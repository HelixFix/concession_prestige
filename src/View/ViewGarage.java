package View;

import BDDManager.BDDManager2;
import Controller.ControllerGarage;
import Tools.Path;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Screen;

import java.util.ArrayList;

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

    }

    private void initCombobox() {
        BDDManager2 bdd = new BDDManager2();
        bdd.start("jdbc:mysql://localhost:3306/concession?characterEncoding=utf8", "root", "");
        String queryVoiture = ("SELECT  libelle_constructeur  FROM constructeur ");

        String queryVoiture2= ("SELECT  libelle_modele FROM model");

        ArrayList<ArrayList<String>> resultatDeMaRequete = bdd.select(queryVoiture);

        comboConstructeur = new ComboBox<>();
        comboConstructeur.setLayoutX(100);
        comboConstructeur.setLayoutY(250);
        comboConstructeur.getItems().addAll(bdd.select(queryVoiture));


        comboModel = new ComboBox<>();
        comboModel.setLayoutX(100);
        comboModel.setLayoutY(450);
        comboModel.getItems().addAll(bdd.select(queryVoiture2));






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
                BDDManager2 bdd = new BDDManager2();
                bdd.start("jdbc:mysql://localhost:3306/DVDTHEQUE", "root", "root");
                bdd.select("SELECT FROM * Voiture where values (null, \" " + t1.getText() + "\");");
                bdd.stop();
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




    }

    public Button getRetour() { return retour; }
}