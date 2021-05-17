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

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

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
    private ArrayList<ArrayList<String>> listeModel;
    private ArrayList<ArrayList<String>> listeConstructeur;
    private int idConstructeur;
    private int idModel;

private boolean variableFalse = false;

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
        bgNav.setStyle("-fx-background-color: rgba(61,74,89, 0.9);");

    }

    public TextField getFieldModel() {
        return fieldModel;
    }

    public TextField getFieldConstructeur() {
        return fieldConstructeur;
    }

    public void setFieldModel(TextField fieldModel) {
        this.fieldModel = fieldModel;
    }

    public void setFieldConstructeur(TextField fieldConstructeur) {
        this.fieldConstructeur = fieldConstructeur;
    }

    private void initButtons() {

        retour = new ImageView(Path.buttonRetour);
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
        fieldModel.setTranslateY(450);
        fieldModel.setTranslateX(700);
        fieldModel.setMinWidth(330);

        fieldConstructeur = new TextField();
        fieldConstructeur.setTranslateY(350);
        fieldConstructeur.setTranslateX(700);
        fieldConstructeur.setMinWidth(330);


        valider = new Button("Valider");
        valider.setTranslateY(550);
        valider.setTranslateX(550);
        valider.setMinWidth(150);
        valider.setMinHeight(50);
        valider.setStyle("-fx-background-color: rgba(82,157,193, 0.9); -fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");
        valider.setOnMouseEntered(t -> valider.setStyle("-fx-background-color: rgba(82,157,193, 1); ; -fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;"));
        valider.setOnMouseExited(t -> valider.setStyle("-fx-background-color: rgba(82,157,193, 0.9) ; -fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;"));
        valider.setCursor(Cursor.HAND);
        valider.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                BDDManager2 bddManager2 = new BDDManager2();
                bddManager2.start("jdbc:mysql://localhost:3306/concession?characterEncoding=utf8", "root", "");
                listeConstructeur = bddManager2.select("SELECT * FROM constructeur");
                listeModel = bddManager2.select("SELECT * FROM model");

                variableFalse = false;

                for (int i = 0; i < listeConstructeur.size(); i++) {
                    if (fieldConstructeur.getText().equals(listeConstructeur.get(i).get(1)))  {
                        variableFalse = true;
                    }
                }

                if (variableFalse == false) {
                    bddManager2.insert("INSERT INTO Constructeur values (null, \"" + fieldConstructeur.getText() + "\");");
                }


                listeConstructeur = bddManager2.select("SELECT * FROM constructeur");

                for (int i = 0; i < listeConstructeur.size(); i++) {
                    if (fieldConstructeur.getText().equals(listeConstructeur.get(i).get(1)))  {
                        idConstructeur = parseInt(listeConstructeur.get(i).get(0));
                        System.out.println("tototototototo");
                    }
                }


                variableFalse = false;

                for (int i = 0; i < listeModel.size(); i++) {

                    if (fieldModel.getText().equals(listeModel.get(i).get(1))) {
                        variableFalse = true;
                    }
                }
                if (variableFalse == false) {
                    bddManager2.insert("INSERT INTO Model values (null, \"" + fieldModel.getText() + "\", \""+ idConstructeur +"\");");
                }

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

        root.getChildren().add(valider);


    }


}
