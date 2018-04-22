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

public class ImplementationArticleDao implements ArticleDao {
	
	private static final String TOUS_ARTICLES= "SELECT * FROM objet";
	private static final String NOMBRE_ARTICLES = "SELECT COUNT(*) AS nombre_articles FROM objet";
	private static final String MEILLEURS_VENTES = "SELECT * FROM objet";
	private static final String PIRES_VENTES = "SELECT * FROM objet";
	
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
		ResultSet rset = pstmt.executeQuery();
		
		rset.next();
		// Récupération des meilleurs ventes
		pstmt.close();
		c.close();

		return null;
	}

	@Override
	public List<Article> piresVentes() throws SQLException {
		// Récupération de la connexion à la base de données
		Connection c = DaoFactory.getDatabase().openConnection();
		PreparedStatement pstmt = c.prepareStatement(PIRES_VENTES);
		ResultSet rset = pstmt.executeQuery();
		
		rset.next();
		// Récupération des pires ventes
		pstmt.close();
		c.close();

		return null;
	}

}
