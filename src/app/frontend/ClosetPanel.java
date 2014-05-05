package app.frontend;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;

import app.backend.interfaces.User;

public class ClosetPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3190971077461927196L;
	private String name;
	private JScrollPane a;
	private JScrollPane c;
	private AllItemsPanel all;
	private ByCategoryPanel category;
	/**
	 * Create the panel.
	 */
	public ClosetPanel(MainFrame parent, User user) {
		name = null;
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		all = new AllItemsPanel(parent, user);
		category = new ByCategoryPanel(parent,user);
		a = new JScrollPane(all);
		c = new JScrollPane(category);

		

		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBackground(Color.BLACK);
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.addTab("All Items", a);
		tabbedPane.setForegroundAt(0, Color.WHITE);
		tabbedPane.setBackgroundAt(0, Color.BLACK);
		tabbedPane.addTab("By Category", c);
		tabbedPane.setForegroundAt(1, Color.WHITE);
		tabbedPane.setBackgroundAt(1, Color.BLACK);

		add(tabbedPane, BorderLayout.CENTER);

	}
	
	public void setCloset(String name){
		this.name = name;
		
		JLabel lblMyWardrobes = new JLabel(name);
		lblMyWardrobes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyWardrobes.setForeground(Color.WHITE);
		lblMyWardrobes.setBackground(Color.BLACK);
		lblMyWardrobes.setOpaque(true);
		add(lblMyWardrobes, BorderLayout.PAGE_START);
		
		all.setCloset(name);
		category.setCloset(name);
	}
	
	public void reset(){
		all.reset();
		category.reset();
		this.repaint();
	}

}
