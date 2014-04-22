package backend.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import backend.interfaces.Item;
import backend.interfaces.User;

public class Saver{

	private AppUser user;
	private String name;
	
	public Saver(String name){
		this.name = name;
		File savedData = new File(name + ".ser");
		if (savedData.exists()){
			try{
				FileInputStream fileIn = new FileInputStream(name + ".ser");
				ObjectInputStream in = new ObjectInputStream (fileIn);
				user = (AppUser) in.readObject();
				in.close();
				fileIn.close();
			}
			catch (IOException e){
				System.out.println("ERROR: error while reading input file of saved data");
			}
			catch (ClassNotFoundException e){
				System.out.println("ERROR: Not an AppUser file");
			}
		}
		else{
			user = new AppUser(name);
		}
	}
	
	public User getUser(){
		return (User) user;
	}
	
	public void saveData(){
		try{
			FileOutputStream fileOut = new FileOutputStream(name+ ".ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(user);
			out.close();
			fileOut.close();
		}
		catch (IOException e){
			System.out.println("ERROR: while saving data");
		}
	}
	
	public static void main(String[] args){
		Saver saved = new Saver("Sohum");
		User user = saved.getUser();
		
	/*	AppItem redShirt = new AppItem("redShirt", null);
		
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
		
		user.addItem((Item) redShirt);
		user.addItem((Item) blueShirt);
		user.addItem((Item) greenShirt);
		user.addItem((Item) redShirt2);
		
		*/
		
		String[] toSearch = new String[]{"red", "shirt", "fits like a glove"};
		

		ArrayList<Item> result = (ArrayList<Item>) user.search(toSearch);
		
		System.out.println(result.size());
		
		for (int i=0; i<result.size();i++){
			System.out.println(result.get(i).getName());
		}
		
		saved.saveData();
	}
}
