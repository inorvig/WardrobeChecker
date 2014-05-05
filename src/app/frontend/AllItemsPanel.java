package app.frontend;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import app.backend.interfaces.Item;
import app.backend.interfaces.User;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.Collection;

public class AllItemsPanel extends JPanel {

	private static final long serialVersionUID = -6528705150591742324L;
	private String closet;
	private User user;
	private MainFrame parent;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints c;
	private int row,col,count = 0;
	/**
	 * Create the panel.
	 */
	public AllItemsPanel(MainFrame parent, User user) {
		setBackground(Color.WHITE);
		closet = "all";
		this.user = user;
		this.parent = parent;
		
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0};
		gridBagLayout.columnWidths = new int[] {130, 130, 130};
		gridBagLayout.rowHeights = new int[] {150};
		
		setLayout(gridBagLayout);
		
		c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1;
		c.weighty = 1;
		
		reset();
	}
	
	public void setCloset(String name){
		closet = name;
		reset();
		repaint();
	}
	
	public void reset(){
		removeAll();
		count = 0;
		row = 0;
		col = 0;
		addButton();
		addItems();
	}
	
	private void addItems(){
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
			item.setSize(new Dimension(150, 150));
			
			c.gridy = row;
			c.gridx = col;
			
			if (count%3==0 && count>0){
				row++;
				gridBagLayout.rowHeights = new int[row+1];
				for (int r=0; r<=row;r++){
					gridBagLayout.rowHeights[r]=150;
				}
				col = 0;
				c.gridx = col;
				c.gridy = row;
				
			}
			System.out.format("row: %d, col: %d, count: %d\n",row,col,count);
			add(item,c);
			count++;
			col++;
		}
	}
	
	private void addButton(){
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.addItem();
				reset();
			}
		});
		ImageIcon icon = new ImageIcon("images/add.gif");
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(120, 120,
				java.awt.Image.SCALE_SMOOTH);
		btnAddItem.setIcon(new ImageIcon(newimg));
		btnAddItem.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAddItem.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddItem.setSize(new Dimension(150, 150));
		c.gridy = row;
		c.gridx = col;
		if (count%3==0 && count>0){
			row++;
			c.gridx = 0;
			c.gridy = row;
		}
		add(btnAddItem,c);
		count++;
		col++;
	}

}
