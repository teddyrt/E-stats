package views;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controllers.CommandeController;
import models.Commande;
import models.CommandeTableModel;

public class CommandePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private final CommandeController cC = new CommandeController();

	public CommandePanel() {
		List<Commande> listeCommandes = cC.toutesCommandes();

		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(50, 20, 20, 20));

		JTable table = new JTable(new CommandeTableModel(listeCommandes));
		JScrollPane sp = new JScrollPane(table);
		sp.setBorder(BorderFactory.createEmptyBorder());
		this.add(sp);// add table in panel using add() method
	}
}
