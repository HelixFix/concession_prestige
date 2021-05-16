package Model;

public class Vente {

private String vendeur;

private  String libelle_modele;
private  String  prix;
private  String annee;

private String  date;

private  String libelle_constructeur;

    public Vente(String vendeur, String libelle_constructeur , String libelle_modele, String prix, String annee, String date) {
        this.vendeur = vendeur;
        this.libelle_constructeur = libelle_constructeur;
        this.libelle_modele = libelle_modele;
        this.prix = prix;
        this.annee = annee;
        this.date = date;

    }

    public String getVendeur() {
        return vendeur;
    }

    public void setVendeur(String vendeur) {
        this.vendeur = vendeur;
    }

    public String getLibelle_modele() {
        return libelle_modele;
    }

    public void setLibelle_modele(String libelle_modele) {
        this.libelle_modele = libelle_modele;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLibelle_constructeur() {
        return libelle_constructeur;
    }

    public void setLibelle_constructeur(String libelle_constructeur) {
        this.libelle_constructeur = libelle_constructeur;
    }
}

