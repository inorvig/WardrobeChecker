package app.frontend;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;

import app.backend.interfaces.User;

public class ClosetPanel extends JPanel {

	private String name;
	private AllItemsPanel all;
	private ByCategoryPanel category;
	/**
	 * Create the panel.
	 */
	public ClosetPanel(MainFrame parent, User user) {
		name = null;
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		all = new AllItemsPanel(user);
		category = new ByCategoryPanel(user);

		JLabel lblMyWardrobes = new JLabel("Home Closet");
		lblMyWardrobes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyWardrobes.setForeground(Color.WHITE);
		lblMyWardrobes.setBackground(Color.BLACK);
		lblMyWardrobes.setOpaque(true);
		add(lblMyWardrobes, BorderLayout.PAGE_START);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.BLACK);
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.addTab("All Items", all);
		tabbedPane.setForegroundAt(0, Color.WHITE);
		tabbedPane.setBackgroundAt(0, Color.BLACK);
		tabbedPane.addTab("By Category", category);
		tabbedPane.setForegroundAt(1, Color.WHITE);
		tabbedPane.setBackgroundAt(1, Color.BLACK);

		add(tabbedPane, BorderLayout.CENTER);

	}
	
	public void setCloset(String name){
		this.name = name;
		all.setCloset(name);
		category.setCloset(name);
	}

}
