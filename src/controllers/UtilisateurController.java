package controllers;

import java.sql.SQLException;
import java.util.List;

import dao.implementations.ImplementationUtilisateurDao;
import models.Utilisateur;

public class UtilisateurController {

	private ImplementationUtilisateurDao iUDao = new ImplementationUtilisateurDao();

	public List<Utilisateur> tous_utilisateurs() {
		try {
			return iUDao.tous_utilisateurs();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
