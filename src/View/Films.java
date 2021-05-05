package View;

import BDDManager.BDDManager2;
import Controller.ControllerFilms;
import Controller.ControllerGenre;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class Films {

    private final Group root;
    private final ControllerFilms controllerFilms;

    private Button retour;

    private Button plus;
    private Button moin;

    private Button button;
    private TextField t1;
    private TextField t2;
    private TextField t3;

    private Text numeroNiveau;

    private int note;

    private static final String fondText = "-fx-font-size: 5em;" +
            "-fx-font-family: Impact, \"Arial Black\", Arial, Verdana, sans-serif;";

    private static final Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds();

    private static final String boutons = "-fx-background-color: rgb(50,50,50,0.5);" +
            "-fx-font-size: 2em;" +
            "-fx-border-insets: -1 -1 -1 -1;" +
            "-fx-border-color: -fx-text-box-border; " +
            "-fx-border-width: 2; " +
            "-fx-border-radius: 10px; " +
            "-fx-color: black; " +
            "-fx-font-family: Impact, \"Arial Black\", Arial, Verdana, sans-serif;";

    // OnCreate

    public Films(Group root, ViewHandler vh) {

        this.root = root;
        this.controllerFilms = new ControllerFilms(this, vh);

        initButtons();
        initChamp();

    }

    private void initButtons() {

        retour = new Button("Retour");
        retour.setTranslateY(10);
        retour.setTranslateX(10);
        retour.setStyle(boutons);
        retour.setPadding(new Insets(20));
        retour.setMinWidth(100);
        retour.setOnMouseClicked(controllerFilms);


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

        t1 = new TextField("Nom");
        t1.setTranslateY(primaryScreenBounds.getHeight() / 2 - 300);
        t1.setTranslateX(primaryScreenBounds.getWidth() / 2 - 100);
        t1.setFont(Font.font(15));

        t2 = new TextField("Année");
        t2.setTranslateY(primaryScreenBounds.getHeight() / 2 - 200);
        t2.setTranslateX(primaryScreenBounds.getWidth() / 2 - 100);
        t2.setFont(Font.font(15));

        t3 = new TextField("Note");
        t3.setTranslateY(primaryScreenBounds.getHeight() / 2 - 100);
        t3.setTranslateX(primaryScreenBounds.getWidth() / 2 - 100);
        t3.setFont(Font.font(15));


        /*
        genre = new Text("Ajout d'un film");
        genre.setTranslateX(50);
        genre.setTranslateY(50);
        genre.setStyle("-fx-fill: red;");

        comboBox = new ComboBox(FXCollections.observableArrayList(genres));
        comboBox.setTranslateX(200);
        comboBox.setTranslateY(200);

        test = new Button("Ajout d'un fichier");
        test.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("All Files", "."));
                File selectedFile = fileChooser.showOpenDialog(mainStage);
            }
        });*/
    }



    // LA VUE

    public void setVueFilms() {
        root.getChildren().clear();
        root.getChildren().add(retour);
        root.getChildren().add(button);
        root.getChildren().add(t1);
        root.getChildren().add(t2);
        root.getChildren().add(t3);
    }

    public Button getRetour() { return retour; }
}
