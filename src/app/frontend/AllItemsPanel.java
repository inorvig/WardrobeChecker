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

public class AllItemsPanel extends JPanel {

	private String closet;
	private User user;
	/**
	 * Create the panel.
	 */
	public AllItemsPanel(User user) {
		setBackground(Color.WHITE);
		setLayout(new GridLayout(0, 3, 0, 0));
		closet = "all";
		this.user = user;
		
		addButton();
	}
	
	public void setCloset(String name){
		closet = name;
		
	}
	
	public void reset(){
		this.removeAll();
		for (Item i : user.searchWardrobe(closet).getItems()){
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
	}
	
	private void addButton(){
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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
