package app.frontend;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextArea;
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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;

public class NewItemPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7431096162115865092L;
	private JTextField txtCategory, txtColor, txtName;
	private JTextArea txtTags;
	private String imagePath;
	private User user;

	public NewItemPanel(final MainFrame parent, final User user) {
		System.out.println(user+ " is the user");
		this.user = user;
		setLayout(new BorderLayout(0, 0));

		imagePath = "images/question.gif";
		
		JLabel lblNewLabel = new JLabel("New Item");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("120px:grow"),
				ColumnSpec.decode("120px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("200px"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("24px:grow"),
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));

		String[] wardrobeNames = user.getWardrobeList().toArray(new String[user.getCategoryList().size()]);
		String[] categoryNames = user.getCategoryList().toArray(new String[user.getCategoryList().size()]);
			//String[] wardrobeNames = new String[]{"hello"};
				
						JLabel lblName = new JLabel("Name");
						lblName.setHorizontalAlignment(SwingConstants.CENTER);
						lblName.setForeground(Color.WHITE);
						lblName.setBackground(Color.BLACK);
						lblName.setOpaque(true);
						panel.add(lblName, "2, 2, fill, default");
		
				txtName = new JTextField();
				txtName.setText("Name");
				panel.add(txtName, "4, 2, fill, default");
				txtName.setColumns(10);
		
				JLabel lblWardrobe = new JLabel("Wardrobe");
				lblWardrobe.setHorizontalAlignment(SwingConstants.CENTER);
				lblWardrobe.setBackground(Color.BLACK);
				lblWardrobe.setForeground(Color.WHITE);
				lblWardrobe.setOpaque(true);
				panel.add(lblWardrobe, "2, 4, fill, default");
		final JComboBox wardrobeComboBox = new JComboBox(wardrobeNames);
		panel.add(wardrobeComboBox, "4, 4, left, top");

		
				JLabel lblCategory = new JLabel("Category");
				lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
				lblCategory.setBackground(Color.BLACK);
				lblCategory.setForeground(Color.WHITE);
				lblCategory.setOpaque(true);
				panel.add(lblCategory, "2, 6, fill, default");
		final JComboBox categoryComboBox = new JComboBox(categoryNames);
		panel.add(categoryComboBox, "4, 6, left, top");
				
						JLabel lblColor = new JLabel("Color");
						lblColor.setHorizontalAlignment(SwingConstants.CENTER);
						lblColor.setBackground(Color.BLACK);
						lblColor.setForeground(Color.WHITE);
						lblColor.setOpaque(true);
						panel.add(lblColor, "2, 8, fill, default");
		
				txtColor = new JTextField();
				txtColor.setText("Color");
				panel.add(txtColor, "4, 8, fill, default");
				txtColor.setColumns(10);
		
		JButton btnCreateItem = new JButton("Create Item");
		btnCreateItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name, wardrobe, category, color;
				ArrayList<String> tags;
				name = txtName.getText();
				wardrobe = wardrobeComboBox.getSelectedItem().toString();
				category = categoryComboBox.getSelectedItem().toString();
				color = txtColor.getText();
				String tagString = txtTags.getText().replaceAll("\\s",",");
				tags = new ArrayList<String>(Arrays.asList(tagString.split(",+")));
				System.out.format("Sending item: %s, %s, %s, %s, %s\n",name,wardrobe,category,color,imagePath);
				System.out.println("tags: ");
				for (String tag : tags){
					System.out.println(tag);
				}
				System.out.println("user: "+user);
				user.addItem(name, wardrobe, category, color, imagePath,tags);
				parent.updateItems();
				parent.returnToHome();
			}
		});
		
		AddPhotoPanel addPhotoPanel = new AddPhotoPanel(this);
		panel.add(addPhotoPanel, "1, 2, fill, fill");
		
		JLabel lblTags = new JLabel("Tags");
		lblTags.setOpaque(true);
		lblTags.setHorizontalAlignment(SwingConstants.CENTER);
		lblTags.setForeground(Color.WHITE);
		lblTags.setBackground(Color.BLACK);
		panel.add(lblTags, "2, 10");
		
		JLabel lblCommaseparated = new JLabel("Comma-separated");
		lblCommaseparated.setFont(new Font("Dialog", Font.ITALIC, 12));
		lblCommaseparated.setOpaque(true);
		lblCommaseparated.setHorizontalAlignment(SwingConstants.LEFT);
		lblCommaseparated.setForeground(Color.BLACK);
		lblCommaseparated.setBackground(new Color(255, 255, 255));
		panel.add(lblCommaseparated, "4, 10");
		
		txtTags = new JTextArea(5,30);
		
		
		panel.add(txtTags, "2, 12, 3, 1, fill, default");
		panel.add(btnCreateItem, "2, 20");
	}
	
	public void setImagePath(String path){
		this.imagePath = path;
	}

	public void clear() {

		txtColor.setText("");
		txtName.setText("");
		txtTags.setText("");
		imagePath = "../wardrobe/images/question.gif";
	}

	public void addTags(String string) {
		System.out.println("generating tags for"+ string);
		Collection<String> tags = user.suggestTags(string);
		String toAdd = "";
		for (String tag: tags){
			toAdd+=(tag+", ");
		}
		txtTags.setText(toAdd);
	}

}
