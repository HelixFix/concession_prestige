package View;

import BDDManager.BDDManager2;
import Controller.ControllerGarage;
import Tools.Path;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class ViewGarage {

    private final Group root;
    private final ControllerGarage controllerGarage;

    private Button retour;

    private Button button;
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
    private Text tfModel;

    // OnCreate

    public ViewGarage(Group root, ViewHandler vh) {

        this.root = root;
        this.controllerGarage = new ControllerGarage(this, vh);

        initButtons();
        initChamp();
        initBackground();
        initBackGroundNav();
        initText();

    }

    private void initText() {
        tfModel = new Text("MODELE");
        tfModel.setLayoutX(220);
        tfModel.setLayoutY(70);
        tfModel.setStyle("-fx-background-color: rgba(50,300,81, 0.8);");
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


        button = new Button("Valider");
        button.setTranslateY(primaryScreenBounds.getHeight() / 2);
        button.setTranslateX(primaryScreenBounds.getWidth() / 2 - 50);
        button.setStyle(boutons);
        button.setPadding(new Insets(10));








        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                BDDManager2 bdd = new BDDManager2();
                bdd.start("jdbc:mysql://localhost:3306/DVDTHEQUE", "root", "root");
                bdd.insert("INSERT INTO View.Genre values (null, \" " + t1.getText() + "\");");
                bdd.stop();
            }
        });
    }

    private void initChamp(){

        t1 = new TextField("Nationalité");
        t1.setTranslateY(primaryScreenBounds.getHeight() / 2 - 100);
        t1.setTranslateX(primaryScreenBounds.getWidth() / 2 - 100);
        t1.setFont(Font.font(15));
    }

    // LA VUE

    public void setVueNationalite() {
        root.getChildren().clear();
        root.getChildren().add(background);
        root.getChildren().add(bgNav);
        root.getChildren().add(retour);
        root.getChildren().add(button);
        root.getChildren().add(t1);
        root.getChildren().add(tfModel);


    }

    public Button getRetour() { return retour; }
}
