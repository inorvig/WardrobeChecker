package app.backend.user;

import java.awt.Color;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import app.backend.interfaces.Category;
import app.backend.interfaces.Item;
import app.backend.interfaces.Outfit;
import app.backend.interfaces.Wardrobe;

public class AppItem implements Item, Serializable {

	private static final long serialVersionUID = -852602098811815755L;
	
	Integer score;
	String name;
	HashSet<String> tags;
	String imagePath;
	AppUser owner;
	Wardrobe wardrobe;
	private String color;
	private Category category;

	public AppItem(AppUser user, Wardrobe wardrobeToPut, Category category,  String name, String imagePath) {
		
		this.score = 0; //score initialize to 0
		this.owner = user; // owner object passed
		this.wardrobe = wardrobeToPut; // parent wardrobe object passed
		this.name = name; // unique identifier name
		this.imagePath = imagePath; // image path
		this.tags = new HashSet<String>(); // initialize set of tags
		this.category = category;
		this.color = "";


	}
	/**
	 * get item name
	 */
	@Override
	public String getName() {
		return this.name;
	}
	
	/**
	 * get set of item tags
	 */
	@Override
	public HashSet<String> getTags() {
		return this.tags;
	}

	// CV STUFF ----
	@Override
	public String whichColor() {
		return color;
	}
	
	/**
	 * add tag to item
	 * 
	 * string new tag is expected to be one word but checks are done for many just in case
	 */
	@Override
	public void addTag(String newTag) {
		
		if (newTag.trim() == "") //empty tag not permitted
			return;
		
		HashMap<String, HashSet<Item>> parentTagMap = this.owner.tagsMap; //get parents tagmap
		
		String fullTag = newTag.trim();
		String[] wordArray =  fullTag.split(" ");
		
		if (wordArray.length >= 1){ //for each word to be tagged
			for (int i=0; i<wordArray.length ; i++){
				
				String word = wordArray[i];
				word = word.toLowerCase().trim();
				this.tags.add(word);
				
				this.owner.autosuggest.addTag(word); // for the case when tags are being added on later
				
				if (parentTagMap.get(word) == null){ // if it doesnt exits, add word --> item
					HashSet<Item> itemSet = new HashSet<Item>();
					itemSet.add(this);
					parentTagMap.put(word, itemSet);
				}
				else{
					parentTagMap.get(word).add(this); // if exists, add item to set
				}
			}
		}
	}
	/**
	 * unimplemented since frontend has no such functionality
	 */
	@Override
	public void removeTag(String tagToRemove) {

//
//		this.tags.remove(tagToRemove);
//		HashMap<String, HashSet<Item>> parentTagMap = this.owner.tagsMap;
//
//		if (parentTagMap.get(tagToRemove) != null) {
//			parentTagMap.get(tagToRemove).remove(this);
//
//			if (parentTagMap.get(tagToRemove).size() == 0) {
//				parentTagMap.remove(tagToRemove);
//			}
//		}
	}
	
	/**
	 * return parent wardrobe
	 */
	@Override
	public Wardrobe whichWardrobe() {
		return this.wardrobe;
	}
	
	/**
	 * returns the outfits it belongs to
	 * 
	 * unimplemented since frontend has no such functionality
	 */
	@Override
	public Collection<Outfit> whichOutfits() {
		return null;
	}
	
	/**
	 * move this item to another wardrobe (for the same user as of now)
	 */
	@Override
	public void moveItem(Wardrobe destination) {
		this.wardrobe.removeItem(this);
		destination.addItem(this);
		
		// check if destination has the same user -- if not remove all tags etc
		// from the users datastructures

	}
	
	/**
	 * change image path 
	 * @param newImage
	 * @return true if reset
	 */
	public void resetImagePath(String newImage) {
		// check if newImage exists
		this.imagePath = newImage;
	}
	
	/**
	 * return imagepath
	 */
	@Override
	public String getImagePath() {
		return this.imagePath;
	}
	
	/**
	 * reset score for new searching
	 */
	@Override
	public void resetScore() {
		this.score = 0;
	}
	
	/**
	 * increment score by one for search scoring
	 */
	@Override
	public void incrementScore() {
		this.score += 1;
	}
	
	/**
	 * return score from search scoring
	 */
	@Override
	public Integer getScore() {
		return this.score;
	}
	
	/**
	 * override compare to method so that we can sort the arraylist to be returned by search
	 * based on search score 
	 */
	@Override
	public int compareTo(Object that) {
		return -1 * this.score.compareTo(((Item) that).getScore());
	}
	
	/**
	 * return category
	 */
	public Category whichCategory(){
		return category;
	}
	
	/**
	 * change category
	 */
	@Override
	public void setCategory(Category category) {
		this.category = category;
	}
	
	/**
	 * change color
	 */
	@Override
	public void setColor(String color) {
		this.color = color;
		
	}
	
	/**
	 * change image path
	 */
	@Override
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;		
	}

}
