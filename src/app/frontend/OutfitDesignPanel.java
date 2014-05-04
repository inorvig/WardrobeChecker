package app.frontend;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.backend.interfaces.User;

import java.awt.Color;

public class OutfitDesignPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1803901267296321638L;

	/**
	 * Create the panel.
	 */
	public OutfitDesignPanel(MainFrame parent, User user) {
		setBackground(Color.WHITE);

		JButton jButton1 = new javax.swing.JButton();
		JTextField jTextField1 = new javax.swing.JTextField();

		jButton1.setBackground(new java.awt.Color(254, 254, 254));
		jButton1.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
		jButton1.setText(" save outfit ");
		jButton1.setBorder(new javax.swing.border.LineBorder(
				new java.awt.Color(0, 0, 0), 1, true));
		jButton1.setMargin(new java.awt.Insets(1, 2, 1, 2));

		jTextField1.setBackground(new java.awt.Color(255, 255, 255));
		jTextField1.setText("jTextField1");
		jTextField1.setBorder(new javax.swing.border.LineBorder(
				new java.awt.Color(0, 0, 0), 1, true));

		javax.swing.GroupLayout gl_OutfitPanel = new javax.swing.GroupLayout(
				this);
		setLayout(gl_OutfitPanel);
		gl_OutfitPanel.setHorizontalGroup(gl_OutfitPanel
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						gl_OutfitPanel
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(jButton1)
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						gl_OutfitPanel
								.createSequentialGroup()
								.addContainerGap(69, Short.MAX_VALUE)
								.addComponent(jTextField1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										113,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(59, 59, 59)));
		gl_OutfitPanel
				.setVerticalGroup(gl_OutfitPanel
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								gl_OutfitPanel
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jButton1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												21,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(
												jTextField1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												19,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
	}

}
