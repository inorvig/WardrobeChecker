package app.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.backend.interfaces.Item;

public class SearchPanels extends JPanel implements MouseListener, MouseMotionListener {

	/**
	 * Create the panel.
	 */	
	public HashMap<JPanel, Item> Clickable;
	public OutfitMakerPanel ourPanel; 
	private GridBagConstraints c;

	public JPanel createPanel(Item x) {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(java.awt.Color.WHITE);
        p.add(new JLabel(x.getName()+ "   ", JLabel.CENTER), BorderLayout.CENTER);
        ImageIcon icon2 = new ImageIcon(x.getImagePath());
		Image img2 = icon2.getImage();
		Image newimg2 = img2.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(newimg2);
        p.add(new JLabel(icon2, JLabel.LEFT), BorderLayout.WEST);
        p.addMouseListener(this);
        p.addMouseMotionListener(this);
        Clickable.put(p, x);
       // repaint();
        return p;
       
    }
	
	public void reset(ArrayList<Item> items){
		removeAll();
		for (Item i: items){
			createPanel(i);
		}
		revalidate();
		repaint();
	}
	
	
	public SearchPanels(List<Item> list, MainFrame parent) {
		setBackground(java.awt.Color.WHITE);
		Clickable = new HashMap<JPanel, Item>();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {120};
		setLayout(gridBagLayout);
		
		c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1;
		c.weighty = 1;
		int row = 0;
		
		for(Item x: list){
			c.gridy = row;
			this.add(createPanel(x),c);
			row++;
		}
		ourPanel = parent.OutfitMakerPanel;
		revalidate();
		repaint();

	}
	
	public void refresh(List<Item> list){
		this.removeAll();
		int row = 0;
		for(Item x: list){
			c.gridy = row;
			this.add(createPanel(x),c);
			row++;
		}
		revalidate();
		repaint();
	}
	
	private boolean toDrag = false;
	private int mouseX;
	private int mouseY;
	private JPanel draggedItem = null;

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(Clickable.containsKey(e.getSource())){
			Item m = Clickable.get(e.getSource());
			System.out.println("clicked!");
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(toDrag){
			System.out.println("released!");
		Item m = Clickable.get(draggedItem); 
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon icon2 = new ImageIcon(m.getImagePath());
		Image img2 = icon2.getImage();
		Image newimg2 = img2.getScaledInstance(120, 138, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel_1.setIcon(new ImageIcon(newimg2));
		lblNewLabel_1.setBounds(60, 60, 120, 138);
		ourPanel.layeredPane.remove(ourPanel.lblNewLabel);
		ourPanel.layeredPane.add(lblNewLabel_1, 1);
		ourPanel.layeredPane.add(ourPanel.lblNewLabel);
		lblNewLabel_1.addMouseListener(ourPanel);
		lblNewLabel_1.addMouseMotionListener(ourPanel);
		
		ourPanel.draggable.add(lblNewLabel_1);
		}
		toDrag = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(Clickable.containsKey(e.getSource())){
			
			draggedItem = (JPanel) e.getSource();
		}
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		toDrag = true;
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}