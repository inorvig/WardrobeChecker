package app.backend.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import app.backend.interfaces.Category;
import app.backend.interfaces.Item;
import app.backend.interfaces.User;
import app.backend.user.AppWardrobe.WardrobeType;

public class TestingScript {

	public static void main(String[] args) {
		
		
		Saver saved = new Saver("TestOwner");
		AppUser u = (AppUser) saved.getUser();
		System.out.println(u.howManyWardrobes());
		
		
		AppCategory shirts = new AppCategory("shirts", new HashSet<Item>());
		AppCategory pants = new AppCategory("pants", new HashSet<Item>());
		AppCategory dresses = new AppCategory("dresses", new HashSet<Item>());
		AppCategory socks = new AppCategory("socks", new HashSet<Item>());
		AppCategory jackets = new AppCategory("jackets", new HashSet<Item>());
		
		
		AppItem item1 = new AppItem(u,u.searchWardrobe("Home Closet"),shirts, "item one", "images/clothes/greenshirt.jpg");
		AppItem item2 = new AppItem(u,u.searchWardrobe("Home Closet"),shirts, "item two", "images/clothes/yellowshity.jpg");
		AppItem item3 = new AppItem(u,u.searchWardrobe("Home Closet"), pants,  "item three", "images/clothes/greenpants.jpg");
		AppItem item4 = new AppItem(u,u.searchWardrobe("Home Closet"), shirts, "item four", "images/clothes/shitshirt.jpg");
		AppItem item5 = new AppItem(u,u.searchWardrobe("Home Closet"), pants, "item five", "images/clothes/100pants.jpg");
		
		u.addWardrobe("Travel Bag One", WardrobeType.SUITCASE); 
		
		AppItem item6 = new AppItem(u,u.searchWardrobe("Travel Bag One"), socks, "item six", "images/clothes/socks.jpg");
		AppItem item7 = new AppItem(u,u.searchWardrobe("Travel Bag One"), jackets, "item seven", "images/clothes/suit.jpg");
		AppItem item8 = new AppItem(u,u.searchWardrobe("Travel Bag One"), jackets, "item eight", "images/clothes/jacket.jpg");
		AppItem item9 = new AppItem(u,u.searchWardrobe("Travel Bag One"), shirts,"item nine", "images/clothes/greenshirt2.jpg");
		AppItem item10 = new AppItem(u,u.searchWardrobe("Travel Bag One"), dresses, "item ten", "images/clothes/kimparty.jpg");
		AppItem item11 = new AppItem(u,u.searchWardrobe("Travel Bag One"), dresses, "item ten", "images/clothes/kimbridal.jpg");
		
//		AppItem item12 = new AppItem(u,u.searchWardrobe("Home Closet"), "item twelve", "");
//		AppItem item13 = new AppItem(u,u.searchWardrobe("Home Closet"), "item thirteen", "");
//		AppItem item14 = new AppItem(u,u.searchWardrobe("Home Closet"), "item fourteen", "");
//		AppItem item15 = new AppItem(u,u.searchWardrobe("Home Closet"), "item fifteen", "");
//		AppItem item16 = new AppItem(u,u.searchWardrobe("Home Closet"), "item sixteen", "");
//		AppItem item17 = new AppItem(u,u.searchWardrobe("Home Closet"), "item seventeen", "");
		
		item1.addTag("shirt green holidays awesome");
		item2.addTag("shirt yellow hilidays bad");
		item3.addTag("pants green holidays awe");
		item4.addTag("shit shirt i don't want!!!!!!!!!!");
		item5.addTag("size 100 pants");
		
		item6.addTag("socks with slippers");
		item7.addTag("suit for meetings");
		item8.addTag("jacket mom gave me");
		item9.addTag("shirt green holidays awesome");
		item10.addTag("kim's party dress");
		item11.addTag("bridal dress from kim");
		
		
		
//		for (String s : item1.getTags())
//			System.out.println(s);
		
		u.addItem(item1);
		u.addItem(item2);
		u.addItem(item3);
		u.addItem(item4);
		u.addItem(item5);
		u.addItem(item6);
		u.addItem(item7);
		u.addItem(item8);
		u.addItem(item9);
		u.addItem(item10);
		u.addItem(item11);

		u.addItem("duPlIcate%%%%%", "Home Closet" , "dresses", "", "images/clothes/duplicate.jpg", new ArrayList<String>());
		u.addItem("duPlIcate%%%%%", "Home Closet" , "dresses", "", "images/clothes/duplicate.jpg", new ArrayList<String>());
		
		ArrayList<Item> r = u.search("100  ");
		
		System.out.println(r.size());
		
		
		
		for (int i = 0; i<r.size();i++){
			System.out.println( "<< "+ i + " >> ---" + r.get(i).getName() );
		}
		
		
		
		ArrayList<Item> r2 = u.search("");
		
		System.out.println(r2.size());
	
		System.out.println("------------------2---------------");
		for (int i = 0; i<r2.size();i++){
			System.out.println( "<< "+ i + " >> ---" + r2.get(i).getName() );
		}
		
		
		ArrayList<Item> r3 = u.search("duplicate");
		
		System.out.println(r3.size());

		System.out.println("------------------3---------------");
		for (int i = 0; i<r3.size();i++){
			System.out.println( "<< "+ i + " >> ---" + r3.get(i).getName() );
		}
		System.out.println(item10.getTags().isEmpty());
		for (String s: item10.getTags()){
			System.out.println(item10.getTags().isEmpty());
			System.out.println(s);
		}
		
		
		saved.saveData();
		
		
		
		
		
		
		
		
		
		
		
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
