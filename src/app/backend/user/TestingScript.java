package app.backend.user;

import java.util.ArrayList;

import app.backend.interfaces.Item;
import app.backend.interfaces.User;
import app.backend.user.AppWardrobe.WardrobeType;

public class TestingScript {

	public static void main(String[] args) {
		
		
		
		AppUser u = new AppUser("TestOwner");
		System.out.println(u.howManyWardrobes());
		
		
		
		AppItem item1 = new AppItem(u,u.searchWardrobe("Home Closet"), "item one", "");
		AppItem item2 = new AppItem(u,u.searchWardrobe("Home Closet"), "item two", "");
		AppItem item3 = new AppItem(u,u.searchWardrobe("Home Closet"), "item three", "");
		AppItem item4 = new AppItem(u,u.searchWardrobe("Home Closet"), "item four", "");
		AppItem item5 = new AppItem(u,u.searchWardrobe("Home Closet"), "item five", "");
		AppItem item6 = new AppItem(u,u.searchWardrobe("Home Closet"), "item six", "");
		AppItem item7 = new AppItem(u,u.searchWardrobe("Home Closet"), "item seven", "");
		AppItem item8 = new AppItem(u,u.searchWardrobe("Home Closet"), "item eight", "");
		AppItem item9 = new AppItem(u,u.searchWardrobe("Home Closet"), "item nine", "");
		AppItem item10 = new AppItem(u,u.searchWardrobe("Home Closet"), "item ten", "");
		AppItem item11 = new AppItem(u,u.searchWardrobe("Home Closet"), "item eleven", "");
		AppItem item12 = new AppItem(u,u.searchWardrobe("Home Closet"), "item twelve", "");
		AppItem item13 = new AppItem(u,u.searchWardrobe("Home Closet"), "item thirteen", "");
		AppItem item14 = new AppItem(u,u.searchWardrobe("Home Closet"), "item fourteen", "");
		AppItem item15 = new AppItem(u,u.searchWardrobe("Home Closet"), "item fifteen", "");
		AppItem item16 = new AppItem(u,u.searchWardrobe("Home Closet"), "item sixteen", "");
		AppItem item17 = new AppItem(u,u.searchWardrobe("Home Closet"), "item seventeen", "");
		
		item1.addTag(" green holidays awesome");
		
		
		
		for (String s : item1.getTags())
			System.out.println(s);
		//u.addItem(item1);
		
		System.out.println(u.search("shi"));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Saver saved = new Saver("Sohum");
//		AppUser user = (AppUser) saved.getUser();
//		
//		  user.addWardrobe("away", WardrobeType.CLOSET);
//		  user.addWardrobe("herenorthere",WardrobeType.CLOSET);
//		  AppItem redShirt = new AppItem(user, user.searchWardrobe("away"), "redShirt", null);
//		  
//		  redShirt.addTag("red"); redShirt.addTag("shirt");
//		  redShirt.addTag("fits like a condom");
//		  
//		  AppItem blueShirt = new AppItem(user, user.searchWardrobe("away"), "blueShirt", null);
//		  
//		  blueShirt.addTag("blue"); blueShirt.addTag("shirt");
//		  blueShirt.addTag("fits like a sack");
//		  
//		  AppItem greenShirt = new AppItem(user, user.searchWardrobe("away"), "greenShirt", null);
//		  
//		  greenShirt.addTag("green"); greenShirt.addTag("shirt");
//		  greenShirt.addTag("fits like a glove");
//		  
//		  AppItem redShirt2 = new AppItem(user, user.searchWardrobe("away"), "redShirt2", null);
//		  
//		  redShirt2.addTag("red"); redShirt2.addTag("shirt");
//		  redShirt2.addTag("fits like a glove");
//		  
//		  user.addItem("redShirt", "away", "red", "red", null, new ArrayList<String>() );
//		  
//
//		String toSearch = " red shirt fits like a glove";
//
//		ArrayList<Item> result = (ArrayList<Item>) user.search(toSearch);
//
//		System.out.println(result.size());
//
//		for (int i = 0; i < result.size(); i++) {
//			System.out.println(result.get(i).getName());
//		}
//
//		saved.saveData();
	}
}
