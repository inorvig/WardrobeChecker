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
public class Node {
    
 //   private Node parent; 
    public char letter; 
    private boolean isLastLetter; //boolean indicating if this node's letter marks the end of a word
    private HashMap<Character, Node> children = new HashMap<Character, Node>(); //hashmap of node's children with letter-node kvpairs
    
    /**
     * constructor method for node
     * @param parent : node's parent
     * @param letter : the letter to be stored in the node
     * @param isLastLetter : boolean indicating if the node marks the end of some word
     */
    public Node(Node parent, char letter, boolean isLastLetter){
   //     this.parent = parent;
        this.letter = letter;
        this.isLastLetter = isLastLetter;
    }
    
    /**
     * 
     * @return true if node is the last letter (end) of a word
     */
    public boolean isLastLetter(){
        return isLastLetter;
    }
    
    /**
     * set a node to be the last letter of a word
     */
    public void wordEnd(){ 
        isLastLetter = true;
    }
    
    /**
     * 
     * @param letter: the letter to be checked
     * @return boolean to indicate whether input letter is a child of given node
     */
    public boolean isChild(char letter){
        return children.containsKey(letter);
    }
    
    /**
     * 
     * @param letter: letter associated with child we are seeking
     * @return Node that contains the letter inputted (node is a child of current node) 
     */
    public Node getChild(char letter){
        return children.get(letter);
    }
    
    /**
     * 
     * @param letter: letter associated with child-to-be
     * @param childNode: the child node to be inserted;
     */
    public void addChild(char letter, Node childNode){
        children.put(letter, childNode);
    }
    
    /**
     * 
     * @return hashmap of children (nodes) for iteration
     */
    public HashMap<Character, Node> getChildren(){ 
        return children;
    }   
}
