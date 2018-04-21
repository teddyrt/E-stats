package controllers;

import java.sql.SQLException;
import java.util.List;

import dao.implementations.ImplementationCommandeDao;
import models.Commande;

public class CommandeController {

	private ImplementationCommandeDao iCDao = new ImplementationCommandeDao();

	public List<Commande> toutesCommandes() {
		try {
			return iCDao.toutesCommandes();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int nombreCommandes() {
		try {
			return iCDao.nombreCommandes();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
