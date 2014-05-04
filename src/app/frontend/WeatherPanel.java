package app.frontend;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Font;


public class WeatherPanel extends JPanel {
	
	WeatherAPI weather = new WeatherAPI();

	/**
	 * Create the panel.
	 */
	public WeatherPanel() {
		setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		
		JLabel lblNewLabel_4 = new JLabel("                                                                                               ");
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("                                                                                                                   ");
		add(lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon((weather.iconpath)));
		add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("        ");
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel(weather.temperature);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 80));
		lblNewLabel_1.setForeground(UIManager.getColor("Table.background"));
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(("/gpfs/main/home/inorvig/course/cs032/wardrobe/images/weather/f.gif")));
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("                                                                                       ");
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel(weather.summary);
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel_5.setForeground(UIManager.getColor("Table.background"));
		add(lblNewLabel_5);

	}

}
