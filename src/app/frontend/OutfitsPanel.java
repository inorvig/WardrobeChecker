package app.frontend;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import app.backend.interfaces.Outfit;
import app.backend.interfaces.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.FlowLayout;

public class OutfitsPanel extends JPanel{

	private User user;
	private MainFrame parent;
	private transient GridBagLayout gridBagLayout;
	private GridBagConstraints c;
	private int row,col,count = 0;
	private JPanel panel;

	private AllOutfitsPanel outfits;
	

	private static final long serialVersionUID = 2466177652642787961L;

	public JLabel lblAllOutfits;
	/**
	 * Create the panel.
	 */
	public OutfitsPanel(MainFrame parent, User user){
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0,0));

		lblAllOutfits = new JLabel("All Outfits");
		lblAllOutfits.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllOutfits.setForeground(Color.WHITE);
		lblAllOutfits.setBackground(Color.BLACK);
		lblAllOutfits.setOpaque(true);
		add(lblAllOutfits, BorderLayout.NORTH);

		outfits = new AllOutfitsPanel(parent, user);
		add(outfits, BorderLayout.CENTER);
		System.out.println("initial outfits: "+outfits);
		parent.pack();
	}
	
	public void reset(){
		System.out.println("outfits: "+outfits);
		outfits.reset();
		repaint();
	}

	public void makeDeletable(){
		final JButton deleteButton = new JButton("Exit");
		deleteButton.setBorder(new LineBorder(new Color(255, 255, 255)));
		deleteButton.setBackground(Color.white);
		deleteButton.setOpaque(true);
		deleteButton.setForeground(Color.black);
		deleteButton.setBounds(380, 0, 60, 16);
		deleteButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				System.out.println("this is happening");
				setVisible(false);
				lblAllOutfits.remove(deleteButton);
				revalidate();
				repaint();
				parent.pack();
				parent.twoOpen = false;
				
			}

		});
		
		lblAllOutfits.add(deleteButton);
		System.out.println(parent.twoOpen);
		parent.twoOpen = true;
		revalidate();
		repaint();


	}



}
