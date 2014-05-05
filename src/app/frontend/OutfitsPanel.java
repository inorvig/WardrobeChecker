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
	
	private static final long serialVersionUID = 2466177652642787961L;

	/**
	 * Create the panel.
	 */
	public OutfitsPanel(MainFrame parent, User user) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		this.parent = parent;
		this.user = user;
		
		JLabel lblAllOutfits = new JLabel("All Outfits");
		lblAllOutfits.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllOutfits.setForeground(Color.WHITE);
		lblAllOutfits.setBackground(Color.BLACK);
		lblAllOutfits.setOpaque(true);
		add(lblAllOutfits, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(467,450));
		
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0};
		gridBagLayout.columnWidths = new int[] {130, 130, 130};
		gridBagLayout.rowHeights = new int[] {150};
		
		panel.setLayout(gridBagLayout);
		
		c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1;
		c.weighty = 1;
		
		reset();
	}
	
	public void addButton(){
		JButton btnNewOutfit = new JButton("New Outfit");
		btnNewOutfit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.toOutfitCreation();
			}
		});
		ImageIcon icon = new ImageIcon("images/add.gif");
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(120, 120,
				java.awt.Image.SCALE_SMOOTH);
		btnNewOutfit.setIcon(new ImageIcon(newimg));
		btnNewOutfit.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewOutfit.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewOutfit.setSize(new Dimension(150, 150));
		
		c.gridy = row;
		c.gridx = col;
		if (count%3==0 && count>0){
			row++;
			c.gridx = 0;
			c.gridy = row;
		}
		System.out.format("row: %d, col: %d, count: %d\n",row,col,count);
		panel.add(btnNewOutfit,c);
		count++;
		col++;
	}
	
	public void addOutfits(){
		for (Outfit o : user.getOutfits()){
			JLabel item = new JLabel(o.getName());
			ImageIcon icon = new ImageIcon(o.getPreview());
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
			item.setIcon(new ImageIcon(newimg));
			item.setVerticalTextPosition(SwingConstants.BOTTOM);
			item.setHorizontalTextPosition(SwingConstants.CENTER);
			item.setSize(new Dimension(150, 150));
			
			c.gridy = row;
			c.gridx = col;
			
			if (count%3==0 && count>0){
				row++;
				gridBagLayout.rowHeights = new int[row+1];
				for (int r=0; r<=row;r++){
					gridBagLayout.rowHeights[r]=150;
				}
				col = 0;
				c.gridx = col;
				c.gridy = row;
				
			}
			System.out.format("row: %d, col: %d, count: %d\n",row,col,count);
			panel.add(item,c);
			count++;
			col++;
		}
	}
	
	public void reset(){
		System.out.println("resetting outfits");
		removeAll();
		count = 0;
		row = 0;
		col = 0;
		addButton();
		addOutfits();
		add(panel, BorderLayout.CENTER);
	}

}
