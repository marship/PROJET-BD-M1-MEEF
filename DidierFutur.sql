DROP TABLE FILM;
DROP TABLE REALISATEUR;
DROP TABLE ACTEUR;
DROP TABLE JOUER;
DROP TABLE CATEGORIE;
DROP TABLE CARTE_BANCAIRE; 
DROP TABLE CLIENT;
DROP TABLE SOUHAIT;
DROP TABLE EMPRUNT;
DROP TABLE TARIF;
DROP TABLE CARTE_ABONNEMENT;
DROP TABLE HISTORIQUE; 

CREATE TABLE REALISATEUR (
    NomRealisateur varchar2(100),
    DateNaissanceRealisateur date,
    NationnaliteRealisateur varchar2(100),
    constraint REALISATEUR_C1_PK primary key (NomRealisateur)
);
INSERT INTO REALISATEUR (NomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Jackson', TO_DATE('31/10/1961', 'DD/MM/YYYY'), 'Neo-Zelandais');
INSERT INTO REALISATEUR (NomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Walt Didier', TO_DATE('05/12/1901', 'DD/MM/YYYY'), 'Americain');
INSERT INTO REALISATEUR (NomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Coogler', TO_DATE('23/05/1986', 'DD/MM/YYYY'), 'Americain');

CREATE TABLE ACTEUR (
    NomActeur varchar2(100),
    DateNaissanceActeur date,
    NationnaliteActeur varchar2(100),
    constraint ACTEUR_C1_PK primary key (NomActeur)
);
INSERT INTO ACTEUR (NomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Didier Depp', TO_DATE('09/06/1963', 'DD/MM/YYYY'), 'Americain');
INSERT INTO ACTEUR (NomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Didier Mortensen', TO_DATE('20/10/1958', 'DD/MM/YYYY'), 'Americain');
INSERT INTO ACTEUR (NomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Sean Didier', TO_DATE('25/02/1971', 'DD/MM/YYYY'), 'Americain');
INSERT INTO ACTEUR (NomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Didier Bloom', TO_DATE('13/01/1977', 'DD/MM/YYYY'), 'Americain');
INSERT INTO ACTEUR (NomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Didier McKellen', TO_DATE('25/04/1939', 'DD/MM/YYYY'), 'Britannique');
INSERT INTO ACTEUR (NomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Didier Bean', TO_DATE('17/04/1959', 'DD/MM/YYYY'), 'Britannique');
INSERT INTO ACTEUR (NomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Chadwick Didier', TO_DATE('29/11/1976', 'DD/MM/YYYY'), 'Americain');
INSERT INTO ACTEUR (NomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Lupita Didier', TO_DATE('1/03/1983', 'DD/MM/YYYY'), 'Mexicain');

CREATE TABLE FILM (
	NomFilm varchar2(100),
	ResumeFilm varchar2(1000),
    DateSortie date,
    DureeFilm date,
    NombreExemplaireFilm number(3) not null,
    LimiteAgeFilm number(2) DEFAULT 0,
    DateAjoutFilm date,
    NombreTotalLocationFilm number(10) DEFAULT 0,
    NomRealisateur varchar2(100),
	constraint FILM_C1_PK primary key (NomFilm),
    constraint FILM_C2_NB_EXEMPLAIRES check (NombreExemplaireFilm between 1 and 101),
    constraint FILM_C3_FK1 foreign key (NomRealisateur) references REALISATEUR (NomRealisateur)
);

CREATE TABLE JOUER (
    NomFilm varchar2(100),
    NomActeur varchar2(100),
    constraint JOUER_C1_PK primary key (NomFilm, NomActeur),
    constraint JOUER_C2_FK1 foreign key (NomFilm) references FILM (NomFilm),
    constraint JOUER_C3_FK2 foreign key (NomActeur) references ACTEUR (NomActeur)
);

CREATE TABLE CATEGORIE (
    NomFilm varchar2(100),
    NomGenre varchar2(100),
    constraint CATEGORIE_C1_PK primary key (NomFilm, NomGenre),
    constraint CATEGORIE_C2_FK1 foreign key (NomFilm) references FILM (NomFilm)
);

CREATE TABLE CARTE_BANCAIRE (
    NumeroCarteBancaire varchar2(17),
    ExpirationCarteBancaire date,
    PictogrammeCarteBancaire varchar2(4),
    AdresseMailClient varchar2(100) not null,
    constraint CARTE_BANCAIRE_C1_PK primary key (NumeroCarteBancaire, ExpirationCarteBancaire, PictogrammeCarteBancaire),
    constraint CARTE_BANCAIRE_C2_FK1 foreign key (AdresseMailClient) references CLIENT (AdresseMailClient)
);

CREATE TABLE CLIENT (
    AdresseMailClient varchar2(100) not null,
	NomClient varchar2(100) not null,
	PrenomClient varchar2(100) not null,
    AdressePostalClient varchar2(100),
    DateNaissanceClient date,
    NumeroTelephoneClient varchar2(11),
    MotDePasseClient varchar2(100) not null,
	constraint CLIENT_C1_PK primary key (AdresseMailClient)
);

CREATE TABLE SOUHAIT (
    NomFilm varchar2(100),
    AdresseMailClient varchar2(100),
    constraint SOUHAIT_C1_PK primary key (NomFilm, AdresseMailClient),
    constraint SOUHAIT_C2_FK1 foreign key (NomFilm) references FILM (NomFilm),
    constraint SOUHAIT_C3_FK2 foreign key (AdresseMailClient) references CLIENT (AdresseMailClient)
);

CREATE TABLE TARIF (
    NomTarif varchar2(100),
    PrixTarif number(4),
    constraint TARIF_C1_PK primary key (NomTarif)
);

CREATE TABLE EMPRUNT (
    DateDebutEmprunt date not null,
    TypeEmprunt varchar2(100) not null,
    NomFilm varchar2(100),
    AdresseMailClient varchar2(100),
    NomTarif varchar2(100),
    constraint EMPRUNT_C1_PK primary key (DateDebutEmprunt, NomFilm, AdresseMailClient),
    constraint EMPRUNT_C2_FK1 foreign key (NomFilm) references FILM (NomFilm),
    constraint EMPRUNT_C3_FK2 foreign key (AdresseMailClient) references CLIENT (AdresseMailClient),
    constraint EMPRUNT_C4_FK3 foreign key (NomTarif) references TARIF (NomTarif)
);

CREATE TABLE CARTE_ABONNEMENT (
    NomCarteAbonnement varchar2(100),
    SoldeCarteAbonnement number(4),
    AgePropietaireCarteAbonnement number(4),
    AdresseMailClient varchar2(100),
    constraint CARTE_ABONNEMENT_C1_PK primary key (NomCarteAbonnement, AdresseMailClient),
    constraint CARTE_ABONNEMENT_C2_FK2 foreign key (AdresseMailClient) references CLIENT (AdresseMailClient)
);

CREATE TABLE HISTORIQUE (
    DateDebutEmprunt date not null,
    DateFinEmprunt date not null,
    TypeEmprunt varchar2(100) not null,
    NomFilm varchar2(100),
    AdresseMailClient varchar2(100),
    constraint HISTORIQUE_C1_PK primary key (DateDebutEmprunt, NomFilm, AdresseMailClient),
    constraint HISTORIQUE_C2_FK1 foreign key (NomFilm) references FILM (NomFilm),
    constraint HISTORIQUE_C3_FK2 foreign key (AdresseMailClient) references CLIENT (AdresseMailClient)
);