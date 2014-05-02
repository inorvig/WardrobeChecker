/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.backend.autosuggest;

import java.util.*;

/**
 * 
 * @author sohumchatterjee
 */
public class Prefix implements Feature {

	private Trie trie;
	public boolean prefixOn; // boolean to mark if prefix search has been turned
								// on by user

	/**
	 * constructor method
	 * 
	 * @param trie
	 *            : trie to be used for prefix matching is passed in from main
	 *            class for better design
	 */
	public Prefix(Trie trie) {
		this.trie = trie;
		this.prefixOn = false;
	}

	/**
	 * method to turn on prefix matching
	 */
	public void turnOnFeature() {
		prefixOn = true;
	}

	/**
	 * method to build set of results using prefix matching
	 */
	public void resultSet(TreeSet<String> results, String word) { // returns the
																	// inputted
																	// hashset
																	// of all
																	// results
																	// found
																	// with
																	// given
																	// prefix in
																	// trie
		if (prefixOn) {
			Node currNode = trie.getRoot();
			char[] charArray = word.toCharArray();
			int wordLength = charArray.length;
			boolean inTrie = true; // boolean that shows if current collection
									// of letters is in the trie
			for (int i = 0; i < wordLength; i++) { // iterate through letters in
													// word
				char letter = charArray[i];
				if (currNode.isChild(letter)) // if letter is a child of
												// currNode
					currNode = currNode.getChild(letter); // get that child node
				else {
					inTrie = false;
					break;
				}
			}
			if (inTrie) {
				getResults(currNode, results, word); // helper method that
														// builds set of
														// suggestions
			}
		} else {
			// do nothing
		}
	}

	/**
	 * recursive helper method for resultSet
	 * 
	 * @param node
	 *            : node to be visited
	 * @param results
	 *            : set to be populated
	 * @param word
	 *            : the word being searched against
	 */
	public void getResults(Node node, TreeSet<String> results, String word) {
		if (node.isLastLetter())
			results.add(word); // if the node that is passed to helper method
								// marks the end of a word, include that word in
								// the results set
		Node currNode = node;
		String newWord = word;
		HashMap<Character, Node> children = node.getChildren();
		for (Character letter : children.keySet()) { // iterate using keys of
														// hashmap of children
			currNode = node.getChild(letter);
			newWord = word + letter.toString(); // append letter to end of word
												// and pass into method as new
												// word
			getResults(currNode, results, newWord); // recursively build all
													// word combinations with
													// given prefix in the trie
		}
	}

}
