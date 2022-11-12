DROP TABLE HISTORIQUE;
DROP TABLE CARTE_ABONNEMENT;
DROP TABLE EMPRUNT;
DROP TABLE SOUHAIT;
DROP TABLE CARTE_BANCAIRE;
DROP TABLE CATEGORIE;
DROP TABLE JOUER;
DROP TABLE FILM;
DROP TABLE SUPPORT;
DROP TABLE TARIF;
DROP TABLE CLIENT;
DROP TABLE GENRE;
DROP TABLE ACTEUR;
DROP TABLE REALISATEUR;

/***********************************/
/*********** REALISATEUR ***********/
/***********************************/
CREATE TABLE REALISATEUR (
    NomPrenomRealisateur varchar2(100) not null,
    DateNaissanceRealisateur date,
    NationnaliteRealisateur varchar2(100),
    constraint REALISATEUR_C1_PK_NomReal primary key (NomPrenomRealisateur)
);
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Jackson', TO_DATE('31/10/1961', 'DD/MM/YYYY'), 'Neo-Zelandais');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Walt Didier', TO_DATE('05/12/1901', 'DD/MM/YYYY'), 'Americain');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Coogler', TO_DATE('23/05/1986', 'DD/MM/YYYY'), 'Americain');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Marsh', TO_DATE('30/04/1963', 'DD/MM/YYYY'), 'Britannique');

INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Lynch', TO_DATE('20/01/1946', 'DD/MM/YYYY'), 'Americain');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Kubrick', TO_DATE('26/07/1928', 'DD/MM/YYYY'), 'Americain');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Fincher', TO_DATE('28/08/1962', 'DD/MM/YYYY'), 'Americain');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Kurosawa', TO_DATE('23/03/1910', 'DD/MM/YYYY'), 'Japonais');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Godard', TO_DATE('3/12/1930', 'DD/MM/YYYY'), 'Franco-suisse');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Kitano', TO_DATE('18/01/1947', 'DD/MM/YYYY'), 'Japonais');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Leone', TO_DATE('3/01/1929', 'DD/MM/YYYY'), 'Italien');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Hitchcock', TO_DATE('13/08/1899', 'DD/MM/YYYY'), 'Britannique');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Malik', TO_DATE('30/11/1943', 'DD/MM/YYYY'), 'Americain');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Scorsese', TO_DATE('17/11/1942', 'DD/MM/YYYY'), 'Italo-americain');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Chaplin', TO_DATE('15/04/1889', 'DD/MM/YYYY'), 'Britannique');


/***********************************/
/************** ACTEUR *************/
/***********************************/
CREATE TABLE ACTEUR (
    NomPrenomActeur varchar2(100) not null,
    DateNaissanceActeur date,
    NationnaliteActeur varchar2(100),
    constraint ACTEUR_C1_PK_NomActeur primary key (NomPrenomActeur)
);
INSERT INTO ACTEUR (NomPrenomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Didier Depp', TO_DATE('09/06/1963', 'DD/MM/YYYY'), 'Americain');
INSERT INTO ACTEUR (NomPrenomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Didier Mortensen', TO_DATE('20/10/1958', 'DD/MM/YYYY'), 'Americain');
INSERT INTO ACTEUR (NomPrenomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Sean Didier', TO_DATE('25/02/1971', 'DD/MM/YYYY'), 'Americain');
INSERT INTO ACTEUR (NomPrenomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Didier Bloom', TO_DATE('13/01/1977', 'DD/MM/YYYY'), 'Americain');
INSERT INTO ACTEUR (NomPrenomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Didier McKellen', TO_DATE('25/04/1939', 'DD/MM/YYYY'), 'Britannique');
INSERT INTO ACTEUR (NomPrenomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Didier Bean', TO_DATE('17/04/1959', 'DD/MM/YYYY'), 'Britannique');
INSERT INTO ACTEUR (NomPrenomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Chadwick Didier', TO_DATE('29/11/1976', 'DD/MM/YYYY'), 'Americain');
INSERT INTO ACTEUR (NomPrenomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Lupita Didier', TO_DATE('1/03/1983', 'DD/MM/YYYY'), 'Mexicain');
INSERT INTO ACTEUR (NomPrenomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Didier Redmayne', TO_DATE('6/01/1982', 'DD/MM/YYYY'), 'Britannique');

/***********************************/
/************** GENRE **************/
/***********************************/
CREATE TABLE GENRE (
    NomGenre varchar2(100) not null,
    DescriptionGenre LONG VARCHAR,
    constraint GENRE_C1_PK_NomGenre primary key (NomGenre)
);
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Fantasy', 'Le cinéma de fantasy est un genre cinématographique fondé sur l imaginaire et le merveilleux de la culture anglo-saxonne, il est apparenté au cinéma onirique européen dont il partage quelques points communs. Il est rattaché au cinéma fantastique.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Aventure', 'Le film d aventures ou film d aventure (au singulier) est un genre cinématographique caractérisé par la présence d un héros fictif ou non, tirant son statut du mythe qu il inspire, l action particulière qui s y déroule, l emploi de décors particuliers également, parfois le décalage temporel par rapport au contemporain ainsi que, parfois, les invraisemblances voulues caractérisant ainsi son excentricité, le tout véhiculant une idée générale de dépaysement.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Super-héros', 'Un film de super-héros est un sous-genre cinématographique appartenant au genre de la science-fiction, des films d action, ou de la fantasy et mettant en scène les actions d un ou plusieurs super-héros, individus qui possèdent des pouvoirs surhumains et s en servent pour protéger la population.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Biographique', 'Un film biographique, également connu dans le milieu du cinéma sous l anglicisme biopic (contraction de « biographical motion picture »), est une œuvre cinématographique de fiction, centrée sur la description biographique d un personnage principal qui a réellement existé. Les événements et l environnement de son époque sont donc subordonnés à son récit.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Comédie', 'La comédie est, au cinéma, un genre cinématographique dont une des caractéristiques majeures est l humour.')
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Drame', 'Le drame est un genre cinématographique qui traite des situations généralement non épiques dans un contexte sérieux, sur un ton plus susceptible d inspirer la tristesse que le rire. Néanmoins, le drame évoque étymologiquement l action.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Romance', 'Le film d amour est un film portant sur une histoire d amour ou d aventure amoureuse, mettant en avant la passion, les émotions et l engagement affectif des personnages principaux.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Action', 'Le film d action est un genre cinématographique qui met en scène une succession de scènes spectaculaires souvent stéréotypées (courses-poursuites, fusillades, explosions…) construites autour d un conflit résolu de manière violente, généralement par la mort des ennemis du héros. ');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Historique', 'Un film historique est un genre cinématographique qui est fondé sur le principe de la fiction historique et qui met en scène des évènements historiques.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Western', 'Le western est un genre cinématographique dont l action se déroule généralement en Amérique du Nord, plus spécialement aux États-Unis, lors de la conquête de l Ouest dans les dernières décennies du XIXe siècle.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Péplum', 'Le péplum est un genre cinématographique de fiction historique dont laction se déroule dans l Antiquité.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Film de cape et d épée', 'Les films de cape et d épée constituent un genre cinématographique. Le contexte de ces films est celui des époques allant du Moyen Âge à la veille de la Révolution française en passant par la Renaissance, les guerres de religion, les siècles de Louis XIII et de Louis XIV.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Criminel', 'Le film criminel, ou cinéma criminel, est un genre cinématographique dont les thèmes tournent autour du crime dans son sens le plus large, inspiré de la littérature criminelle ou de faits réels.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Fantastique', 'Le cinéma fantastique est un genre cinématographique regroupant des films faisant appel au surnaturel, à l horreur, à l insolite ou aux monstres. L’intrigue se fonde sur des éléments irrationnels, ou irréalistes.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Opéra', 'Le film d opéra est un genre de cinéma qui regroupe les œuvres cinématographiques qui portent à l écran des œuvres lyriques.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Science fiction', 'La science-fiction est un genre narratif, principalement littéraire (littérature et bande dessinée), cinématographique et vidéo-ludique. Comme son nom l indique, elle consiste à raconter des fictions reposant sur des progrès scientifiques et techniques obtenus dans un futur plus ou moins lointain (il s agit alors également d anticipation), parfois dans un passé fictif1 ou dans un univers parallèle au nôtre, ou des progrès physiquement impossibles, du moins en l état actuel de nos connaissances.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Horreur', 'Le film d horreur, ou film d épouvante, est un genre cinématographique dont l objectif est de créer un sentiment de peur, de répulsion ou d angoisse chez le spectateur.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Catastrophe', 'Un film catastrophe est un genre cinématographique à suspense, dont l intrigue met en scène une catastrophe naturelle (tremblement de terre, raz-de-marée, chute de météorites, etc.)1 ou technologique (explosion nucléaire, crash aérien, naufrage, incendie, etc.) et les conséquences qui en découlent.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Anticipation', 'L anticipation est un genre littéraire et cinématographique, constitué par les œuvres dont l action se déroule dans le futur, proche ou lointain. Ce genre est souvent lié à la science-fiction, mais pas systématiquement.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Thriller', 'Le thriller (anglicisme, de « to thrill » : faire frémir) est un genre artistique utilisant le suspense ou la tension narrative pour provoquer chez le lecteur ou le spectateur une excitation ou une appréhension et le tenir en haleine jusqu au dénouement de l intrigue.');



/***********************************/
/************** CLIENT *************/
/***********************************/
CREATE TABLE CLIENT (
    AdresseMailClient varchar2(100) not null,
	NomClient varchar2(100),
	PrenomClient varchar2(100),
    AdressePostalClient varchar2(100),
    DateNaissanceClient date,
    NumeroTelephoneClient varchar2(11),
    MotDePasseClient varchar2(100) not null,
	constraint CLIENT_C1_PK_MailClient primary key (AdresseMailClient)
);
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('Jean.Didier@gmail.com', 'Didier', 'Jean', '8 rue de la fontaine 26300 Châteauneuf-sur-Isère', TO_DATE('01/01/1987', 'DD/MM/YYYY'), '0612345678', 'MotDePasse');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('Didier.Paul@orange.com', 'Paul', 'Didier', 'Chemin du rail bleu 43150 Freycenet-la-Cuche', TO_DATE('24/12/2000', 'DD/MM/YYYY'), '0634567812', '???');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('Didier.Didier@gmail.com', 'Didier', 'Didier', 'Avenue avenante 30340 Saint-Privat-des-Vieux', TO_DATE('11/11/1922', 'DD/MM/YYYY'), '0656781234', 'Didier');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('purus.maecenas@yahoo.couk', 'Shellie', 'Wilcox', '534 Phasellus St.', TO_DATE('30/08/2022', 'DD/MM/YYYY'), '0434351828', 'ROS34COV8KR');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('nec.eleifend@icloud.com', 'Kyra', 'Morin', '208-6539 Velit Ave', TO_DATE('29/05/2023', 'DD/MM/YYYY'), '0743435290', 'ISW68RYL6WH');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('nam.tempor.diam@aol.com', 'Phelan', 'Madden', '641-4358 Laoreet Ave', TO_DATE('12/03/2023', 'DD/MM/YYYY'), '0284608821', 'SNF24BNM5XB');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('sed@yahoo.ca', 'Jin', 'Sullivan', '1032 Lorem Ave', TO_DATE('28/12/2021', 'DD/MM/YYYY'), '0408212444', 'SMR25UKP2IG');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('pede.sagittis@outlook.org', 'Holmes', 'Cortez', 'Ap #692-7918 Parturient St.', TO_DATE('09/07/2022', 'DD/MM/YYYY'), '0913246031', 'XCG96WBT9HZ');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('adipiscing.non.luctus@aol.couk', 'Donovan', 'Stone', '519-9451 Fringilla Av.', TO_DATE('19/03/2023', 'DD/MM/YYYY'), '0843551218', 'TFU64MNW5TT');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('ipsum.suspendisse.sagittis@aol.org', 'Paloma', 'Conner', '3035 Donec Ave', TO_DATE('24/03/2023', 'DD/MM/YYYY'), '0938715254', 'YJS38MIE5LV');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('dictum.ultricies@yahoo.edu', 'Stacy', 'Eaton', '139-161 Commodo Street', TO_DATE('18/12/2022', 'DD/MM/YYYY'), '0161282921', 'IQE05FII0JQ');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('feugiat.lorem.ipsum@yahoo.ca', 'Tyler', 'Collier', '650-7310 Eu Road', TO_DATE('21/06/2023', 'DD/MM/YYYY'), '0856530934', 'EPD77QUR2JQ');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('et.magnis.dis@google.com', 'Uma', 'Maddox', 'Ap #452-513 Phasellus Av.', TO_DATE('21/04/2023', 'DD/MM/YYYY'), '0665319364', 'LQT46NRG4VS');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('facilisi.sed.neque@aol.net', 'Leah', 'Finch', 'Ap #265-3177 Tellus Road', TO_DATE('29/04/2023', 'DD/MM/YYYY'), '0277634167', 'UEP56SEY4MI');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('sit@yahoo.org', 'Roanna', 'Oliver', 'Ap #334-1843 Semper. Street', TO_DATE('03/03/2023', 'DD/MM/YYYY'), '0932728383', 'CLD72TJJ7TE');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('morbi.tristique.senectus@icloud.com', 'Jeremy', 'Kemp', '380 Integer Av.', TO_DATE('30/08/2023', 'DD/MM/YYYY'), '0771365998', 'VVK76WOW3ZD');





/***********************************/
/************** TARIF **************/
/***********************************/
CREATE TABLE TARIF (
    NomTarif varchar2(100) not null,
    PrixTarif number(4),
    constraint TARIF_C1_PK_NomTarif primary key (NomTarif)
);
INSERT INTO TARIF (NomTarif, PrixTarif) VALUES ('Adhérent', 4);
INSERT INTO TARIF (NomTarif, PrixTarif) VALUES ('Défaut', 5);

/***********************************/
/************* SUPPORT *************/
/***********************************/
CREATE TABLE SUPPORT (
    TypeSupport varchar2(100) not null,
    constraint TARIF_C1_PK_TypeSupport primary key (TypeSupport)
);
INSERT INTO SUPPORT (TypeSupport) VALUES ('Physique');
INSERT INTO SUPPORT (TypeSupport) VALUES ('QR Code');

/***********************************/
/*************** FILM **************/
/***********************************/
CREATE TABLE FILM (
	NomFilm varchar2(100) not null,
	ResumeFilm LONG VARCHAR,
    DateSortieFilm date,
    DureeFilm date,
    NombreExemplaireFilm number(3) not null,
    LimiteAgeFilm number(2) DEFAULT 0,
    DateAjoutFilm date,
    NombreTotalLocationFilm number(10) DEFAULT 0,
    NomPrenomRealisateur varchar2(100) not null,
	constraint FILM_C1_PK_NomFilm primary key (NomFilm),
    constraint FILM_C2_NB_EXEMPLAIRES check (NombreExemplaireFilm between 0 and 101),
    constraint FILM_C3_FK_NomRealisateur foreign key (NomPrenomRealisateur) references REALISATEUR (NomPrenomRealisateur)
);
INSERT INTO FILM (NomFilm, ResumeFilm, DateSortieFilm, DureeFilm, NombreExemplaireFilm, LimiteAgeFilm, DateAjoutFilm, NombreTotalLocationFilm, NomPrenomRealisateur) VALUES ('Black Didier', 'Après avoir participé à l affrontement entre Iron Man et Captain AmericaN 1, le prince T Challa retourne chez lui dans la nation africaine reculée et technologiquement avancée du Wakanda, pour servir son pays en tant que nouveau roi. Cependant, le pouvoir de T Challa va bientôt être défié par des membres de son propre pays. Quand deux ennemis conspirent pour détruire le Wakanda, Black Panther doit s allier à l agent de la CIA Everett K. Ross et aux membres du Dora Milaje, les forces spéciales du Wakanda, pour éviter que le pays ne soit emporté dans un conflit mondial.', TO_DATE('2018', 'YYYY'), TO_DATE('02:14', 'HH24:MI'), 3, 0, TO_DATE('10/11/2022', 'DD/MM/YYYY'), 0, 'Didier Coogler');
INSERT INTO FILM (NomFilm, ResumeFilm, DateSortieFilm, DureeFilm, NombreExemplaireFilm, LimiteAgeFilm, DateAjoutFilm, NombreTotalLocationFilm, NomPrenomRealisateur) VALUES ('Didier des Caraïbes : La Malédiction du Black Pearl', 'La fille du gouverneur Swann, Elizabeth, promise au commodore James Norrington, s éprend d un forgeron, nommé William Turner, qu elle a sauvé des eaux lorsqu il était enfant et auquel elle a toujours caché qu il était le fils d un pirate. Lorsque les pirates d Hector Barbossa attaquent Port Royal pour retrouver le dernier médaillon aztèque manquant du trésor maudit, Elizabeth est embarquée à bord du Black Pearl. William Turner part à sa recherche avec un autre pirate : le capitaine Jack Sparrow. L équipage du Black Pearl est hanté par la malédiction de l or aztèque, qui change toutes les âmes au cœur impur (celles qui seraient donc amenées à toucher ce trésor maudit) en squelettes, immortels et méprisés. Ceux-ci n ont alors plus aucune sensation corporelle ou gustative, c est pourquoi ils cherchent à inverser la malédiction. Au cours de cette quête pour retrouver le dernier médaillon, le capitaine Barbossa est prêt à tout pour empêcher le capitaine Jack Sparrow de récupérer le Black Pearl, qu il a perdu à la suite d une mutinerie.', TO_DATE('2003', 'YYYY'), TO_DATE('02:22', 'HH24:MI'), 5, 0, TO_DATE('10/11/2022', 'DD/MM/YYYY'), 0, 'Walt Didier');
INSERT INTO FILM (NomFilm, ResumeFilm, DateSortieFilm, DureeFilm, NombreExemplaireFilm, LimiteAgeFilm, DateAjoutFilm, NombreTotalLocationFilm, NomPrenomRealisateur) VALUES ('Le Seigneur des anneaux : Les Deux Didiers', 'Après être entrés en Emyn Muil, Frodon Sacquet et Sam Gamegie rencontrent la créature Gollum, qui essaye de leur voler l Anneau par la force. Vaincu, il promet aux Hobbits de les guider jusqu au Mordor. Après avoir traversé l Emyn Muil et les marais des Morts, ils arrivent à la Morannon, la « Porte Noire » de Mordor. Cependant, elle est trop bien protégée pour qu ils entrent par là et Gollum leur propose de leur montrer le chemin secret de Cirith Ungol. Pendant le voyage, ils rencontrent une troupe avancée du Gondor, dirigée par Faramir, fils de l Intendant Denethor II et frère de Boromir. Il les fait prisonniers et découvre qu ils portent lAnneau unique. Il décide alors de les mener devant son père, mais, en traversant la cité détruite d Osgiliath, les soldats du Gondor sont confrontés aux forces de Sauron menées par des Nazgûl. Se rendant compte du pouvoir maléfique de l Anneau sur Frodon, qui a presque été pris par un des Nazgûl, Faramir se résout à les libérer pour qu ils accomplissent leur mission.', TO_DATE('2002', 'YYYY'), TO_DATE('03:55', 'HH24:MI'), 2, 0, TO_DATE('10/11/2022', 'DD/MM/YYYY'), 0, 'Didier Jackson');
INSERT INTO FILM (NomFilm, ResumeFilm, DateSortieFilm, DureeFilm, NombreExemplaireFilm, LimiteAgeFilm, DateAjoutFilm, NombreTotalLocationFilm, NomPrenomRealisateur) VALUES ('Une merveilleuse histoire de Didier', 'Le film narre la première partie de la vie du physicien théoricien Stephen Hawking, sa rencontre avec sa première épouse, Jane, ses premières découvertes, son doctorat et ses succès en physique cosmologiste, et son diagnostic de sclérose latérale amyotrophique, une maladie neurodégénérative touchant les neurones moteurs mais épargnant les fonctions cognitives.', TO_DATE('2014', 'YYYY'), TO_DATE('2:03', 'HH24:MI'), 1, 0, TO_DATE('10/11/2022', 'DD/MM/YYYY'), 0, 'Didier Marsh');

/***********************************/
/************** JOUER **************/
/***********************************/
CREATE TABLE JOUER (
    NomFilm varchar2(100) not null,
    NomPrenomActeur varchar2(100) not null,
    constraint JOUER_C1_PK_NomFilm_NomActeur primary key (NomFilm, NomPrenomActeur),
    constraint JOUER_C2_FK_NomFilm foreign key (NomFilm) references FILM (NomFilm),
    constraint JOUER_C3_FK_NomActeur foreign key (NomPrenomActeur) references ACTEUR (NomPrenomActeur)
);
INSERT INTO JOUER (NomFilm, NomPrenomActeur) VALUES ('Black Didier', 'Chadwick Didier');
INSERT INTO JOUER (NomFilm, NomPrenomActeur) VALUES ('Black Didier', 'Lupita Didier');
INSERT INTO JOUER (NomFilm, NomPrenomActeur) VALUES ('Didier des Caraïbes : La Malédiction du Black Pearl', 'Didier Depp');
INSERT INTO JOUER (NomFilm, NomPrenomActeur) VALUES ('Didier des Caraïbes : La Malédiction du Black Pearl', 'Didier Bloom');
INSERT INTO JOUER (NomFilm, NomPrenomActeur) VALUES ('Le Seigneur des anneaux : Les Deux Didiers', 'Didier Mortensen');
INSERT INTO JOUER (NomFilm, NomPrenomActeur) VALUES ('Le Seigneur des anneaux : Les Deux Didiers', 'Didier Bloom');
INSERT INTO JOUER (NomFilm, NomPrenomActeur) VALUES ('Le Seigneur des anneaux : Les Deux Didiers', 'Didier McKellen');
INSERT INTO JOUER (NomFilm, NomPrenomActeur) VALUES ('Le Seigneur des anneaux : Les Deux Didiers', 'Didier Bean');
INSERT INTO JOUER (NomFilm, NomPrenomActeur) VALUES ('Une merveilleuse histoire de Didier', 'Didier Redmayne');

/***********************************/
/************ CATEGORIE ************/
/***********************************/
CREATE TABLE CATEGORIE (
    NomFilm varchar2(100) not null,
    NomGenre varchar2(100) not null,
    constraint CATEGORIE_C1_PK_Film_Genre primary key (NomFilm, NomGenre),
    constraint CATEGORIE_C2_FK_NomFilm foreign key (NomFilm) references FILM (NomFilm),
    constraint CATEGORIE_C3_FK_NomGenre foreign key (NomGenre) references GENRE (NomGenre)
);
INSERT INTO CATEGORIE (NomFilm, NomGenre) VALUES ('Black Didier', 'Super-héros');
INSERT INTO CATEGORIE (NomFilm, NomGenre) VALUES ('Didier des Caraïbes : La Malédiction du Black Pearl', 'Fantasy');
INSERT INTO CATEGORIE (NomFilm, NomGenre) VALUES ('Didier des Caraïbes : La Malédiction du Black Pearl', 'Aventure');
INSERT INTO CATEGORIE (NomFilm, NomGenre) VALUES ('Le Seigneur des anneaux : Les Deux Didiers', 'Fantasy');

/***********************************/
/********** CARTE_BANCAIRE *********/
/***********************************/
CREATE TABLE CARTE_BANCAIRE (
    NumeroCarteBancaire varchar2(16) not null,
    ExpirationCarteBancaire date,
    PictogrammeCarteBancaire varchar2(3),
    AdresseMailClient varchar2(100) not null,
    constraint BANQUE_C1_PK_NumCarteBanque primary key (NumeroCarteBancaire),
    constraint BANQUE_C2_FK_MailClient foreign key (AdresseMailClient) references CLIENT (AdresseMailClient)
);
INSERT INTO CARTE_BANCAIRE (NumeroCarteBancaire, ExpirationCarteBancaire, PictogrammeCarteBancaire, AdresseMailClient) VALUES ('0123456789101112', TO_DATE('24/08', 'DD/MM'), '012', 'Jean.Didier@gmail.com');
INSERT INTO CARTE_BANCAIRE (NumeroCarteBancaire, ExpirationCarteBancaire, PictogrammeCarteBancaire, AdresseMailClient) VALUES ('4567891011120123', TO_DATE('14/02', 'DD/MM'), '345', 'Didier.Paul@orange.com');
INSERT INTO CARTE_BANCAIRE (NumeroCarteBancaire, ExpirationCarteBancaire, PictogrammeCarteBancaire, AdresseMailClient) VALUES ('8910111201234567', TO_DATE('04/04', 'DD/MM'), '678', 'Didier.Didier@gmail.com');

/***********************************/
/************* SOUHAIT *************/
/***********************************/
CREATE TABLE SOUHAIT (
    NomFilm varchar2(100) not null,
    AdresseMailClient varchar2(100) not null,
    constraint SOUHAIT_C1_PK_Film_MailClient primary key (NomFilm, AdresseMailClient),
    constraint SOUHAIT_C2_FK_NomFilm foreign key (NomFilm) references FILM (NomFilm),
    constraint SOUHAIT_C3_FK_MailClient foreign key (AdresseMailClient) references CLIENT (AdresseMailClient)
);
INSERT INTO SOUHAIT (NomFilm, AdresseMailClient) VALUES ('Black Didier', 'Didier.Didier@gmail.com');

/***********************************/
/************* EMPRUNT *************/
/***********************************/
CREATE TABLE EMPRUNT (
    DateDebutEmprunt date not null,
    NomFilm varchar2(100) not null,
    AdresseMailClient varchar2(100) not null,
    TypeSupport varchar2(100),
    NomTarif varchar2(100) not null,
    constraint EMPRUNT_C1_PK_Date_Film_Mail primary key (DateDebutEmprunt, NomFilm, AdresseMailClient),
    constraint EMPRUNT_C2_FK_NomFilm foreign key (NomFilm) references FILM (NomFilm),
    constraint EMPRUNT_C3_FK_MailClient foreign key (AdresseMailClient) references CLIENT (AdresseMailClient),
    constraint EMPRUNT_C4_FK_TypeSupport foreign key (TypeSupport) references SUPPORT (TypeSupport),
    constraint EMPRUNT_C5_FK_NomTarif foreign key (NomTarif) references TARIF (NomTarif)
);
INSERT INTO EMPRUNT (DateDebutEmprunt, NomFilm, AdresseMailClient, TypeSupport, NomTarif) VALUES (TO_DATE('20/11/2022', 'DD/MM/YYYY'), 'Black Didier', 'Jean.Didier@gmail.com', 'Physique', 'Défaut');
INSERT INTO EMPRUNT (DateDebutEmprunt, NomFilm, AdresseMailClient, TypeSupport, NomTarif) VALUES (TO_DATE('20/11/2022', 'DD/MM/YYYY'), 'Didier des Caraïbes : La Malédiction du Black Pearl', 'Jean.Didier@gmail.com', 'QR Code', 'Défaut');

/***********************************/
/********* CARTE_ABONNEMENT ********/
/***********************************/
CREATE TABLE CARTE_ABONNEMENT (
    NomCarteAbonnement varchar2(100) not null,
    AdresseMailClient varchar2(100) not null,
    SoldeCarteAbonnement number(4) DEFAULT 0,
    AgePropietaireCarteAbonnement number(4),
    constraint ABONNEMENT_C1_PK_NomCarte_Mail primary key (NomCarteAbonnement, AdresseMailClient),
    constraint ABONNEMENT_C2_FK_Mail foreign key (AdresseMailClient) references CLIENT (AdresseMailClient)
);
INSERT INTO CARTE_ABONNEMENT (NomCarteAbonnement, AdresseMailClient, SoldeCarteAbonnement, AgePropietaireCarteAbonnement) VALUES ('CarteDeDidiette', 'Didier.Didier@gmail.com', 50, 15);
INSERT INTO CARTE_ABONNEMENT (NomCarteAbonnement, AdresseMailClient, SoldeCarteAbonnement, AgePropietaireCarteAbonnement) VALUES ('CarteDeDidiot', 'Didier.Didier@gmail.com', 50, 7);

/***********************************/
/************ HISTORIQUE ***********/
/***********************************/
CREATE TABLE HISTORIQUE (
    DateDebutEmprunt date not null,
    NomFilm varchar2(100) not null,
    AdresseMailClient varchar2(100) not null,
    DateFinEmprunt date not null,
    TypeSupport varchar2(100) not null,
    constraint HISTORIQUE_C1_PK_Date_Nom_Mail primary key (DateDebutEmprunt, NomFilm, AdresseMailClient),
    constraint HISTORIQUE_C2_FK_NomFilm foreign key (NomFilm) references FILM (NomFilm),
    constraint HISTORIQUE_C3_FK_Mail foreign key (AdresseMailClient) references CLIENT (AdresseMailClient),
    constraint HISTORIQUE_C4_FK_Support foreign key (TypeSupport) references SUPPORT (TypeSupport)
);
