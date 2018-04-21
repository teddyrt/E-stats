package models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CommandeTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private String[] nomColonnes = { "Date commande", "quantite", "prix" };
	private ArrayList<Commande> listCommandes;

	public CommandeTableModel(List<Commande> p_listeCommandes) {
		listCommandes = (ArrayList<Commande>) p_listeCommandes;
	}

	@Override
	public int getColumnCount() {
		return nomColonnes.length;
	}

	@Override
	public int getRowCount() {
		int size;
		if (listCommandes == null) {
			size = 0;
		} else {
			size = listCommandes.size();
		}
		return size;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Commande c = listCommandes.get(rowIndex);
		Object value = null;
		switch (columnIndex) {
		case 0:
			value = c.getDate();
			break;
		case 1:
			value = c.getQuantite();
			break;
		case 2:
			value = c.getPrix();
		}
		return value;
	}

	@Override
	public String getColumnName(int col) {
		return nomColonnes[col];
	}

}
