package app.backend.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import app.backend.autosuggest.Autosuggest;
import java.util.List;
import java.util.TreeSet;

import app.backend.interfaces.Category;

import app.backend.interfaces.Item;
import app.backend.interfaces.Outfit;
import app.backend.interfaces.TagSuggesting;
import app.backend.interfaces.User;
import app.backend.interfaces.Wardrobe;
import app.backend.user.AppWardrobe.WardrobeType;

public class AppUser implements User, Serializable {

	String username;
	ArrayList<Wardrobe> wardrobeList = new ArrayList<Wardrobe>();
	ArrayList<Outfit> outfitList = new ArrayList<Outfit>();

	HashSet<Item> allItems = new HashSet<Item>(); // set instead of map
																	
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
<<<<<<< HEAD
		allCategories.add(new AppCategory())
=======

>>>>>>> b816914109c23ecccb6f80da1274dddb203d4fad
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
	
	public Wardrobe searchWardrobe(String name){
		Wardrobe result = null;
		for (Wardrobe i : wardrobeList){
			if (i.getName().equals(name)){
				result = i;
			}
		}
		return result;
	}


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

 

	
	public static void main(String[] args){
		
//		AppUser a = new AppUser("Sohum");
//		
//		AppItem redShirt = new AppItem("redShirt", null);
//		
//		redShirt.addTag("red");
//		redShirt.addTag("shirt");
//		redShirt.addTag("fits like a condom");
//		
//		AppItem blueShirt = new AppItem("blueShirt", null);
//		
//		blueShirt.addTag("blue");
//		blueShirt.addTag("shirt");
//		blueShirt.addTag("fits like a sack");
//		
//		AppItem greenShirt = new AppItem("greenShirt", null);
//		
//		greenShirt.addTag("green");
//		greenShirt.addTag("shirt");
//		greenShirt.addTag("fits like a glove");
//		
//		AppItem redShirt2 = new AppItem("redShirt2", null);
//		
//		redShirt2.addTag("red");
//		redShirt2.addTag("shirt");
//		redShirt2.addTag("fits like a glove");
//		
//		a.addItem(redShirt);
//		a.addItem(blueShirt);
//		a.addItem(greenShirt);
//		a.addItem(redShirt2);
//		
//
//		
//		
//		
//		String[] toSearch = new String[]{"red", "shirt", "fits like a glove"};
//		
//
//		ArrayList<Item> result = (ArrayList<Item>) a.search(toSearch);
//		
//		System.out.println(result.size());
//		
//		for (int i=0; i<result.size();i++){
//			System.out.println(result.get(i).getName());
//		}
//		
//		
//		String[] toSearch2 = new String[]{"green", "fits like a sack", "fits like a glove"};
//		
//
//		ArrayList<Item> result2 = (ArrayList<Item>) a.search(toSearch2);
//		
//		System.out.println(result2.size());
//		
//		for (int i=0; i<result2.size();i++){
//			System.out.println(result2.get(i).getName());
//		}
//		
//		
//		String[] toSearch3 = new String[]{"green", "fits like a sack", "fits like a glove", "shirt"};
//		
//
//		ArrayList<Item> result3 = (ArrayList<Item>) a.search(toSearch3);
//		
//		System.out.println(result3.size());
//		
//		for (int i=0; i<result3.size();i++){
//			System.out.println(result3.get(i).getName());
//		}
		
		

	/*
	 * public static void main(String[] args){
	 * 
	 * AppUser a = new AppUser("Sohum");
	 * 
	 * AppItem redShirt = new AppItem("redShirt", null);
	 * 
	 * redShirt.addTag("red"); redShirt.addTag("shirt");
	 * redShirt.addTag("fits like a condom");
	 * 
	 * AppItem blueShirt = new AppItem("blueShirt", null);
	 * 
	 * blueShirt.addTag("blue"); blueShirt.addTag("shirt");
	 * blueShirt.addTag("fits like a sack");
	 * 
	 * AppItem greenShirt = new AppItem("greenShirt", null);
	 * 
	 * greenShirt.addTag("green"); greenShirt.addTag("shirt");
	 * greenShirt.addTag("fits like a glove");
	 * 
	 * AppItem redShirt2 = new AppItem("redShirt2", null);
	 * 
	 * redShirt2.addTag("red"); redShirt2.addTag("shirt");
	 * redShirt2.addTag("fits like a glove");
	 * 
	 * a.addItem(redShirt); a.addItem(blueShirt); a.addItem(greenShirt);
	 * a.addItem(redShirt2);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * String[] toSearch = new String[]{"red", "shirt", "fits like a glove"};
	 * 
	 * 
	 * ArrayList<Item> result = (ArrayList<Item>) a.search(toSearch);
	 * 
	 * System.out.println(result.size());
	 * 
	 * for (int i=0; i<result.size();i++){
	 * System.out.println(result.get(i).getName()); }
	 * 
	 * 
	 * String[] toSearch2 = new String[]{"green", "fits like a sack",
	 * "fits like a glove"};
	 * 
	 * 
	 * ArrayList<Item> result2 = (ArrayList<Item>) a.search(toSearch2);
	 * 
	 * System.out.println(result2.size());
	 * 
	 * for (int i=0; i<result2.size();i++){
	 * System.out.println(result2.get(i).getName()); }
	 * 
	 * 
	 * String[] toSearch3 = new String[]{"green", "fits like a sack",
	 * "fits like a glove", "shirt"};
	 * 
	 * 
	 * ArrayList<Item> result3 = (ArrayList<Item>) a.search(toSearch3);
	 * 
	 * System.out.println(result3.size());
	 * 
	 * for (int i=0; i<result3.size();i++){
	 * System.out.println(result3.get(i).getName()); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
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
	public void addWardrobe(String name) {
		wardrobeList.add(new AppWardrobe(name, WardrobeType.CLOSET));

	}

	@Override
	public void addCategory(String categoryName) {
		if (!(tagsMap.containsKey(categoryName))) {
			tagsMap.put(categoryName, new HashSet<Item>());
		}
		if (!allCategories.contains(categoryName)) {
			allCategories.add(new AppCategory(categoryName, tagsMap
					.get(categoryName)));
		}
>>>>>>> 7a4cf4ba7be6720fda233b6b114fe7f03421ca03
	}

	@Override
	public Collection<Category> getCategories() {
		return allCategories;
	}

	@Override
	public Collection<Item> allItems() {
		return allItems.keySet();
	}

}
