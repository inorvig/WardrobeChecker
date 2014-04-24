package frontend;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ByCategoryPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ByCategoryPanel() {
		
		setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnDresses = new JButton("Dresses");
		ImageIcon icon = new ImageIcon("../wardrobe/images/dresses.gif");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		btnDresses.setIcon(new ImageIcon(newimg));
		btnDresses.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDresses.setHorizontalTextPosition(SwingConstants.CENTER);
		add(btnDresses);
		
		JButton btnNewButton_3 = new JButton("New button");
		add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("New button");
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("New button");
		add(btnNewButton_4);

	}

}
