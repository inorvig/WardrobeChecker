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
		
		this.allCategories = new HashSet<Category>(); //initialize category set with default categories and images
		addCategory("t-shirts");
		this.searchCategory("t-shirts").setImagePath("images/categories/t-shirts.gif");
		addCategory("pants");
		this.searchCategory("pants").setImagePath("images/categories/pants.gif");
		addCategory("skirt");
		this.searchCategory("skirt").setImagePath("images/categories/skirt.gif");
		addCategory("swim");		
		this.searchCategory("swim").setImagePath("images/categories/swim.gif");
		addCategory("tanks");
		this.searchCategory("tanks").setImagePath("images/categories/tanks.gif");
		addCategory("workout");
		this.searchCategory("workout").setImagePath("images/categories/workout.gif");
		addCategory("dresses");
		this.searchCategory("dresses").setImagePath("images/categories/dresses.gif");
		
		this.autosuggest = new Autosuggest(tagsMap); //set up autosuggest
		autosuggest.setUp();
		
		this.tagsuggester = new StubTagger();//stub tagger for cv
		
	}
	
	/**
	 * list of wardrobes that user owns
	 */
	@Override
	public Collection<Wardrobe> getWardrobes() {
		return this.wardrobeList;
	}
	
	/**
	 * count of wardrbobes owned by user
	 */
	@Override
	public int howManyWardrobes() {
		return this.wardrobeList.size();
	}
	
	/**
	 * list of outfits owned by user
	 */
	@Override
	public Collection<Outfit> getOutfits() {
		return this.outfitList;
	}
	
	/**
	 * count of outfits owned by user
	 */
	@Override
	public int howManyOutfits() {
		return this.outfitList.size();
	}
	
	/**
	 * given a string that is wardrobe name, search and return that wardrobe
	 */
	@Override
	public Wardrobe searchWardrobe(String name){
		Wardrobe result = null;
		for (Wardrobe i : wardrobeList){
			if (i.getName().equals(name)){
				result = i;
				break;
			}
		}
		return result;
	}
	
	/**
	 * return list of category names 
	 */
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
	public void addItem(String name, String wardrobe, String cat, String color, String imagePath, ArrayList<String> tags) {
		
		//contruct the item object first
		
		Wardrobe wardrobeToPut = searchWardrobe(wardrobe); //search for the wardrobe name
		if (wardrobeToPut == null){
			wardrobeToPut = wardrobeList.get(0); //if name does not match add to the default closet
		}
		
		ArrayList<String> allTags = tags;
		tags.add(color); //add color as a tag for searching
		
		String category = cat.replaceAll("[^A-Za-z0-9]", "").toLowerCase().trim();
		tags.add(category); //add category as a tag for searching

		String itemName = name.replaceAll("[^A-Za-z0-9]", " ").toLowerCase().trim(); //remove illegitimate charach
		if (itemName == "") //do not permit empty string names
			itemName = "defaultName";
		tags.add(itemName); //add name as a tag for searching
		
		//create new item
		Item toAdd = new AppItem(this, wardrobeToPut, searchCategory(category),  itemName, imagePath);
		
		for (String i : allTags) {		//for each tag
			String tag = i.replaceAll("[^A-Za-z0-9]", "").toLowerCase().trim(); //	
			toAdd.addTag(tag); //add it to tag list of the item
		}

		wardrobeToPut.addItem(toAdd);

		addItem(toAdd);


		
		addItem(toAdd);//pass the item to the method below

	}
	
	
	/**
	 * add an Item object from method above
	 * @param item
	 */
	public void addItem(Item item) {

		allItems.add(item); //add to list of all items
		
		//add items tags
		HashSet<String> tagsToAdd = item.getTags();
		
		for (String tag: tagsToAdd){ //for each tag
			autosuggest.addTag(tag); //insert into unigram map and trie
			
			if (tagsMap.containsKey(tag)){ //insert into parent tagmap
				tagsMap.get(tag).add(item);
			}
			else{
				HashSet<Item> itemSet = new HashSet<Item>();
				itemSet.add(item);
				tagsMap.put(tag, itemSet);
			}	
		}
	}
	
	/**
	 * 
	 * @param toSearch
	 * @return
	 */
	private Category searchCategory(String toSearch){
		for (Category i: allCategories){
			if (i.getName().equals(toSearch))
				return i;
		}
		addCategory(toSearch);
		return searchCategory(toSearch);
	}
	
	/**
	 * save an outfit
	 * 
	 * not implemented yet?
	 */
	@Override
	public void saveOutfit(Outfit outfit) {
		this.outfitList.add(outfit);
		System.out.format("saved outfit: %s with %d items",outfit.getName(),outfit.itemsInOutfit().size());
		for (Item i : outfit.itemsInOutfit()){
			System.out.println("item: "+i.getName());
		}
	}

	/**
	 * SEARCH: get a list of items having given a string of words
	 */
	@Override
	public ArrayList<Item> search(String searchTerms) {
		
		String query = searchTerms.replaceAll("[^A-Za-z0-9]", " ").toLowerCase().trim(); //prune inpur	
		for (Item item: allItems){
			item.resetScore(); //reset score for all items
		}
		HashSet<Item> matchingItems = new HashSet<Item>();//initialize set of all items that match search terms
		ArrayList<Item> toReturn = new ArrayList<Item>();//initialize list to be returned
		Set<String> matchingTags = autosuggest.lookup(query); //get list of all tags that match the search terms from autosuggest
		
		for (String tag: matchingTags){ //for all tags that match the query	
			HashSet<Item> items = tagsMap.get(tag); //get the list of all items that contain the tag
			for (Item item: items){
				item.incrementScore();//increment score for every item that matches a given tag
				matchingItems.add(item);//add it to the set of all matching items
			}
		}
		
		for (Item item: matchingItems){//for all items that match the tags that were searched on
			toReturn.add(item);//add the item to the list to be returned
		}
		
		Collections.sort(toReturn);//sort the list based on search score
		return (ArrayList<Item>) toReturn;
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
		//System.out.println("wardrobe list is "+ wardrobeList.size());
		for (Wardrobe i : wardrobeList){
			result.add(i.getName());
		}
		return result;
	}

	@Override
	public void UpdateItem(Item item, String wardrobe, String category, String color, String imagePath, ArrayList<String> tags) {
		item.moveItem(searchWardrobe(wardrobe));
		item.setCategory(searchCategory(category));
		item.addTag(color);
		item.setColor(color);
		item.setImagePath(imagePath);
		for (String i: tags){
			item.addTag(i);
		}
	}

	@Override
	public String suggestColor(String imagePath) {
		String result = tagsuggester.suggestColor(imagePath);
		
		System.out.println(result + "\n is what the suer has");
		return result;
	}

}
