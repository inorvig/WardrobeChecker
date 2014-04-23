package frontend;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

public class WardrobePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public WardrobePanel() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblMyWardrobes = new JLabel("My Wardrobes");
		add(lblMyWardrobes, BorderLayout.PAGE_START);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("All Items", new AllItemsPanel());
		tabbedPane.setForegroundAt(0, Color.WHITE);
		tabbedPane.setBackgroundAt(0, Color.BLACK);
		tabbedPane.addTab("By Wardrobe", new ByWardrobePanel());
		tabbedPane.setForegroundAt(1, Color.WHITE);
		tabbedPane.setBackgroundAt(1, Color.BLACK);

		add(tabbedPane, BorderLayout.CENTER);

	}

}
