package dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import models.Utilisateur;

public interface UtilisateurDao {
	List<Utilisateur> tousUtilisateurs() throws SQLException;
	int nombreUtilisateurs() throws SQLException;
	List<Utilisateur> meilleursAcheteurs() throws SQLException;
	List<Utilisateur> piresAcheteurs() throws SQLException;
	Utilisateur meilleurPayeur() throws SQLException;
}
