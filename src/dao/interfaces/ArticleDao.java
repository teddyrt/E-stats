package dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import models.Article;

public interface ArticleDao {
	List<Article> tousArticles() throws SQLException;
	int nombreArticles() throws SQLException;
}
