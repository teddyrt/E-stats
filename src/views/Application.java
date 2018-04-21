package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Application extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public Application() {
		super("E-stats");

		/* Bar de menu */
		JMenuBar menuBar = new JMenuBar();
		/* différents menus */
		JMenu menu1Acceuil = new JMenu("Accueil");
		JMenu menuCatalogue = new JMenu("Catalogue");
		JMenu menuCommande = new JMenu("Commandes");
		JMenu menuClient = new JMenu("Clients");
		JMenu menuStat = new JMenu("Statistiques");
		/* differents choix de chaque menu */
		JMenuItem info = new JMenuItem("Info");
		JMenuItem quitter = new JMenuItem("Quitter");
		JMenuItem listerCatalogue = new JMenuItem("Lister");
		JMenuItem listerCommande = new JMenuItem("Lister");
		JMenuItem listerClient = new JMenuItem("Lister");
		JMenuItem client = new JMenuItem("Client");
		JMenuItem produit = new JMenuItem("Produit");

		/* Ajouter les choix au menu */
		menu1Acceuil.add(info);
		menu1Acceuil.add(quitter);
		menuCatalogue.add(listerCatalogue);
		menuCommande.add(listerCommande);
		menuClient.add(listerClient);
		menuStat.add(client);
		menuStat.add(produit);
		/* Ajouter les menu sur la bar de menu */
		menuBar.add(menu1Acceuil);
		menuBar.add(menuCatalogue);
		menuBar.add(menuCommande);
		menuBar.add(menuClient);
		menuBar.add(menuStat);
		/* Ajouter la bar du menu à la frame */
		this.setJMenuBar(menuBar);

		/* Action réaliser par l'ihm */
		/* clic sur le bouton info */
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficherInfo();
			}
		});
		/* clic sur le choix lister du menu Catalogue */
		listerCatalogue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficherCatalogue();
			}
		});
		/* clic sur le choix afficher du menu Commandes */
		listerCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficherCommande();
			}
		});
		/* clic sur le choix derouler du menu Clients */
		listerClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficherClient();
			}
		});
		/* clic sur le choix client du menu Statistiques */
		client.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Voici la liste des clients : ");
			}
		});
		/* clic sur le choix produit du menu Statistiques */
		produit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Voici les statistiques clients : ");
			}
		});
		
		/* clic spour quitter l'application */
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitter();
			}
		});
		
		this.setSize(1000, 600);
		InfoPanel infoPanel = new InfoPanel();
		
		this.setContentPane(infoPanel);
	}
	
	public void afficherInfo() {
		InfoPanel infoPanel = new InfoPanel();
		
		this.setContentPane(infoPanel);
		this.revalidate();
	}
	
	public void afficherCatalogue() {
		ArticlePanel articlePanel = new ArticlePanel();
		
		this.setContentPane(articlePanel);
		this.revalidate();
	}
	
	public void afficherCommande() {
		CommandePanel commandePanel = new CommandePanel();
		
		this.setContentPane(commandePanel);
		this.revalidate();
	}
	
	public void afficherClient() {
		UtilisateurPanel utilisateurPanel = new UtilisateurPanel();
		
		this.setContentPane(utilisateurPanel);
		this.revalidate();
	}
	
	public void quitter() {
		System.exit(0);
	}
}
