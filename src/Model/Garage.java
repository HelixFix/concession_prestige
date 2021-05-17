package Model;

public class Garage {

    private String id;
    private String constructeur;
    private String modele;
    private String annee;
    private String kilometrage;
    private String chevaux;
    private String nbPorte;



    public Garage(String id, String annee, String kilometrage, String chevaux, String nbPorte, String constructeur, String modele) {
        this.id = id;


        this.annee = annee;
        this.kilometrage = kilometrage;
        this.chevaux = chevaux;
        this.nbPorte = nbPorte;
        this.constructeur= constructeur;
        this.modele=modele;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConstructeur() {
        return constructeur;
    }

    public void setConstructeur(String constructeur) {
        this.constructeur = constructeur;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(String kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getChevaux() {
        return chevaux;
    }

    public void setChevaux(String chevaux) {
        this.chevaux = chevaux;
    }

    public String getNbPorte() {
        return nbPorte;
    }

    public void setNbPorte(String nbPorte) {
        this.nbPorte = nbPorte;
    }


}