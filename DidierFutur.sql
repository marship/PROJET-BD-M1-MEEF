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
    DateNaissanceRealisateur varchar2(10),
    NationnaliteRealisateur varchar2(100),
    constraint REALISATEUR_C1_PK_NomReal primary key (NomPrenomRealisateur)
);
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Jackson', '31/10/1961', 'Neo-Zelandais');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Walt Didier', '05/12/1901', 'Americain');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Coogler', '23/05/1986', 'Americain');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Marsh', '30/04/1963', 'Britannique');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Columbus', '10/09/1958', 'Americain');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Lynch', '20/01/1946', 'Americain');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Kubrick', '26/07/1928', 'Americain');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Fincher', '28/08/1962', 'Americain');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Kurosawa', '23/03/1910', 'Japonais');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Godard', '3/12/1930', 'Franco-suisse');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Kitano', '18/01/1947', 'Japonais');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Leone', '3/01/1929', 'Italien');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Hitchcock', '13/08/1899', 'Britannique');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Malik', '30/11/1943', 'Americain');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Scorsese', '17/11/1942', 'Italo-americain');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Chaplin', '15/04/1889', 'Britannique');
INSERT INTO REALISATEUR (NomPrenomRealisateur, DateNaissanceRealisateur, NationnaliteRealisateur) VALUES ('Didier Spielberg', '18/12/1946', 'Americain');

/***********************************/
/************** ACTEUR *************/
/***********************************/
CREATE TABLE ACTEUR (
    NomPrenomActeur varchar2(100) not null,
    DateNaissanceActeur varchar2(10),
    NationnaliteActeur varchar2(100),
    constraint ACTEUR_C1_PK_NomActeur primary key (NomPrenomActeur)
);
INSERT INTO ACTEUR (NomPrenomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Didier Depp', '09/06/1963', 'Americain');
INSERT INTO ACTEUR (NomPrenomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Didier Mortensen', '20/10/1958', 'Americain');
INSERT INTO ACTEUR (NomPrenomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Sean Didier', '25/02/1971', 'Americain');
INSERT INTO ACTEUR (NomPrenomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Didier Bloom', '13/01/1977', 'Americain');
INSERT INTO ACTEUR (NomPrenomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Didier McKellen', '25/04/1939', 'Britannique');
INSERT INTO ACTEUR (NomPrenomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Didier Bean', '17/04/1959', 'Britannique');
INSERT INTO ACTEUR (NomPrenomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Chadwick Didier', '29/11/1976', 'Americain');
INSERT INTO ACTEUR (NomPrenomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Lupita Didier', '1/03/1983', 'Mexicain');
INSERT INTO ACTEUR (NomPrenomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Didier Redmayne', '6/01/1982', 'Britannique');
INSERT INTO ACTEUR (NomPrenomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Didier Radcliffe', '23/07/1989', 'Britannique');
INSERT INTO ACTEUR (NomPrenomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Didier Watson', '15/04/1990', 'Britannique');
INSERT INTO ACTEUR (NomPrenomActeur, DateNaissanceActeur, NationnaliteActeur) VALUES ('Didier LeRequin', '11/11/1111', 'Australien'); 

/***********************************/
/************** GENRE **************/
/***********************************/
CREATE TABLE GENRE (
    NomGenre varchar2(100) not null,
    DescriptionGenre LONG VARCHAR,
    constraint GENRE_C1_PK_NomGenre primary key (NomGenre)
);
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Fantasy', 'Le cinema de fantasy est un genre cinematographique fonde sur l imaginaire et le merveilleux de la culture anglo-saxonne, il est apparente au cinema onirique europeen dont il partage quelques points communs. Il est rattache au cinema fantastique.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Aventure', 'Le film d aventures ou film d aventure (au singulier) est un genre cinematographique caracterise par la presence d un heros fictif ou non, tirant son statut du mythe qu il inspire, l action particuliere qui s y deroule, l emploi de decors particuliers egalement, parfois le decalage temporel par rapport au contemporain ainsi que, parfois, les invraisemblances voulues caracterisant ainsi son excentricite, le tout vehiculant une idee generale de depaysement.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Super-heros', 'Un film de super-heros est un sous-genre cinematographique appartenant au genre de la science-fiction, des films d action, ou de la fantasy et mettant en scene les actions d un ou plusieurs super-heros, individus qui possedent des pouvoirs surhumains et s en servent pour proteger la population.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Biographique', 'Un film biographique, egalement connu dans le milieu du cinema sous l anglicisme biopic (contraction de « biographical motion picture »), est une œuvre cinematographique de fiction, centree sur la description biographique d un personnage principal qui a reellement existe. Les evenements et l environnement de son epoque sont donc subordonnes a son recit.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Comedie', 'La comedie est, au cinema, un genre cinematographique dont une des caracteristiques majeures est l humour.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Drame', 'Le drame est un genre cinematographique qui traite des situations generalement non epiques dans un contexte serieux, sur un ton plus susceptible d inspirer la tristesse que le rire. Neanmoins, le drame evoque etymologiquement l action.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Romance', 'Le film d amour est un film portant sur une histoire d amour ou d aventure amoureuse, mettant en avant la passion, les emotions et l engagement affectif des personnages principaux.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Action', 'Le film d action est un genre cinematographique qui met en scene une succession de scenes spectaculaires souvent stereotypees (courses-poursuites, fusillades, explosions…) construites autour d un conflit resolu de maniere violente, generalement par la mort des ennemis du heros. ');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Historique', 'Un film historique est un genre cinematographique qui est fonde sur le principe de la fiction historique et qui met en scene des evenements historiques.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Western', 'Le western est un genre cinematographique dont l action se deroule generalement en Amerique du Nord, plus specialement aux etats-Unis, lors de la conquête de l Ouest dans les dernieres decennies du XIXe siecle.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Peplum', 'Le peplum est un genre cinematographique de fiction historique dont laction se deroule dans l Antiquite.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Film de cape et d epee', 'Les films de cape et d epee constituent un genre cinematographique. Le contexte de ces films est celui des epoques allant du Moyen Âge a la veille de la Revolution francaise en passant par la Renaissance, les guerres de religion, les siecles de Louis XIII et de Louis XIV.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Criminel', 'Le film criminel, ou cinema criminel, est un genre cinematographique dont les themes tournent autour du crime dans son sens le plus large, inspire de la litterature criminelle ou de faits reels.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Fantastique', 'Le cinema fantastique est un genre cinematographique regroupant des films faisant appel au surnaturel, a l horreur, a l insolite ou aux monstres. L’intrigue se fonde sur des elements irrationnels, ou irrealistes.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Opera', 'Le film d opera est un genre de cinema qui regroupe les œuvres cinematographiques qui portent a l ecran des œuvres lyriques.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Science fiction', 'La science-fiction est un genre narratif, principalement litteraire (litterature et bande dessinee), cinematographique et video-ludique. Comme son nom l indique, elle consiste a raconter des fictions reposant sur des progres scientifiques et techniques obtenus dans un futur plus ou moins lointain (il s agit alors egalement d anticipation), parfois dans un passe fictif1 ou dans un univers parallele au nôtre, ou des progres physiquement impossibles, du moins en l etat actuel de nos connaissances.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Horreur', 'Le film d horreur, ou film d epouvante, est un genre cinematographique dont l objectif est de creer un sentiment de peur, de repulsion ou d angoisse chez le spectateur.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Catastrophe', 'Un film catastrophe est un genre cinematographique a suspense, dont l intrigue met en scene une catastrophe naturelle (tremblement de terre, raz-de-maree, chute de meteorites, etc.)1 ou technologique (explosion nucleaire, crash aerien, naufrage, incendie, etc.) et les consequences qui en decoulent.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Anticipation', 'L anticipation est un genre litteraire et cinematographique, constitue par les œuvres dont l action se deroule dans le futur, proche ou lointain. Ce genre est souvent lie a la science-fiction, mais pas systematiquement.');
INSERT INTO GENRE (NomGenre, DescriptionGenre) VALUES ('Thriller', 'Le thriller (anglicisme, de « to thrill » : faire fremir) est un genre artistique utilisant le suspense ou la tension narrative pour provoquer chez le lecteur ou le spectateur une excitation ou une apprehension et le tenir en haleine jusqu au denouement de l intrigue.');

/***********************************/
/************** CLIENT *************/
/***********************************/
CREATE TABLE CLIENT (
    AdresseMailClient varchar2(100) not null,
	NomClient varchar2(100),
	PrenomClient varchar2(100),
    AdressePostalClient varchar2(100),
    DateNaissanceClient varchar2(10),
    NumeroTelephoneClient varchar2(11),
    MotDePasseClient varchar2(100) not null,
	constraint CLIENT_C1_PK_MailClient primary key (AdresseMailClient)
);
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('Jean.Didier@gmail.com', 'Didier', 'Jean', '8 rue de la fontaine 26300 Châteauneuf-sur-Isere', '01/01/1987', '0612345678', 'MotDePasse');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('Didier.Paul@orange.com', 'Paul', 'Didier', 'Chemin du rail bleu 43150 Freycenet-la-Cuche', '24/12/2000', '0634567812', '???');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('Didier.Didier@gmail.com', 'Didier', 'Didier', 'Avenue avenante 30340 Saint-Privat-des-Vieux', '11/11/1922', '0656781234', 'Didier');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('purus.maecenas@yahoo.couk', 'Shellie', 'Wilcox', '534 Phasellus St.', '30/08/2022', '0434351828', 'ROS34COV8KR');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('nec.eleifend@icloud.com', 'Kyra', 'Morin', '208-6539 Velit Ave', '29/05/2023', '0743435290', 'ISW68RYL6WH');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('nam.tempor.diam@aol.com', 'Phelan', 'Madden', '641-4358 Laoreet Ave', '12/03/2023', '0284608821', 'SNF24BNM5XB');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('sed@yahoo.ca', 'Jin', 'Sullivan', '1032 Lorem Ave', '28/12/2021', '0408212444', 'SMR25UKP2IG');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('pede.sagittis@outlook.org', 'Holmes', 'Cortez', 'Ap #692-7918 Parturient St.', '09/07/2022', '0913246031', 'XCG96WBT9HZ');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('adipiscing.non.luctus@aol.couk', 'Donovan', 'Stone', '519-9451 Fringilla Av.', '19/03/2023', '0843551218', 'TFU64MNW5TT');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('ipsum.suspendisse.sagittis@aol.org', 'Paloma', 'Conner', '3035 Donec Ave', '24/03/2023', '0938715254', 'YJS38MIE5LV');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('dictum.ultricies@yahoo.edu', 'Stacy', 'Eaton', '139-161 Commodo Street', '18/12/2022', '0161282921', 'IQE05FII0JQ');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('feugiat.lorem.ipsum@yahoo.ca', 'Tyler', 'Collier', '650-7310 Eu Road', '21/06/2023', '0856530934', 'EPD77QUR2JQ');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('et.magnis.dis@google.com', 'Uma', 'Maddox', 'Ap #452-513 Phasellus Av.', '21/04/2023', '0665319364', 'LQT46NRG4VS');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('facilisi.sed.neque@aol.net', 'Leah', 'Finch', 'Ap #265-3177 Tellus Road', '29/04/2023', '0277634167', 'UEP56SEY4MI');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('sit@yahoo.org', 'Roanna', 'Oliver', 'Ap #334-1843 Semper. Street', '03/03/2023', '0932728383', 'CLD72TJJ7TE');
INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES ('morbi.tristique.senectus@icloud.com', 'Jeremy', 'Kemp', '380 Integer Av.', '30/08/2023', '0771365998', 'VVK76WOW3ZD');

/***********************************/
/************** TARIF **************/
/***********************************/
CREATE TABLE TARIF (
    NomTarif varchar2(100) not null,
    PrixTarif number(4),
    constraint TARIF_C1_PK_NomTarif primary key (NomTarif)
);
INSERT INTO TARIF (NomTarif, PrixTarif) VALUES ('Adherent', 4);
INSERT INTO TARIF (NomTarif, PrixTarif) VALUES ('Defaut', 5);

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
    DateSortieFilm varchar2(10),
    DureeFilm varchar2(10),
    NombreExemplaireFilm number(3) not null,
    LimiteAgeFilm number(2) DEFAULT 0,
    DateAjoutFilm varchar2(10),
    NombreTotalLocationFilm number(10) DEFAULT 0,
    NomPrenomRealisateur varchar2(100) not null,
	constraint FILM_C1_PK_NomFilm primary key (NomFilm),
    constraint FILM_C2_NB_EXEMPLAIRES check (NombreExemplaireFilm between 0 and 101),
    constraint FILM_C3_FK_NomRealisateur foreign key (NomPrenomRealisateur) references REALISATEUR (NomPrenomRealisateur)
);
INSERT INTO FILM (NomFilm, ResumeFilm, DateSortieFilm, DureeFilm, NombreExemplaireFilm, LimiteAgeFilm, DateAjoutFilm, NombreTotalLocationFilm, NomPrenomRealisateur) VALUES ('Black Didier', 'Apres avoir participe a l affrontement entre Iron Man et Captain AmericaN 1, le prince T Challa retourne chez lui dans la nation africaine reculee et technologiquement avancee du Wakanda, pour servir son pays en tant que nouveau roi. Cependant, le pouvoir de T Challa va bientôt être defie par des membres de son propre pays. Quand deux ennemis conspirent pour detruire le Wakanda, Black Panther doit s allier a l agent de la CIA Everett K. Ross et aux membres du Dora Milaje, les forces speciales du Wakanda, pour eviter que le pays ne soit emporte dans un conflit mondial.', '2018', '02:14', 3, 0, '10/11/2022', 0, 'Didier Coogler');
INSERT INTO FILM (NomFilm, ResumeFilm, DateSortieFilm, DureeFilm, NombreExemplaireFilm, LimiteAgeFilm, DateAjoutFilm, NombreTotalLocationFilm, NomPrenomRealisateur) VALUES ('Didier des Caraïbes : La Malediction du Black Pearl', 'La fille du gouverneur Swann, Elizabeth, promise au commodore James Norrington, s eprend d un forgeron, nomme William Turner, qu elle a sauve des eaux lorsqu il etait enfant et auquel elle a toujours cache qu il etait le fils d un pirate. Lorsque les pirates d Hector Barbossa attaquent Port Royal pour retrouver le dernier medaillon azteque manquant du tresor maudit, Elizabeth est embarquee a bord du Black Pearl. William Turner part a sa recherche avec un autre pirate : le capitaine Jack Sparrow. L equipage du Black Pearl est hante par la malediction de l or azteque, qui change toutes les âmes au cœur impur (celles qui seraient donc amenees a toucher ce tresor maudit) en squelettes, immortels et meprises. Ceux-ci n ont alors plus aucune sensation corporelle ou gustative, c est pourquoi ils cherchent a inverser la malediction. Au cours de cette quête pour retrouver le dernier medaillon, le capitaine Barbossa est prêt a tout pour empêcher le capitaine Jack Sparrow de recuperer le Black Pearl, qu il a perdu a la suite d une mutinerie.', '2003', '02:22', 5, 0, '10/11/2022', 0, 'Walt Didier');
INSERT INTO FILM (NomFilm, ResumeFilm, DateSortieFilm, DureeFilm, NombreExemplaireFilm, LimiteAgeFilm, DateAjoutFilm, NombreTotalLocationFilm, NomPrenomRealisateur) VALUES ('Le Seigneur des anneaux : Les Deux Didiers', 'Apres être entres en Emyn Muil, Frodon Sacquet et Sam Gamegie rencontrent la creature Gollum, qui essaye de leur voler l Anneau par la force. Vaincu, il promet aux Hobbits de les guider jusqu au Mordor. Apres avoir traverse l Emyn Muil et les marais des Morts, ils arrivent a la Morannon, la « Porte Noire » de Mordor. Cependant, elle est trop bien protegee pour qu ils entrent par la et Gollum leur propose de leur montrer le chemin secret de Cirith Ungol. Pendant le voyage, ils rencontrent une troupe avancee du Gondor, dirigee par Faramir, fils de l Intendant Denethor II et frere de Boromir. Il les fait prisonniers et decouvre qu ils portent lAnneau unique. Il decide alors de les mener devant son pere, mais, en traversant la cite detruite d Osgiliath, les soldats du Gondor sont confrontes aux forces de Sauron menees par des Nazgûl. Se rendant compte du pouvoir malefique de l Anneau sur Frodon, qui a presque ete pris par un des Nazgûl, Faramir se resout a les liberer pour qu ils accomplissent leur mission.', '2002', '03:55', 2, 0, '10/11/2022', 0, 'Didier Jackson');
INSERT INTO FILM (NomFilm, ResumeFilm, DateSortieFilm, DureeFilm, NombreExemplaireFilm, LimiteAgeFilm, DateAjoutFilm, NombreTotalLocationFilm, NomPrenomRealisateur) VALUES ('Une merveilleuse histoire de Didier', 'Le film narre la premiere partie de la vie du physicien theoricien Stephen Hawking, sa rencontre avec sa premiere epouse, Jane, ses premieres decouvertes, son doctorat et ses succes en physique cosmologiste, et son diagnostic de sclerose laterale amyotrophique, une maladie neurodegenerative touchant les neurones moteurs mais epargnant les fonctions cognitives.', '2014', '2:03', 1, 0, '10/11/2022', 0, 'Didier Marsh');
INSERT INTO FILM (NomFilm, ResumeFilm, DateSortieFilm, DureeFilm, NombreExemplaireFilm, LimiteAgeFilm, DateAjoutFilm, NombreTotalLocationFilm, NomPrenomRealisateur) VALUES ('Didier Potter a l ecole des sorciers', 'Harry Potter, jeune orphelin, a ete eleve par son oncle et sa tante dans des conditions hostiles1. a l âge de onze ans, un demi-geant nomme Rubeus Hagrid lui apprend qu il possede des pouvoirs magiques1 et que ses parents ont ete assassines, des annees auparavant, par le mage noir Lord Voldemort. Ce dernier avait egalement essaye de tuer Harry alors qu il etait un bebe, mais le sort a rebondi. En frequentant pour la premiere fois le monde des sorciers, accompagne par Hagrid, Harry decouvre qu il y est tres celebre. Il entame sa premiere annee d etudes a l ecole de sorcellerie Poudlard, où il apprend a maîtriser la magie aux côtes de ses deux nouveaux amis Ron Weasley et Hermione Granger1. Au cours de l annee, le trio se trouve implique dans le mystere de la pierre philosophale, gardee au sein de l ecole et convoitee par un inconnu qu ils cherchent a demasquer. Ce dernier se revele être Voldemort, qui habite le corps du professeur Quirell.', '2001', '2:32', 3, 0, '10/10/2022', 10, 'Didier Columbus');
INSERT INTO FILM (NomFilm, ResumeFilm, DateSortieFilm, DureeFilm, NombreExemplaireFilm, LimiteAgeFilm, DateAjoutFilm, NombreTotalLocationFilm, NomPrenomRealisateur) VALUES ('Les Dents de Didier', 'Pendant l ete du 1er juillet 1974, sur l île d Amity, un groupe d etudiants fait la fête sur la plage. Une jeune femme s eloigne du groupe pour un bain de minuit alors que son flirt s endort sur la plage, ivre. Apres quelques brasses, la jeune femme est attaquee par une force mysterieuse, elle tente de resister mais est happee et disparaît dans l eau en poussant des cris de terreur. Quelques secondes apres, la mer retrouve son calme nocturne. Personne ne sait ce qui vient de se derouler.', '1975', '2:04', 1, 18, '20/10/2022', 0, 'Didier Spielberg');

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
INSERT INTO JOUER (NomFilm, NomPrenomActeur) VALUES ('Didier des Caraïbes : La Malediction du Black Pearl', 'Didier Depp');
INSERT INTO JOUER (NomFilm, NomPrenomActeur) VALUES ('Didier des Caraïbes : La Malediction du Black Pearl', 'Didier Bloom');
INSERT INTO JOUER (NomFilm, NomPrenomActeur) VALUES ('Le Seigneur des anneaux : Les Deux Didiers', 'Didier Mortensen');
INSERT INTO JOUER (NomFilm, NomPrenomActeur) VALUES ('Le Seigneur des anneaux : Les Deux Didiers', 'Didier Bloom');
INSERT INTO JOUER (NomFilm, NomPrenomActeur) VALUES ('Le Seigneur des anneaux : Les Deux Didiers', 'Didier McKellen');
INSERT INTO JOUER (NomFilm, NomPrenomActeur) VALUES ('Le Seigneur des anneaux : Les Deux Didiers', 'Didier Bean');
INSERT INTO JOUER (NomFilm, NomPrenomActeur) VALUES ('Une merveilleuse histoire de Didier', 'Didier Redmayne');
INSERT INTO JOUER (NomFilm, NomPrenomActeur) VALUES ('Didier Potter a l ecole des sorciers', 'Didier Radcliffe');
INSERT INTO JOUER (NomFilm, NomPrenomActeur) VALUES ('Didier Potter a l ecole des sorciers', 'Didier Watson');
INSERT INTO JOUER (NomFilm, NomPrenomActeur) VALUES ('Les Dents de Didier', 'Didier LeRequin');


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
INSERT INTO CATEGORIE (NomFilm, NomGenre) VALUES ('Black Didier', 'Super-heros');
INSERT INTO CATEGORIE (NomFilm, NomGenre) VALUES ('Didier des Caraïbes : La Malediction du Black Pearl', 'Fantasy');
INSERT INTO CATEGORIE (NomFilm, NomGenre) VALUES ('Didier des Caraïbes : La Malediction du Black Pearl', 'Aventure');
INSERT INTO CATEGORIE (NomFilm, NomGenre) VALUES ('Le Seigneur des anneaux : Les Deux Didiers', 'Fantasy');
INSERT INTO CATEGORIE (NomFilm, NomGenre) VALUES ('Une merveilleuse histoire de Didier', 'Biographique');
INSERT INTO CATEGORIE (NomFilm, NomGenre) VALUES ('Didier Potter a l ecole des sorciers', 'Fantasy');
INSERT INTO CATEGORIE (NomFilm, NomGenre) VALUES ('Didier Potter a l ecole des sorciers', 'Action');
INSERT INTO CATEGORIE (NomFilm, NomGenre) VALUES ('Didier Potter a l ecole des sorciers', 'Aventure');
INSERT INTO CATEGORIE (NomFilm, NomGenre) VALUES ('Les Dents de Didier', 'Horreur');

/***********************************/
/********** CARTE_BANCAIRE *********/
/***********************************/
CREATE TABLE CARTE_BANCAIRE (
    NumeroCarteBancaire varchar2(16) not null,
    ExpirationCarteBancaire varchar2(10),
    PictogrammeCarteBancaire varchar2(3),
    AdresseMailClient varchar2(100) not null,
    constraint BANQUE_C1_PK_NumCarteBanque primary key (NumeroCarteBancaire),
    constraint BANQUE_C2_FK_MailClient foreign key (AdresseMailClient) references CLIENT (AdresseMailClient)
);
INSERT INTO CARTE_BANCAIRE (NumeroCarteBancaire, ExpirationCarteBancaire, PictogrammeCarteBancaire, AdresseMailClient) VALUES ('0123456789101112', '24/08', '012', 'Jean.Didier@gmail.com');
INSERT INTO CARTE_BANCAIRE (NumeroCarteBancaire, ExpirationCarteBancaire, PictogrammeCarteBancaire, AdresseMailClient) VALUES ('4567891011120123', '14/02', '345', 'Didier.Paul@orange.com');
INSERT INTO CARTE_BANCAIRE (NumeroCarteBancaire, ExpirationCarteBancaire, PictogrammeCarteBancaire, AdresseMailClient) VALUES ('8910111201234567', '04/04', '678', 'Didier.Didier@gmail.com');

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
INSERT INTO SOUHAIT (NomFilm, AdresseMailClient) VALUES ('Didier Potter a l ecole des sorciers', 'ipsum.suspendisse.sagittis@aol.org');

/***********************************/
/************* EMPRUNT *************/
/***********************************/
CREATE TABLE EMPRUNT (
    DateDebutEmprunt varchar2(10) not null,
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
INSERT INTO EMPRUNT (DateDebutEmprunt, NomFilm, AdresseMailClient, TypeSupport, NomTarif) VALUES ('20/11/2022', 'Black Didier', 'Jean.Didier@gmail.com', 'Physique', 'Defaut');
INSERT INTO EMPRUNT (DateDebutEmprunt, NomFilm, AdresseMailClient, TypeSupport, NomTarif) VALUES ('20/11/2022', 'Didier des Caraïbes : La Malediction du Black Pearl', 'Jean.Didier@gmail.com', 'QR Code', 'Defaut');
INSERT INTO EMPRUNT (DateDebutEmprunt, NomFilm, AdresseMailClient, TypeSupport, NomTarif) VALUES ('20/11/2022', 'Didier Potter a l ecole des sorciers', 'nec.eleifend@icloud.com', 'Physique', 'Defaut');
INSERT INTO EMPRUNT (DateDebutEmprunt, NomFilm, AdresseMailClient, TypeSupport, NomTarif) VALUES ('20/11/2022', 'Didier Potter a l ecole des sorciers', 'morbi.tristique.senectus@icloud.com', 'Physique', 'Defaut');
INSERT INTO EMPRUNT (DateDebutEmprunt, NomFilm, AdresseMailClient, TypeSupport, NomTarif) VALUES ('20/11/2022', 'Didier Potter a l ecole des sorciers', 'dictum.ultricies@yahoo.edu', 'Physique', 'Adherent');
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
INSERT INTO CARTE_ABONNEMENT (NomCarteAbonnement, AdresseMailClient, SoldeCarteAbonnement, AgePropietaireCarteAbonnement) VALUES ('CarteDeDidiette', 'Didier.Didier@gmail.com', 5, 15);
INSERT INTO CARTE_ABONNEMENT (NomCarteAbonnement, AdresseMailClient, SoldeCarteAbonnement, AgePropietaireCarteAbonnement) VALUES ('CarteDeDidiot', 'Didier.Didier@gmail.com', 50, 7);
INSERT INTO CARTE_ABONNEMENT (NomCarteAbonnement, AdresseMailClient, SoldeCarteAbonnement, AgePropietaireCarteAbonnement) VALUES ('CarteDictum', 'dictum.ultricies@yahoo.edu', 500, 33);

/***********************************/
/************ HISTORIQUE ***********/
/***********************************/
CREATE TABLE HISTORIQUE (
    DateDebutEmprunt varchar2(10) not null,
    NomFilm varchar2(100) not null,
    AdresseMailClient varchar2(100) not null,
    DateFinEmprunt varchar2(10) not null,
    TypeSupport varchar2(100) not null,
    constraint HISTORIQUE_C1_PK_Date_Nom_Mail primary key (DateDebutEmprunt, NomFilm, AdresseMailClient),
    constraint HISTORIQUE_C2_FK_NomFilm foreign key (NomFilm) references FILM (NomFilm),
    constraint HISTORIQUE_C3_FK_Mail foreign key (AdresseMailClient) references CLIENT (AdresseMailClient),
    constraint HISTORIQUE_C4_FK_Support foreign key (TypeSupport) references SUPPORT (TypeSupport)
);

/***********************************/
/************** TRIGGER ************/
/***********************************/
CREATE OR REPLACE TRIGGER archivageEmprunt
AFTER DELETE ON EMPRUNT
FOR EACH ROW
BEGIN
	INSERT INTO HISTORIQUE VALUES(:old.DateDebutEmprunt, :old.NomFilm, :old.AdresseMailClient, TO_CHAR(SYSDATE, 'DD/MM/YYYYHH24:MI:SS'), 'Physique');
END;
/


CREATE OR REPLACE TRIGGER decrementNombreCopie
AFTER INSERT ON EMPRUNT
FOR EACH ROW
BEGIN
	IF :new.TypeSupport = 'Physique' THEN
		UPDATE FILM
		SET NombreExemplaireFilm = NombreExemplaireFilm - 1
		WHERE NomFilm = :new.NomFilm;
	END IF;
END;
/


CREATE OR REPLACE TRIGGER incrementNombreCopie
AFTER DELETE ON EMPRUNT
FOR EACH ROW
BEGIN
	IF :new.TypeSupport = 'Physique' THEN
		UPDATE FILM
		SET NombreExemplaireFilm = NombreExemplaireFilm + 1
		WHERE NomFilm = :new.NomFilm;
	END IF;
END;
/


CREATE OR REPLACE TRIGGER miseAJourWishList
AFTER INSERT ON EMPRUNT
FOR EACH ROW
DECLARE
	existe integer;
BEGIN
	SELECT count(*) into existe from SOUHAIT WHERE AdresseMailClient = :new.AdresseMailClient AND NomFilm = :new.NomFilm;
	IF existe > 0 THEN
		DELETE FROM SOUHAIT WHERE AdresseMailClient = :new.AdresseMailClient AND NomFilm = :new.NomFilm;
	END IF;
END;
/
