package app.frontend;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;

import app.backend.interfaces.Outfit;
import app.backend.interfaces.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class OutfitsPanel extends JPanel {

	private User user;
	private MainFrame parent;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints c;
	private int row,col,count = 0;
	private JPanel panel;
	private AllOutfitsPanel outfits;
	
	private static final long serialVersionUID = 2466177652642787961L;

	/**
	 * Create the panel.
	 */
	public OutfitsPanel(MainFrame parent, User user){
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0,0));
		
		JLabel lblAllOutfits = new JLabel("All Outfits");
		lblAllOutfits.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllOutfits.setForeground(Color.WHITE);
		lblAllOutfits.setBackground(Color.BLACK);
		lblAllOutfits.setOpaque(true);
		add(lblAllOutfits, BorderLayout.NORTH);
		
		outfits = new AllOutfitsPanel(parent, user);
		add(outfits, BorderLayout.CENTER);
		
		parent.pack();
	}
	
	public void reset(){
		outfits.reset();
		repaint();
	}

}
