package views;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controllers.UtilisateurController;
import models.Utilisateur;
import models.UtilisateurTableModel;

public class UtilisateurPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private final UtilisateurController uC = new UtilisateurController();
	
	public UtilisateurPanel() {
		List<Utilisateur> list_utilisateur = uC.tous_utilisateurs();
		
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(50, 20, 20, 20));
		
		JTable table = new JTable(new UtilisateurTableModel(list_utilisateur));
		JScrollPane sp = new JScrollPane(table);
		sp.setBorder(BorderFactory.createEmptyBorder());
		this.add(sp);// add table in panel using add() method
	}
	
}
