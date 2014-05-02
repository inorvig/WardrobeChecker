package app.frontend;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OutfitsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public OutfitsPanel() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel lblAllOutfits = new JLabel("All Outfits");
		lblAllOutfits.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllOutfits.setForeground(Color.WHITE);
		lblAllOutfits.setBackground(Color.BLACK);
		lblAllOutfits.setOpaque(true);
		add(lblAllOutfits, BorderLayout.NORTH);

		JButton btnNewOutfit = new JButton("New Outfit");
		btnNewOutfit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		ImageIcon icon = new ImageIcon("../wardrobe/images/add.gif");
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(120, 120,
				java.awt.Image.SCALE_SMOOTH);
		btnNewOutfit.setIcon(new ImageIcon(newimg));
		btnNewOutfit.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewOutfit.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewOutfit.setPreferredSize(new Dimension(150, 150));
		add(btnNewOutfit);

	}

}
