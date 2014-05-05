package app.backend.interfaces;

import java.util.Collection;

public interface Category {

	public String getName();

	public String getImagePath();
	
	public void setImagePath(String imagePath);

	public Collection<Item> getItems();
	
	public Collection<Item> getItemsinWardrobe(Wardrobe wardrobe);
}
