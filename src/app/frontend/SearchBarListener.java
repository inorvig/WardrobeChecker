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
	
	ItemDisplayTester test = new ItemDisplayTester();
	ArrayList<Item> tempResults = new ArrayList<Item>(test.getItems());
			
	
	
	public SearchBarListener(JTextField searchBar, User user, MainFrame frame){
		this.searchBar = searchBar;
		searchBar.getDocument().addDocumentListener(this);
		this.user = user;
		this.frame = frame;
		
	}
	@Override
	public void insertUpdate(DocumentEvent e) {
		ArrayList<Item> results = user.search(searchBar.getText());

		
		if (results.size() > 6){
			frame.getResultsPanel().refresh(results.subList(0, 5));
		}
		else{
		frame.getResultsPanel().refresh(results);
		}
		frame.revalidate();
		frame.repaint();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		ArrayList<Item> results = user.search(searchBar.getText());
		//frame.setResultsPanel(new SearchPanels(results, frame));
		//frame.getResultsPanel().reset(results);
		if (results.size() > 6){
			frame.getResultsPanel().refresh(results.subList(0, 5));
		}
		else{
		frame.getResultsPanel().refresh(results);
		}
		frame.revalidate();
		frame.repaint();	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		ArrayList<Item> results = user.search(searchBar.getText());
		//frame.setResultsPanel(new SearchPanels(results, frame));
		//frame.getResultsPanel().reset(results);
		if (results.size() > 6){
			frame.getResultsPanel().refresh(results.subList(0, 5));
		}
		else{
		frame.getResultsPanel().refresh(results);
		}
		frame.revalidate();
		frame.repaint();	}

}
