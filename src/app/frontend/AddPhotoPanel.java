package app.frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.*;


public class AddPhotoPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9073375689800475191L;
	private JButton btnAddPhoto;
	private JFileChooser fc;
	private NewItemPanel parent;
	private JPanel photoPanel;
	
	public AddPhotoPanel(NewItemPanel parent) {
		this.parent = parent;
		setLayout(new BorderLayout());
		btnAddPhoto = new JButton("Add Photo");
		
		fc = new JFileChooser();
		FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
		fc.setFileFilter(imageFilter);
		
		btnAddPhoto.addActionListener(this);
		
		photoPanel = new JPanel();
		photoPanel.setPreferredSize(new Dimension(120,120));
		setPreferredSize(new Dimension(120,140));
		add(photoPanel, BorderLayout.CENTER);
		add(btnAddPhoto, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAddPhoto){
			int returnVal = fc.showOpenDialog(this);
			 
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File imageFile = fc.getSelectedFile();
                String path = imageFile.getAbsolutePath();
                parent.setImagePath(path);
                ImageIcon icon = new ImageIcon(path);
                Image img = icon.getImage();
        		Image newimg = img.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon(newimg));
                photoPanel.removeAll();
                photoPanel.add(label);
                this.revalidate();
                this.repaint();

            }
		}
		
	}

}
