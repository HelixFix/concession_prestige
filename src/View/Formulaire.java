package View;

import Controller.ControllerFormulaire;
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
import javafx.scene.text.Text;
import javafx.stage.Screen;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Formulaire {

    private final Group root;
    private final ControllerFormulaire controllerFormulaire;

    private Button genre;
    private Button nationalite;
    private Button acteurs;
    private Button realisateurs;
    private Button films;

    private Button quitter;

    private static final Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds();

    private static final String boutons = "-fx-background-color: transparent;" +
            "-fx-font-size: 3em;" +
            "-fx-border-insets: -1 -1 -1 -1;" +
            "-fx-border-width: 2; " +
            "-fx-border-radius: 10px; " +
            "-fx-color: black; " +
            "-fx-font-family: Impact, \"Arial Black\", Arial, Verdana, sans-serif;";

    private ImageView background;
    private Button bgNav;

    // OnCreate

    public Formulaire(Group root, ViewHandler vh) {

        this.root = root;
        this.controllerFormulaire = new ControllerFormulaire(this, vh);

        initButtons();
        initBackground();
        initBackGroundNav();
    }

    private void initBackground() {
        background = new ImageView(Path.fondMenu);

    }

private void initBackGroundNav(){
        bgNav = new Button();
        bgNav.setTranslateY(220);
        bgNav.setTranslateX(70);
        bgNav.setMinWidth(450);
        bgNav.setMinHeight(400);
        bgNav.setStyle("-fx-background-color: rgba(122,207,161, 0.8);");

}

    private void initButtons() {
        Font luxe = Font.loadFont(getClass().getResourceAsStream(Path.Luxerie), 100);

        quitter = new Button("LMJOS");
        quitter.setTranslateY(10);
        quitter.setTranslateX(10);

        quitter.setStyle(boutons);
        quitter.setPadding(new Insets(20));
        quitter.setMinWidth(100);
        quitter.setCursor(Cursor.HAND);

        quitter.setOnMouseClicked(controllerFormulaire);


        genre = new Button("Gestion");
        genre.setTranslateY(primaryScreenBounds.getHeight() / 2 - 150);
        genre.setTranslateX(primaryScreenBounds.getWidth() /2 -780);
        genre.setStyle(boutons);
        genre.setPadding(new Insets(20));
        genre.setMinWidth(400);
        genre.setCursor(Cursor.HAND);
        genre.setOnMouseEntered(t -> genre.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em; "));
        genre.setOnMouseExited(t -> genre.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;"));
        genre.setFont(luxe);

        genre.setOnMouseClicked(controllerFormulaire);

        nationalite = new Button("Garage");
        nationalite.setTranslateY(primaryScreenBounds.getHeight() / 2 - 50);
        nationalite.setTranslateX(primaryScreenBounds.getWidth() /2 -780);
        nationalite.setStyle(boutons);
        nationalite.setPadding(new Insets(20));
        nationalite.setMinWidth(400);
        nationalite.setCursor(Cursor.HAND);
        nationalite.setOnMouseEntered(t -> nationalite.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;"));
        nationalite.setOnMouseExited(t -> nationalite.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;"));

        nationalite.setOnMouseClicked(controllerFormulaire);

        films = new Button("Vente");
        films.setTranslateY(primaryScreenBounds.getHeight() / 2 + 50);
        films.setTranslateX(primaryScreenBounds.getWidth() /2 -780);
        films.setStyle(boutons);
        films.setPadding(new Insets(20));
        films.setMinWidth(400);
        films.setCursor(Cursor.HAND);
        films.setOnMouseEntered(t -> films.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;"));
        films.setOnMouseExited(t -> films.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;"));

        films.setOnMouseClicked(controllerFormulaire);

        acteurs = new Button("HyperCars");
        acteurs.setTranslateY(primaryScreenBounds.getHeight() / 2 + 100);
        acteurs.setTranslateX(primaryScreenBounds.getWidth() /2 -780);
        acteurs.setStyle(boutons);
        acteurs.setPadding(new Insets(20));
        acteurs.setMinWidth(400);
        acteurs.setCursor(Cursor.HAND);
        acteurs.setOnMouseEntered(t -> acteurs.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;"));
        acteurs.setOnMouseExited(t -> acteurs.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;"));

        acteurs.setOnMouseClicked(controllerFormulaire);

        realisateurs = new Button("SuperCars");
        realisateurs.setTranslateY(primaryScreenBounds.getHeight() / 2 + 200);
        realisateurs.setTranslateX(primaryScreenBounds.getWidth() /2 -780);
        realisateurs.setStyle(boutons);
        realisateurs.setPadding(new Insets(20));
        realisateurs.setMinWidth(400);
        realisateurs.setCursor(Cursor.HAND);
        realisateurs.setOnMouseEntered(t -> realisateurs.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;"));
        realisateurs.setOnMouseExited(t -> realisateurs.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;"));

        realisateurs.setOnMouseClicked(controllerFormulaire);

    }


    // LA VUE

    public void setVueCompleteMenu() {
        root.getChildren().clear();

        root.getChildren().add(background);
        root.getChildren().add(bgNav);
        root.getChildren().add(quitter);
        root.getChildren().add(genre);
        root.getChildren().add(nationalite);
       // root.getChildren().add(acteurs);
      //  root.getChildren().add(realisateurs);
        root.getChildren().add(films);
    }

    public Button getQuitter() { return quitter; }

    public Button getGenre() { return genre; }
    public Button getNationalite() { return nationalite; }
    public Button getRealisateurs() { return realisateurs; }
    public Button getFilms() { return films; }
    public Button getActeurs() { return acteurs; }
}
