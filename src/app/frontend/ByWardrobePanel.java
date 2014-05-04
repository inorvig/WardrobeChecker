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

public class ByWardrobePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5125816748670380176L;

	/**
	 * Create the panel.
	 */
	public ByWardrobePanel(final MainFrame parent, final User user) {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		setBackground(Color.WHITE);

		for (final Wardrobe w : user.getWardrobes()){
			JButton btnWardrobe = new JButton(w.getName());
			btnWardrobe.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					parent.openWardrobe(w.getName());
				}
			});
			ImageIcon icon = new ImageIcon("../wardrobe/images/closet.gif");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(120, 120,
					java.awt.Image.SCALE_SMOOTH);
			btnWardrobe.setIcon(new ImageIcon(newimg));
			btnWardrobe.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnWardrobe.setHorizontalTextPosition(SwingConstants.CENTER);
			btnWardrobe.setSize(new Dimension(150, 150));
			add(btnWardrobe);
		}

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
						//this.repaint();
					} else {
						user.addWardrobe(name, WardrobeType.SUITCASE);
					}
				}
			}
		});
		ImageIcon icon = new ImageIcon("../wardrobe/images/add.gif");
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(120, 120,
				java.awt.Image.SCALE_SMOOTH);
		btnAddWardrobe.setIcon(new ImageIcon(newimg));
		btnAddWardrobe.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAddWardrobe.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddWardrobe.setSize(new Dimension(130, 150));
		add(btnAddWardrobe);
		
		

	}

}
