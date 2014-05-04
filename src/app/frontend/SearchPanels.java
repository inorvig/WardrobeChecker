package app.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.backend.interfaces.Item;

public class SearchPanels extends JPanel {

	/**
	 * Create the panel.
	 */	public ArrayList<JPanel> Clickable;
	

	List<JPanel> panels;
	
	
	

	public JPanel createPanel(Item x) {
		System.out.println(x.getName());
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JLabel(x.getName()+ "   ", JLabel.CENTER), BorderLayout.CENTER);
        ImageIcon icon2 = new ImageIcon(x.getImagePath());
        System.out.println(x.getImagePath());
		Image img2 = icon2.getImage();
		Image newimg2 = img2.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(newimg2);
        p.add(new JLabel(icon2, JLabel.LEFT), BorderLayout.WEST);
        p.setBorder(BorderFactory.createLineBorder(Color.blue));
        Clickable.add(p);
       // repaint();
        return p;
       
    }
	
	public void repaint(){
		super.repaint();
		if (panels != null){
		for (JPanel i: panels){
			i.revalidate();
			i.repaint();
		}
		}
		else System.out.println("panels nuklllll");
	}
	public SearchPanels(List<Item> list) {
		Clickable = new ArrayList<JPanel>();
		System.out.println(panels+ " is null?");
		setLayout(new GridLayout(0, 1));
		for(Item x: list){
			this.add(createPanel(x));
		}
		this.setBackground(new java.awt.Color(127, 110, 186));
		String s= "sfdfs";
		revalidate();
		repaint();

	}


}