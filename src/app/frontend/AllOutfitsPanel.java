package app.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import app.backend.interfaces.Outfit;
import app.backend.interfaces.User;

public class AllOutfitsPanel extends JPanel {

	private final MainFrame parent;
	private final User user;
	private transient GridBagLayout gridBagLayout;
	private GridBagConstraints c;
	private int row,col,count = 0;
	
	public AllOutfitsPanel(final MainFrame parent, final User user) {
		setBackground(Color.WHITE);
		this.parent = parent;
		this.user = user;
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0};
		gridBagLayout.columnWidths = new int[] {130, 130, 130};
		gridBagLayout.rowHeights = new int[] {150};
		
		setLayout(gridBagLayout);
		
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
		btnNewOutfit.setSize(new Dimension(130, 150));
		
		c.gridy = row;
		c.gridx = col;
		if (count%3==0 && count>0){
			row++;
			c.gridx = 0;
			c.gridy = row;
		}
		System.out.format("row: %d, col: %d, count: %d\n",row,col,count);
		add(btnNewOutfit,c);
		count++;
		col++;
	}
	
	public void addOutfits(){
		System.out.println("add outfits called; outfits length: "+user.getOutfits().size());
		for (final Outfit o : user.getOutfits()){
			System.out.println("outfit encountered");
			JButton item = new JButton(o.getName());
			item.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e){
					parent.editOutfit(o);
				}
			});
			ImageIcon icon = new ImageIcon(o.getDisplayInfo().getPreview());
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
			add(item,c);
			count++;
			col++;
		}
	}
	

	public void reset(){
		System.out.println("resetting all outfits panel");
		removeAll();
		count = 0;
		row = 0;
		col = 0;
		addButton();
		addOutfits();
	}

}
