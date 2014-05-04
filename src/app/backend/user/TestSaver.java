package app.backend.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import app.backend.interfaces.Item;
import app.backend.interfaces.Savable;
import app.backend.interfaces.User;
import app.backend.user.AppWardrobe.WardrobeType;

public class TestSaver implements Savable {

	private User user;
	private String name;
	
	public TestSaver(String name){
		this.user = new AppUser("testing");
		File savedData = new File(name + ".ser");
		if (savedData.exists()) {
			try {
				FileInputStream fileIn = new FileInputStream(name + ".ser");
				ObjectInputStream in = new ObjectInputStream(fileIn);
				user = (AppUser) in.readObject();
				in.close();
				fileIn.close();
			} catch (IOException e) {
				System.out.println("ERROR: error while reading input file of saved data: "
								+ e.getMessage());
				System.out.println("making a new user");
				user = new AppUser(name);
				
			} catch (ClassNotFoundException e) {
				System.out.println("ERROR: Not an AppUser file");
				System.out.println("making a new user");
				user = new AppUser(name);
			}
		} else {
			user = new AppUser(name);
			user.addWardrobe("other closet", WardrobeType.CLOSET);
			user.addCategory("shirts");
			user.addCategory("dresses");
			user.addCategory("shoes");
			user.addCategory("skirts");
			user.addCategory("pants");
			user.addCategory("sweaters");
		}
	}
	@Override
	public User getUser() {
		return user;
	}

	@Override
	public void saveData() {

	}

}
