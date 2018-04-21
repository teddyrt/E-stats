package dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.interfaces.CommandeDao;
import daoFactory.DaoFactory;
import models.Commande;

public class ImplementationCommandeDao implements CommandeDao {

	private static final String TOUTES_COMMANDES = "SELECT * FROM commande";
	private static final String NOMBRE_COMMANDES= "SELECT COUNT(*) AS nombre_commandes FROM commande";
	
	@Override
	public List<Commande> toutesCommandes() throws SQLException {
		// Récupération de la connexion à la base de données
		Connection c = DaoFactory.getDatabase().openConnection();
		PreparedStatement pstmt = c.prepareStatement(TOUTES_COMMANDES);

		List<Commande> liste_commandes = new ArrayList<Commande>();

		ResultSet rset = pstmt.executeQuery();
		while (rset.next()) {
			Commande commande = new Commande();
			commande.setIdCommande(rset.getInt("id_commande"));
			commande.setDate(rset.getString("date_obtention"));
			commande.setQuantite(rset.getInt("quantite"));
			commande.setPrix(rset.getFloat("prix_total"));
			commande.setType(rset.getString("type"));
			commande.setIdUtilisateur(rset.getInt("id_utilisateur"));
			commande.setIdObjets(rset.getString("id_objets"));
			liste_commandes.add(commande);
		}

		pstmt.close();
		c.close();

		return liste_commandes;
	}

	@Override
	public int nombreCommandes() throws SQLException {
		// Récupération de la connexion à la base de données
		Connection c = DaoFactory.getDatabase().openConnection();
		PreparedStatement pstmt = c.prepareStatement(NOMBRE_COMMANDES);
		ResultSet rset = pstmt.executeQuery();
		
		rset.next();
		int nombreCommandes = rset.getInt("nombre_commandes");
		pstmt.close();
		c.close();

		return nombreCommandes;
	}

}
