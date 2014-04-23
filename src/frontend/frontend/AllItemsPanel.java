package frontend;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class AllItemsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AllItemsPanel() {
		
		JLabel lblItem = new JLabel("Item 1");
		add(lblItem);
		
		JLabel lblItem_1 = new JLabel("Item 2");
		add(lblItem_1);
		
		JLabel lblItem_2 = new JLabel("Item 3");
		add(lblItem_2);

	}

}
