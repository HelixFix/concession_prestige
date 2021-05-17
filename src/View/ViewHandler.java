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
    private ViewClients viewClients;
    private ViewGestion_Crud vgc;
    private ViewGestion_Ajout vga;
    private ViewTableau_Jour tbj;
    private ViewTableau_Mois tbm;
    private  ViewTableau_Annee tba;

    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);

        mp = new ViewMenuPrincipal(root, this);
        viewGestion = new ViewGestion(root, this);
        nationalite = new ViewGarage(root, this);
        viewClients = new ViewClients(root, this);

        tba = new ViewTableau_Annee(root,this);
        tbj = new ViewTableau_Jour(root, this);
        tbm = new ViewTableau_Mois(root, this);
        vgc = new ViewGestion_Crud(root, this);





        vga = new ViewGestion_Ajout(root, this);



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

    public void afficherGestion(){ viewGestion.setVueGenre();}

    public void afficherNationalite(){ nationalite.setVueNationalite();}

    public void afficherClients(){ viewClients.setVueClients();}

    public void afficherCrud(){
        vgc.setVueCompleteCrud();
    }
    public void afficherAjout(){
        vga.setVueCompletAjout();
    }

    public void afficherTableauJour(){ tbj.setVueJour();}

    public void afficherTableauMois(){tbm.setVueMois();}

    public void afficherTableauAnne() {
        tba.setVueTableauAnnee();
    }
}