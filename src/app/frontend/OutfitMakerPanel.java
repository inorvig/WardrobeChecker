package app.frontend;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTextArea;

import javax.swing.JLayeredPane;

import app.backend.interfaces.User;


public class OutfitMakerPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton testButton;
	private JButton saveButton;
	private JLayeredPane layeredPane;
	private JLabel lblNewLabel;
	private JLabel savedLabel = null;
	private SearchPanels panel;
	
	private ArrayList<JLabel> draggable = new ArrayList<JLabel>();

	/**
	 * Create the panel.
	 */
	public OutfitMakerPanel(MainFrame parent, User user) {
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(35, 35, 170, 372);
		ImageIcon icon = new ImageIcon(("/gpfs/main/home/inorvig/course/cs032/wardrobe/images/person.gif"));
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(170, 372, java.awt.Image.SCALE_SMOOTH);
		setLayout(null);
		
		saveButton = new JButton("save");
		saveButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		saveButton.setBackground(UIManager.getColor("TabbedPane.selectHighlight"));
		saveButton.setBounds(5, 10, 60, 25);
		saveButton.addActionListener(this);
		add(saveButton);
		
		
		JTextArea txtrNameYourOutfit = new JTextArea();
		txtrNameYourOutfit.setText("Name your outfit...");
		txtrNameYourOutfit.setBounds(56, 460, 130, 20);
		add(txtrNameYourOutfit);
		
		testButton = new JButton("testButton");
		testButton.setBounds(124, 10, 117, 25);
		testButton.addActionListener(this);
		add(testButton);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 35, 241, 400);
		layeredPane.setBackground(Color.WHITE);
		layeredPane.setOpaque(true);
		add(layeredPane);
		
		
		
		lblNewLabel.setIcon(new ImageIcon(newimg));
		layeredPane.add(lblNewLabel);
		
		panel = new SearchPanels();
		panel.setBounds(253, 12, 183, 396);
		add(panel);
		
	}
	
	
	
	public BufferedImage createImage(JLayeredPane panel) {

	    int w = panel.getWidth();
	    int h = panel.getHeight();
	    BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	    Graphics2D g = bi.createGraphics();
	    panel.paint(g);
	    return bi;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		System.out.println(src.getClass());
		if(src == testButton){
			
			//panel.createPanel("shirt1", "/outfitImages/shit1.gif");
			System.out.println("testButton pressed");
			JLabel lblNewLabel_1 = new JLabel("");
			ImageIcon icon2 = new ImageIcon(OutfitMakerPanel.class.getResource("/outfitImages/shit1.gif"));
			Image img2 = icon2.getImage();
			Image newimg2 = img2.getScaledInstance(120, 138, java.awt.Image.SCALE_SMOOTH);
			lblNewLabel_1.setIcon(new ImageIcon(newimg2));
			lblNewLabel_1.setBounds(59, 46, 120, 138);
			layeredPane.remove(lblNewLabel);
			layeredPane.add(lblNewLabel_1);
			layeredPane.add(lblNewLabel);
			lblNewLabel_1.addMouseListener(this);
			lblNewLabel_1.addMouseMotionListener(this);
			
			draggable.add(lblNewLabel_1);
			
			
		}
		if(src == saveButton){
			if(savedLabel != null){
				layeredPane.remove(savedLabel);
			}
			System.out.println("getting to save");
			Image x = createImage(layeredPane).getScaledInstance(this.getHeight()/6, this.getWidth()/6, java.awt.Image.SCALE_SMOOTH);
			JLabel m = new JLabel("");
			ImageIcon icon3 = new ImageIcon(x);
			m.setIcon(icon3);
			m.setBounds(4, 4, icon3.getIconWidth(), icon3.getIconHeight());
			layeredPane.add(m);
			savedLabel = m;
			
			
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




	private boolean drag = false;
	private int mouseX;
	private int mouseY;
	private JLabel toMove = null;

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
		}
		
	}






	@Override
	public void mouseReleased(MouseEvent e) {
		drag = false;
		
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
