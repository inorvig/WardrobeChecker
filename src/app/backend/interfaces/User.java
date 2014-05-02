package app.backend.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface User {

	public Collection<Wardrobe> getWardrobes();

	public int howManyWardrobes();

	public Collection<Outfit> getOutfits();

	public int howManyOutfits();

	public void addWardrobe(String name);
	
	public Wardrobe searchWardrobe(String name);

	public void addCategory(String categoryName);

	public Collection<Category> getCategories();

	public void addItem(String name, String Wardrobe, String category,
			String color, String imagePath, ArrayList<String> tags);

	public void saveOutfit(Outfit outfit);

	public void removeItem(Item item);


	public Collection<Item> search(String searchTerms);
	

	public Collection<String> suggestTags(String imagePath);
	
	public Collection<Item> allItems();

}
