/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.frontend;

import javax.swing.AbstractButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import app.backend.interfaces.Savable;
import app.backend.interfaces.User;
import app.backend.user.Saver;
import java.awt.Color;

/**
 * 
 * @author kbhatia
 */
public class MainFrame extends javax.swing.JFrame implements WindowListener {

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel LeftPanel;
	private javax.swing.JScrollPane ResultsPanel;
	private javax.swing.JPanel RightPanel;
	private javax.swing.ButtonGroup toggleGroup;
	private javax.swing.JToggleButton addNewItem;
	private javax.swing.JToggleButton favoriteOutfits;
	private javax.swing.JToggleButton helpButton;
	private javax.swing.JButton jButton1;
	private OutfitDesignPanel OutfitDesignPanel;
	private WardrobePanel WardrobePanel;
	private OutfitsPanel OutfitsPanel;
	private NewItemPanel newItemPanel;
	private ClosetPanel closetPanel;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JPanel logoPanel;
	private javax.swing.JToggleButton myWardrobes;
	private javax.swing.JButton newWindow;
	private javax.swing.JToggleButton searchWeb;
	private javax.swing.JPanel weatherAPI;
	private org.jdesktop.beansbinding.BindingGroup bindingGroup;
	private JTextField txtSearch;
	private Saver _savedUser;
	private final User _user;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form MainFrame
	 */
	public MainFrame() {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		_savedUser = new Saver("Gabe");
		_user = _savedUser.getUser();
		System.out.println("mainframe user: "+_user);
		initComponents();
		

		addWindowListener(this);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

		LeftPanel = new javax.swing.JPanel();
		LeftPanel.setBackground(Color.WHITE);
		newWindow = new javax.swing.JButton();
		newWindow.setIcon(new ImageIcon("../wardrobe/images/plus.gif"));
		toggleGroup = new javax.swing.ButtonGroup();
		myWardrobes = new javax.swing.JToggleButton();
		addNewItem = new javax.swing.JToggleButton();
		favoriteOutfits = new javax.swing.JToggleButton();
		toggleGroup.add(myWardrobes);
		toggleGroup.add(addNewItem);
		toggleGroup.add(favoriteOutfits);
		searchWeb = new javax.swing.JToggleButton();
		helpButton = new javax.swing.JToggleButton();
		helpButton.setFont(new Font("Dialog", Font.BOLD, 12));
		RightPanel = new javax.swing.JPanel();
		RightPanel.setBackground(Color.WHITE);
		weatherAPI = new javax.swing.JPanel();
		ResultsPanel = new javax.swing.JScrollPane();
		logoPanel = new javax.swing.JPanel();
		OutfitDesignPanel = new OutfitDesignPanel(this, _user);
		newItemPanel = new NewItemPanel(this, _user);
		WardrobePanel = new WardrobePanel(this,_user);
		OutfitsPanel = new OutfitsPanel(this, _user);
		closetPanel = new ClosetPanel(this, _user);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		newWindow.setBackground(new java.awt.Color(127, 110, 186));
		newWindow.setForeground(new java.awt.Color(255, 255, 255));
		ImageIcon icon = new ImageIcon("../wardrobe/images/newwindow.gif");
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(75, 75,
				java.awt.Image.SCALE_SMOOTH);
		newWindow.setIcon(new ImageIcon(newimg));
		// newWindow.setText("<html><center>New<br>Window</center></html>");
		newWindow.setVerticalTextPosition(AbstractButton.BOTTOM);
		newWindow.setHorizontalTextPosition(AbstractButton.CENTER);
		newWindow.setToolTipText("");
		newWindow.setAlignmentX(0.5F);
		newWindow.setAutoscrolls(true);
		newWindow.setHorizontalTextPosition(SwingConstants.RIGHT);

		myWardrobes.setBackground(new java.awt.Color(127, 110, 186));
		myWardrobes.setForeground(new java.awt.Color(254, 254, 254));
		myWardrobes.setText("My Wardrobes");
		myWardrobes.setOpaque(true);

		addNewItem.setBackground(new java.awt.Color(127, 110, 186));
		addNewItem.setForeground(new java.awt.Color(254, 254, 254));
		addNewItem.setText("Add New Item");

		org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings
				.createAutoBinding(
						org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE,
						addNewItem, org.jdesktop.beansbinding.ELProperty
								.create("${opaque}"), addNewItem,
						org.jdesktop.beansbinding.BeanProperty.create("opaque"));
		bindingGroup.addBinding(binding);

		addNewItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addNewItemActionPerformed(evt);
			}
		});

		favoriteOutfits.setBackground(new java.awt.Color(127, 110, 186));
		favoriteOutfits.setForeground(new java.awt.Color(255, 255, 255));
		favoriteOutfits.setText("Favorite Outfits");

		searchWeb.setBackground(new java.awt.Color(127, 110, 186));
		searchWeb.setForeground(new java.awt.Color(255, 255, 255));
		ImageIcon icon2 = new ImageIcon("../wardrobe/images/search-web.gif");
		Image img2 = icon2.getImage();
		Image newimg2 = img2.getScaledInstance(150, 75,
				java.awt.Image.SCALE_SMOOTH);
		searchWeb.setIcon(new ImageIcon(newimg2));
		searchWeb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

		helpButton.setBackground(new java.awt.Color(127, 110, 186));
		helpButton.setForeground(new java.awt.Color(255, 255, 255));
		ImageIcon icon3 = new ImageIcon("../wardrobe/images/help.gif");
		Image img3 = icon3.getImage();
		Image newimg3 = img3.getScaledInstance(75, 120,
				java.awt.Image.SCALE_SMOOTH);
		helpButton.setIcon(new ImageIcon(newimg3));
		// helpButton.setIcon(new ImageIcon("../wardrobe/images/question.gif"));
		// // NOI18N
		helpButton.setText("<html><center>Help</center></html>");

		javax.swing.GroupLayout LeftPanelLayout = new javax.swing.GroupLayout(
				LeftPanel);
		LeftPanelLayout.setHorizontalGroup(
			LeftPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(LeftPanelLayout.createSequentialGroup()
					.addGroup(LeftPanelLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(LeftPanelLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(helpButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(newWindow, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
						.addGroup(LeftPanelLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(myWardrobes, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(addNewItem, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(favoriteOutfits, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(searchWeb, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 164, Short.MAX_VALUE)))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		LeftPanelLayout.setVerticalGroup(
			LeftPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(LeftPanelLayout.createSequentialGroup()
					.addComponent(myWardrobes, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(addNewItem, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(favoriteOutfits, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(searchWeb, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(LeftPanelLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(helpButton, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
						.addComponent(newWindow, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
					.addContainerGap())
		);
		LeftPanel.setLayout(LeftPanelLayout);

		javax.swing.GroupLayout weatherAPILayout = new javax.swing.GroupLayout(
				weatherAPI);
		weatherAPI.setLayout(weatherAPILayout);
		weatherAPILayout.setHorizontalGroup(weatherAPILayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE));
		weatherAPILayout.setVerticalGroup(weatherAPILayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 56,
				Short.MAX_VALUE));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("../wardrobe/images/logo.gif"));

		javax.swing.GroupLayout logoPanelLayout = new javax.swing.GroupLayout(
				logoPanel);
		logoPanelLayout.setHorizontalGroup(logoPanelLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				logoPanelLayout.createSequentialGroup()
						.addComponent(lblNewLabel)
						.addContainerGap(54, Short.MAX_VALUE)));
		logoPanelLayout.setVerticalGroup(logoPanelLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				logoPanelLayout.createSequentialGroup()
						.addComponent(lblNewLabel)
						.addContainerGap(97, Short.MAX_VALUE)));
		logoPanel.setLayout(logoPanelLayout);

		txtSearch = new JTextField();
		txtSearch.setText("Search");
		txtSearch.setColumns(10);

		javax.swing.GroupLayout RightPanelLayout = new javax.swing.GroupLayout(
				RightPanel);
		RightPanelLayout.setHorizontalGroup(RightPanelLayout
				.createParallelGroup(Alignment.LEADING)
				.addComponent(weatherAPI, GroupLayout.DEFAULT_SIZE, 188,
						Short.MAX_VALUE)
				.addComponent(ResultsPanel, GroupLayout.DEFAULT_SIZE, 188,
						Short.MAX_VALUE)
				.addGroup(
						RightPanelLayout
								.createSequentialGroup()
								.addComponent(logoPanel,
										GroupLayout.PREFERRED_SIZE, 176,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
				.addGroup(
						RightPanelLayout
								.createSequentialGroup()
								.addComponent(txtSearch,
										GroupLayout.DEFAULT_SIZE, 176,
										Short.MAX_VALUE).addContainerGap()));
		RightPanelLayout.setVerticalGroup(RightPanelLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				RightPanelLayout
						.createSequentialGroup()
						.addComponent(weatherAPI, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(ResultsPanel, GroupLayout.PREFERRED_SIZE,
								116, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(logoPanel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)));
		RightPanel.setLayout(RightPanelLayout);

		final javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(LeftPanel, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(OutfitDesignPanel, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(WardrobePanel, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(newItemPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(OutfitsPanel, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(closetPanel, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(RightPanel, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
					
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(RightPanel, GroupLayout.PREFERRED_SIZE, 460, Short.MAX_VALUE))
				.addComponent(LeftPanel, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
					.addComponent(newItemPanel, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(layout.createSequentialGroup()
					.addComponent(OutfitDesignPanel, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(layout.createSequentialGroup()
					.addComponent(WardrobePanel, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(layout.createSequentialGroup()
					.addComponent(OutfitsPanel, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(layout.createSequentialGroup()
					.addComponent(closetPanel, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
					.addContainerGap())
		);
		WardrobePanel.setVisible(false);
		newItemPanel.setVisible(false);
		OutfitsPanel.setVisible(false);
		closetPanel.setVisible(false);
		getContentPane().setLayout(layout);

		myWardrobes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (myWardrobes.isSelected()) {
					OutfitDesignPanel.setVisible(false);
					newItemPanel.setVisible(false);
					OutfitsPanel.setVisible(false);
					WardrobePanel.setVisible(true);
					pack();
					System.out.println("wardrobes selected");
				} else {
					WardrobePanel.setVisible(false);
					OutfitDesignPanel.setVisible(true);
					pack();
					System.out.println("wardrobes deselected");
				}
			}
		});

		addNewItem.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (addNewItem.isSelected()) {
					OutfitDesignPanel.setVisible(false);
					WardrobePanel.setVisible(false);
					OutfitsPanel.setVisible(false);
					closetPanel.setVisible(false);
					newItemPanel.setVisible(true);
					pack();
					System.out.println("addNewItem selected");
				} else {
					newItemPanel.setVisible(false);
					OutfitDesignPanel.setVisible(true);
					pack();
					System.out.println("addNewItem deselected");
				}
			}
		});

		favoriteOutfits.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (favoriteOutfits.isSelected()) {
					OutfitDesignPanel.setVisible(false);
					WardrobePanel.setVisible(false);
					newItemPanel.setVisible(false);
					closetPanel.setVisible(false);
					OutfitsPanel.setVisible(true);
					pack();
					System.out.println("addNewItem selected");
				} else {
					OutfitsPanel.setVisible(false);
					OutfitDesignPanel.setVisible(true);
					pack();
					System.out.println("addNewItem deselected");
				}
			}
		});

		bindingGroup.bind();

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void addNewItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addNewItemActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_addNewItemActionPerformed

	/**
	 * @param args
	 *            the command line arguments
	 */
	
	public void addItem(){
		OutfitDesignPanel.setVisible(false);
		WardrobePanel.setVisible(false);
		OutfitsPanel.setVisible(false);
		closetPanel.setVisible(false);
		newItemPanel.setVisible(true);
		pack();
	}
	
	public void updateItems(){
		closetPanel.reset();
		pack();
	}
	public void returnToHome(){
		OutfitDesignPanel.setVisible(true);
		WardrobePanel.setVisible(false);
		OutfitsPanel.setVisible(false);
		newItemPanel.setVisible(false);
		closetPanel.setVisible(false);
		pack();
	}
	
	public void openWardrobe(String name){
		closetPanel.setName(name);
		WardrobePanel.setVisible(false);
		OutfitsPanel.setVisible(false);
		newItemPanel.setVisible(false);
		OutfitDesignPanel.setVisible(false);
		closetPanel.setVisible(true);
		pack();
	}
	public static void main(String args[]) {

		System.out.println("We found the main");
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				final MainFrame frame = new MainFrame();
				frame.setVisible(true);
				frame.addComponentListener(new ComponentAdapter() {

					@Override
					public void componentResized(ComponentEvent e) {
						frame.setSize(new Dimension(frame.getWidth(), 500));
						super.componentResized(e);
					}

				});
			}
		});
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		_savedUser.saveData();
		System.out.println("closed");

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
}
