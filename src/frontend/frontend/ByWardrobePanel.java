package frontend;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ByWardrobePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ByWardrobePanel() {
		
		setLayout(new GridLayout(0, 3, 0, 0)); 
		
		JButton btnHomeCloset = new JButton("Home Closet");
		ImageIcon icon = new ImageIcon("../wardrobe/images/closet.gif");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		btnHomeCloset.setIcon(new ImageIcon(newimg));
		add(btnHomeCloset);
		
		JButton btnSpringBreak = new JButton("Spring Break");
		add(btnSpringBreak);

	}

}
