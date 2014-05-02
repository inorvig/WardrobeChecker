package app.backend.autosuggest;

import java.util.*;

import backend.auto.Feature.*;
import backend.auto.Gui.*;
import backend.auto.Ranking.*;

/**
 * 
 * @author sohumchatterjee
 */
public class ReadUserInput {
	private Prefix prefix;
	private LED led;
	private Whitespace whitespace;
	private HashMap<String, Integer> unigramMap, bigramMap;
	// private boolean smartOn;
	ArrayList<String> finalFive = new ArrayList<String>(); // the final five
															// results to be
															// returned sit in
															// this list
															// (space-saving?)

	/**
	 * constructor method
	 * 
	 * @param prefix
	 * @param led
	 * @param whitespace
	 * @param trie
	 * @param unigram
	 * @param bigram
	 * @param smartOn
	 *            : boolean indicating whether smart ranking has been asked for
	 *            by user
	 */
	public ReadUserInput(Prefix prefix, LED led, Whitespace whitespace,
			Trie trie, HashMap<String, Integer> unigram,
			HashMap<String, Integer> bigram) {
		this.prefix = prefix;
		this.led = led;
		this.whitespace = whitespace;
		this.unigramMap = unigram;
		this.bigramMap = bigram;
		// this.smartOn = smartOn;
	}

	/**
	 * method that returns the list of suggestion to be displayed by finding the
	 * best suggestions using relevant features
	 * 
	 * @param userTyped
	 *            : input string typed in by user
	 * @return: list of top 5 suggestions by autocorrect (in order)
	 */
	public ArrayList<String> getList(String userTyped) {
		String input = userTyped.replaceAll("[^0-9a-zA-Z ]", " ").toLowerCase();
		;
		StringTokenizer tokenizer = new StringTokenizer(input);
		ArrayList<String> inputWordList = new ArrayList<String>();

		while (tokenizer.hasMoreTokens())
			inputWordList.add(tokenizer.nextToken());

		int listSize = inputWordList.size();
		String lastWord = "";
		if (listSize == 0) {
			return finalFive;
		}
		lastWord = inputWordList.get(listSize - 1); // last word
		String penultimateWord = ""; // second last word
		String toPrepend = ""; // String that is needed to correctly print out
								// results for repl or gui
		if (listSize > 1) {
			penultimateWord = inputWordList.get(listSize - 2);
			for (int j = 0; j < listSize - 1; j++) {
				toPrepend = toPrepend + inputWordList.get(j) + " ";
			}
		}

		TreeSet<String> results; // tree set structure passed to all features to
									// insert results using comparator

		// use regular comparator is smart off
		RegComparator regCompare = new RegComparator(lastWord, penultimateWord,
				unigramMap, bigramMap);// lastWord, secondLastWord, wrfwrfe);
		results = new TreeSet<String>(regCompare);

		finalFive.clear(); // clear globe variable

		// default case / exact matching
		if (!prefix.prefixOn && !led.ledOn && !whitespace.whitespaceOn) {
			if (unigramMap.containsKey(lastWord))
				finalFive.add(toPrepend + lastWord);
			else
				finalFive.add(toPrepend);

			return finalFive;
		}

		// pass tree set to the feature classes to add relevant results to the
		// set
		prefix.resultSet(results, lastWord); // get prefix match results
		led.resultSet(results, lastWord); // get led results
		whitespace.resultSet(results, lastWord); // get whitespace results

		HashSet<String> tempSet = new HashSet<String>(); // temp set to bypass
															// bug in the
															// regComparator
		String toAdd, fullAdd; // temporary helper strings to avoid polling more
								// than is necessary
		int counter = 0;
		while (counter < 5) {
			if (!results.isEmpty()) {
				toAdd = results.pollLast();
				fullAdd = toPrepend + toAdd;
				if (tempSet.contains(fullAdd)) {

				} else {
					tempSet.add(fullAdd);
					finalFive.add(fullAdd);
					counter = counter + 1;
				}
			} else
				break;
		}

		return finalFive;

	}
}