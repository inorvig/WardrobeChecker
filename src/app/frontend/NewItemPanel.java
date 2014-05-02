package app.frontend;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import app.backend.interfaces.User;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class NewItemPanel extends JPanel {
	private JTextField txtCategory;
	private JTextField txtColor;
	private JTextField txtName;

	public NewItemPanel(final User user) {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("New Item");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("106px"),
				ColumnSpec.decode("114px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("119px"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("24px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.WHITE);
		lblName.setBackground(Color.BLACK);
		lblName.setOpaque(true);
		panel.add(lblName, "1, 2, fill, default");
		
		String[] wardrobeNames = {"Home Closet","Spring Break"};
		String[] categoryNames = {"T-Shirts","Pants","Dresses"};
		
		txtName = new JTextField();
		txtName.setText("Name");
		panel.add(txtName, "2, 2, fill, default");
		txtName.setColumns(10);
		
		JLabel lblWardrobe = new JLabel("Wardrobe");
		lblWardrobe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWardrobe.setBackground(Color.BLACK);
		lblWardrobe.setForeground(Color.WHITE);
		lblWardrobe.setOpaque(true);
		panel.add(lblWardrobe, "1, 4, fill, default");
		final JComboBox wardrobeComboBox = new JComboBox(wardrobeNames);
		panel.add(wardrobeComboBox, "2, 4, left, top");
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategory.setBackground(Color.BLACK);
		lblCategory.setForeground(Color.WHITE);
		lblCategory.setOpaque(true);
		panel.add(lblCategory, "1, 6, fill, default");
		
		txtCategory.setColumns(10);
		final JComboBox categoryComboBox = new JComboBox(categoryNames);
		panel.add(categoryComboBox, "2, 6, left, top");
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setHorizontalAlignment(SwingConstants.CENTER);
		lblColor.setBackground(Color.BLACK);
		lblColor.setForeground(Color.WHITE);
		lblColor.setOpaque(true);
		panel.add(lblColor, "1, 8, fill, default");
		
		txtColor = new JTextField();
		txtColor.setText("Color");
		panel.add(txtColor, "2, 8, fill, default");
		txtColor.setColumns(10);
		
		JButton btnCreateItem = new JButton("Create Item");
		btnCreateItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name, wardrobe, category, color;
				ArrayList<String> tags;
				name = txtName.getText();
				wardrobe = wardrobeComboBox.getSelectedItem().toString();
				category = categoryComboBox.getSelectedItem().toString();
				color = txtColor.getText();
				//user.addItem(name, wardrobe, category, color, tags);
			}
		});
		panel.add(btnCreateItem, "2, 20");
		// TODO Auto-generated constructor stub
	}

}
