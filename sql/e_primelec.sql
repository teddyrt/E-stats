-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Hôte : db
-- Généré le :  Dim 22 avr. 2018 à 18:01
-- Version du serveur :  5.7.21
-- Version de PHP :  7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `e_primelec`
--

DELIMITER $$
--
-- Procédures
--
CREATE DEFINER=`root`@`%` PROCEDURE `meilleurs_utilisateurs` ()  BEGIN
    SELECT id_utilisateur, SUM(quantite) AS nombre_achats
    FROM commande
    GROUP BY id_utilisateur
    ORDER BY nombre_achats
    LIMIT 5;
END$$

CREATE DEFINER=`root`@`%` PROCEDURE `pires_utilisateurs` ()  BEGIN
    SELECT id_utilisateur, SUM(quantite) AS nombre_achats
    FROM commande
    GROUP BY id_utilisateur
    ORDER BY nombre_achats DESC
    LIMIT 5;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `acheter`
--

CREATE TABLE `acheter` (
  `id_acheter` int(11) NOT NULL,
  `date_achat` datetime DEFAULT NULL,
  `quantite` int(11) NOT NULL,
  `prix_total` float DEFAULT NULL,
  `id_utilisateur` int(11) NOT NULL,
  `id_objet` int(11) NOT NULL,
  `id_facture` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

CREATE TABLE `adresse` (
  `id_adresse` int(11) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `code_postal` varchar(10) DEFAULT NULL,
  `ville` varchar(100) DEFAULT NULL,
  `pays` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `adresse`
--

INSERT INTO `adresse` (`id_adresse`, `designation`, `code_postal`, `ville`, `pays`) VALUES
(1, '91, rue des Soeurs', '13600', 'LA CIOTAT', 'France'),
(2, '28, Chemin des Bateliers', '61000', 'ALENÇON', 'France'),
(3, '19, rue des Chaligny', '58000', 'NEVERS', 'France'),
(4, '11, rue du Superflu', '67000', 'LYON', 'France'),
(5, '22, rue de Paris', '75001', 'PARIS', 'France'),
(6, '16, rue Saint-Georges', '15000', 'Ruynes en Margeride', 'France'),
(7, '9, rue des Postillons', '93200', 'Saint-Denis', 'France'),
(8, '61, rue Bonneterie', '59370', 'MONS-EN-BAROEUL', 'France'),
(9, '32, Rue Frédéric Chopin', '03200', 'VICHY', 'France'),
(10, '28, Chemin des Bateliers', '61000', 'ALENÇON', 'France'),
(11, '83 rue de paris', '93260', 'les lilas', 'France'),
(12, '83 rue de paris', '93260', 'bhezvhfbehkfbezf', 'France'),
(13, '83 rue de paris', '93260', 'bhezvhfbehkfbezf', 'France');

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id_categorie` int(11) NOT NULL,
  `designation` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id_categorie`, `designation`) VALUES
(1, 'chauffage'),
(2, 'climatisation'),
(3, 'plomberie');

-- --------------------------------------------------------

--
-- Structure de la table `chauffage`
--

CREATE TABLE `chauffage` (
  `id_chauffage` int(11) NOT NULL,
  `id_objet` int(11) NOT NULL,
  `matiere` varchar(255) DEFAULT NULL,
  `puissance` varchar(255) DEFAULT NULL,
  `hauteur` varchar(255) DEFAULT NULL,
  `largeur` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `chauffage`
--

INSERT INTO `chauffage` (`id_chauffage`, `id_objet`, `matiere`, `puissance`, `hauteur`, `largeur`) VALUES
(1, 1, 'acier', '495W', '440mm', '600mm');

-- --------------------------------------------------------

--
-- Structure de la table `climatisation`
--

CREATE TABLE `climatisation` (
  `id_climatisation` int(11) NOT NULL,
  `id_objet` int(11) NOT NULL,
  `puissance` varchar(150) DEFAULT NULL,
  `Puissance_nominale_(kW)` varchar(150) DEFAULT NULL,
  `Charge_réfrigérant_(kg)` varchar(150) DEFAULT NULL,
  `Débit_d’air_maximum` varchar(150) DEFAULT NULL,
  `Dimension` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `climatisation`
--

INSERT INTO `climatisation` (`id_climatisation`, `id_objet`, `puissance`, `Puissance_nominale_(kW)`, `Charge_réfrigérant_(kg)`, `Débit_d’air_maximum`, `Dimension`) VALUES
(1, 3, NULL, '2,6', '0,4', '410', '795 x 480 x 400');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id_commande` int(11) NOT NULL,
  `date_obtention` varchar(100) DEFAULT NULL,
  `quantite` varchar(50) NOT NULL,
  `prix_total` double DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `id_utilisateur` int(11) NOT NULL,
  `id_objets` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id_commande`, `date_obtention`, `quantite`, `prix_total`, `type`, `id_utilisateur`, `id_objets`) VALUES
(1, '21052018', '1', 1200, 'teddy', 1, '0'),
(2, '21-03-65', '1', 30, 'achat', 2, '0'),
(3, '21933', '1', 50, 'achat', 2, 'aaa'),
(4, '21933', '1', 50, 'achat', 2, 'aaa'),
(5, '2017-12-19-14:49:55', '1', 1314.99, 'achat', 2, 'a:1:{i:0;s:1:\"2\";}'),
(6, '2017-12-19-14:51:12', '1', 1769.99, 'achat', 2, 'a:2:{i:0;s:1:\"2\";i:1;s:1:\"7\";}'),
(7, '2017-12-19-16:41:09', '1', 2224.99, 'achat', 2, 'a:3:{i:0;s:1:\"2\";i:1;s:1:\"7\";i:2;s:1:\"7\";}'),
(9, '2017-12-21-14:19:17', '1', 1514.99, 'achat', 2, 'a:2:{i:0;s:1:\"1\";i:1;s:1:\"6\";}'),
(11, '2018-01-11-12:05:00', '1', 1182, 'achat', 2, 'a:3:{i:0;s:1:\"7\";i:1;s:1:\"9\";i:2;s:1:\"9\";}'),
(12, '2018-01-11-12:05:18', '1', 1182, 'achat', 2, 'a:3:{i:0;s:1:\"7\";i:1;s:1:\"9\";i:2;s:1:\"9\";}'),
(13, '2018-01-11-12:06:09', '1', 1182, 'achat', 2, 'a:3:{i:0;s:1:\"7\";i:1;s:1:\"9\";i:2;s:1:\"9\";}'),
(14, '2018-01-11-13:20:43', '1', 1514.99, 'achat', 2, 'a:2:{i:0;s:1:\"1\";i:1;s:1:\"6\";}'),
(15, '2018-03-14-10:01:57', '1', 470, 'achat', 5, 'a:1:{i:0;s:1:\"7\";}');

-- --------------------------------------------------------

--
-- Structure de la table `mesobjetsachetes`
--

CREATE TABLE `mesobjetsachetes` (
  `id_acheter` int(11) DEFAULT NULL,
  `id_objet` int(11) DEFAULT NULL,
  `id_utilisateur` int(11) DEFAULT NULL,
  `designation` varchar(150) DEFAULT NULL,
  `categ` varchar(100) DEFAULT NULL,
  `subcateg` varchar(100) DEFAULT NULL,
  `description` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `message_sav`
--

CREATE TABLE `message_sav` (
  `id_message` int(3) NOT NULL,
  `id_utilisateur` int(4) NOT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `message` text,
  `date_message` date NOT NULL,
  `statut` varchar(30) DEFAULT 'En attente'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `notation`
--

CREATE TABLE `notation` (
  `id_notation` int(3) NOT NULL,
  `id_utilisateur` int(4) NOT NULL,
  `id_objet` int(4) NOT NULL,
  `note` float DEFAULT '0',
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `objet`
--

CREATE TABLE `objet` (
  `id_objet` int(11) NOT NULL,
  `id_sous_categorie` int(11) NOT NULL,
  `designation` varchar(150) DEFAULT NULL,
  `description` text,
  `prix` float DEFAULT NULL,
  `quantite` varchar(255) DEFAULT NULL,
  `couleur` varchar(30) DEFAULT NULL,
  `marque` varchar(30) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `objet`
--

INSERT INTO `objet` (`id_objet`, `id_sous_categorie`, `designation`, `description`, `prix`, `quantite`, `couleur`, `marque`, `photo`, `reference`) VALUES
(1, 1, 'ALTAÏ HORIZONTAL DOUBLE', 'Radiateur décoratif de chauffage central en acier (qualité 102). - Fabriqué en France.-Tubes émetteurs plats verticaux (section 38 x 10,25 mm) en double épaisseur.- Tubes soudés sur collecteurs ronds Ø 38 mm horizontaux, épaisseur 1,5 mm.- Traitement de surface double protection, anticorrosion, par bains de cataphorèse haute résistance et finition par revêtement en poudre époxy/polyester.\r\n- Teinte de base blanc Pure White 603 (RAL 9016).- Température de service maximale 110° C.- Pression de service 4 bars (400 kpa).- Fixations : 4 consoles murales. Système anti-décrochage de sécurité.\r\n-  Position verticale ou à horizontale.', 799.99, '3', 'Divers', 'Acova', '1508142791.png', 'VYD-044-060'),
(2, 4, 'AÉROMAX 4', 'Radiateur décoratif de chauffage central en acier (qualité 102). - Fabriqué en France.-Tubes émetteurs plats verticaux (section 38 x 10,25 mm) en double épaisseur.- Tubes soudés sur collecteurs ronds Ø 38 mm horizontaux, épaisseur 1,5 mm.- Traitement de surface double protection, anticorrosion, par bains de cataphorèse haute résistance et finition par revêtement en poudre époxy/polyester.\r\n- Teinte de base blanc Pure White 603 (RAL 9016).- Température de service maximale 110° C.- Pression de service 4 bars (400 kpa).- Fixations : 4 consoles murales. Système anti-décrochage de sécurité.\r\n- Position verticale ou à horizontale.', 1299.99, '3', 'Unique', 'Thermor', 'Aeromax4Thermor.jpg', 'VYD-044-070'),
(3, 8, 'SOFTY/SOFTYH', 'Froid seul ou réversible , Look sympa et smart,Esthétique : blanc et gris argent,Matériaux haute qualité,Fonction nuit pour plus d’économie\r\n,Auto-restart,Interface de fonctionnement à LED,Télécommande numérique, avec minuterie 24h,Système automatique d’évacuation des condensats,Très facile à transporter, monté sur roulette\r\nAccessoires inclus : tuyau et kits fenêtre et hublot', 800, '3', 'Unique', 'Technibel', 'th-aeromax-4-200l-296061-d.png', 'VYD-044-080'),
(4, 5, 'E.L.M Leblanc Acleis NGLM', 'Chaudière ,complète ,Classe énergétique ,Emplacement Murale, Energie Gaz naturel Evacuation des gaz brulés Cheminée ,(CF)Gamme ACLEIS NGLMHuteur mm), 86 Lrgeur mm) 40\r\nMise en service inclus par prestataire agréé (hors pose) ,Modèle 24-7M,Performance Basse température', 857, '3', 'Blanc', 'ELM Leblanc', 'AcleisNGLM.png', 'ME205062'),
(5, 6, 'WC ALLIA JAM', 'Pack WC au sol JAM Rimfree® (sans bride), avec robinet flotteur silencieux, mécanisme double-chasse 3/6 L, sortie orientable cachée Multi.', 857, '3', 'Blanc', 'WC ALLIA JAM', 'toilette.jpg', 'ME205062'),
(6, 1, 'JOBEL 3.0 horizontal Blanc', 'Radiateur électrique rayonnant CAMPA Jobel 3.0 en acier et en pierre de lave. 2 émetteurs rayonnants entourent un corps de chauffe en pierre de lave massive, matériau à très haut pouvoir d’inertie, ayant une grande aptitude à accumuler et restituer la chaleur.\r\nUne régulation électronique digitale très ergonomique commande le fonctionnement de Jobel qui séduit par son design contemporain et volontairement épuré.\r\nJobel se fond facilement dans les intérieurs modernes et bénéficie d’un encombrement réduit et d’une façade lisse, facile à nettoyer.\r\nDoté de la nouvelle technologie 3.0 Smart ECOcontrol', 700, '3', 'Blanc', 'CAMPA', 'JOBEL.jpg', 'ME205062'),
(7, 2, 'Régate Premium Digital', 'ACOVA Regate, le \" roi \" du chauffage efficace et séchage rapide\r\nPensé astucieusement pour un confort optimal, le radiateur électrique sèche-serviettes Acova Régate Premium est composé dune zone supérieure aérée spécialement conçue pour le séchage rapide des serviettes. Sa partie basse plus dense assure un chauffage efficace et réactif dans la salle de bains.', 455, '3', 'Divers', 'Acova', 'Regate.jpg', 'ME205062'),
(8, 3, 'COLOMBE Reverso', 'Façade rayonnante ultra homogène.Elément chauffant interne à haute émissivité.Elément chauffant interne complémentaire ultra-diffusant.', 455, '3', 'Blanc', 'CAMPA', 'reverso.png', 'ME205062'),
(9, 8, 'TECHNIBEL CLIMATISEUR MOBILE SOFTY & SOFTY PLUS', 'Softy se caractérise par son design décontracté et une finition argent/blanc « high gloss ».\r\nLe volet de diffusion d’air motorisé s’ouvre automatiquement au démarrage de l’appareil.\r\nIl peut soit assurer un balayage automatique soit être positionné à l’angle souhaité par l’utilisateur de façon à assurer une répartition d’air optimale dans la pièce.\r\nIl se ferme dès l’arrêt du climatiseur évitant ainsi le dépôt de poussières et l’intrusion accidentelle d’objets indésirables lors du stockage.\r\nEn fonctionnements froid ou déshumidification, la ré évaporation des condensats améliore considérablement le rendement de l’appareil. En cas d’humidité extrême, l’excédent d’eau est recueilli dans un réservoir interne.', 356, '3', 'Blanc', 'TECHNIBEL', 'SOFTYHTECH_TECHNIBEL.jpg', 'ME205062');

-- --------------------------------------------------------

--
-- Structure de la table `plomberie`
--

CREATE TABLE `plomberie` (
  `id_plomberie` int(11) NOT NULL,
  `id_objet` int(11) NOT NULL,
  `volume` varchar(50) DEFAULT NULL,
  `classe_energetique` varchar(50) DEFAULT NULL,
  `pilotage_a_distance` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `plomberie`
--

INSERT INTO `plomberie` (`id_plomberie`, `id_objet`, `volume`, `classe_energetique`, `pilotage_a_distance`) VALUES
(1, 2, '270L', 'A', 'CONNECTÉ - Pour un pilotage à distance avec l’ap');

-- --------------------------------------------------------

--
-- Structure de la table `sous_categorie`
--

CREATE TABLE `sous_categorie` (
  `id_sous_categorie` int(11) NOT NULL,
  `designation` varchar(100) DEFAULT NULL,
  `id_categorie` int(11) NOT NULL,
  `par_defaut` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `sous_categorie`
--

INSERT INTO `sous_categorie` (`id_sous_categorie`, `designation`, `id_categorie`, `par_defaut`) VALUES
(1, 'Radiateur chauffage central', 1, NULL),
(2, 'Radiateur seche serviettes', 1, NULL),
(3, 'Radiateur electrique', 1, NULL),
(4, 'Chauffe-eau', 3, NULL),
(5, 'Chaudiere', 3, NULL),
(6, 'Toilette', 3, NULL),
(7, 'Robinetterie', 3, NULL),
(8, 'Climatiseur mobile', 2, NULL),
(9, 'Climatiseur monobloc', 2, NULL),
(10, 'Climatiseur split', 2, NULL),
(11, 'Climatiseur fixe/mural', 2, NULL),
(12, 'Climatisation reversible', 2, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id_utilisateur` int(11) NOT NULL,
  `email` varchar(70) DEFAULT NULL,
  `civilite` varchar(10) DEFAULT NULL,
  `pseudo` varchar(100) DEFAULT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `mot_de_passe` varchar(100) DEFAULT NULL,
  `telfixe` varchar(20) DEFAULT NULL,
  `telmobile` varchar(20) DEFAULT NULL,
  `id_adresse` int(11) NOT NULL DEFAULT '1',
  `role` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id_utilisateur`, `email`, `civilite`, `pseudo`, `nom`, `prenom`, `mot_de_passe`, `telfixe`, `telmobile`, `id_adresse`, `role`) VALUES
(1, 'MartinJodoin@orange.com', '0', 'Martin55', 'Jodoin', 'Martin', 'c669621852c6b227182e0db44d3e55e01799bc68', '0534230681', '0681053423', 1, ''),
(2, 'RmyCharrette@teleworm.us', '0', 'Martin55', 'Charrette', 'RÃ©my', 'eed15d68c3c7d7b34386d8c560dd31cd5d4c9714', '0597144482', '0714448205', 2, 'admin'),
(5, 'teddy.tata@icloud.com', '0', 'ramstek', 'teddy', 'tata', 'ttt', '0534230681', '0681053423', 1, NULL),
(16, 'teddy.tata@icloud.com', 'Madame', 'nkbuhb', 'cgfughubhbhb', 'Martin55', 'eed15d68c3c7d7b34386d8c560dd31cd5d4c9714', 'jjbnjjn', 'jnjnbjnjj', 1, NULL),
(17, 'teddy.orvency@gmail.com', 'Madame', 'tttt', 'ttt', 'Martin55', 'eed15d68c3c7d7b34386d8c560dd31cd5d4c9714', 'ttttttt', 'ttttt', 1, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `vuesav`
--

CREATE TABLE `vuesav` (
  `id_message` int(3) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `message` text,
  `date_message` date DEFAULT NULL,
  `statut` varchar(30) DEFAULT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `email` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `acheter`
--
ALTER TABLE `acheter`
  ADD PRIMARY KEY (`id_acheter`),
  ADD KEY `id_utilisateur` (`id_utilisateur`),
  ADD KEY `id_objet` (`id_objet`);

--
-- Index pour la table `adresse`
--
ALTER TABLE `adresse`
  ADD PRIMARY KEY (`id_adresse`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id_categorie`);

--
-- Index pour la table `chauffage`
--
ALTER TABLE `chauffage`
  ADD PRIMARY KEY (`id_chauffage`),
  ADD KEY `id_objet` (`id_objet`);

--
-- Index pour la table `climatisation`
--
ALTER TABLE `climatisation`
  ADD PRIMARY KEY (`id_climatisation`),
  ADD KEY `id_objet` (`id_objet`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id_commande`),
  ADD KEY `id_utilisateur` (`id_utilisateur`);

--
-- Index pour la table `message_sav`
--
ALTER TABLE `message_sav`
  ADD PRIMARY KEY (`id_message`),
  ADD KEY `id_utilisateur` (`id_utilisateur`);

--
-- Index pour la table `notation`
--
ALTER TABLE `notation`
  ADD PRIMARY KEY (`id_notation`),
  ADD KEY `id_utilisateur` (`id_utilisateur`),
  ADD KEY `id_objet` (`id_objet`);

--
-- Index pour la table `objet`
--
ALTER TABLE `objet`
  ADD PRIMARY KEY (`id_objet`),
  ADD KEY `id_sous_categorie` (`id_sous_categorie`);

--
-- Index pour la table `plomberie`
--
ALTER TABLE `plomberie`
  ADD PRIMARY KEY (`id_plomberie`),
  ADD KEY `id_objet` (`id_objet`);

--
-- Index pour la table `sous_categorie`
--
ALTER TABLE `sous_categorie`
  ADD PRIMARY KEY (`id_sous_categorie`),
  ADD KEY `id_categorie` (`id_categorie`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id_utilisateur`),
  ADD KEY `id_adresse` (`id_adresse`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `acheter`
--
ALTER TABLE `acheter`
  MODIFY `id_acheter` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `adresse`
--
ALTER TABLE `adresse`
  MODIFY `id_adresse` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id_categorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `chauffage`
--
ALTER TABLE `chauffage`
  MODIFY `id_chauffage` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `climatisation`
--
ALTER TABLE `climatisation`
  MODIFY `id_climatisation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id_commande` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT pour la table `message_sav`
--
ALTER TABLE `message_sav`
  MODIFY `id_message` int(3) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `notation`
--
ALTER TABLE `notation`
  MODIFY `id_notation` int(3) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `objet`
--
ALTER TABLE `objet`
  MODIFY `id_objet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `plomberie`
--
ALTER TABLE `plomberie`
  MODIFY `id_plomberie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `sous_categorie`
--
ALTER TABLE `sous_categorie`
  MODIFY `id_sous_categorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id_utilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `acheter`
--
ALTER TABLE `acheter`
  ADD CONSTRAINT `acheter_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`),
  ADD CONSTRAINT `acheter_ibfk_2` FOREIGN KEY (`id_objet`) REFERENCES `objet` (`id_objet`);

--
-- Contraintes pour la table `chauffage`
--
ALTER TABLE `chauffage`
  ADD CONSTRAINT `chauffage_ibfk_1` FOREIGN KEY (`id_objet`) REFERENCES `objet` (`id_objet`);

--
-- Contraintes pour la table `climatisation`
--
ALTER TABLE `climatisation`
  ADD CONSTRAINT `climatisation_ibfk_1` FOREIGN KEY (`id_objet`) REFERENCES `objet` (`id_objet`);

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`);

--
-- Contraintes pour la table `message_sav`
--
ALTER TABLE `message_sav`
  ADD CONSTRAINT `message_sav_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`);

--
-- Contraintes pour la table `notation`
--
ALTER TABLE `notation`
  ADD CONSTRAINT `notation_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`),
  ADD CONSTRAINT `notation_ibfk_2` FOREIGN KEY (`id_objet`) REFERENCES `objet` (`id_objet`);

--
-- Contraintes pour la table `objet`
--
ALTER TABLE `objet`
  ADD CONSTRAINT `objet_ibfk_1` FOREIGN KEY (`id_sous_categorie`) REFERENCES `sous_categorie` (`id_sous_categorie`);

--
-- Contraintes pour la table `plomberie`
--
ALTER TABLE `plomberie`
  ADD CONSTRAINT `plomberie_ibfk_1` FOREIGN KEY (`id_objet`) REFERENCES `objet` (`id_objet`);

--
-- Contraintes pour la table `sous_categorie`
--
ALTER TABLE `sous_categorie`
  ADD CONSTRAINT `sous_categorie_ibfk_1` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id_categorie`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`id_adresse`) REFERENCES `adresse` (`id_adresse`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
