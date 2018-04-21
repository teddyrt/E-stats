package dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import models.Commande;

public interface CommandeDao {
	List<Commande> toutesCommandes() throws SQLException;
	int nombreCommandes() throws SQLException;
}
