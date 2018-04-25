-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Hôte : db
-- Généré le :  mer. 25 avr. 2018 à 21:05
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

-- --------------------------------------------------------

--
-- Structure de la table `acheter`
--

CREATE TABLE `acheter` (
  `id_acheter` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  `id_objet` int(11) NOT NULL,
  `id_commande` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `acheter`
--

INSERT INTO `acheter` (`id_acheter`, `quantite`, `id_objet`, `id_commande`) VALUES
(1, 1, 2, 5),
(2, 1, 2, 6),
(3, 1, 7, 6),
(4, 1, 2, 7),
(5, 1, 7, 7),
(6, 1, 5, 7),
(7, 1, 2, 9),
(8, 1, 8, 11),
(9, 1, 2, 12),
(10, 1, 4, 14),
(11, 1, 3, 15),
(12, 1, 3, 14);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `acheter`
--
ALTER TABLE `acheter`
  ADD PRIMARY KEY (`id_acheter`),
  ADD KEY `id_objet` (`id_objet`),
  ADD KEY `acheter_ibfk_1` (`id_commande`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `acheter`
--
ALTER TABLE `acheter`
  MODIFY `id_acheter` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `acheter`
--
ALTER TABLE `acheter`
  ADD CONSTRAINT `acheter_ibfk_1` FOREIGN KEY (`id_commande`) REFERENCES `commande` (`id_commande`),
  ADD CONSTRAINT `acheter_ibfk_2` FOREIGN KEY (`id_objet`) REFERENCES `objet` (`id_objet`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
