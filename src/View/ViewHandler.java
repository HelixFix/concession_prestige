package View;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ViewHandler extends Application {

    private ViewMenuPrincipal mp;
    private ViewGestion viewGestion;
    private ViewGarage nationalite;
    private ViewClient viewClient;
    private ViewVente viewVente;
    private ViewGestion_Crud vgc;

    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);

        mp = new ViewMenuPrincipal(root, this);
        viewGestion = new ViewGestion(root, this);
        nationalite = new ViewGarage(root, this);
        viewClient = new ViewClient(root, this);

        viewVente = new ViewVente(root, this);
        vgc = new ViewGestion_Crud(root, this);


        afficherMenuPrincipal();

        primaryStage.setTitle("Bdd");
        primaryStage.setWidth(1280);
        primaryStage.setHeight(853);
        primaryStage.setX(500);
        primaryStage.setY(200);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setFullScreen(false);
        primaryStage.show();
    }

    public void afficherMenuPrincipal() {
        mp.setVueCompleteMenu();
    }

    public void afficherGenre(){ viewGestion.setVueGenre();}

    public void afficherNationalite(){ nationalite.setVueNationalite();}

    public void afficherActeurs(){ viewClient.setVueActeurs();}



    public void afficherFilms(){ viewVente.setVueFilms();}

    public void afficherCrud(){
        vgc.setVueCompleteCrud();
    }
}
