package app.frontend;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import app.backend.interfaces.Item;
import app.backend.interfaces.User;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.Collection;

public class AllItemsPanel extends JPanel {

	private String closet;
	private User user;
	private MainFrame parent;
	/**
	 * Create the panel.
	 */
	public AllItemsPanel(MainFrame parent, User user) {
		setBackground(Color.WHITE);
		setLayout(new GridLayout(0, 3, 0, 0));
		closet = "all";
		this.user = user;
		this.parent = parent;
		
		addButton();
	}
	
	public void setCloset(String name){
		closet = name;
		reset();
	}
	
	public void reset(){
		this.removeAll();
		System.out.println("searching for wardrobe "+closet+" in user "+user);
		Collection<Item> items;
		if (closet.equals("all")){
			items = user.allItems();
		} else {
			items = user.searchWardrobe(closet).getItems();
		}
		for (Item i : items){
			JLabel item = new JLabel(i.getName());
			ImageIcon icon = new ImageIcon(i.getImagePath());
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
			item.setIcon(new ImageIcon(newimg));
			item.setVerticalTextPosition(SwingConstants.BOTTOM);
			item.setHorizontalTextPosition(SwingConstants.CENTER);
			item.setPreferredSize(new Dimension(150, 150));
			add(item);
		}
		
		addButton();
		
		this.repaint();
	}
	
	private void addButton(){
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.addItem();
			}
		});
		ImageIcon icon = new ImageIcon("../wardrobe/images/add.gif");
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(120, 120,
				java.awt.Image.SCALE_SMOOTH);
		btnAddItem.setIcon(new ImageIcon(newimg));
		btnAddItem.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAddItem.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddItem.setPreferredSize(new Dimension(150, 150));
		add(btnAddItem);
	}

}
