package View;

import Controller.ControllerClients;
import Tools.Path;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import BDDManager.BDDManager2;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class ViewClients {

    private final Group root;
    private final ControllerClients controllerClients;

    private Button bgNav;
    private Integer posX = 70;
    private Integer posy = 190;

    private TextField textFieldNomClient;
    private Text textNomClient;
    private TextField textFieldPrenomClient;
    private Text textPrenomClient;
    private TextField textFieldTelClient;
    private Text texttelClient;
    private Text titreFormulaire;
    private TextField textFieldVoiture;
    private Text textVoiture;

    private Label id;
    private Label constructeur;
    private Label modele;
    private Label annee;
    private Label kilometrage;
    private Label chevaux;
    private Label nbPorte;
    private Label vitesse;
    private Label lblConstructeur;

    private GridPane gridpane;

    private Button buttonValider;
    private Button buttonRetour;

    private Button tabClient;
    private Button tabVoiture;

    private ImageView retour;
    private ImageView background;

    private TableView<ArrayList<String>> table;


    public ViewClients(Group root, ViewHandler vh) {

        this.root = root;
        this.controllerClients = new ControllerClients(this, vh);

        initBackground();
        initBackGroundNav();
        initTextField();
        initButton();
        initCombobox();
        initTab();
    }

    private void initBackground() {
        background = new ImageView(Path.fondClient);

    }

    private void initBackGroundNav() {
        bgNav = new Button();
        bgNav.setTranslateX(70);
        bgNav.setTranslateY(220);
        bgNav.setMinWidth(420);
        bgNav.setMinHeight(400);
        bgNav.setStyle("-fx-background-color: rgba(116,201,190, 0.8);");
    }

    private void initTextField() {
        // Titre
        titreFormulaire = new Text("Ajout client");
        titreFormulaire.setTranslateX(posX + 10);
        titreFormulaire.setTranslateY(posy + 40);

        // Nom du client
        textFieldNomClient = new TextField();
        textFieldNomClient.setTranslateX(posX + 100);
        textFieldNomClient.setTranslateY(posy + 100);

        textNomClient = new Text("Nom : ");
        textNomClient.setTranslateX(posX + 10);
        textNomClient.setTranslateY(posy + 110);
        textNomClient.setFill(Color.rgb(140, 128, 113));

        // Prénom du client
        textFieldPrenomClient = new TextField();
        textFieldPrenomClient.setTranslateX(posX + 100);
        textFieldPrenomClient.setTranslateY(posy + 140);

        textPrenomClient = new Text("Prénom : ");
        textPrenomClient.setTranslateX(posX + 10);
        textPrenomClient.setTranslateY(posy + 150);
        textPrenomClient.setFill(Color.rgb(140, 128, 113));

        // Téléphone du client
        textFieldTelClient = new TextField();
        textFieldTelClient.setTranslateX(posX + 100);
        textFieldTelClient.setTranslateY(posy + 180);

        texttelClient = new Text("Téléphone : ");
        texttelClient.setTranslateX(posX + 10);
        texttelClient.setTranslateY(posy + 190);
        texttelClient.setFill(Color.rgb(140, 128, 113));

        // Voiture
        textFieldVoiture = new TextField();
        textFieldVoiture.setTranslateX(posX + 100);
        textFieldVoiture.setTranslateY(posy + 220);

        textVoiture = new Text("ID voiture : ");
        textVoiture.setTranslateX(posX + 10);
        textVoiture.setTranslateY(posy + 230);
        textVoiture.setFill(Color.rgb(140, 128, 113));
    }


    public void initCombobox() {
        /************* BDD **************/
        BDDManager2 bdd = new BDDManager2();
        bdd.start("jdbc:mysql://localhost:3306/concession?characterEncoding=utf8", "root", "");
        String queryVoiture = ("SELECT id_voiture, libelle_constructeur, libelle_model, annee, kilometrage, chevaux, nombre_de_porte, vitesse_max\n" +
                "FROM voiture\n" +
                "INNER JOIN model ON model.id_modele = voiture.id_modele\n" +
                "INNER JOIN constructeur ON constructeur.id_constructeur = voiture.id_constructeur\n" +
                "WHERE stock > 0");
        System.out.println(bdd.select(queryVoiture));
        /************* VOITURE **************/
        // Une liste de string
        ArrayList<ArrayList<String>> resultatDeMaRequete = new ArrayList<ArrayList<String>>(bdd.select(queryVoiture));


        gridpane = new GridPane();
        gridpane.setTranslateX(445);
        gridpane.setTranslateY(131);


        id = new Label("ID");
        id.setStyle("-fx-background-color: rgba(116,201,190, 0.8);");

        lblConstructeur = new Label("Constructeur");
        lblConstructeur.setStyle("-fx-background-color: rgba(116,201,190, 0.8);");
        modele = new Label("Modele");
        TextField txtfirstname = new TextField();
        TextField txtlastname = new TextField();
        gridpane.add(id, 0, 0);
        gridpane.add(lblConstructeur, 1, 0);
        gridpane.add(modele, 2, 0);

        ColumnConstraints column0 = new ColumnConstraints();
        column0.setPercentWidth(50);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(50);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(50);


        for (int i = 0; i < resultatDeMaRequete.size(); i++) {

            gridpane.add(id = new Label(resultatDeMaRequete.get(i).get(0)), 0, i + 1); // column=1 row=0
            id.setStyle("-fx-background-color: rgba(116,50,190, 0.8);");

            gridpane.add(constructeur = new Label(resultatDeMaRequete.get(i).get(1)), 1, i + 1); // column=1 row=0
            constructeur.setStyle("-fx-background-color: rgba(116,50,190, 0.8);");

            gridpane.add(modele = new Label(resultatDeMaRequete.get(i).get(2)), 2, i + 1); // column=1 row=0
            modele.setStyle("-fx-background-color: rgba(116,50,190, 0.8);");
        }

        bdd.stop();
    }


    public void initButton() {

        buttonValider = new Button("Valider");
        buttonValider.setTranslateX(posX + 100);
        buttonValider.setTranslateY(posy + 310);
        buttonValider.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                BDDManager2 insert = new BDDManager2();
                insert.start("jdbc:mysql://localhost:3306/concession?characterEncoding=utf8", "root", "");
                String queryClient = ("INSERT INTO client (`id_client`, `nom`, `prenom`, `telephone`) VALUES (null, \""
                        + textFieldNomClient.getText() + "\",  \"" + textFieldPrenomClient.getText() + "\",  " + textFieldTelClient.getText() + "  );");
                insert.insert(queryClient);
                insert.stop();
            }

        });

        buttonRetour = new Button("Retour");
        buttonRetour.setTranslateY(310);
        buttonRetour.setTranslateX(180);
        buttonRetour.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        retour = new ImageView(Path.buttonRetour);
        retour.setTranslateY(10);
        retour.setTranslateX(10);
        retour.setCursor(Cursor.HAND);
        retour.setOnMouseClicked(controllerClients);
    }

    public void initTab() {
        tabClient = new Button("Clients");
        tabClient.setTranslateX(445);
        tabClient.setTranslateY(100);

        tabVoiture = new Button("Voitures");
        tabVoiture.setTranslateX((500));
        tabVoiture.setTranslateY(100);
    }

    public void setVueClients() {
        root.getChildren().clear();

        root.getChildren().add(background);

        root.getChildren().add(bgNav);

        root.getChildren().add(titreFormulaire);
        root.getChildren().add(textFieldNomClient);
        root.getChildren().add(textNomClient);
        root.getChildren().add(textFieldPrenomClient);
        root.getChildren().add(textPrenomClient);
        root.getChildren().add(textFieldTelClient);
        root.getChildren().add(texttelClient);
        root.getChildren().add(textFieldVoiture);
        root.getChildren().add(textVoiture);

        root.getChildren().add(buttonValider);
        root.getChildren().add(retour);

        root.getChildren().add(gridpane);
        gridpane.getChildren().addAll(id, constructeur, modele, annee, kilometrage, chevaux, nbPorte, vitesse);
    }

    public ImageView getRetour() {
        return retour;
    }
}
