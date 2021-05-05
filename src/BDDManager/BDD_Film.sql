DROP DATABASE IF EXISTS DVDTHEQUE;

CREATE DATABASE DVDTHEQUE;
USE DVDTHEQUE;

CREATE TABLE Realisateur(
        Id_Realisateur   Int Auto_increment NOT NULL PRIMARY KEY,
        Nom_Realisateur      Varchar (50) NOT NULL,
        Prenom_Realisateur   Varchar (50) NOT NULL
);

CREATE TABLE Nationalite(
        Id_Nationalite   Int Auto_increment NOT NULL PRIMARY KEY,
        Libelle_Nationalite      Varchar (250) NOT NULL
);

CREATE TABLE Film(
        Id_Film     Int  Auto_increment  NOT NULL PRIMARY KEY,
        Nom_Film    Varchar (50) NOT NULL,
        Annee_Film  Int (250) NOT NULL,
        Note_Film   Int (250) NOT NULL,
        Resume_Film Varchar (500) NOT NULL,
        Image_Film  Varchar (250) NOT NULL,
        Realisateur_id int,
        Nationalite_id int,
        CONSTRAINT fkRealFilm FOREIGN KEY (Realisateur_id) REFERENCES Realisateur(Id_Realisateur),
        CONSTRAINT fkNationaliteFilm FOREIGN KEY (Nationalite_id) REFERENCES Nationalite(Id_Nationalite)
);

CREATE TABLE Acteur(
        Id_Acteur       Int Auto_increment NOT NULL PRIMARY KEY,
        Nom_Acteur      Varchar (50) NOT NULL,
        Prenom_Acteur   Varchar (50) NOT NULL
);

CREATE TABLE Genre(
        Id_Genre        Int Auto_increment NOT NULL PRIMARY KEY,
        Libelle_Genre   Varchar (50) NOT NULL
);

CREATE TABLE Film_Acteur(
        Film_id    Int,
        Acteur_id   Int,
        PRIMARY KEY(Film_id,Acteur_id),
        CONSTRAINT fkFilmActeur1 FOREIGN KEY (Film_id) REFERENCES Film(Id_Film),
        CONSTRAINT fkFilmActeur2 FOREIGN KEY (Acteur_id) REFERENCES Acteur(Id_Acteur)
);

CREATE TABLE Film_Genre(
        Film_id    Int,
        Genre_id   Int,
        PRIMARY KEY(Film_id,Genre_id),
        CONSTRAINT fkFilmGenre1 FOREIGN KEY (Film_id) REFERENCES Film(Id_Film),
        CONSTRAINT fkFilmGenre2 FOREIGN KEY (Genre_id) REFERENCES Genre(Id_Genre)
);

INSERT INTO Genre values (null, "Comédie");
INSERT INTO Genre values (null, "Science-Fiction");
INSERT INTO Genre values (null, "Fantastique");
INSERT INTO Genre values (null, "Biopic");