package models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class UtilisateurAchatTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;

	private String[] nomColonnes = { "Nom", "Prenom", "Email", "Nombre d'achats" };
	private ArrayList<Utilisateur> listeUtilisateur;

	public UtilisateurAchatTableModel(List<Utilisateur> p_listeUtilisateur) {
		listeUtilisateur = (ArrayList<Utilisateur>) p_listeUtilisateur;
	}

	@Override
	public int getColumnCount() {
		return nomColonnes.length;
	}

	@Override
	public int getRowCount() {
		int size;
		if (listeUtilisateur == null) {
			size = 0;
		} else {
			size = listeUtilisateur.size();
		}
		return size;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Utilisateur u = listeUtilisateur.get(rowIndex);
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
			value = u.getNombreAchats();
		}
		return value;
	}

	@Override
	public String getColumnName(int col) {
		return nomColonnes[col];
	}

}