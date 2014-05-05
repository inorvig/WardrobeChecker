package app.frontend;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import app.backend.interfaces.User;
import app.backend.interfaces.Wardrobe;
import app.backend.user.AppWardrobe.WardrobeType;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class ByWardrobePanel extends JPanel {

	private final MainFrame parent;
	private final User user;
	private GridBagLayout gridBagLayout;
	private int row,col,count = 0;
	private GridBagConstraints c;

	/**
	 * Create the panel.
	 */
	public ByWardrobePanel(final MainFrame parent, final User user) {
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

	protected void reset() {
		removeAll();
		count = 0;
		row = 0;
		col = 0;
		addButton();
		addWardrobes();
	}
	
	public void addButton(){
		ImageIcon icon = new ImageIcon("images/add.gif");
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(120, 120,
				java.awt.Image.SCALE_SMOOTH);
		
		JButton btnAddWardrobe = new JButton("Add Wardrobe");
		btnAddWardrobe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("add wardrobe pressed");
				WardrobeDialog wd = new WardrobeDialog(parent);
				wd.setLocationRelativeTo(parent);
				String name = wd.getName();
				String style = wd.getStyle();
				if (name!=null){
					if (style.equals("closet")){
						user.addWardrobe(name, WardrobeType.CLOSET);
					} else {
						user.addWardrobe(name, WardrobeType.SUITCASE);
					}
					
					revalidate();
					reset();
				}
			}
		});
		btnAddWardrobe.setIcon(new ImageIcon(newimg));
		btnAddWardrobe.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAddWardrobe.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddWardrobe.setPreferredSize(new Dimension(130, 150));
		c.gridy = row;
		c.gridx = col;
		if (count%3==0 && count>0){
			row++;
			c.gridx = 0;
			c.gridy = row;
		}
		add(btnAddWardrobe, c);
		count++;
		col++;
	}
	
	public void addWardrobes(){
		for (final Wardrobe w : user.getWardrobes()){
			JButton btnWardrobe = new JButton(w.getName());
			btnWardrobe.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					parent.openWardrobe(w.getName());
				}
			});
			ImageIcon icon;
			if (w.getType()==WardrobeType.CLOSET){
				icon = new ImageIcon("images/closet.gif");
			} else {
				icon = new ImageIcon("images/luggage.gif");
			}
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(120, 120,
					java.awt.Image.SCALE_SMOOTH);
			btnWardrobe.setIcon(new ImageIcon(newimg));
			btnWardrobe.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnWardrobe.setHorizontalTextPosition(SwingConstants.CENTER);
			btnWardrobe.setPreferredSize(new Dimension(130, 150));
			
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
			add(btnWardrobe, c);
			count++;
			col++;
		}
	}

}
