DROP TABLE FILM;
DROP TABLE REALISATEUR;
DROP TABLE ACTEUR;
DROP TABLE JOUER;
DROP TABLE GENRE;
DROP TABLE CATEGORIE;
DROP TABLE CARTE_BANCAIRE; 
DROP TABLE CLIENT;
DROP TABLE SOUHAIT;
DROP TABLE EMPRUNT;
DROP TABLE TARIF;
DROP TABLE CARTE_ABONNEMENT;
DROP TABLE HISTORIQUE; 

CREATE TABLE REALISATEUR (
    IdRealisateur number(4),
    NomRealisateur varchar2(100) not null,
    PrenomRealisateur varchar2(100) not null,
    DateNaissanceRealisateur date,
    NationnaliteRealisateur varchar2(100),
    constraint REALISATEUR_C1_PK primary key (IdRealisateur)
);

CREATE TABLE ACTEUR (
    IdActeur number(4),
    NomActeur varchar2(100) not null,
    PrenomActeur varchar2(100) not null,
    DateNaissanceActeur date,
    NationnaliteActeur varchar2(100),
    constraint ACTEUR_C1_PK primary key (IdActeur)
);

CREATE TABLE FILM (
	IdFilm number(4),
	NomFilm varchar2(100) not null,
	ResumeFilm varchar2(1000),
    DateSortie date,
    DureeFilm time,
    NombreExemplaireFilm number(3) not null,
    LimiteAgeFilm number(2) DEFAULT 0,
    DateAjoutFilm date,
    NombreTotalLocationFilm number(1000) DEFAULT 0,
    IdRealisateur number(4),
	constraint FILM_C1_PK primary key (idFilm),
    constraint FILM_C2_NB_EXEMPLAIRES check (NombreExemplaireFilm between 1 and 101),
    constraint FILM_C3_FK1 foreign key (IdRealisateur) references REALISATEUR (IdRealisateur)
);

CREATE TABLE JOUER (
    IdFilm number(4),
    IdActeur number(4),
    constraint JOUER_C1_PK primary key (IdFilm, IdActeur),
    constraint JOUER_C2_FK1 foreign key (IdFilm) references FILM (IdFilm),
    constraint JOUER_C3_FK2 foreign key (IdActeur) references ACTEUR (IdActeur)
);

CREATE TABLE GENRE (
    IdGenre number(4),
    NomGenre varchar2(100) not null,
    DescriptionGenre varchar2(100),
    constraint GENRE_C1_PK primary key (IdGenre)
);

CREATE TABLE CATEGORIE (
    IdFilm number(4),
    IdGenre number(4),
    constraint CATEGORIE_C1_PK primary key (IdFilm, IdGenre),
    constraint CATEGORIE_C2_FK1 foreign key (IdFilm) references FILM (IdFilm),
    constraint CATEGORIE_C3_FK2 foreign key (IdGenre) references GENRE (IdGenre)
);

CREATE TABLE CARTE_BANCAIRE (
    IdCarteBancaire number(4),
    NumeroCarteBancaire varchar2(17),
    ExpirationCarteBancaire date,
    PictogrammeCarteBancaire varchar2(4),
    constraint CARTE_BANCAIRE_C1_PK primary key (IdCarteBancaire)
);

CREATE TABLE CLIENT (
	IdClient number(4),
	NomClient varchar2(100) not null,
	PrenomClient varchar2(100) not null,
    AdresseMailClient varchar2(100) not null,
    AdressePostalClient varchar2(100),
    DateNaissanceClient date,
    NumeroTelephoneClient varchar2(11),
    MotDePasseClient varchar2(100) not null,
    IdCarteBancaire number(4),
	constraint CLIENT_C1_PK primary key (IdClient),
    constraint CLIENT_C2_FK1 foreign key (IdCarteBancaire) references CARTE_BANCAIRE (IdCarteBancaire)
);

CREATE TABLE SOUHAIT (
    IdFilm number(4),
    IdClient number(4),
    constraint JOUER_C1_PK primary key (IdFilm, IdClient),
    constraint JOUER_C2_FK1 foreign key (IdFilm) references FILM (IdFilm),
    constraint JOUER_C3_FK2 foreign key (IdClient) references CLIENT (IdClient)
);

CREATE TABLE TARIF (
    IdTarif number(4),
    TarifClientLambda number(4),
    TarifClientAbonne number(4),
    constraint EMPRUNT_C1_PK primary key (IdTarif)
);

CREATE TABLE EMPRUNT (
    IdEmprunt number(4),
    DateDebutEmprunt date not null,
    TypeEmprunt varchar2(100) not null,
    IdFilm number(4),
    IdClient number(4),
    IdTarif number(4),
    constraint EMPRUNT_C1_PK primary key (IdEmprunt),
    constraint EMPRUNT_C2_FK1 foreign key (IdFilm) references FILM (IdFilm),
    constraint EMPRUNT_C3_FK2 foreign key (IdClient) references CLIENT (IdClient),
    constraint EMPRUNT_C4_FK3 foreign key (IdTarif) references TARIF (IdTarif)
);

CREATE TABLE CARTE_ABONNEMENT (
    IdCarteAbonnement number(4),
    SoldeCarteAbonnement number(4),
    AgePropietaireCarteAbonnement number(4),
    IdClient number(4),
    constraint CARTE_ABONNEMENT_C1_PK primary key (IdCarteAbonnement),
    constraint CARTE_ABONNEMENT_C2_FK2 foreign key (IdClient) references CLIENT (IdClient)
);

CREATE TABLE HISTORIQUE (
    IdHistorique number(4),
    DureeEmprunt time not null,
    NomRealisateur varchar2(100) not null,
    IdFilm number(4),
    IdClient number(4),
    constraint HISTORIQUE_C1_PK primary key (IdHistorique),
    constraint HISTORIQUE_C2_FK1 foreign key (IdFilm) references FILM (IdFilm),
    constraint HISTORIQUE_C3_FK2 foreign key (IdClient) references CLIENT (IdClient)
);