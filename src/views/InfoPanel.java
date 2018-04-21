package views;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ArticleController;
import controllers.CommandeController;
import controllers.UtilisateurController;

public class InfoPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private final UtilisateurController uC = new UtilisateurController();
	private final CommandeController cC = new CommandeController();
	private final ArticleController aC = new ArticleController();
	
	public InfoPanel() {
		int nombreUtilisateurs = uC.nombreUtilisateurs();
		int nombreCommandes = cC.nombreCommandes();
		int nombreArticles = aC.nombreArticles();
		
		JPanel descriptionPanel = new JPanel(new FlowLayout());
		JLabel descriptionLabel = new JLabel("Bienvenue dans l'application E-stats.Vous y trouverez tous les articles , les clients , mais aussi differentes statistiques");
		descriptionPanel.add(descriptionLabel);
		
		JPanel nbUtilisateursPanel = new JPanel(new FlowLayout());
		JLabel nbUtilisateursLabel = new JLabel("Le site possède: " + nombreUtilisateurs + " utilisateurs");
		nbUtilisateursPanel.add(nbUtilisateursLabel);
		
		JPanel nbCommandesPanel = new JPanel(new FlowLayout());
		JLabel nbCommandesLabel = new JLabel("Le site a eu: " + nombreCommandes + " commandes");
		nbCommandesPanel.add(nbCommandesLabel);
		
		JPanel nbReferencesPanel = new JPanel(new FlowLayout());
		JLabel nbReferencesLabel = new JLabel("Le site possède: " + nombreArticles + " articles");
		nbReferencesPanel.add(nbReferencesLabel);
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(new EmptyBorder(150, 50, 150, 50));
		this.add(descriptionPanel);
		this.add(nbUtilisateursPanel);
		this.add(nbCommandesPanel);
		this.add(nbReferencesPanel);
	}

}
