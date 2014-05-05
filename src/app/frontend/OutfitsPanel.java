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

import app.backend.interfaces.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class OutfitsPanel extends JPanel {

	/**
	 *
	 **/
	private static final long serialVersionUID = 2466177652642787961L;

	/**
	 * Create the panel.
	 */
	public OutfitsPanel(MainFrame parent, User user) {
		setLayout(new BorderLayout(0, 0));
		
				
		JLabel lblAllOutfits = new JLabel("All Outfits");
		lblAllOutfits.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllOutfits.setForeground(Color.WHITE);
		lblAllOutfits.setBackground(Color.BLACK);
		lblAllOutfits.setOpaque(true);
		add(lblAllOutfits, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JButton btnNewOutfit = new JButton("New Outfit");
		btnNewOutfit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		ImageIcon icon = new ImageIcon("images/add.gif");
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(120, 120,
				java.awt.Image.SCALE_SMOOTH);
		btnNewOutfit.setIcon(new ImageIcon(newimg));
		btnNewOutfit.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewOutfit.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewOutfit.setPreferredSize(new Dimension(150, 150));
		panel.add(btnNewOutfit);

	}
	
	public void addButton(){
		
	}
	
	public void addOutfits(){
		
	}
	
	public void reset(){
		
	}

}
