package backend.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import backend.interfaces.Item;
import backend.interfaces.Outfit;
import backend.interfaces.User;
import backend.interfaces.Wardrobe;

public class AppUser implements User{
	
	String username;
	ArrayList<Wardrobe> wardrobeList = new ArrayList<Wardrobe>();
	ArrayList<Outfit> outfitList = new ArrayList<Outfit>();
	HashMap<Item, Integer> allItems = new HashMap<Item, Integer>(); //list of tags instead of integer
	//HashSet<String> allTags = new HashSet<String>();
	HashMap<String, HashSet<Item>> tagsMap = new HashMap<String, HashSet<Item>>(); 
	
	
	public AppUser(String name){
		this.username = name;
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
	public void addItem(Item item) {
		//add to map of all items for count
		Integer count = 1;
		if (allItems.containsKey(item))
			count = allItems.get(item) + 1;
		
		allItems.put(item, count);
		
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
	public void removeItem(Item item) {
		//MAKE CHANGES FOR CASE WHEN COUNT IS GREATER THAN ONE....
		allItems.remove(item);
	}


	public HashSet<Item> searchItem(String[] searchTerms) {
		
		HashSet<Item> matchingItems = new HashSet<Item>();
		//unigram bigram searching needed?
		
		String unigram = null;
		for (int i=0; i< searchTerms.length; i++){
			
			unigram = searchTerms[i];
			
			if (tagsMap.containsKey(unigram)){
				matchingItems.addAll(tagsMap.get(unigram));
			}
			
		}
		
		return matchingItems;
		
	}

	@Override
	public Collection<Item> search(String[] searchTerms) {
		
		
		
		HashSet<Item> matchingItems = searchItem(searchTerms);
		
		ArrayList<Item> toReturn = new ArrayList<Item>();
		
		for (Item item: matchingItems){
			
			for (int i=0; i< searchTerms.length; i++){
				
				String tag = searchTerms[i];
				
				if (item.getTags().contains(tag)){
					item.incrementScore();
				}
			}
			
			toReturn.add(item);
		}
		
		Collections.sort(toReturn);
		
		for (Item item: matchingItems){
			item.resetScore();
		}
		
		return toReturn;
	}
	
	
	public static void main(String[] args){
		
		AppUser a = new AppUser("Sohum");
		
		AppItem redShirt = new AppItem("redShirt", null);
		
		redShirt.addTag("red");
		redShirt.addTag("shirt");
		redShirt.addTag("fits like a condom");
		
		AppItem blueShirt = new AppItem("blueShirt", null);
		
		blueShirt.addTag("blue");
		blueShirt.addTag("shirt");
		blueShirt.addTag("fits like a sack");
		
		AppItem greenShirt = new AppItem("greenShirt", null);
		
		greenShirt.addTag("green");
		greenShirt.addTag("shirt");
		greenShirt.addTag("fits like a glove");
		
		AppItem redShirt2 = new AppItem("redShirt2", null);
		
		redShirt2.addTag("red");
		redShirt2.addTag("shirt");
		redShirt2.addTag("fits like a glove");
		
		a.addItem(redShirt);
		a.addItem(blueShirt);
		a.addItem(greenShirt);
		a.addItem(redShirt2);
		

		
		
		
		String[] toSearch = new String[]{"red", "shirt", "fits like a glove"};
		

		ArrayList<Item> result = (ArrayList<Item>) a.search(toSearch);
		
		System.out.println(result.size());
		
		for (int i=0; i<result.size();i++){
			System.out.println(result.get(i).getName());
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
}
