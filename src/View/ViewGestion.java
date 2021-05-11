package View;

import BDDManager.BDDManager2;
import Controller.ControllerGestion;
import Tools.Path;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Screen;

public class ViewGestion {

    private final Group root;
    private final ControllerGestion controllerGestion;

    private ImageView retour;

    private Button button;
    private TextField t1;

    private ImageView background;
    private Button bgNav;
    private Button buttonAjout;
    private Button buttonCrud;


    // OnCreate

    public ViewGestion(Group root, ViewHandler vh) {

        this.root = root;
        this.controllerGestion = new ControllerGestion(this, vh);

        initButtons();
        initBackGroundNav();
        initBackground();
    }

    private void initBackGroundNav(){
        bgNav = new Button();
        bgNav.setTranslateY(220);
        bgNav.setTranslateX(70);
        bgNav.setMinWidth(420);
        bgNav.setMinHeight(400);
        bgNav.setStyle("-fx-background-color: rgba(61,74,89, 0.9);");

    }

    private void initBackground() {
        background = new ImageView(Path.fondGestion);

    }

    public Button getButtonAjout() {
        return buttonAjout;
    }

    private void initButtons() {

        retour = new ImageView(Path.buttonRetour);
        retour.setTranslateY(10);
        retour.setTranslateX(10);
        retour.setCursor(Cursor.HAND);
        retour.setOnMouseClicked(controllerGestion);

        buttonAjout = new Button("Ajout Modèle/Constructeur");
        buttonAjout.setTranslateY(320);
        buttonAjout.setTranslateX(68);
        buttonAjout.setPadding(new Insets(20));
        buttonAjout.setMinWidth(100);
        buttonAjout.setCursor(Cursor.HAND);
        buttonAjout.setOnMouseEntered(t -> buttonAjout.setStyle("-fx-background-color: transparent;-fx-text-fill: rgb(82,157,193) ;-fx-font-size: 2em;-fx-font-weight: bold;"));
        buttonAjout.setOnMouseExited(t -> buttonAjout.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;"));
        buttonAjout.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");
        buttonAjout.setOnMouseClicked(controllerGestion);

        buttonCrud = new Button("Ajout Véhicule");
        buttonCrud.setTranslateY(420);
        buttonCrud.setTranslateX(68);
        buttonCrud.setPadding(new Insets(20));
        buttonCrud.setMinWidth(400);
        buttonCrud.setCursor(Cursor.HAND);
        buttonCrud.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");
        buttonCrud.setOnMouseEntered(t -> buttonCrud.setStyle("-fx-background-color: transparent;-fx-text-fill: rgb(82,157,193) ;-fx-font-size: 2em;-fx-font-weight: bold;"));
        buttonCrud.setOnMouseExited(t -> buttonCrud.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;"));
        buttonCrud.setOnMouseClicked(controllerGestion);

    }

    public Button getButtonCrud() {
        return buttonCrud;
    }
// LA VUE

    public void setVueGenre() {
        root.getChildren().clear();
        root.getChildren().add(background);
        root.getChildren().add(retour);
        root.getChildren().add(bgNav);
        root.getChildren().add(buttonCrud);
        root.getChildren().add(buttonAjout);


    }

    public ImageView getRetour() { return retour; }
}