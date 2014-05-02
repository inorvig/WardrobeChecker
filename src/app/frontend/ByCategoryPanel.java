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
import java.awt.Color;

public class ByCategoryPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ByCategoryPanel() {
		setBackground(Color.WHITE);

		setLayout(new GridLayout(0, 3, 0, 0));

		JButton btnTShirts = new JButton("T-Shirts");
		btnTShirts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ImageIcon icon2 = new ImageIcon(
				"../wardrobe/images/categories/t-shirts.gif");
		Image img2 = icon2.getImage();
		Image newimg2 = img2.getScaledInstance(120, 120,
				java.awt.Image.SCALE_SMOOTH);
		btnTShirts.setIcon(new ImageIcon(newimg2));
		btnTShirts.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTShirts.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTShirts.setPreferredSize(new Dimension(150, 150));
		add(btnTShirts);

		JButton btnPants = new JButton("Pants");
		btnTShirts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ImageIcon icon3 = new ImageIcon(
				"../wardrobe/images/categories/pants.gif");
		Image img3 = icon3.getImage();
		Image newimg3 = img3.getScaledInstance(120, 120,
				java.awt.Image.SCALE_SMOOTH);
		btnTShirts.setIcon(new ImageIcon(newimg3));
		btnTShirts.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTShirts.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTShirts.setPreferredSize(new Dimension(150, 150));
		add(btnPants);

		JButton btnSkirts = new JButton("Skirts");
		btnSkirts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ImageIcon icon4 = new ImageIcon(
				"../wardrobe/images/categories/skirt.gif");
		Image img4 = icon4.getImage();
		Image newimg4 = img4.getScaledInstance(120, 120,
				java.awt.Image.SCALE_SMOOTH);
		btnSkirts.setIcon(new ImageIcon(newimg4));
		btnSkirts.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSkirts.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSkirts.setPreferredSize(new Dimension(150, 150));
		add(btnSkirts);

		JButton btnDresses = new JButton("Dresses");
		btnDresses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ImageIcon icon5 = new ImageIcon(
				"../wardrobe/images/categories/t-shirts.gif");
		Image img5 = icon5.getImage();
		Image newimg5 = img5.getScaledInstance(120, 120,
				java.awt.Image.SCALE_SMOOTH);
		btnDresses.setIcon(new ImageIcon(newimg5));
		btnDresses.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDresses.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDresses.setPreferredSize(new Dimension(150, 150));
		add(btnDresses);

		JButton btnAddCategory = new JButton("Add Category");
		btnAddCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		ImageIcon icon = new ImageIcon("../wardrobe/images/categories/add.gif");
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(120, 120,
				java.awt.Image.SCALE_SMOOTH);
		btnAddCategory.setIcon(new ImageIcon(newimg));
		btnAddCategory.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAddCategory.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddCategory.setPreferredSize(new Dimension(150, 150));
		add(btnAddCategory);

	}

}
