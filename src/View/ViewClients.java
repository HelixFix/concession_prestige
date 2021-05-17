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
    private Integer posy = 230;

    private TextField textFieldIdClient;
    private Text textidClient;
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
    private Button buttonVenteVoiture;

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
        titreFormulaire.setTranslateX(posX + 90);
        titreFormulaire.setTranslateY(posy + 10);
        titreFormulaire.setFill(Color.WHITE);
        titreFormulaire.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");


        // ID du client
        textFieldIdClient = new TextField();
        textFieldIdClient.setTranslateX(posX + 150);
        textFieldIdClient.setTranslateY(posy + 50);

        textidClient = new Text("ID :");
        textidClient.setTranslateX(posX + 10);
        textidClient.setTranslateY(posy + 70);
        textidClient.setFill(Color.rgb(140, 128, 113));
        textidClient.setFill(Color.WHITE);
        textidClient.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");



        // Nom du client
        textFieldNomClient = new TextField();
        textFieldNomClient.setTranslateX(posX + 150);
        textFieldNomClient.setTranslateY(posy + 90);

        textNomClient = new Text("Nom : ");
        textNomClient.setTranslateX(posX + 10);
        textNomClient.setTranslateY(posy + 110);
        textNomClient.setFill(Color.WHITE);
        textNomClient.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");

        // Prénom du client
        textFieldPrenomClient = new TextField();
        textFieldPrenomClient.setTranslateX(posX + 150);
        textFieldPrenomClient.setTranslateY(posy + 130);

        textPrenomClient = new Text("Prénom : ");
        textPrenomClient.setTranslateX(posX + 10);
        textPrenomClient.setTranslateY(posy + 150);
        textPrenomClient.setFill(Color.rgb(140, 128, 113));
        textPrenomClient.setFill(Color.WHITE);
        textPrenomClient.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");

        // Téléphone du client
        textFieldTelClient = new TextField();
        textFieldTelClient.setTranslateX(posX + 150);
        textFieldTelClient.setTranslateY(posy + 170);

        texttelClient = new Text("Téléphone : ");
        texttelClient.setTranslateX(posX + 10);
        texttelClient.setTranslateY(posy + 190);
        texttelClient.setFill(Color.rgb(140, 128, 113));
        texttelClient.setFill(Color.WHITE);
        texttelClient.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");

        // Voiture
        textFieldIDVoiture = new TextField();
        textFieldIDVoiture.setTranslateX(posX + 150);
        textFieldIDVoiture.setTranslateY(posy + 310);

        textVoiture = new Text("ID voiture : ");
        textVoiture.setTranslateX(posX + 10);
        textVoiture.setTranslateY(posy + 330);
        textVoiture.setFill(Color.rgb(140, 128, 113));
        textVoiture.setFill(Color.WHITE);
        textVoiture.setStyle("-fx-background-color: transparent;-fx-text-fill: white ;-fx-font-size: 2em;-fx-font-weight: bold;");

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
        // ajout table vente
    }


    public void initButton() {

        buttonAjtClient = new Button("Ajout client");
        buttonAjtClient.setTranslateX(posX + 100);
        buttonAjtClient.setTranslateY(posy + 210);
        buttonAjtClient.setMinWidth(80);
        buttonAjtClient.setMinHeight(20);
        buttonAjtClient.setStyle("-fx-background-color: rgba(82,157,193); -fx-text-fill: white ;-fx-font-size: 1em;-fx-font-weight: bold;");

        buttonAjtClient.setCursor(Cursor.HAND);
        buttonAjtClient.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                BDDManager2 insert = new BDDManager2();
                insert.start("jdbc:mysql://localhost:3306/concession?characterEncoding=utf8", "root", "");
                String queryClient = ("INSERT INTO client (`id_client`, `nom`, `prenom`, `telephone`) VALUES (null, \""
                        + textFieldNomClient.getText() + "\",  \"" + textFieldPrenomClient.getText() + "\",  " + textFieldTelClient.getText() + "  );");
                insert.insert(queryClient);
                insert.stop();

                // Vide les champs
                textFieldNomClient.clear();
                textFieldPrenomClient.clear();
                textFieldTelClient.clear();

                // Recharge la table client
                initTableClient();
                root.getChildren().add(tableClient);

                // Active style
                tabClient.setStyle("-fx-background-color: rgba(82,157,193); -fx-text-fill: white ;-fx-font-size: 1em;-fx-font-weight: bold;");;

                // Inactive tab
                tabVoiture.setStyle("-fx-background-color: rgba(255,255,255); -fx-text-fill: black ;-fx-font-size: 1em;");

                //ViewClients viewClients = new ViewClients();
                //viewClients.afficherClients();

                /*
                ViewFormulaireFilm viewFormulaireFilm = new ViewFormulaireFilm(root);
                viewFormulaireFilm.afficherFormulaire();
                 */

            }
        });


        buttonEditClient = new Button("Edit client");
        buttonEditClient.setTranslateX(posX + 200);
        buttonEditClient.setTranslateY(posy + 210);
        buttonEditClient.setMinWidth(80);
        buttonEditClient.setMinHeight(20);
        buttonEditClient.setStyle("-fx-background-color: rgba(82,157,193); -fx-text-fill: white ;-fx-font-size: 1em;-fx-font-weight: bold;");
        buttonEditClient.setCursor(Cursor.HAND);

        buttonEditClient.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                BDDManager2 bdd = new BDDManager2();
                bdd.start("jdbc:mysql://localhost:3306/concession?characterEncoding=utf8", "root", "");
                String queryClient = ("UPDATE `client` SET `nom` = \"" + textFieldNomClient.getText() + "\", `prenom` = \"" + textFieldPrenomClient.getText() + "\", `telephone` = " + textFieldTelClient.getText() + " WHERE `client`.`id_client` = " + textFieldIdClient.getText() + "");
                bdd.update(queryClient);
                bdd.stop();

                // Vide les champs
                textFieldIdClient.clear();
                textFieldNomClient.clear();
                textFieldPrenomClient.clear();
                textFieldTelClient.clear();

                // Recharge la table client
                initTableClient();
                root.getChildren().add(tableClient);

                // Active style
                tabClient.setStyle("-fx-background-color: rgba(82,157,193); -fx-text-fill: white ;-fx-font-size: 1em;-fx-font-weight: bold;");;

                // Inactive tab
                tabVoiture.setStyle("-fx-background-color: rgba(255,255,255); -fx-text-fill: black ;-fx-font-size: 1em;");

                //ViewClients viewClients = new ViewClients();
                //viewClients.afficherClients();

                /*
                ViewFormulaireFilm viewFormulaireFilm = new ViewFormulaireFilm(root);
                viewFormulaireFilm.afficherFormulaire();
                 */

            }
        });

        buttonVenteVoiture = new Button("Vendre");
        buttonVenteVoiture.setTranslateX(posX + 100);
        buttonVenteVoiture.setTranslateY(posy + 350);
        buttonVenteVoiture.setMinWidth(80);
        buttonVenteVoiture.setMinHeight(20);
        buttonVenteVoiture.setStyle("-fx-background-color: rgba(82,157,193); -fx-text-fill: white ;-fx-font-size: 1em;-fx-font-weight: bold;");
        buttonVenteVoiture.setCursor(Cursor.HAND);

        buttonVenteVoiture.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                BDDManager2 bdd = new BDDManager2();
                bdd.start("jdbc:mysql://localhost:3306/concession?characterEncoding=utf8", "root", "");
                String queryClient = ("INSERT INTO `acheter` (`id_voiture`, `id_client`, `vendeur`, `date`) VALUES (\"" + textFieldIDVoiture.getText() + "\", \"" + textFieldIdClient.getText() + "\", '', CURDATE())");
                bdd.insert(queryClient);
                bdd.stop();

                // Vide les champs
                textFieldIdClient.clear();
                textFieldNomClient.clear();
                textFieldPrenomClient.clear();
                textFieldTelClient.clear();
                textFieldIDVoiture.clear();

                // Recharge la table client
                initTableClient();
                root.getChildren().add(tableClient);

                // Active style
                tabClient.setStyle("-fx-background-color: rgba(82,157,193); -fx-text-fill: white ;-fx-font-size: 1em;-fx-font-weight: bold;");;

                // Inactive tab
                tabVoiture.setStyle("-fx-background-color: rgba(255,255,255); -fx-text-fill: black ;-fx-font-size: 1em;");



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
        tabClient.setStyle("-fx-background-color: rgba(255,255,255); -fx-text-fill: black ;-fx-font-size: 1em;");
        tabClient.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                // Active style
                tabClient.setStyle("-fx-background-color: rgba(82,157,193); -fx-text-fill: white ;-fx-font-size: 1em;-fx-font-weight: bold;");;

                // Inactive tab
                tabVoiture.setStyle("-fx-background-color: rgba(255,255,255); -fx-text-fill: black ;-fx-font-size: 1em;");

                initTableClient();
                root.getChildren().add(tableClient);
            }
        });

        tabVoiture = new Button("Voitures");
        tabVoiture.setTranslateX((500));
        tabVoiture.setTranslateY(100);
        tabVoiture.setStyle("-fx-background-color: rgba(82,157,193); -fx-text-fill: white ;-fx-font-size: 1em;-fx-font-weight: bold;");;
        tabVoiture.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                // Actvie style
                tabVoiture.setStyle("-fx-background-color: rgba(82,157,193); -fx-text-fill: white ;-fx-font-size: 1em;-fx-font-weight: bold;");;

                // Inactive tab
                tabClient.setStyle("-fx-background-color: rgba(255,255,255); -fx-text-fill: black ;-fx-font-size: 1em;");

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
        root.getChildren().add(textFieldIdClient);
        root.getChildren().add(textidClient);
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
        root.getChildren().add(buttonVenteVoiture);

        root.getChildren().add(retour);

    }

    public ImageView getRetour() {
        return retour;
    }


}