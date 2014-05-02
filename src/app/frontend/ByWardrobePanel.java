package app.frontend;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ByWardrobePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ByWardrobePanel() {
		
		setLayout(new GridLayout(0, 3, 0, 0)); 
		
		JButton btnHomeCloset = new JButton("Home Closet");
		btnHomeCloset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		ImageIcon icon = new ImageIcon("../wardrobe/images/closet.gif");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		btnHomeCloset.setIcon(new ImageIcon(newimg));
		btnHomeCloset.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnHomeCloset.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHomeCloset.setPreferredSize(new Dimension(150,150));
		add(btnHomeCloset);
		
		JButton btnSpringBreak = new JButton("Spring Break");
		add(btnSpringBreak);

	}

}
