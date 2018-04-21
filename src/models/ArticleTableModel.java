package models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ArticleTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private String[] nomColonnes = { "Designation", "Description", "prix" };
	private ArrayList<Article> listArticles;

	public ArticleTableModel(List<Article> p_listeArticles) {
		listArticles = (ArrayList<Article>) p_listeArticles;
	}

	@Override
	public int getColumnCount() {
		return nomColonnes.length;
	}

	@Override
	public int getRowCount() {
		int size;
		if (listArticles == null) {
			size = 0;
		} else {
			size = listArticles.size();
		}
		return size;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Article a = listArticles.get(rowIndex);
		Object value = null;
		switch (columnIndex) {
		case 0:
			value = a.getDesignation();
			break;
		case 1:
			value = a.getDescription();
			break;
		case 2:
			value = a.getPrix();
		}
		return value;
	}

	@Override
	public String getColumnName(int col) {
		return nomColonnes[col];
	}

}
