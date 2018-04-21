package views;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controllers.ArticleController;
import models.Article;
import models.ArticleTableModel;

public class ArticlePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private final ArticleController aC = new ArticleController();

	public ArticlePanel() {
		List<Article> listeArticles = aC.tousArticles();

		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(50, 20, 20, 20));

		JTable table = new JTable(new ArticleTableModel(listeArticles));
		JScrollPane sp = new JScrollPane(table);
		sp.setBorder(BorderFactory.createEmptyBorder());
		this.add(sp);// add table in panel using add() method
	}

}
