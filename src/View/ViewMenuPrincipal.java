package View;

import Controller.ControllerMenu;
import Tools.Path;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;

public class ViewMenuPrincipal {

    private final Group root;
    private final ControllerMenu controllerMenu;
    private Button buttonGestion;
    private Button buttonGarage;
    private Button buttonClient;
    private Button realisateurs;
    private Button buttonVente;
    private ImageView quitter;
    //private static final Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds();
    private ImageView background;
    private Button bgNav;



    public ViewMenuPrincipal(Group root, ViewHandler vh) {

        this.root = root;
        this.controllerMenu = new ControllerMenu(this, vh);

        initButtons();
        initBackground();
        initBackGroundNav();
    }

    private void initBackground() {
        background = new ImageView(Path.fondMenu);

    }

    private void initBackGroundNav() {
        bgNav = new Button();
        bgNav.setTranslateY(220);
        bgNav.setTranslateX(70);
        bgNav.setMinWidth(420);
        bgNav.setMinHeight(400);
        bgNav.setStyle("-fx-background-color: rgba(116,201,190, 0.8);");

    }

    private void initButtons() {


        quitter = new ImageView(Path.buttonQuitter);
        quitter.setTranslateY(10);
        quitter.setTranslateX(10);
        quitter.setCursor(Cursor.HAND);
        quitter.setOnMouseClicked(controllerMenu);


        buttonGestion = new Button("Gestion");
        buttonGestion.setTranslateY(220);
        //buttonGestion.setTranslateX(primaryScreenBounds.getWidth() / 2 - 880);
        buttonGestion.setPadding(new Insets(20));
        buttonGestion.setMinWidth(400);
        buttonGestion.setCursor(Cursor.HAND);
        buttonGestion.setOnMouseEntered(t -> buttonGestion.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3.5em;-fx-font-weight: bold; "));
        buttonGestion.setOnMouseExited(t -> buttonGestion.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3em;-fx-font-weight: bold;"));
        buttonGestion.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3em;-fx-font-weight: bold;");
        buttonGestion.setOnMouseClicked(controllerMenu);

        buttonGarage = new Button("Garage");
        buttonGarage.setTranslateY(320);
        //buttonGarage.setTranslateX(primaryScreenBounds.getWidth() / 2 - 880);
        buttonGarage.setPadding(new Insets(20));
        buttonGarage.setMinWidth(400);
        buttonGarage.setCursor(Cursor.HAND);
        buttonGarage.setOnMouseEntered(t -> buttonGarage.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3.5em;-fx-font-weight: bold;"));
        buttonGarage.setOnMouseExited(t -> buttonGarage.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3em;-fx-font-weight: bold;"));
        buttonGarage.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3em;-fx-font-weight: bold;");
        buttonGarage.setOnMouseClicked(controllerMenu);

        buttonVente = new Button("Vente");
        buttonVente.setTranslateY(420);
        //buttonVente.setTranslateX(primaryScreenBounds.getWidth() / 2 - 880);
        buttonVente.setPadding(new Insets(20));
        buttonVente.setMinWidth(400);
        buttonVente.setCursor(Cursor.HAND);
        buttonVente.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3em;-fx-font-weight: bold;");
        buttonVente.setOnMouseEntered(t -> buttonVente.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3.5em;-fx-font-weight: bold;"));
        buttonVente.setOnMouseExited(t -> buttonVente.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3em;-fx-font-weight: bold;"));
        buttonVente.setOnMouseClicked(controllerMenu);

        buttonClient = new Button("Client");
        buttonClient.setTranslateY(520);
        //buttonClient.setTranslateX(primaryScreenBounds.getWidth() / 2 - 880);
        buttonClient.setPadding(new Insets(20));
        buttonClient.setMinWidth(400);
        buttonClient.setCursor(Cursor.HAND);
        buttonClient.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3em;-fx-font-weight: bold;");
        buttonClient.setOnMouseEntered(t -> buttonClient.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3.5em;-fx-font-weight: bold;"));
        buttonClient.setOnMouseExited(t -> buttonClient.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3em;-fx-font-weight: bold;"));
        buttonClient.setOnMouseClicked(controllerMenu);
/*
        realisateurs = new Button("SuperCars");
        realisateurs.setTranslateY(primaryScreenBounds.getHeight() / 2 + 200);
        realisateurs.setTranslateX(primaryScreenBounds.getWidth() /2 -780);
        realisateurs.setPadding(new Insets(20));
        realisateurs.setMinWidth(400);
        realisateurs.setCursor(Cursor.HAND);
        realisateurs.setOnMouseEntered(t -> realisateurs.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3em;"));
        realisateurs.setOnMouseExited(t -> realisateurs.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 3em;"));
        realisateurs.setOnMouseClicked(controllerFormulaire);*/

    }


    // LA VUE

    public void setVueCompleteMenu() {
        root.getChildren().clear();

        root.getChildren().add(background);
        root.getChildren().add(bgNav);
        root.getChildren().add(quitter);
        root.getChildren().add(buttonGestion);
        root.getChildren().add(buttonGarage);
        root.getChildren().add(buttonClient);
        //  root.getChildren().add(realisateurs);
        root.getChildren().add(buttonVente);
    }

    public ImageView getQuitter() {
        return quitter;
    }

    public Button getButtonGestion() {
        return buttonGestion;
    }

    public Button getButtonGarage() {
        return buttonGarage;
    }

    public Button getRealisateurs() {
        return realisateurs;
    }

    public Button getButtonVente() {
        return buttonVente;
    }

    public Button getButtonClient() {
        return buttonClient;
    }
}