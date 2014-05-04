package app.backend.user;

import java.util.ArrayList;

import app.backend.interfaces.Item;
import app.backend.interfaces.User;

public class TestingScript {

	public static void main(String[] args) {
		Saver saved = new Saver("Sohum");
		AppUser user = (AppUser) saved.getUser();
		
		user.addWardrobe("away");
		user.addWardrobe("herenorthere");
		  AppItem redShirt = new AppItem(user, user.searchWardrobe("away"), "redShirt", null);
		  
		  redShirt.addTag("red"); redShirt.addTag("shirt");
		  redShirt.addTag("fits like a condom");
		  
		  AppItem blueShirt = new AppItem(user, user.searchWardrobe("away"), "blueShirt", null);
		  
		  blueShirt.addTag("blue"); blueShirt.addTag("shirt");
		  blueShirt.addTag("fits like a sack");
		  
		  AppItem greenShirt = new AppItem(user, user.searchWardrobe("away"), "greenShirt", null);
		  
		  greenShirt.addTag("green"); greenShirt.addTag("shirt");
		  greenShirt.addTag("fits like a glove");
		  
		  AppItem redShirt2 = new AppItem(user, user.searchWardrobe("away"), "redShirt2", null);
		  
		  redShirt2.addTag("red"); redShirt2.addTag("shirt");
		  redShirt2.addTag("fits like a glove");
		  
		  user.addItem("redShirt", "away", "red", "red", null, new ArrayList<String>() )
		  user.addI

		String toSearch = " red shirt fits like a glove";

		ArrayList<Item> result = (ArrayList<Item>) user.search(toSearch);

		System.out.println(result.size());

		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getName());
		}

		saved.saveData();
	}
}
