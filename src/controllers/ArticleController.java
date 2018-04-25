package controllers;

import java.sql.SQLException;
import java.util.List;

import dao.implementations.ImplementationArticleDao;
import models.Article;

public class ArticleController {

	private ImplementationArticleDao iADao = new ImplementationArticleDao();

	public List<Article> tousArticles() {
		try {
			return iADao.tousArticles();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int nombreArticles() {
		try {
			return iADao.nombreArticles();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public List<Article> meilleursVentes() {
		try {
			return iADao.meilleursVentes();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Article> piresVentes() {
		try {
			return iADao.piresVentes();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
