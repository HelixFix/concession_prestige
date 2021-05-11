

DROP DATABASE IF EXISTS CONCESSION;

CREATE DATABASE CONCESSION;

USE CONCESSION;




CREATE TABLE client(
        id_client Int  Auto_increment  NOT NULL ,
        nom       Varchar (50) NOT NULL ,
        prenom    Varchar (50) NOT NULL ,
        telephone Varchar (50) NOT NULL
	,CONSTRAINT client_PK PRIMARY KEY (id_client)
)ENGINE=InnoDB;




CREATE TABLE model(
        id_modele     Int  Auto_increment  NOT NULL ,
        libelle_model Varchar (40) NOT NULL
	,CONSTRAINT model_PK PRIMARY KEY (id_modele)
)ENGINE=InnoDB;




CREATE TABLE constructeur(
        id_constructeur      Int  Auto_increment  NOT NULL ,
        libelle_constructeur Varchar (40) NOT NULL
	,CONSTRAINT constructeur_PK PRIMARY KEY (id_constructeur)
)ENGINE=InnoDB;




CREATE TABLE voiture(
        id_voiture      Int  Auto_increment  NOT NULL ,
        annee           Int NOT NULL ,
        kilometrage     Int NOT NULL ,
        chevaux         Int NOT NULL ,
        nombre_de_porte Int NOT NULL ,
        couleur         Varchar (20) NOT NULL ,
        vitesse_max     Varchar (5) NOT NULL ,
        prix            Float NOT NULL ,
        stock           Int NOT NULL ,
        vendeur         Varchar (40) NOT NULL ,
        datetime        Datetime NOT NULL ,
        id_client       Int NOT NULL ,
        id_modele       Int NOT NULL ,
        id_constructeur Int NOT NULL
	,CONSTRAINT voiture_PK PRIMARY KEY (id_voiture)

	,CONSTRAINT voiture_client_FK FOREIGN KEY (id_client) REFERENCES client(id_client)
	,CONSTRAINT voiture_model0_FK FOREIGN KEY (id_modele) REFERENCES model(id_modele)
	,CONSTRAINT voiture_constructeur1_FK FOREIGN KEY (id_constructeur) REFERENCES constructeur(id_constructeur)
)ENGINE=InnoDB;
