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
public class LED implements Feature {
    
    private int led; // the levenshtein edit distance
    private HashSet<String> wordMap; 
    public boolean ledOn; // boolean to mark if LED search has been turned on by user
    
    /**
     * constructor method
     * @param unigramMap: save space by reusing the unigram map built in main class
     */
    public LED(HashSet<String> unigramMap){
        this.led = 0;
        this.wordMap = unigramMap;
        this.ledOn = false;
    }
    
    /**
     * method to turn on led calculation
     */
    public void turnOnFeature(){
        ledOn = true;
    }

    /**
     * @param distance: integer passed in is set as the levenshtein edit distance. Int is checked
     * before being passed.
     */
    public void inputDistance(int distance){
        led = distance;
    }
    
    /**
     * method to build set of results using led calculation
     */
    public void resultSet(Set<String> results, String word){
        if (ledOn){
	        for(String entry : wordMap){ // iterating through keyset of all words in corpus
	            if (distance(word, entry)<=led) // finding all words in corpus that are less than or equal to led away from input word
	                results.add(entry);
	        }
        }
        else{
        	//do nothing
        }
    }
    
    /**
     * method to calculate the levenshtein edit distance between two strings
     * using matrix algorithm (iXj matrix for two words of length i and j)
     * @param word : word one
     * @param entry : word two
     * @return : integer that is the led
     */
    public int distance(String word, String entry){ 
        int wordLength = word.length();
        int entryLength = entry.length();
        int cost;
        int[][] matrix = new int[wordLength+1][entryLength+1];
        for (int i=0; i<=wordLength; i++){
            matrix[i][0] = i;
            }
        for (int j=0; j<=entryLength; j++){
            matrix[0][j] = j;
            }
        for (int i=1; i<=wordLength; i++) {
            char ithLetterInWord = word.charAt(i - 1);           
            for (int j=1; j<=entryLength; j++) {
                char jthLetterInEntry = entry.charAt(j - 1);
                if (ithLetterInWord == jthLetterInEntry) cost = 0;
                else cost = 1;
                matrix[i][j] = MinOfThree(matrix[i-1][j]+1, matrix[i][j-1]+1, matrix[i-1][j-1] + cost);
                }
            }
            return matrix[wordLength][entryLength];
    }
    
    /**
     * 
     * @param a int1
     * @param b int2
     * @param c int3
     * @return helper method that returns Math.min for three ints a b  c
     */
    private int MinOfThree(int a, int b, int c) { 
        int min;
        min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        return min;
    }
}
