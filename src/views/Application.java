package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controllers.UtilisateurController;
import models.Utilisateur;

public class Application extends JFrame {
	
	private final UtilisateurController uC = new UtilisateurController();
	private static final long serialVersionUID = 1L;

	public Application() {
		super("E-stats");

		/* Bar de menu */
		JMenuBar menu_bar1 = new JMenuBar();
		/* différents menus */
		JMenu menu1 = new JMenu("Accueil");
		JMenu menu2 = new JMenu("Catalogue");
		JMenu menu3 = new JMenu("Commandes");
		JMenu menu4 = new JMenu("Clients");
		JMenu menu5 = new JMenu("Statistiques");
		/* differents choix de chaque menu */
		JMenuItem info = new JMenuItem("Info");
		JMenuItem quitter = new JMenuItem("Quitter");
		JMenuItem lister = new JMenuItem("Lister");
		JMenuItem afficher = new JMenuItem("Afficher");
		JMenuItem derouler = new JMenuItem("Derouler");
		JMenuItem client = new JMenuItem("Client");
		JMenuItem produit = new JMenuItem("Produit");

		/* Ajouter les choix au menu */
		menu1.add(info);
		menu1.add(quitter);
		menu2.add(lister);
		menu3.add(afficher);
		menu4.add(derouler);
		menu5.add(client);
		menu5.add(produit);
		/* Ajouter les menu sur la bar de menu */
		menu_bar1.add(menu1);
		menu_bar1.add(menu2);
		menu_bar1.add(menu3);
		menu_bar1.add(menu4);
		menu_bar1.add(menu5);
		/* Ajouter la bar du menu à la frame */
		this.setJMenuBar(menu_bar1);

		/* Action réaliser par l'ihm */
		/* clic sur le bouton info */
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(
						"Bienvenue dans l'application E-stats.Vous y trouverez tous les articles , les clients , mais aussi differentes statistiques");
			}
		});
		/* clic sur le choix lister du menu Catalogue */
		lister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Voici la liste du catalogue : ");
			}
		});
		/* clic sur le choix afficher du menu Commandes */
		afficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Voici la liste des commandes : ");
			}
		});
		/* clic sur le choix derouler du menu Clients */
		derouler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Voici la liste des clients : ");
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
				System.out.println("Voici la liste des produits : ");
			}
		});
		this.setSize(1000, 600);
		
		List<Utilisateur> list_utilisateur = uC.tous_utilisateurs();
		
		System.out.println(list_utilisateur.get(0).getEmail());
	}
}
