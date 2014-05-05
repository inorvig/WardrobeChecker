package app.frontend;

import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import app.backend.interfaces.Item;
import app.backend.interfaces.User;

public class SearchBarListener implements DocumentListener {

	JTextField searchBar;
	User user;
	MainFrame frame;
	
	public SearchBarListener(JTextField searchBar, User user, MainFrame frame){
		this.searchBar = searchBar;
		this.user = user;
		this.frame = frame;
		
	}
	@Override
	public void insertUpdate(DocumentEvent e) {
		ArrayList<Item> results = user.search(searchBar.getText());
		System.out.println("dfdfwer");
		frame.setResultsPanel(new SearchPanels(results, frame.getOutfitsPanel()));
		frame.revalidate();
		frame.repaint();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		ArrayList<Item> results = user.search(searchBar.getText());
		System.out.println("dfdfwer");


	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		ArrayList<Item> results = user.search(searchBar.getText());
		System.out.println("dfdfwer");


	}

}
