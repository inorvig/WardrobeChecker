package app.backend.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import app.backend.interfaces.Item;
import app.backend.interfaces.Savable;
import app.backend.interfaces.User;

public class Saver implements Savable {

	private AppUser user;
	private String name;

	public Saver(String name) {
		this.name = name;
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
				user = new AppUser(name);
				
			} catch (ClassNotFoundException e) {
				System.out.println("ERROR: Not an AppUser file");
				user = new AppUser(name);
			}
		} else {
			user = new AppUser(name);
		}
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public void saveData() {
		try {
			FileOutputStream fileOut = new FileOutputStream(name + ".ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(user);
			out.close();
			fileOut.close();
			System.out.println("saved");
		} catch (IOException e) {
			System.out.println("ERROR: while saving data: " + e.getMessage());
		}

	}

}
