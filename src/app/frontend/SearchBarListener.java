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
	SearchPanels results;
	
	public SearchBarListener(JTextField searchBar, User user, SearchPanels results){
		this.searchBar = searchBar;
		this.user = user;
		this.results = results;
		
	}
	@Override
	public void insertUpdate(DocumentEvent e) {
		ArrayList<Item> results = user.search(searchBar.getText());
		System.out.println("dfdfwer");
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
