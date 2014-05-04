package app.backend.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import app.backend.autosuggest.Autosuggest;
import app.backend.interfaces.Category;

import app.backend.interfaces.Item;
import app.backend.interfaces.Outfit;
import app.backend.interfaces.TagSuggesting;
import app.backend.interfaces.User;
import app.backend.interfaces.Wardrobe;
import app.backend.user.AppWardrobe.WardrobeType;

public class AppUser implements User, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5405996534890993199L;
	String username; //user's name
	ArrayList<Wardrobe> wardrobeList; //list of all wardrobes  
	ArrayList<Outfit> outfitList; //list of all saved outfits
	HashSet<String> itemNames; //set of all item names
	HashSet<Item> allItems; //set of all items								
	HashSet<Category> allCategories; //set of all categories
	HashMap<String, HashSet<Item>> tagsMap;  //map of all tags saved by user, mapped to set of all items that contain the tag
	Autosuggest autosuggest; //autosuggester
	TagSuggesting tagsuggester; //cv tag suggester

	/**
	 * contructor method -- initialize data structures
	 * @param name
	 */
	public AppUser(String name) {

		this.username = name; //initialize name

		
		this.allItems = new HashSet<Item>(); //initialize set of all items 
		this.itemNames = new HashSet<String>(); //initialize set of all itemNames
		
		this.outfitList = new ArrayList<Outfit>(); //initialize list of outfits
		
		this.tagsMap = new HashMap<String, HashSet<Item>>(); //initialize map of tags to items
		
		this.wardrobeList = new ArrayList<Wardrobe>(); //initialize empty list
		wardrobeList.add(new AppWardrobe("Home Closet", WardrobeType.CLOSET)); //add default home closet

		this.allCategories = new HashSet<Category>(); //initialize category set
		addCategory("shirts");
		addCategory("dresses");
		addCategory("shoes");
		addCategory("skirts");
		addCategory("pants");
		addCategory("sweaters");
		addCategory("jeans");
		addCategory("jackets");


		this.allItems = new HashSet<Item>(); //initialize set of all items 
		this.itemNames = new HashSet<String>(); //initialize set of all itemNames

		this.outfitList = new ArrayList<Outfit>(); //initialize list of outfits

		this.tagsMap = new HashMap<String, HashSet<Item>>(); //initialize map of tags to items

		this.autosuggest = new Autosuggest(tagsMap); //set up autosuggest
		autosuggest.setUp();

		this.tagsuggester = new StubTagger();

	}

	@Override
	public Collection<Wardrobe> getWardrobes() {
		return this.wardrobeList;
	}

	@Override
	public int howManyWardrobes() {
		return this.wardrobeList.size();
	}

	@Override
	public Collection<Outfit> getOutfits() {
		return this.outfitList;
	}

	@Override
	public int howManyOutfits() {
		return this.outfitList.size();
	}

	@Override
	public Wardrobe searchWardrobe(String name){
		Wardrobe result = null;
		for (Wardrobe i : wardrobeList){
			if (i.getName().equals(name)){
				result = i;
			}
		}
		return result;
	}

	public Collection<String> getCategoryList(){
		Collection<String> result = new ArrayList<String>();
		for (Category i : allCategories){
			result.add(i.getName());
		}
		return result;
	}
	
	/**
	 * wrapper around addItem that contructs Item and then passes
	 */
	@Override
	public void addItem(String name, String wardrobe, String category, String color, String imagePath, ArrayList<String> tags) {
		Wardrobe wardrobeToPut = searchWardrobe(wardrobe);
		if (wardrobeToPut == null){
			wardrobeToPut = wardrobeList.get(0);
		}
		ArrayList<String> allTags = tags;
		tags.add(color);
		Item toAdd = new AppItem(this, wardrobeToPut, name, imagePath);
		for (String i : allTags) {
			toAdd.addTag(i);
		}
		addItem(toAdd);

	}

	private void addItem(Item item) {

		allItems.add(item);

		//add items tags
		HashSet<String> tagsToAdd = item.getTags();

		for (String tag: tagsToAdd){

			if (tagsMap.containsKey(tag)){
				tagsMap.get(tag).add(item);

			}
			else{
				HashSet<Item> itemSet = new HashSet<Item>();
				itemSet.add(item);
				tagsMap.put(tag, itemSet);
			}	
		}
	}

	@Override
	public void saveOutfit(Outfit outfit) {

		this.outfitList.add(outfit);
	}



	@Override
	public Collection<Item> search(String searchTerms) {

		for (Item item: allItems){
			item.resetScore();
		}

		HashSet<Item> matchingItems = new HashSet<Item>();
		ArrayList<Item> toReturn = new ArrayList<Item>();



		Set<String> matchingTags = autosuggest.lookup(searchTerms);


		for (String tag: matchingTags){

			HashSet<Item> items = tagsMap.get(tag);

			for (Item item: items){
				item.incrementScore();
				matchingItems.add(item);
			}

		}

		for (Item item: matchingItems){
			toReturn.add(item);
		}

		Collections.sort(toReturn);

		return toReturn;
	}




	@Override
	public Collection<String> suggestTags(String imagePath) {
		return tagsuggester.suggestTags(imagePath);
	}

	@Override
	public void removeItem(Item item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addWardrobe(String name, WardrobeType type) {
		wardrobeList.add(new AppWardrobe(name, type));

	}

	@Override
	public void addCategory(String categoryName) {
		//check whether it exists
		if (!(tagsMap.containsKey(categoryName))) {
			tagsMap.put(categoryName, new HashSet<Item>());
		}
		if (!allCategories.contains(categoryName)) {
			allCategories.add(new AppCategory(categoryName, tagsMap.get(categoryName)));
		}
	}

	@Override
	public Collection<Category> getCategories() {
		return allCategories;
	}

	@Override
	public Collection<Item> allItems() {
		return allItems;
	}

	@Override
	public Collection<String> getWardrobeList() {
		Collection<String> result = new ArrayList<String>();
		System.out.println("wardrobe list is "+ wardrobeList.size());
		for (Wardrobe i : wardrobeList){
			result.add(i.getName());
		}
		return result;
	}

}
