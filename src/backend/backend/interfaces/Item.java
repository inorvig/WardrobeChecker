package backend.interfaces;

import java.awt.Color;
import java.util.Collection;
import java.util.HashSet;

public interface Item extends Comparable{

	public String getName();

	public HashSet<String> getTags();

	public Color whichColor();

	public void addTag(String newTag);

	public void removeTag(String tagToRemove);

	public Wardrobe whichWardrobe();

	public Collection<Outfit> whichOutfits();

	public void moveItem(Wardrobe destination);
	
	public String getImagePath();
	
	public Integer getScore();
	
	public void incrementScore();
	
	public void resetScore();
}
