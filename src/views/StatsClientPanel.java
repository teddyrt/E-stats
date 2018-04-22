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
import models.UtilisateurAchatTableModel;

public class StatsClientPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private final UtilisateurController uC = new UtilisateurController();
	
	public StatsClientPanel() {
		// Le client qui a le plus de références
		
		// Les client qui ont dépensés le plus
		List<Utilisateur> meilleursUtilisateurs = uC.meilleursUtilisateurs();
		JTable tableMeilleursUtilisateurs = new JTable(new UtilisateurAchatTableModel(meilleursUtilisateurs));
		JScrollPane spMU = new JScrollPane(tableMeilleursUtilisateurs);
		
		// Le nombre d'achat par utilisateur
		
		// Le nombre de location par utilisateur
		
		
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(50, 20, 20, 20));
		
		spMU.setBorder(BorderFactory.createEmptyBorder());
		this.add(spMU);// add table in panel using add() method
	}

}
