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
	private static final String MEILLEURS_UTILISATEURS = "CALL meilleurs_utilisateurs";
	private static final String PIRES_UTILISATEURS = "CALL pires_utilisateurs";

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
			utilisateur.setMotDePasse(rset.getString("mot_de_passe"));
			utilisateur.setTelmobile(rset.getString("telmobile"));
			utilisateur.setIdAdresse(rset.getInt("id_adresse"));
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

	@Override
	public List<Utilisateur> meilleursUtilisateurs() throws SQLException {
		// Récupération de la connexion à la base de données
		Connection c = DaoFactory.getDatabase().openConnection();
		PreparedStatement pstmt = c.prepareStatement(MEILLEURS_UTILISATEURS);
		ResultSet rset = pstmt.executeQuery();

		// Récupération des meilleurs utilisateurs
		while (rset.next()) {
			System.out.println(rset.getInt("id_utilisateur"));
			System.out.println(rset.getInt("nombre_achats"));
		}

		pstmt.close();
		c.close();

		return null;
	}

	@Override
	public List<Utilisateur> piresUtilisateurs() throws SQLException {
		// Récupération de la connexion à la base de données
		Connection c = DaoFactory.getDatabase().openConnection();
		PreparedStatement pstmt = c.prepareStatement(PIRES_UTILISATEURS);
		ResultSet rset = pstmt.executeQuery();

		// Récupération des pires utilisateurs
		// Récupération des meilleurs utilisateurs
		while (rset.next()) {
			System.out.println(rset.getInt("id_utilisateur"));
			System.out.println(rset.getInt("nombre_achats"));
		}

		pstmt.close();
		c.close();
		return null;
	}

}
