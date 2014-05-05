package app.frontend;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.JTextArea;

import javax.swing.JLayeredPane;

import app.backend.interfaces.Item;
import app.backend.interfaces.Outfit;
import app.backend.interfaces.User;
import app.backend.user.AppOutfit;
import app.backend.user.OutfitDisplayer;

import javax.swing.JTextField;


public class OutfitMakerPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton saveButton;
	public JLayeredPane layeredPane;
	public JLabel lblNewLabel;
	private JLabel savedLabel = null;
	//this is the hamper
	private JLabel hamper;
	private Outfit outfitExisting;
	private User u;
	private MainFrame p;
	
	//hashmap of JLabel to item
	private HashMap<JLabel, Item> itemStorage = new HashMap<JLabel, Item>();
	
	
	
	public ArrayList<JLabel> draggable = new ArrayList<JLabel>();

	/**
	 * Create the panel.
	 */
	public OutfitMakerPanel(MainFrame parent, User user) {
		setBackground(Color.WHITE);
		setSize(467,460);
		ImageIcon icon = new ImageIcon(("images/person.gif"));
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(170, 372, java.awt.Image.SCALE_SMOOTH);
		setLayout(null);
		this.outfitExisting = null;
		if(parent.selectedOutfit != null){
			this.outfitExisting = parent.selectedOutfit;
		}
		this.u = user;
		this.p = parent;
		
		saveButton = new JButton("save");
		saveButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		saveButton.setBackground(UIManager.getColor("TabbedPane.selectHighlight"));
		saveButton.setBounds(5, 10, 60, 25);
		saveButton.addActionListener(this);
		add(saveButton);
		
		
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(148, 12, 241, 400);
		layeredPane.setBackground(Color.WHITE);
		layeredPane.setOpaque(true);
		add(layeredPane);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 28, 170, 372);
		layeredPane.add(lblNewLabel);
		
		
		
		lblNewLabel.setIcon(new ImageIcon(newimg));
		
		textField = new JTextField();
		textField.setBounds(176, 415, 114, 25);
		add(textField);
		textField.setColumns(10);
		
		//make the hamper and add it to the layered pane/
		hamper = new JLabel("");
		hamper.setBounds(173, 345, 70, 70);
		ImageIcon Hampericon = new ImageIcon(("images/hamper.png"));
		Image imghamper = Hampericon.getImage();
		Image newimgHamper = imghamper.getScaledInstance(70,40, java.awt.Image.SCALE_SMOOTH);
		hamper.setIcon(new ImageIcon(newimgHamper));
		layeredPane.add(hamper);
		//done making the hamper
	}
	
	public void removeUnder(){
		
	}
	
	public void addItem(JLabel x, Item m){
		this.itemStorage.put(x, m);
	}
	
	public void removeItem(JLabel x){
		this.itemStorage.remove(x);
	}
	
	
	public BufferedImage createImage(JLayeredPane panel) {

	    int w = panel.getWidth();
	    int h = panel.getHeight();
	    BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	    Graphics2D g = bi.createGraphics();
	    panel.paint(g);
	    return bi;
	}
	
	private void msgbox(String s){
		   JOptionPane.showMessageDialog(null, s);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		System.out.println(src.getClass());
		if(src == saveButton){
			if(textField.getText().equals("")){
				msgbox("You must enter an outfit name!");
			}
			else{

			if(savedLabel != null){
				layeredPane.remove(savedLabel);
			}
			System.out.println("getting to save");
			Image x = createImage(layeredPane).getScaledInstance(this.getHeight()/6, this.getWidth()/4, java.awt.Image.SCALE_SMOOTH);
			JLabel m = new JLabel("");
			ImageIcon icon3 = new ImageIcon(x);
			m.setIcon(icon3);
			m.setBounds(180, 25, icon3.getIconWidth(), icon3.getIconHeight());
			layeredPane.add(m);
			savedLabel = m;
			
			OutfitDisplayer toSend = new OutfitDisplayer(this.itemStorage, x);
			Collection<Item> itemstoSend = itemStorage.values();
			if(outfitExisting != null){
				outfitExisting.setName(textField.getText());
				outfitExisting.setItems(itemstoSend);
				outfitExisting.setDisplayInfo(toSend);
			}
			else{
			AppOutfit toSave = new AppOutfit(textField.getText(), null, itemstoSend, toSend);
			u.saveOutfit(toSave);
			}

			}
			
		}
		
	}
	
	
//	public static void main(String[] args) {
//		JFrame window = new JFrame();
//		OutfitMakerPanel test = new OutfitMakerPanel();
//	    window.setSize(600, 600);
//		window.setLayout(new BorderLayout());
//		window.add(test, BorderLayout.CENTER);
//		window.setVisible(true);
//	}


	public void makeDeletable(){
		final JButton deleteButton = new JButton("Exit");
		deleteButton.setBorder(new LineBorder(new Color(255, 255, 255)));
		deleteButton.setBackground(Color.white);
		deleteButton.setOpaque(true);
		deleteButton.setForeground(Color.black);
		deleteButton.setBounds(380, 0, 60, 16);
		deleteButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				System.out.println("this is happening");
				setVisible(false);
				remove(deleteButton);
				clear();
				p.twoOpen = false;
				revalidate();
				repaint();
				p.pack();
				
			}

		});
		
		add(deleteButton);
		p.twoOpen = true;
		revalidate();
		repaint();


	}
	
	public void clear(){
		for(JLabel x: this.itemStorage.keySet()){
			layeredPane.remove(x);
			removeItem(x);
			revalidate();
			repaint();
			
		}
	}
	
	public void fill(HashMap<JLabel, Item> toFill){
		this.itemStorage = toFill;
		for(JLabel x: toFill.keySet()){
			layeredPane.add(x);
		}
	}

	private boolean drag = false;
	private int mouseX;
	private int mouseY;
	private JLabel toMove = null;
	private JTextField textField;

	@Override
	public void mouseDragged(MouseEvent e) {
		if(drag = true){
			 mouseX = e.getX();
		     mouseY = e.getY();
		     //toMove.setBounds(mouseX, mouseY, toMove.getWidth(), toMove.getHeight());
		     toMove.setLocation(toMove.getX()/4+mouseX, toMove.getY()/4+mouseY);
		     
		}
		
	}






	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void mousePressed(MouseEvent e) {
		if(draggable.contains(e.getSource())){
			drag = true;
			toMove = (JLabel) e.getSource();
			layeredPane.remove(toMove);
			layeredPane.add(toMove, 1);
		}
		
	}






	@Override
	public void mouseReleased(MouseEvent e) {
		drag = false;
		/*
		 * checks if the bounds of the moved item intersect with the hamper, if they do, then we trash the item
		 */
		Rectangle itemBounds = toMove.getBounds();
		Rectangle hamperBounds = hamper.getBounds();
		System.out.println();
		if(itemBounds.intersects(hamperBounds)){
			System.out.println("gettingHere");
			layeredPane.remove(toMove);
			removeItem(toMove);
			repaint();
		}
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
