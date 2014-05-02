/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.backend.autosuggest;

import java.util.*;

/**
 * implements interface feature
 * 
 * @author sohumchatterjee
 */
public class Whitespace implements Feature {

	private HashMap<String, Integer> wordMap;
	public boolean whitespaceOn; // boolean to indicate whether this feature has
									// been turned on by user

	/**
	 * constructor method
	 * 
	 * @param unigramMap
	 *            : reusing the unigram hashmap keyset from main class to
	 *            iterate over all words in corpus
	 */
	public Whitespace(HashMap<String, Integer> unigramMap) {
		this.wordMap = unigramMap;
		this.whitespaceOn = false;
	}

	/**
	 * method to turn on whitespace insertion
	 */
	public void turnOnFeature() {
		whitespaceOn = true;
	}

	/**
	 * method to build set of results using whitespace insertion
	 */
	public void resultSet(TreeSet<String> results, String word) {
		if (whitespaceOn) {
			int wordLength = word.length();
			String word1, word2, returnWord;
			for (int i = 1; i < wordLength; i++) { // iterate through the entire
													// string and
				word1 = word.substring(0, i); // split word into all possible
												// pairs (except degenerate
												// cases)
				word2 = word.substring(i);
				if (wordMap.containsKey(word1) && wordMap.containsKey(word2)) { // if
																				// both
																				// words
																				// are
																				// legitimate
					returnWord = word1 + " " + word2; // add them separated by a
														// space as a suggested
														// results
					results.add(returnWord);
				}
			}
		} else {
			// do nothing
		}
	}
}