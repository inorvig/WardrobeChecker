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
	 * 
	 */
	private static final long serialVersionUID = -1109275360431582813L;
	private AllItemsPanel all;
	private ByWardrobePanel wardrobe;
	/**
	 * Create the panel.
	 */
	public WardrobePanel(MainFrame parent,User user) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		all = new AllItemsPanel(parent, user);
		wardrobe = new ByWardrobePanel(parent, user);
		
		JLabel lblMyWardrobes = new JLabel("My Wardrobes");
		lblMyWardrobes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyWardrobes.setForeground(Color.WHITE);
		lblMyWardrobes.setBackground(Color.BLACK);
		lblMyWardrobes.setOpaque(true);
		add(lblMyWardrobes, BorderLayout.PAGE_START);

		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBackground(Color.BLACK);
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.addTab("All Items", all);
		tabbedPane.setForegroundAt(0, Color.WHITE);
		tabbedPane.setBackgroundAt(0, Color.BLACK);
		tabbedPane.addTab("By Wardrobe", wardrobe);
		tabbedPane.setForegroundAt(1, Color.WHITE);
		tabbedPane.setBackgroundAt(1, Color.BLACK);

		add(tabbedPane, BorderLayout.CENTER);

	}
	
//	public void reset(){
//		all.reset();
//		wardrobe.reset();
//	}

}
