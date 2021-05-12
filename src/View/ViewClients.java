package View;

import Controller.ControllerClients;
import Tools.Path;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import BDDManager.BDDManager2;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import Model.Voiture;
import Model.Client;

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
    private TextField textFieldIDVoiture;
    private Text textVoiture;

    private Button buttonAjtClient;
    private Button buttonEditClient;

    private Button tabClient;
    private Button tabVoiture;

    private ImageView retour;
    private ImageView background;

    private TableView<Voiture> tableVoiture;
    private TableView<Client> tableClient;

    public ViewClients(Group root, ViewHandler vh) {

        this.root = root;
        this.controllerClients = new ControllerClients(this, vh);

        initBackground();
        initBackGroundNav();
        initTextField();
        initButton();
        initTableVoiture();
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

        // ID du client

        textidClient = new Text("");
        textidClient.setTranslateX(posX + 10);
        textidClient.setTranslateY(posy + 80);
        textidClient.setFill(Color.rgb(140, 128, 113));



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
        textFieldIDVoiture = new TextField();
        textFieldIDVoiture.setTranslateX(posX + 100);
        textFieldIDVoiture.setTranslateY(posy + 220);

        textVoiture = new Text("ID voiture : ");
        textVoiture.setTranslateX(posX + 10);
        textVoiture.setTranslateY(posy + 230);
        textVoiture.setFill(Color.rgb(140, 128, 113));

    }

    private void initTableClient() {

        /************* BDD **************/

        BDDManager2 bdd = new BDDManager2();
        bdd.start("jdbc:mysql://localhost:3306/concession?characterEncoding=utf8", "root", "");
        String queryClient = ("SELECT * FROM client");

        ArrayList<ArrayList<String>> resultatDeMaRequete = new ArrayList<>(bdd.select(queryClient));


        /************* TableView **************/

        tableClient = new TableView<Client>();
        tableClient.setLayoutX(445);
        tableClient.setLayoutY(131);
        tableClient.setPrefHeight(669);
        tableClient.setPrefWidth(782);

        TableColumn<Client, String> column1 = new TableColumn<>("ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));
        column1.setPrefWidth(20);

        TableColumn<Client, String> column2 = new TableColumn<>("nom");
        column2.setCellValueFactory(new PropertyValueFactory<>("nom"));
        column2.setPrefWidth(100);

        TableColumn<Client, String> column3 = new TableColumn<>("prénom");
        column3.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        column3.setPrefWidth(100);

        TableColumn<Client, String> column4 = new TableColumn<>("téléphone");
        column4.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        column4.setPrefWidth(69);



        tableClient.getColumns().add(column1);
        tableClient.getColumns().add(column2);
        tableClient.getColumns().add(column3);
        tableClient.getColumns().add(column4);



        for (int i = 0; i < resultatDeMaRequete.size(); i++) {


            System.out.println("test1" + resultatDeMaRequete.get(i));

            tableClient.getItems().add(new Client(resultatDeMaRequete.get(i).get(0), resultatDeMaRequete.get(i).get(1), resultatDeMaRequete.get(i).get(2), resultatDeMaRequete.get(i).get(3)));


        }

        // TODO: 12/05/2021
        // Récupéré l'ID au clique et l'insérer dans le champ dédié
        // Changer de tableau via les Tabs
        // update stock -1 quand vendu
    }


    private void initTableVoiture() {

        /************* BDD **************/

        BDDManager2 bdd = new BDDManager2();
        bdd.start("jdbc:mysql://localhost:3306/concession?characterEncoding=utf8", "root", "");
        String queryVoiture = ("SELECT id_voiture, libelle_constructeur, libelle_model, annee, kilometrage, chevaux, nombre_de_porte, vitesse_max\n" +
                "FROM voiture\n" +
                "INNER JOIN model ON model.id_modele = voiture.id_modele\n" +
                "INNER JOIN constructeur ON constructeur.id_constructeur = voiture.id_constructeur\n" +
                "WHERE stock > 0");

        ArrayList<ArrayList<String>> resultatDeMaRequete = new ArrayList<>(bdd.select(queryVoiture));


        /************* TableView **************/

        tableVoiture = new TableView<Voiture>();
        tableVoiture.setLayoutX(445);
        tableVoiture.setLayoutY(131);
        tableVoiture.setPrefHeight(669);
        tableVoiture.setPrefWidth(782);

        TableColumn<Voiture, String> column1 = new TableColumn<>("ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));
        column1.setPrefWidth(20);

        TableColumn<Voiture, String> column2 = new TableColumn<>("constructeur");
        column2.setCellValueFactory(new PropertyValueFactory<>("constructeur"));
        column2.setPrefWidth(100);

        TableColumn<Voiture, String> column3 = new TableColumn<>("modele");
        column3.setCellValueFactory(new PropertyValueFactory<>("modele"));
        column3.setPrefWidth(100);

        TableColumn<Voiture, String> column4 = new TableColumn<>("annee");
        column4.setCellValueFactory(new PropertyValueFactory<>("annee"));
        column4.setPrefWidth(69);

        TableColumn<Voiture, String> column5 = new TableColumn<>("kilometrage");
        column5.setCellValueFactory(new PropertyValueFactory<>("kilometrage"));
        column5.setPrefWidth(150);

        TableColumn<Voiture, String> column6 = new TableColumn<>("chevaux");
        column6.setCellValueFactory(new PropertyValueFactory<>("chevaux"));
        column6.setPrefWidth(100);

        TableColumn<Voiture, String> column7 = new TableColumn<>("nb de porte");
        column7.setCellValueFactory(new PropertyValueFactory<>("nbPorte"));
        column7.setPrefWidth(100);

        TableColumn<Voiture, String> column8 = new TableColumn<>("vitesse");
        column8.setCellValueFactory(new PropertyValueFactory<>("vitesse"));
        column8.setPrefWidth(100);

        tableVoiture.getColumns().add(column1);
        tableVoiture.getColumns().add(column2);
        tableVoiture.getColumns().add(column3);
        tableVoiture.getColumns().add(column4);
        tableVoiture.getColumns().add(column5);
        tableVoiture.getColumns().add(column6);
        tableVoiture.getColumns().add(column7);
        tableVoiture.getColumns().add(column8);


        for (int i = 0; i < resultatDeMaRequete.size(); i++) {


            System.out.println("test1" + resultatDeMaRequete.get(i));

            tableVoiture.getItems().add(new Voiture(resultatDeMaRequete.get(i).get(0), resultatDeMaRequete.get(i).get(1), resultatDeMaRequete.get(i).get(2), resultatDeMaRequete.get(i).get(3), resultatDeMaRequete.get(i).get(4), resultatDeMaRequete.get(i).get(5), resultatDeMaRequete.get(i).get(6), resultatDeMaRequete.get(i).get(7)));

            System.out.println("nb de porte : " + resultatDeMaRequete.get(i).get(6));
        }

        // TODO: 12/05/2021
        // Récupéré l'ID au clique et l'insérer dans le champ dédié
        // Changer de tableau via les Tabs
        // update stock -1 quand vendu
    }


    public void initButton() {

        buttonAjtClient = new Button("Ajout client");
        buttonAjtClient.setTranslateX(posX + 100);
        buttonAjtClient.setTranslateY(posy + 310);
        buttonAjtClient.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                BDDManager2 insert = new BDDManager2();
                insert.start("jdbc:mysql://localhost:3306/concession?characterEncoding=utf8", "root", "");
                String queryClient = ("INSERT INTO client (`id_client`, `nom`, `prenom`, `telephone`) VALUES (null, \""
                        + textFieldNomClient.getText() + "\",  \"" + textFieldPrenomClient.getText() + "\",  " + textFieldTelClient.getText() + "  );");
                insert.insert(queryClient);
                insert.stop();

                //ViewClients viewClients = new ViewClients();
                //viewClients.afficherClients();

                /*
                ViewFormulaireFilm viewFormulaireFilm = new ViewFormulaireFilm(root);
                viewFormulaireFilm.afficherFormulaire();
                 */

            }
        });


        buttonEditClient = new Button("Edit client");
        buttonEditClient.setTranslateX(posX + 180);
        buttonEditClient.setTranslateY(posy + 310);

        buttonEditClient.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                BDDManager2 bdd = new BDDManager2();
                bdd.start("jdbc:mysql://localhost:3306/concession?characterEncoding=utf8", "root", "");
                String queryClient = ("INSERT INTO client (`id_client`, `nom`, `prenom`, `telephone`) VALUES (null, \""
                        + textFieldNomClient.getText() + "\",  \"" + textFieldPrenomClient.getText() + "\",  " + textFieldTelClient.getText() + "  +
                        + " WHERE id_client = \"" + textFieldIDVoiture.getText() + "\" );");
                bdd.update(queryClient);
                bdd.stop();

                //ViewClients viewClients = new ViewClients();
                //viewClients.afficherClients();

                /*
                ViewFormulaireFilm viewFormulaireFilm = new ViewFormulaireFilm(root);
                viewFormulaireFilm.afficherFormulaire();
                 */

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
        tabClient.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                initTableClient();
                root.getChildren().add(tableClient);
            }
        });

        tabVoiture = new Button("Voitures");
        tabVoiture.setTranslateX((500));
        tabVoiture.setTranslateY(100);
        tabVoiture.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                initTableVoiture();
                root.getChildren().add(tableVoiture);

            }
        });
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
        root.getChildren().add(textFieldIDVoiture);
        root.getChildren().add(textVoiture);

        root.getChildren().add(tableVoiture);
        //root.getChildren().add(tableClient);

        root.getChildren().addAll(tabClient);
        root.getChildren().addAll(tabVoiture);

        root.getChildren().add(buttonAjtClient);
        root.getChildren().add(buttonEditClient);

        root.getChildren().add(retour);

    }

    public ImageView getRetour() {
        return retour;
    }


}