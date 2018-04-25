package controllers;

import java.sql.SQLException;
import java.util.List;

import dao.implementations.ImplementationUtilisateurDao;
import models.Utilisateur;

public class UtilisateurController {

	private ImplementationUtilisateurDao iUDao = new ImplementationUtilisateurDao();

	public List<Utilisateur> tousUtilisateurs() {
		try {
			return iUDao.tousUtilisateurs();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int nombreUtilisateurs() {
		try {
			return iUDao.nombreUtilisateurs();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public List<Utilisateur> meilleursAcheteurs() {
		try {
			return iUDao.meilleursAcheteurs();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Utilisateur> piresAcheteurs() {
		try {
			return iUDao.piresAcheteurs();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Utilisateur meilleurPayeur() {
		try {
			return iUDao.meilleurPayeur();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
