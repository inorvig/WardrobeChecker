package app.frontend;

import java.util.ArrayList;
import java.util.Collection;

import app.backend.interfaces.Item;
import app.backend.interfaces.Wardrobe;
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
		items.add(new AppItem(user, wardrobe, "Yellow Shirt", "images/yellowshirt.jpg"));
		items.add(new AppItem(user, wardrobe, "Green Shirt", "images/greenshirt.jpg"));
		items.add(new AppItem(user, wardrobe, "Blue Shirt", "images/blueshirt.jpg"));
		System.out.println("Size is"+ items.size());
	}
	
	public Collection<Item> getItems(){
		return items;
	}
}
