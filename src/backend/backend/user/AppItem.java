package backend.user;

import java.awt.Color;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import backend.interfaces.Item;
import backend.interfaces.Outfit;
import backend.interfaces.Wardrobe;

public class AppItem implements Item, Serializable {
	
	private Integer score = 0;
	String name;
	HashSet<String> tags = new HashSet<String>();
	String imagePath;
	
	public AppItem(String name, String imagePath){
		this.name = name;
		this.imagePath = imagePath;
		
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public HashSet<String> getTags() {
		return this.tags;
	}

	@Override
	public Color whichColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTag(String newTag) {
		
		this.tags.add(newTag);
		
		//SO FAR THIS METHOD DOES NOT UPDATE THE USERS TAGS MAP WHEN A NEW TAG IS ADDED TO THE ITEM! NEED TO FIX THIS...
		
	}

	@Override
	public void removeTag(String tagToRemove) {
		
		this.tags.remove(tagToRemove);
	}

	@Override
	public Wardrobe whichWardrobe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Outfit> whichOutfits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void moveItem(Wardrobe destination) {
		
		destination.addItem(this);
		
	}

	
	//HAVE RESET IMAGE FUNCTION TOOO
	@Override
	public String getImagePath() {
		return this.imagePath;
	}

	@Override
	public void resetScore() {
		this.score = 0;
		
	}

	@Override
	public void incrementScore() {
		this.score +=1;
		
	}

	@Override
	public Integer getScore() {
		
		return this.score;
	}

	@Override
	public int compareTo(Object that) {
		return -1*this.score.compareTo(((Item) that).getScore());
	}

}
