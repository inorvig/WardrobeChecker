package app.frontend;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import app.backend.interfaces.User;

public class WardrobePanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1109275360431582813L;
	private JScrollPane all, wardrobe;
	private JLabel lblMyWardrobes;
	private MainFrame p;
	/**
	 * Create the panel.
	 */
	public WardrobePanel(MainFrame parent,User user) {
		setBackground(Color.WHITE);
		p = parent;
		setLayout(new BorderLayout(0, 0));
		all = new JScrollPane(new AllItemsPanel(parent, user));
		wardrobe = new JScrollPane(new ByWardrobePanel(parent, user));
		
		lblMyWardrobes = new JLabel("My Wardrobes");
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

		parent.pack();
	}
	
	public void makeDeletable(){
		final JButton deleteButton = new JButton("Exit");
		deleteButton.setBorder(new LineBorder(new Color(255, 255, 255)));
		deleteButton.setBackground(Color.white);
		deleteButton.setOpaque(true);
		deleteButton.setForeground(Color.black);
		deleteButton.setBounds(380, 0, 60, 16);
		deleteButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				System.out.println("this is happening");
				setVisible(false);
				lblMyWardrobes.remove(deleteButton);
				revalidate();
				repaint();
				p.pack();
				p.twoOpen = false;
				
			}

		});
		
		lblMyWardrobes.add(deleteButton);
		p.twoOpen = true;
		revalidate();
		repaint();


	}
//	public void reset(){
//		all.reset();
//		wardrobe.reset();
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
