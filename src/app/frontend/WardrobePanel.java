package app.frontend;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;

import app.backend.interfaces.User;

public class WardrobePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public WardrobePanel(MainFrame parent,User user) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));

		JLabel lblMyWardrobes = new JLabel("My Wardrobes");
		lblMyWardrobes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyWardrobes.setForeground(Color.WHITE);
		lblMyWardrobes.setBackground(Color.BLACK);
		lblMyWardrobes.setOpaque(true);
		add(lblMyWardrobes, BorderLayout.PAGE_START);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.BLACK);
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.addTab("All Items", new AllItemsPanel(user));
		tabbedPane.setForegroundAt(0, Color.WHITE);
		tabbedPane.setBackgroundAt(0, Color.BLACK);
		tabbedPane.addTab("By Wardrobe", new ByWardrobePanel(parent, user));
		tabbedPane.setForegroundAt(1, Color.WHITE);
		tabbedPane.setBackgroundAt(1, Color.BLACK);

		add(tabbedPane, BorderLayout.CENTER);

	}

}
