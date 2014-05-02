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
import java.awt.Color;

public class ByWardrobePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ByWardrobePanel() {
		setBackground(Color.WHITE);

		setLayout(new GridLayout(0, 3, 0, 0));

		JButton btnAddWardrobe = new JButton("Add Wardrobe");
		btnAddWardrobe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		ImageIcon icon = new ImageIcon("../wardrobe/images/add.gif");
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(120, 120,
				java.awt.Image.SCALE_SMOOTH);
		btnAddWardrobe.setIcon(new ImageIcon(newimg));
		btnAddWardrobe.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAddWardrobe.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddWardrobe.setPreferredSize(new Dimension(150, 150));
		add(btnAddWardrobe);

	}

}
