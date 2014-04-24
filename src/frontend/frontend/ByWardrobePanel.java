package frontend;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class ByWardrobePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ByWardrobePanel() {
		setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Home Closet");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel);
		
		JLabel lblSpringBreak = new JLabel("Spring Break");
		GridBagConstraints gbc_lblSpringBreak = new GridBagConstraints();
		gbc_lblSpringBreak.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblSpringBreak.gridx = 2;
		gbc_lblSpringBreak.gridy = 0;
		add(lblSpringBreak);

	}

}
