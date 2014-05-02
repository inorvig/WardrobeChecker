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
public class RegComparator implements Comparator<String> {
    
	private String inputWord;
	private String prevWord;
	private HashMap<String, Integer> unigramMap, bigramMap;
    
	/**
	 * constructor method
	 * @param inputWord
	 * @param prevWord
	 * @param unigram
	 * @param bigram
	 */
	public RegComparator(String inputWord,String prevWord,HashMap<String, Integer> unigram, HashMap<String, Integer> bigram){
		this.inputWord = inputWord;
		this.prevWord = prevWord;
		this.unigramMap = unigram;
		this.bigramMap = bigram;
	}
	
	/**
	 * compare method for deciding between any two methods
	 */
    @Override
    public int compare(String word1, String word2) {
    	
    	int alphabeticOrder = word2.compareTo(word1); //alphabetic order to break ties
    	
    	if (word1.compareTo(inputWord)==0) // if either string being compared is the same as the user's input, privilege it
    		return 1;
    	if (word2.compareTo(inputWord)==0)
    		return -1;
    	
    	// split for bigram comparison and use the word just before given user input
    	if (word1.contains(" ")){
    		int i = word1.indexOf(" ");
    		word1 = word1.substring(0,i);
    	}
    	String bg1 = prevWord + " " + word1; 
    	
    	if (word2.contains(" ")){
    		int i = word2.indexOf(" ");
    		word1 = word2.substring(0,i);
    	}
    	String bg2 = prevWord + " " + word2;
    	
    	if (bigramMap.containsKey(bg1) && bigramMap.containsKey(bg2)) {
    		if (bigramMap.get(bg1) > bigramMap.get(bg2))
    			return 1;
    		else if (bigramMap.get(bg1) < bigramMap.get(bg2))
    			return -1;

    	} 
    	else if (bigramMap.containsKey(bg1))
    		return 1;
    	else if (bigramMap.containsKey(bg2))
    		return -1;
    
    	//unigram comparison
	    if (unigramMap.containsKey(word1) && unigramMap.containsKey(word2)) {
			if (unigramMap.get(word1) > unigramMap.get(word2))
				return 1;
			else if (unigramMap.get(word1) < unigramMap.get(word2))
				return -1;
		
		} 
	    return alphabeticOrder;
	}

    	
}
