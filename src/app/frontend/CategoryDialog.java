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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CategoryDialog extends JDialog {

	private String name = null;
	private String style = null;
	private JTextField input;
	public CategoryDialog(Frame owner) {
		super(owner, true);
		
		JPanel btnPanel = new JPanel();  
	    JButton addBtn   = new JButton("Add");  
	    JButton cancelBtn   = new JButton("Cancel");  
	    
	    btnPanel.add(addBtn);  
	    addBtn.addActionListener(new ActionListener() {  
	         public void actionPerformed(java.awt.event.ActionEvent ae) {  
	            addButton();  
	         }  
	      });  
	    btnPanel.add(cancelBtn);
	    cancelBtn.addActionListener(new ActionListener(){
	    	public void actionPerformed(java.awt.event.ActionEvent ae){
	    		setVisible(false);
	    	}
	    });
	    
	    JLabel instructions = new JLabel("Category Name:");
	    input = new JTextField();
	    
	    getContentPane().add(instructions, BorderLayout.NORTH);
	    getContentPane().add(input, BorderLayout.CENTER);
	    getContentPane().add(btnPanel, BorderLayout.SOUTH);
	    
	    pack();
	    setVisible(true);
	}
	
	public void addButton(){
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
