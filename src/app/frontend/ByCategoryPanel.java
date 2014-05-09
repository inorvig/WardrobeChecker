package app.frontend;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import app.backend.interfaces.Category;
import app.backend.interfaces.Item;
import app.backend.interfaces.User;

import java.awt.Color;

public class ByCategoryPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3463027705622908506L;
	private String closet;
	private User user;
	private MainFrame parent;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints c;
	private int count, row, col;
	/**
	 * Create the panel.
	 */
	public ByCategoryPanel(MainFrame parent, User user) {
		setBackground(Color.WHITE);
		closet = null;
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
	}
	
	//TODO: items of certain category in certain wardrobe
	public void displayCategory(String name){
		System.out.println("category: "+name);
		this.removeAll();
		addButton();
		row = 0;
		col = 1;
		count =1;
		for (Item i : user.searchWardrobe(closet).getItems()){
			JLabel item = new JLabel(i.getName());
			ImageIcon icon = new ImageIcon(i.getImagePath());
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
			item.setIcon(new ImageIcon(newimg));
			item.setVerticalTextPosition(SwingConstants.BOTTOM);
			item.setHorizontalTextPosition(SwingConstants.CENTER);
			item.setPreferredSize(new Dimension(130, 150));
			
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
			add(item,c);
			count++;
			col++;
		}
		
		
		revalidate();
		repaint();
	}
	

	public void reset(){
		System.out.println("category panel resetting with name "+closet);
		this.removeAll();
		count = 0;
		row = 0;
		col = 0;
		addButton();
		addCategories();
	}
	
	private void addButton(){
		JButton btnAddCategory = new JButton("Add Category");
		btnAddCategory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("add category pressed");
				CategoryDialog cd = new CategoryDialog(parent);
				cd.setLocationRelativeTo(parent);
				String name = cd.getName();
				String style = cd.getStyle();
				if (name!=null){
					user.addCategory(name);
					
					revalidate();
					reset();
				}
			}
		});
		ImageIcon icon = new ImageIcon("images/add.gif");
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(120, 120,
				java.awt.Image.SCALE_SMOOTH);
		btnAddCategory.setIcon(new ImageIcon(newimg));
		btnAddCategory.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAddCategory.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddCategory.setPreferredSize(new Dimension(130, 150));
		
		c.gridy = 0;
		c.gridx = 0;
		if (count%3==0 && count>0){
			row++;
			c.gridx = 0;
			c.gridy = row;
		}
		add(btnAddCategory, c);
		count++;
		col++;
	}
	
	public void addCategories(){
		for (final Category cg : user.getCategories()){
			JButton cat = new JButton(cg.getName());
			cat.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					displayCategory(cg.getName());
				}
			});
			ImageIcon icon = new ImageIcon(cg.getImagePath());
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
			cat.setIcon(new ImageIcon(newimg));
			cat.setVerticalTextPosition(SwingConstants.BOTTOM);
			cat.setHorizontalTextPosition(SwingConstants.CENTER);
			cat.setPreferredSize(new Dimension(130, 150));
			
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
			add(cat,c);
			count++;
			col++;
		}
	}
}
