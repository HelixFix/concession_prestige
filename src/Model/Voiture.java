package Model;

public class Voiture {

    private String id;
    private String constructeur;
    private String modele;
    private String annee;
    private String kilometrage;
    private String chevaux;
    private String nbPorte;
    private String vitesse;

    public Voiture(String id, String constructeur, String modele, String annee, String kilometrage, String chevaux, String nbPorte, String vitesse) {
        this.id = id;
        this.constructeur = constructeur;
        this.modele = modele;
        this.annee = annee;
        this.kilometrage = kilometrage;
        this.chevaux = chevaux;
        this.nbPorte = nbPorte;
        this.vitesse = vitesse;
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

    public String getVitesse() {
        return vitesse;
    }

    public void setVitesse(String vitesse) {
        this.vitesse = vitesse;
    }
}
