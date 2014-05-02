package app.frontend;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class OutfitsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public OutfitsPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Outfit A");
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Outfit B");
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Outfit C");
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Outfit D");
		panel.add(lblNewLabel);
		
		JLabel lblAllOutfits = new JLabel("All Outfits");
		lblAllOutfits.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllOutfits.setForeground(Color.WHITE);
		lblAllOutfits.setBackground(Color.BLACK);
		lblAllOutfits.setOpaque(true);
		add(lblAllOutfits, BorderLayout.NORTH);

	}

}
