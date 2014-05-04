package app.frontend;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.backend.interfaces.Item;

@SuppressWarnings("serial")
public class SearchPanels extends JPanel {
	
	public ArrayList<JPanel> clickables;
	
	public SearchPanels(){
		
		clickables = new ArrayList<JPanel>();
		
	}
	 public JPanel createPanel(Item item) {
		 String s = item.getName();
		 String imagePath = item.getImagePath();
         JPanel p = new JPanel(new BorderLayout());
         p.add(new JLabel(s+ "   ", JLabel.RIGHT), BorderLayout.EAST);
         ImageIcon icon2 = new ImageIcon(imagePath);
			Image img2 = icon2.getImage();
			Image newimg2 = img2.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
			icon2 = new ImageIcon(newimg2);
         p.add(new JLabel(icon2, JLabel.LEFT), BorderLayout.WEST);
         p.setBorder(BorderFactory.createLineBorder(Color.blue));
         clickables.add(p);
         System.out.println("just made a panel with title "+ s+ " and path "+ imagePath);
         return p;
	 }
}