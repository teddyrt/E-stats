package views;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controllers.ArticleController;
import models.Article;
import models.ArticleVenteTableModel;

public class StatsProduitPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private final ArticleController aC = new ArticleController();

	public StatsProduitPanel() {
		// Les client qui ont acheté le plus avec leurs nombres d'achats
		JLabel meilleursVentesLabel = new JLabel("Voici les 5 meilleurs ventes");
		List<Article> meilleursVentes = aC.meilleursVentes();
		JTable tableMeilleursVentes = new JTable(new ArticleVenteTableModel(meilleursVentes));
		JScrollPane spMA = new JScrollPane(tableMeilleursVentes);
		spMA.setBorder(BorderFactory.createEmptyBorder());

		// Les client qui ont acheté le plus avec leurs nombres d'achats
		JLabel piresVentesLabel = new JLabel("Voici les 5 pires ventes");
		List<Article> piresVentes = aC.piresVentes();
		JTable tablePiresVentes = new JTable(new ArticleVenteTableModel(piresVentes));
		JScrollPane spPA = new JScrollPane(tablePiresVentes);
		spPA.setBorder(BorderFactory.createEmptyBorder());

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(new EmptyBorder(100, 50, 150, 50));

		this.add(meilleursVentesLabel);
		this.add(spMA);
		this.add(piresVentesLabel);
		this.add(spPA);
	}

}
