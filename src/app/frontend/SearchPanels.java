package app.frontend;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SearchPanels extends JPanel {
	
	public ArrayList<JPanel> clickables;
	
	public SearchPanels(){
		
		clickables = new ArrayList<JPanel>();
		
	}
	 public JPanel createPanel(String s, String imagePath) {
         JPanel p = new JPanel(new BorderLayout());
         p.add(new JLabel(s+ "   ", JLabel.RIGHT), BorderLayout.EAST);
         ImageIcon icon2 = new ImageIcon(OutfitMakerPanel.class.getResource(imagePath));
			Image img2 = icon2.getImage();
			Image newimg2 = img2.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
			icon2 = new ImageIcon(newimg2);
         p.add(new JLabel(icon2, JLabel.LEFT), BorderLayout.WEST);
         p.setBorder(BorderFactory.createLineBorder(Color.blue));
         clickables.add(p);
         return p;
	 }
}