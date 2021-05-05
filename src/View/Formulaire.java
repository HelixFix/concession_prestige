package View;

import Controller.ControllerFormulaire;
import Tools.Path;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

    private static final String boutons = "-fx-background-color: rgb(50,50,50,0.5);" +
            "-fx-font-size: 2em;" +
            "-fx-border-insets: -1 -1 -1 -1;" +
            "-fx-border-color: -fx-text-box-border; " +
            "-fx-border-width: 2; " +
            "-fx-border-radius: 10px; " +
            "-fx-color: black; " +
            "-fx-font-family: Impact, \"Arial Black\", Arial, Verdana, sans-serif;";
    private ImageView background;

    // OnCreate

    public Formulaire(Group root, ViewHandler vh) {

        this.root = root;
        this.controllerFormulaire = new ControllerFormulaire(this, vh);

        initButtons();
        initBackground();
    }

    private void initBackground() {
        background = new ImageView(Path.fondMenu);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds(); // Récupération de la taille de l'écran
        background.setFitHeight((int) primaryScreenBounds.getHeight());
        background.setFitWidth((int) primaryScreenBounds.getWidth());
    }


    private void initButtons() {

        quitter = new Button("Quitter");
        quitter.setTranslateY(10);
        quitter.setTranslateX(10);
        quitter.setStyle(boutons);
        quitter.setPadding(new Insets(20));
        quitter.setMinWidth(100);

        quitter.setOnMouseClicked(controllerFormulaire);


        genre = new Button("Genre");
        genre.setTranslateY(primaryScreenBounds.getHeight() / 2 - 300);
        genre.setTranslateX(primaryScreenBounds.getWidth() /2 -250);
        genre.setStyle(boutons);
        genre.setPadding(new Insets(20));
        genre.setMinWidth(400);

        genre.setOnMouseClicked(controllerFormulaire);

        nationalite = new Button("Nationalité");
        nationalite.setTranslateY(primaryScreenBounds.getHeight() / 2 - 200);
        nationalite.setTranslateX(primaryScreenBounds.getWidth() /2 -250);
        nationalite.setStyle(boutons);
        nationalite.setPadding(new Insets(20));
        nationalite.setMinWidth(400);

        nationalite.setOnMouseClicked(controllerFormulaire);

        films = new Button("Films");
        films.setTranslateY(primaryScreenBounds.getHeight() / 2 - 100);
        films.setTranslateX(primaryScreenBounds.getWidth() /2 -250);
        films.setStyle(boutons);
        films.setPadding(new Insets(20));
        films.setMinWidth(400);

        films.setOnMouseClicked(controllerFormulaire);

        acteurs = new Button("Acteurs");
        acteurs.setTranslateY(primaryScreenBounds.getHeight() / 2);
        acteurs.setTranslateX(primaryScreenBounds.getWidth() /2 -250);
        acteurs.setStyle(boutons);
        acteurs.setPadding(new Insets(20));
        acteurs.setMinWidth(400);

        acteurs.setOnMouseClicked(controllerFormulaire);

        realisateurs = new Button("Realisateurs");
        realisateurs.setTranslateY(primaryScreenBounds.getHeight() / 2 + 100);
        realisateurs.setTranslateX(primaryScreenBounds.getWidth() /2 -250);
        realisateurs.setStyle(boutons);
        realisateurs.setPadding(new Insets(20));
        realisateurs.setMinWidth(400);

        realisateurs.setOnMouseClicked(controllerFormulaire);

    }


    // LA VUE

    public void setVueCompleteMenu() {
        root.getChildren().clear();
        root.getChildren().add(background);
        root.getChildren().add(quitter);
        root.getChildren().add(genre);
        root.getChildren().add(nationalite);
        root.getChildren().add(acteurs);
        root.getChildren().add(realisateurs);
        root.getChildren().add(films);
    }

    public Button getQuitter() { return quitter; }

    public Button getGenre() { return genre; }
    public Button getNationalite() { return nationalite; }
    public Button getRealisateurs() { return realisateurs; }
    public Button getFilms() { return films; }
    public Button getActeurs() { return acteurs; }
}
