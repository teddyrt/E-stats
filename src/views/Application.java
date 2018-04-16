package views;

import javax.swing.JFrame;


public class Application extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void start() {
		/* Création de la fenêtre principal */
		JFrame mainFrame= new JFrame("E-stats");
		
		mainFrame.setVisible(true);
	}
}
