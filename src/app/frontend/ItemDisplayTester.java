package app.frontend;

import java.util.ArrayList;
import java.util.Collection;

import app.backend.interfaces.Category;
import app.backend.interfaces.Item;
import app.backend.interfaces.Wardrobe;
import app.backend.user.AppCategory;
import app.backend.user.AppItem;
import app.backend.user.AppUser;
import app.backend.user.AppWardrobe;
import app.backend.user.AppWardrobe.WardrobeType;

public class ItemDisplayTester {
	Collection<Item> items;
	
	public ItemDisplayTester(){
		AppUser user = new AppUser("test");
		this.items = new ArrayList<Item>();
		Wardrobe wardrobe = new AppWardrobe("fun", WardrobeType.CLOSET);
		Category shirts = new AppCategory("Search", items);
		items.add(new AppItem(user, wardrobe,shirts, "Yellow Shirt", "images/yellowshirt.jpg"));
		items.add(new AppItem(user, wardrobe,shirts, "Green Shirt", "images/greenshirt.jpg"));
		items.add(new AppItem(user, wardrobe, shirts,"Blue Shirt", "images/blueshirt.jpg"));
	}
	
	public Collection<Item> getItems(){
		return items;
	}
}
