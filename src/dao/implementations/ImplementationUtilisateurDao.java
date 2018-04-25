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
	private static final String MEILLEURS_ACHETEURS = "CALL meilleurs_acheteurs";
	private static final String PIRES_ACHETEURS = "CALL pires_acheteurs";
	private static final String MEILLEUR_PAYEUR = "CALL meilleur_payeur";

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
	public List<Utilisateur> meilleursAcheteurs() throws SQLException {
		// Récupération de la connexion à la base de données
		Connection c = DaoFactory.getDatabase().openConnection();
		PreparedStatement pstmt = c.prepareStatement(MEILLEURS_ACHETEURS);

		List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();

		// Récupération des meilleurs acheteurs
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
			utilisateur.setNombreAchats(rset.getInt("nombre_achats"));
			listeUtilisateurs.add(utilisateur);
		}

		pstmt.close();
		c.close();

		return listeUtilisateurs;
	}

	@Override
	public List<Utilisateur> piresAcheteurs() throws SQLException {
		// Récupération de la connexion à la base de données
		Connection c = DaoFactory.getDatabase().openConnection();
		PreparedStatement pstmt = c.prepareStatement(PIRES_ACHETEURS);

		List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();

		// Récupération des pires acheteurs
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
			utilisateur.setNombreAchats(rset.getInt("nombre_achats"));
			listeUtilisateurs.add(utilisateur);
		}

		pstmt.close();
		c.close();
		return listeUtilisateurs;
	}

	@Override
	public Utilisateur meilleurPayeur() throws SQLException {
		// Récupération de la connexion à la base de données
		Connection c = DaoFactory.getDatabase().openConnection();
		PreparedStatement pstmt = c.prepareStatement(MEILLEUR_PAYEUR);
		
		ResultSet rset = pstmt.executeQuery();
		rset.next();
		Utilisateur meilleurPayeur = new Utilisateur();
		meilleurPayeur.setIdUtilisateur(rset.getInt("id_utilisateur"));
		meilleurPayeur.setEmail(rset.getString("email"));
		meilleurPayeur.setCivilite(rset.getString("civilite"));
		meilleurPayeur.setPseudo(rset.getString("pseudo"));
		meilleurPayeur.setNom(rset.getString("nom"));
		meilleurPayeur.setPrenom(rset.getString("prenom"));
		meilleurPayeur.setMotDePasse(rset.getString("mot_de_passe"));
		meilleurPayeur.setTelmobile(rset.getString("telmobile"));
		meilleurPayeur.setIdAdresse(rset.getInt("id_adresse"));
		meilleurPayeur.setRole(rset.getString("role"));
		meilleurPayeur.setTotalPrixAchat(rset.getFloat("total_prix_achat"));
		
		pstmt.close();
		c.close();
		return meilleurPayeur;
	}

}
