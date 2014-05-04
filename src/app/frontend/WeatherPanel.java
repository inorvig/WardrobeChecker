package app.frontend;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;


public class WeatherPanel extends JPanel {
	WeatherAPI weather = new WeatherAPI();
	/**
	 * Create the panel.
	 */
	public WeatherPanel() {
		setBackground(new java.awt.Color(127, 110, 186));
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon icon = new ImageIcon((weather.iconpath));
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(newimg));
		lblNewLabel.setBounds(10, 5, 68, 49);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("77");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 23));
		lblNewLabel_1.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel_1.setBounds(93, 0, 45, 37);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		ImageIcon icon2 = new ImageIcon("images/weather/f.gif");
		Image img2 = icon2.getImage();
		Image newimg2 = img2.getScaledInstance(27, 27, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel_2.setIcon(new ImageIcon(newimg2));
		lblNewLabel_2.setBounds(128, 4, 36, 26);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(weather.summary);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new java.awt.Color(255, 255, 255));
		lblNewLabel_3.setBounds(68, 32, 120, 19);
		add(lblNewLabel_3);

	}

}
