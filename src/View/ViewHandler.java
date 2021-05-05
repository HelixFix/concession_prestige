package View;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ViewHandler extends Application {

    private Formulaire mp;
    private Genre genre;
    private Nationalité nationalite;
    private Acteurs acteurs;
    private Realisateurs realisateurs;
    private Films films;

    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);

        mp = new Formulaire(root, this);
        genre = new Genre(root, this);
        nationalite = new Nationalité(root, this);
        acteurs = new Acteurs(root, this);
        realisateurs = new Realisateurs(root, this);
        films = new Films(root, this);


        afficherMenuPrincipal();

        primaryStage.setTitle("Bdd");
        primaryStage.setWidth(1280);
        primaryStage.setHeight(853);
        primaryStage.setX(500);
        primaryStage.setY(200);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setFullScreen(false);
        primaryStage.show();
    }

    public void afficherMenuPrincipal() {
        mp.setVueCompleteMenu();
    }

    public void afficherGenre(){ genre.setVueGenre();}

    public void afficherNationalite(){ nationalite.setVueNationalite();}

    public void afficherActeurs(){ acteurs.setVueActeurs();}

    public void afficherRealisateurs(){ realisateurs.setVueRealisateurs();}

    public void afficherFilms(){ films.setVueFilms();}
}
