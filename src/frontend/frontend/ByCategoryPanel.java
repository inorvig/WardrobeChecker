package frontend;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ByCategoryPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ByCategoryPanel() {
		
		setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnNewButton = new JButton("Dresses");
		btnNewButton.setIcon(new ImageIcon("../wardrobe/images/dresses.gif"));
		add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("New button");
		add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("New button");
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("New button");
		add(btnNewButton_4);

	}

}
