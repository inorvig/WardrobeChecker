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
	String username;
	ArrayList<Wardrobe> wardrobeList = new ArrayList<Wardrobe>();
	ArrayList<Outfit> outfitList = new ArrayList<Outfit>();

	HashSet<Item> allItems = new HashSet<Item>(); 
																	
	HashSet<Category> allCategories = new HashSet<Category>();
	HashMap<String, HashSet<Item>> tagsMap = new HashMap<String, HashSet<Item>>();
	Autosuggest autosuggest;
	TagSuggesting tagsuggester;

	public AppUser(String name) {
		this.username = name;
		this.autosuggest = new Autosuggest(tagsMap);
		autosuggest.setUp();
		this.tagsuggester = new StubTagger();
		wardrobeList.add(new AppWardrobe("Home Closet", WardrobeType.CLOSET));
		addCategory("shirts");
		addCategory("dresses");
		addCategory("shoes");
		addCategory("skirts");
		addCategory("pants");
		addCategory("sweaters");
		addCategory("jeans");
		addCategory("jackets");
		addWardrobe("df");


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

	@Override
	public void addItem(String name, String wardrobe, String category,
			String color, String imagePath, ArrayList<String> tags) {
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
			allCategories.add(new AppCategory(categoryName, tagsMap
					.get(categoryName)));
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
