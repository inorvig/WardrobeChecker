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

	/**
	 * 
	 */
	private static final long serialVersionUID = -852602098811815755L;
	Integer score = 0;
	String name;
	HashSet<String> tags;
	String imagePath;
	AppUser owner;
	Wardrobe wardrobe;
	private Category category;

	public AppItem(AppUser user, Wardrobe wardrobeToPut, Category category,  String name, String imagePath) {

		this.owner = user; // owner object passed
		this.wardrobe = wardrobeToPut; // parent wardrobe object passed
		this.name = name; // unique identifier name
		this.imagePath = imagePath; // image path
		this.tags = new HashSet<String>(); // initialize set of tags
		this.category = category;


	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public HashSet<String> getTags() {
		return this.tags;
	}

	// CV STUFF ----
	@Override
	public Color whichColor() {
		return null;
	}

	@Override
	public void addTag(String newTag) {
		if (newTag.trim() == "")
			return;
		
		HashMap<String, HashSet<Item>> parentTagMap = this.owner.tagsMap;
		
		String fullTag = newTag.trim();
		String[] wordArray =  fullTag.split(" ");
		
		if (wordArray.length >= 1){
			for (int i=0; i<wordArray.length ; i++){
				String word = wordArray[i];
				word = word.toLowerCase().trim();
				this.tags.add(word);
				
				this.owner.autosuggest.addTag(word); // for the case when tags are being added on later
				
				if (parentTagMap.get(word) == null){
					HashSet<Item> itemSet = new HashSet<Item>();
					itemSet.add(this);
					parentTagMap.put(word, itemSet);
				}
				else{
					parentTagMap.get(word).add(this);
				}

			}
		}
		

		
		
		
		
		//INSERT INTO TRIE UNIGRAM BIGRAM ETC...

	}

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
//
//		// REMOVE FROM TRIE UNIGRAM BIGRAM ETC...

	}

	@Override
	public Wardrobe whichWardrobe() {
		return this.wardrobe;
	}

	@Override
	public Collection<Outfit> whichOutfits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void moveItem(Wardrobe destination) {
		this.wardrobe.removeItem(this);

		// check if destination has the same user -- if not remove all tags etc
		// from the users datastructures
		destination.addItem(this);

	}

	public boolean resetImagePath(String newImage) {
		// check if newImage exists
		this.imagePath = newImage;
		return true;
	}

	@Override
	public String getImagePath() {
		return this.imagePath;
	}

	@Override
	public void resetScore() {
		this.score = 0;

	}

	@Override
	public void incrementScore() {
		this.score += 1;

	}

	@Override
	public Integer getScore() {

		return this.score;
	}

	@Override
	public int compareTo(Object that) {
		return -1 * this.score.compareTo(((Item) that).getScore());
	}
	
	
	public Category whichCategory(){
		return category;
	}

}
