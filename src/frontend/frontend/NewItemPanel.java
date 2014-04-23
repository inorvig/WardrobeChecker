package frontend;

import java.awt.LayoutManager;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

public class NewItemPanel extends JPanel {
	private JTextField txtCategory;
	private JTextField txtColor;
	private JTextField txtName;

	public NewItemPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("New Item");
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblN = new JLabel("Name");
		panel.add(lblN, "1, 2, right, default");
		
		String[] wardrobeNames = {"Home Closet","Spring Break"};
		
		txtName = new JTextField();
		txtName.setText("Name");
		panel.add(txtName, "2, 2, fill, default");
		txtName.setColumns(10);
		
		JLabel lblWardrobe = new JLabel("Wardrobe");
		panel.add(lblWardrobe, "1, 4, right, default");
		JComboBox comboBox = new JComboBox(wardrobeNames);
		panel.add(comboBox, "2, 4, left, top");
		
		JLabel lblCategory = new JLabel("Category");
		panel.add(lblCategory, "1, 6, right, default");
		
		txtCategory = new JTextField();
		txtCategory.setText("Category");
		panel.add(txtCategory, "2, 6, fill, default");
		txtCategory.setColumns(10);
		
		JLabel lblColor = new JLabel("Color");
		panel.add(lblColor, "1, 8, right, default");
		
		txtColor = new JTextField();
		txtColor.setText("Color");
		panel.add(txtColor, "2, 8, fill, default");
		txtColor.setColumns(10);
		// TODO Auto-generated constructor stub
	}

}
