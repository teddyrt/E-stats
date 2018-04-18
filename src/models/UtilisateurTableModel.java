package models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class UtilisateurTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	private String[] nomColonnes = {"Nom", "Prenom", "Email", "Civilite"};
	private ArrayList<Utilisateur> list_utilisateur;

	public UtilisateurTableModel(List<Utilisateur> p_list_utilisateur) {
		list_utilisateur = (ArrayList<Utilisateur>) p_list_utilisateur;
	}

	@Override
	public int getColumnCount() {
		return nomColonnes.length;
	}

	@Override
	public int getRowCount() {
		int size;
		if (list_utilisateur == null) {
			size = 0;
		} else {
			size = list_utilisateur.size();
		}
		return size;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Utilisateur u = list_utilisateur.get(rowIndex);
		Object value = null;
		switch (columnIndex) {
		case 0:
			value = u.getNom();
			break;
		case 1:
			value = u.getPrenom();
			break;
		case 2:
			value = u.getEmail();
			break;
		case 3:
			value = u.getCivilite();
		}
		return value;
	}

	@Override
	public String getColumnName(int col) {
		return nomColonnes[col];
	}

}
