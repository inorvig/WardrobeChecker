package app.frontend;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 5125816748670380176L;

	/**
	 * Create the panel.
	 */
	public ByWardrobePanel(final MainFrame parent, final User user) {
		setBackground(Color.WHITE);
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0};
		gridBagLayout.columnWidths = new int[] {130, 130, 130};
		//gridBagLayout.rowHeights = new int[] {150};
		
		setLayout(gridBagLayout);
		
		GridBagConstraints cst = new GridBagConstraints();
		
		int count = 0;
		int row = 0;
		int col = 0;
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
			cst.gridx=col;

			System.out.println("count: "+count+", col: "+col);
			if (count%3==0 && count>0){
				row++;
				//gridBagLayout.rowHeights.
				col = 0;
				cst.gridx = col;
				cst.gridy = row;
			}
			add(btnWardrobe, cst);
			count++;
			col++;
		}
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
					repaint();
				}
			}
		});
		btnAddWardrobe.setIcon(new ImageIcon(newimg));
		btnAddWardrobe.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAddWardrobe.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddWardrobe.setPreferredSize(new Dimension(130, 150));
		cst.gridx=col;
		System.out.println("count: "+count+", col: "+col);
		if (count%3==0 && count>0){
			row++;
			cst.gridx = 0;
			cst.gridy = row;
		}
		add(btnAddWardrobe, cst);
		
		parent.pack();
	}

}
