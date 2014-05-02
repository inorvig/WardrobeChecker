package app.frontend;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllItemsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AllItemsPanel() {
		setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		ImageIcon icon = new ImageIcon("../wardrobe/images/add.gif");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		btnAddItem.setIcon(new ImageIcon(newimg));
		btnAddItem.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAddItem.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddItem.setPreferredSize(new Dimension(150,150));
		add(btnAddItem);
	}

}
