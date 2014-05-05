package app.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.backend.interfaces.Item;

public class SearchPanels extends JPanel implements MouseListener {

	/**
	 * Create the panel.
	 */	
	public HashMap<JPanel, Item> Clickable;
	public OutfitMakerPanel ourPanel; 
	
	
	
	

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
        p.addMouseListener(this);
        Clickable.put(p, x);
       // repaint();
        return p;
       
    }
	
	public void update(List<Item> newList){
		while (!Clickable.isEmpty()){
			Clickable.remove()
		}
	}
	
	
	public SearchPanels(List<Item> list, OutfitMakerPanel outfitsPanel) {
		Clickable = new HashMap<JPanel, Item>();
		setLayout(new GridLayout(0, 1));
		for(Item x: list){
			this.add(createPanel(x));
		}
		ourPanel = outfitsPanel;
		this.setBackground(new java.awt.Color(127, 110, 186));
		revalidate();
		repaint();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(Clickable.containsKey(e.getSource())){
			System.out.println(e.getX());
			System.out.println(e.getY());
			Item m = Clickable.get(e.getSource()); 
			JLabel lblNewLabel_1 = new JLabel("");
			ImageIcon icon2 = new ImageIcon(m.getImagePath());
			Image img2 = icon2.getImage();
			Image newimg2 = img2.getScaledInstance(120, 138, java.awt.Image.SCALE_SMOOTH);
			lblNewLabel_1.setIcon(new ImageIcon(newimg2));
			lblNewLabel_1.setBounds(59, 46, 120, 138);
			ourPanel.layeredPane.remove(ourPanel.lblNewLabel);
			ourPanel.layeredPane.add(lblNewLabel_1);
			ourPanel.layeredPane.add(ourPanel.lblNewLabel);
			lblNewLabel_1.addMouseListener(ourPanel);
			lblNewLabel_1.addMouseMotionListener(ourPanel);
			
			ourPanel.draggable.add(lblNewLabel_1);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}