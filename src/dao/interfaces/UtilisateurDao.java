package dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import models.Utilisateur;

public interface UtilisateurDao {
	List<Utilisateur> tous_utilisateurs() throws SQLException;
}
