/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.backend.autosuggest;

import java.io.Serializable;

/**
 * 
 * @author sohumchatterjee
 */
public class Trie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3169287185553983624L;
	private Node root;

	/**
	 * constructor method for Trie
	 */
	public Trie() {
		root = new Node(null, '\0', false); // root is set to null with the null
											// character by default
	}

	/**
	 * 
	 * @return root of the Trie
	 */
	public Node getRoot() {
		return root;
	}

	/**
	 * insert method for Trie
	 * 
	 * @param word
	 *            : word to be inserted.
	 */
	public void insert(String word) {
		char[] letterArray = word.toCharArray(); // iterate through letters in
													// word
		Node currNode = root;
		int wordLength = letterArray.length;
		for (int i = 0; i < wordLength; i++) {
			char letter = letterArray[i];
			if (currNode.isChild(letter)) { // if letter is a child of currNode
				currNode = currNode.getChild(letter); // set that node as
														// currNode
				if (i == wordLength - 1)
					currNode.wordEnd(); // if letter is end of a word, change
										// that node's boolean flag
			} else { // if letter is not a child of currNode
				if (i == wordLength - 1) {
					currNode.addChild(letter, new Node(currNode, letter, true)); // create
																					// appropriate
																					// node
																					// with
																					// flag
				} else {
					currNode.addChild(letter, new Node(currNode, letter, false)); // checking
																					// to
																					// see
																					// if
																					// letter
																					// is
																					// also
																					// end
																					// of
																					// word
				}
				currNode = currNode.getChild(letter); // update currNode
			}
		}
	}

}
