package dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.interfaces.UtilisateurDao;
import daoFactory.DaoFactory;
import models.Utilisateur;

public class ImplementationUtilisateurDao implements UtilisateurDao {

	private static final String TOUS_UTILISATEURS = "SELECT * FROM utilisateur";
	private static final String NOMBRE_UTILISATEURS = "SELECT COUNT(*) AS nombre_utilisateurs FROM utilisateur";

	@Override
	public List<Utilisateur> tousUtilisateurs() throws SQLException {
		// Récupération de la connexion à la base de données
		Connection c = DaoFactory.getDatabase().openConnection();
		PreparedStatement pstmt = c.prepareStatement(TOUS_UTILISATEURS);

		List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();

		ResultSet rset = pstmt.executeQuery();
		while (rset.next()) {
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setIdUtilisateur(rset.getInt("id_utilisateur"));
			utilisateur.setEmail(rset.getString("email"));
			utilisateur.setCivilite(rset.getString("civilite"));
			utilisateur.setPseudo(rset.getString("pseudo"));
			utilisateur.setNom(rset.getString("nom"));
			utilisateur.setPrenom(rset.getString("prenom"));
			utilisateur.setMot_de_passe(rset.getString("mot_de_passe"));
			utilisateur.setTelmobile(rset.getString("telmobile"));
			utilisateur.setId_adresse(rset.getInt("id_adresse"));
			utilisateur.setRole(rset.getString("role"));
			listeUtilisateurs.add(utilisateur);
		}

		pstmt.close();
		c.close();

		return listeUtilisateurs;
	}

	@Override
	public int nombreUtilisateurs() throws SQLException {
		// Récupération de la connexion à la base de données
		Connection c = DaoFactory.getDatabase().openConnection();
		PreparedStatement pstmt = c.prepareStatement(NOMBRE_UTILISATEURS);
		ResultSet rset = pstmt.executeQuery();
		
		rset.next();
		int nombreUtilisateurs = rset.getInt("nombre_utilisateurs");
		pstmt.close();
		c.close();

		return nombreUtilisateurs;
	}

}
