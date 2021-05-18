DROP DATABASE IF EXISTS CONCESSION;

CREATE DATABASE CONCESSION;

USE CONCESSION;

CREATE TABLE `acheter` (
  `id_voiture` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `vendeur` varchar(40) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



INSERT INTO `acheter` (`id_voiture`, `id_client`, `vendeur`, `date`) VALUES
(1, 1, '', '2021-05-17');


CREATE TABLE `client` (
  `id_client` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `telephone` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `client` (`id_client`, `nom`, `prenom`, `telephone`) VALUES
(1, 'JEAN', 'PAUL', '70707');



CREATE TABLE `constructeur` (
  `id_constructeur` int(11) NOT NULL,
  `libelle_constructeur` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



INSERT INTO `constructeur` (`id_constructeur`, `libelle_constructeur`) VALUES
(1, 'Peugeot'),
(2, 'Ferrari'),
(3, 'McLaren'),
(4, 'Bentley'),
(5, 'Lamborghini'),
(6, 'Mercedes'),
(7, 'BMW'),
(8, 'Tesla'),
(9, 'Bugatti'),
(10, 'Pagani'),
(11, 'Koenigsegg ');



CREATE TABLE `model` (
  `id_modele` int(11) NOT NULL,
  `libelle_modele` varchar(40) NOT NULL,
  `id_constructeur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



INSERT INTO `model` (`id_modele`, `libelle_modele`, `id_constructeur`) VALUES
(1, '306', 1),
(2, '488', 2),
(3, '458', 2),
(4, 'Enzo', 2),
(5, 'LaFerrari', 2),
(6, 'F12 TDF', 2),
(7, '812 Superfast', 2),
(8, '720s', 3),
(9, '675LT', 3),
(10, 'Senna', 3),
(11, 'P1', 3),
(12, 'P1 GTR', 3),
(13, 'Continental GT', 4),
(14, 'Urus', 5),
(15, 'Countach', 5),
(16, 'Murcielago', 5),
(17, 'Gallardo', 5),
(18, 'Reventon', 5),
(19, 'SLR', 6),
(20, 'AMG GTR', 6),
(21, 'G63S', 6),
(22, 'R8', 7),
(23, 'I8', 7),
(24, 'Model X', 8),
(25, 'Model S', 8),
(26, 'Model Y', 8),
(27, 'Model S Sport', 8),
(28, 'Chiron', 9),
(29, 'Divo', 9),
(30, 'Huayra', 10),
(31, 'Zonda', 10),
(32, 'Regera', 11),
(33, 'Jesko', 11);



CREATE TABLE `voiture` (
  `id_voiture` int(11) NOT NULL,
  `annee` int(11) NOT NULL,
  `kilometrage` int(11) NOT NULL,
  `chevaux` int(11) NOT NULL,
  `nombre_de_porte` int(11) NOT NULL,
  `couleur` varchar(20) NOT NULL,
  `vitesse_max` varchar(5) NOT NULL,
  `prix` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `id_modele` int(11) NOT NULL,
  `id_constructeur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `voiture` (`id_voiture`, `annee`, `kilometrage`, `chevaux`, `nombre_de_porte`, `couleur`, `vitesse_max`, `prix`, `stock`, `id_modele`, `id_constructeur`) VALUES
(1, 2006, 152202, 5, 5, 'rouge', '180', 9000, 10, 1, 1);


ALTER TABLE `acheter`
  ADD PRIMARY KEY (`id_voiture`,`id_client`),
  ADD KEY `acheter_client0_FK` (`id_client`);


ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`);


ALTER TABLE `constructeur`
  ADD PRIMARY KEY (`id_constructeur`);


ALTER TABLE `model`
  ADD PRIMARY KEY (`id_modele`),
  ADD KEY `model_constructeur_FK` (`id_constructeur`);


ALTER TABLE `voiture`
  ADD PRIMARY KEY (`id_voiture`),
  ADD KEY `voiture_model_FK` (`id_modele`),
  ADD KEY `voiture_constructeur0_FK` (`id_constructeur`);


ALTER TABLE `client`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;


ALTER TABLE `constructeur`
  MODIFY `id_constructeur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;


ALTER TABLE `model`
  MODIFY `id_modele` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;


ALTER TABLE `voiture`
  MODIFY `id_voiture` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;


ALTER TABLE `acheter`
  ADD CONSTRAINT `acheter_client0_FK` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`),
  ADD CONSTRAINT `acheter_voiture_FK` FOREIGN KEY (`id_voiture`) REFERENCES `voiture` (`id_voiture`);


ALTER TABLE `model`
  ADD CONSTRAINT `model_constructeur_FK` FOREIGN KEY (`id_constructeur`) REFERENCES `constructeur` (`id_constructeur`);


ALTER TABLE `voiture`
  ADD CONSTRAINT `voiture_constructeur0_FK` FOREIGN KEY (`id_constructeur`) REFERENCES `constructeur` (`id_constructeur`),
  ADD CONSTRAINT `voiture_model_FK` FOREIGN KEY (`id_modele`) REFERENCES `model` (`id_modele`);
COMMIT;

