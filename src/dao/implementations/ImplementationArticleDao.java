package dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.interfaces.ArticleDao;
import daoFactory.DaoFactory;
import models.Article;
import models.Utilisateur;

public class ImplementationArticleDao implements ArticleDao {
	
	private static final String TOUS_ARTICLES= "SELECT * FROM objet";
	private static final String NOMBRE_ARTICLES = "SELECT COUNT(*) AS nombre_articles FROM objet";
	private static final String MEILLEURS_VENTES = "CALL meilleurs_ventes";
	private static final String PIRES_VENTES = "CALL pires_ventes";
	
	@Override
	public List<Article> tousArticles() throws SQLException {
		// Récupération de la connexion à la base de données
		Connection c = DaoFactory.getDatabase().openConnection();
		PreparedStatement pstmt = c.prepareStatement(TOUS_ARTICLES);

		List<Article> listeArticles = new ArrayList<Article>();

		ResultSet rset = pstmt.executeQuery();
		while (rset.next()) {
			Article article = new Article();
			article.setDesignation(rset.getString("designation"));
			article.setDescription(rset.getString("description"));
			article.setPrix(rset.getFloat("prix"));
			article.setQuantite(rset.getInt("quantite"));
			article.setCouleur(rset.getString("couleur"));
			article.setMarque(rset.getString("marque"));
			article.setPhoto(rset.getString("photo"));
			listeArticles.add(article);
		}

		pstmt.close();
		c.close();

		return listeArticles;
	}
	
	@Override
	public int nombreArticles() throws SQLException {
		// Récupération de la connexion à la base de données
		Connection c = DaoFactory.getDatabase().openConnection();
		PreparedStatement pstmt = c.prepareStatement(NOMBRE_ARTICLES);
		ResultSet rset = pstmt.executeQuery();
		
		rset.next();
		int nombreArticles = rset.getInt("nombre_articles");
		pstmt.close();
		c.close();

		return nombreArticles;
	}

	@Override
	public List<Article> meilleursVentes() throws SQLException {
		// Récupération de la connexion à la base de données
		Connection c = DaoFactory.getDatabase().openConnection();
		PreparedStatement pstmt = c.prepareStatement(MEILLEURS_VENTES);

		List<Article> listeArticles = new ArrayList<Article>();
		
		// Récupération des meilleurs ventes
		ResultSet rset = pstmt.executeQuery();
		while (rset.next()) {
			Article article = new Article();
			article.setDesignation(rset.getString("designation"));
			article.setDescription(rset.getString("description"));
			article.setPrix(rset.getFloat("prix"));
			article.setQuantite(rset.getInt("quantite"));
			article.setCouleur(rset.getString("couleur"));
			article.setMarque(rset.getString("marque"));
			article.setPhoto(rset.getString("photo"));
			article.setNombreVentes(rset.getInt("nombre_ventes"));
			listeArticles.add(article);
		}
		
		pstmt.close();
		c.close();

		return listeArticles;
	}

	@Override
	public List<Article> piresVentes() throws SQLException {
		// Récupération de la connexion à la base de données
		Connection c = DaoFactory.getDatabase().openConnection();
		PreparedStatement pstmt = c.prepareStatement(PIRES_VENTES);

		List<Article> listeArticles = new ArrayList<Article>();
		
		// Récupération des pires ventes
		ResultSet rset = pstmt.executeQuery();
		while (rset.next()) {
			Article article = new Article();
			article.setDesignation(rset.getString("designation"));
			article.setDescription(rset.getString("description"));
			article.setPrix(rset.getFloat("prix"));
			article.setQuantite(rset.getInt("quantite"));
			article.setCouleur(rset.getString("couleur"));
			article.setMarque(rset.getString("marque"));
			article.setPhoto(rset.getString("photo"));
			article.setNombreVentes(rset.getInt("nombre_ventes"));
			listeArticles.add(article);
		}

		pstmt.close();
		c.close();

		return listeArticles;
	}

}
