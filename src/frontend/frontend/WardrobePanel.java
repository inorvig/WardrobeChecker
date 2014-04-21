package frontend;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class WardrobePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public WardrobePanel() {
		
		JLabel lblMyWardrobes = new JLabel("My Wardrobes");
		add(lblMyWardrobes);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("All Items", new AllItemsPanel());
		tabbedPane.addTab("By Wardrobe", new ByWardrobePanel());

		add(tabbedPane);
		
		tabbedPane.setTabPlacement(JTabbedPane.LEFT);

	}

}
