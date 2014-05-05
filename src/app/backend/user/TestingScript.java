package app.backend.user;

import java.util.ArrayList;
import java.util.Collection;

import app.backend.interfaces.Item;
import app.backend.interfaces.User;
import app.backend.user.AppWardrobe.WardrobeType;

public class TestingScript {

	public static void main(String[] args) {
		
		
		Saver saved = new Saver("TestOwner");
		AppUser u = (AppUser) saved.getUser();
		System.out.println(u.howManyWardrobes());
		
		
		
		AppItem item1 = new AppItem(u,u.searchWardrobe("Home Closet"), "item one", "");
		AppItem item2 = new AppItem(u,u.searchWardrobe("Home Closet"), "item two", "");
		AppItem item3 = new AppItem(u,u.searchWardrobe("Home Closet"), "item three", "");
		AppItem item4 = new AppItem(u,u.searchWardrobe("Home Closet"), "item four", "");
		AppItem item5 = new AppItem(u,u.searchWardrobe("Home Closet"), "item five", "");
		
		u.addWardrobe("Travel Bag One", WardrobeType.SUITCASE); 
		
		AppItem item6 = new AppItem(u,u.searchWardrobe("Travel Bag One"), "item six", "");
		AppItem item7 = new AppItem(u,u.searchWardrobe("Travel Bag One"), "item seven", "");
		AppItem item8 = new AppItem(u,u.searchWardrobe("Travel Bag One"), "item eight", "");
		AppItem item9 = new AppItem(u,u.searchWardrobe("Travel Bag One"), "item nine", "");
		AppItem item10 = new AppItem(u,u.searchWardrobe("Travel Bag One"), "item ten", "");
		AppItem item11 = new AppItem(u,u.searchWardrobe("Travel Bag One"), "item ten", "");
		
		AppItem item12 = new AppItem(u,u.searchWardrobe("Home Closet"), "item twelve", "");
		AppItem item13 = new AppItem(u,u.searchWardrobe("Home Closet"), "item thirteen", "");
		AppItem item14 = new AppItem(u,u.searchWardrobe("Home Closet"), "item fourteen", "");
		AppItem item15 = new AppItem(u,u.searchWardrobe("Home Closet"), "item fifteen", "");
		AppItem item16 = new AppItem(u,u.searchWardrobe("Home Closet"), "item sixteen", "");
		AppItem item17 = new AppItem(u,u.searchWardrobe("Home Closet"), "item seventeen", "");
		
		item1.addTag("shirt green holidays awesome");
		item2.addTag("shirt blue hilidays bad");
		item3.addTag("pants green holidays awe");
		item4.addTag("shit shirt i don't want");
		item5.addTag("size 100 pants that belong to your mom");
		
		item6.addTag("socks with slippers");
		item7.addTag("suit for meetings");
		item8.addTag("my mom does not need to know this exists");
		item9.addTag("shirt green holidays awesome");
		item10.addTag("");
		item11.addTag("");
		
		
		
//		for (String s : item1.getTags())
//			System.out.println(s);
		
		u.addItem(item1);
		u.addItem(item2);
		u.addItem(item3);
		u.addItem(item4);
		u.addItem(item5);
		
		ArrayList<Item> r = u.search("100  ");
		
		System.out.println(r.size());
		
		
		
		for (int i = 0; i<r.size();i++){
			System.out.println( "<< "+ i + " >> ---" + r.get(i).getName() );
		}
		
		
		
		ArrayList<Item> r2 = u.search("");
		
		System.out.println(r2.size());
		
		//saved.saveData();
		System.out.println("------------------2---------------");
		for (int i = 0; i<r2.size();i++){
			System.out.println( "<< "+ i + " >> ---" + r2.get(i).getName() );
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
