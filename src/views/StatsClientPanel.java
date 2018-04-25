package views;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
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
		// Les client qui ont acheté le plus avec leurs nombres d'achats
		JLabel meilleursAcheteursLabel = new JLabel("Voici les 5 utilisateurs qui ont le plus achetés");
		List<Utilisateur> meilleursAcheteurs = uC.meilleursAcheteurs();
		JTable tableMeilleursAcheteurs = new JTable(new UtilisateurAchatTableModel(meilleursAcheteurs));
		JScrollPane spMU = new JScrollPane(tableMeilleursAcheteurs);
		spMU.setBorder(BorderFactory.createEmptyBorder());

		// Les client qui ont acheté le plus avec leurs nombres d'achats
		JLabel piresAcheteursLabel = new JLabel("Voici les 5 utilisateurs qui ont le moins achetés");
		List<Utilisateur> piresAcheteurs = uC.piresAcheteurs();
		JTable tablePiresAcheteurs = new JTable(new UtilisateurAchatTableModel(piresAcheteurs));
		JScrollPane spPU = new JScrollPane(tablePiresAcheteurs);
		spPU.setBorder(BorderFactory.createEmptyBorder());
		
		// Le client qui à le plus dépensé
		Utilisateur meilleurPayeur = uC.meilleurPayeur();
		JLabel meilleurPayeurLabel = new JLabel("Le meilleur payeur est " + meilleurPayeur.getNom() + " " + meilleurPayeur.getPrenom() + " avec " + meilleurPayeur.getTotalPrixAchat() + " € dépensé");

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(new EmptyBorder(100, 50, 150, 50));
		
		this.add(meilleursAcheteursLabel);
		this.add(spMU);
		this.add(piresAcheteursLabel);
		this.add(spPU);
		this.add(meilleurPayeurLabel);
	}

}
