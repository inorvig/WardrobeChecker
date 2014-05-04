package app.frontend;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WardrobeDialog extends JDialog {

	private String name = null;
	private String style = null;
	private JTextField input;
	public WardrobeDialog(Frame owner) {
		super(owner, true);
		
		JPanel btnPanel = new JPanel();  
	    JButton closetBtn   = new JButton("Closet");  
	    JButton suitcaseBtn = new JButton("Suitcase");
	    JButton cancelBtn   = new JButton("Cancel");  
	    
	    btnPanel.add(closetBtn);  
	    closetBtn.addActionListener(new ActionListener() {  
	         public void actionPerformed(java.awt.event.ActionEvent ae) {  
	            closetButton();  
	         }  
	      });  
	    btnPanel.add(suitcaseBtn);
	    suitcaseBtn.addActionListener(new ActionListener() {  
	         public void actionPerformed(java.awt.event.ActionEvent ae) {  
	            suitcaseButton();  
	         }  
	      });  
	    btnPanel.add(cancelBtn);
	    cancelBtn.addActionListener(new ActionListener(){
	    	public void actionPerformed(java.awt.event.ActionEvent ae){
	    		setVisible(false);
	    	}
	    });
	    
	    JLabel instructions = new JLabel("Wardrobe Name:");
	    input = new JTextField();
	    
	    getContentPane().add(instructions, BorderLayout.NORTH);
	    getContentPane().add(input, BorderLayout.CENTER);
	    getContentPane().add(btnPanel, BorderLayout.SOUTH);
	    
	    pack();
	    setVisible(true);
	}
	
	public void closetButton(){
		style = "closet";
		name = input.getText();
		setVisible(false);
	}
	
	public void suitcaseButton(){
		style = "suitcase";
		name = input.getText();
		setVisible(false);
	}
	
	public String getName(){
		return name;
	}
	
	public String getStyle(){
		return style;
	}

}
