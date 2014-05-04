package app.frontend;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
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
	/**
	 * Create the panel.
	 */
	public ByCategoryPanel(User user) {
		setBackground(Color.WHITE);
		closet = null;
		this.user = user;
		
		setLayout(new GridLayout(0, 3, 0, 0));

//		JButton btnTShirts = new JButton("T-Shirts");
//		btnTShirts.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		ImageIcon icon2 = new ImageIcon(
//				"../wardrobe/images/categories/t-shirts.gif");
//		Image img2 = icon2.getImage();
//		Image newimg2 = img2.getScaledInstance(120, 120,
//				java.awt.Image.SCALE_SMOOTH);
//		btnTShirts.setIcon(new ImageIcon(newimg2));
//		btnTShirts.setVerticalTextPosition(SwingConstants.BOTTOM);
//		btnTShirts.setHorizontalTextPosition(SwingConstants.CENTER);
//		btnTShirts.setPreferredSize(new Dimension(150, 150));
//		add(btnTShirts);
//
//		JButton btnPants = new JButton("Pants");
//		btnTShirts.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		ImageIcon icon3 = new ImageIcon(
//				"../wardrobe/images/categories/pants.gif");
//		Image img3 = icon3.getImage();
//		Image newimg3 = img3.getScaledInstance(120, 120,
//				java.awt.Image.SCALE_SMOOTH);
//		btnTShirts.setIcon(new ImageIcon(newimg3));
//		btnTShirts.setVerticalTextPosition(SwingConstants.BOTTOM);
//		btnTShirts.setHorizontalTextPosition(SwingConstants.CENTER);
//		btnTShirts.setPreferredSize(new Dimension(150, 150));
//		add(btnPants);
//
//		JButton btnSkirts = new JButton("Skirts");
//		btnSkirts.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		ImageIcon icon4 = new ImageIcon(
//				"../wardrobe/images/categories/skirt.gif");
//		Image img4 = icon4.getImage();
//		Image newimg4 = img4.getScaledInstance(120, 120,
//				java.awt.Image.SCALE_SMOOTH);
//		btnSkirts.setIcon(new ImageIcon(newimg4));
//		btnSkirts.setVerticalTextPosition(SwingConstants.BOTTOM);
//		btnSkirts.setHorizontalTextPosition(SwingConstants.CENTER);
//		btnSkirts.setPreferredSize(new Dimension(150, 150));
//		add(btnSkirts);
//
//		JButton btnDresses = new JButton("Dresses");
//		btnDresses.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		ImageIcon icon5 = new ImageIcon(
//				"../wardrobe/images/categories/t-shirts.gif");
//		Image img5 = icon5.getImage();
//		Image newimg5 = img5.getScaledInstance(120, 120,
//				java.awt.Image.SCALE_SMOOTH);
//		btnDresses.setIcon(new ImageIcon(newimg5));
//		btnDresses.setVerticalTextPosition(SwingConstants.BOTTOM);
//		btnDresses.setHorizontalTextPosition(SwingConstants.CENTER);
//		btnDresses.setPreferredSize(new Dimension(150, 150));
//		add(btnDresses);

		addButton();

	}
	
	public void setCloset(String name){
		closet = name;
		reset();
	}
	
	//TODO: items of certain category in certain wardrobe
	public void displayCategory(String name){
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
	public void reset(){
		this.removeAll();
		for (final Category c : user.getCategories()){
			JButton cat = new JButton(c.getName());
			cat.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					displayCategory(c.getName());
				}
			});
			ImageIcon icon = new ImageIcon(c.getImagePath());
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
			cat.setIcon(new ImageIcon(newimg));
			cat.setVerticalTextPosition(SwingConstants.BOTTOM);
			cat.setHorizontalTextPosition(SwingConstants.CENTER);
			cat.setPreferredSize(new Dimension(150, 150));
			add(cat);
		}
		
		addButton();
		this.repaint();
	}
	
	private void addButton(){
		JButton btnAddItem = new JButton("Add Category");
		btnAddItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		ImageIcon icon = new ImageIcon("images/add.gif");
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
