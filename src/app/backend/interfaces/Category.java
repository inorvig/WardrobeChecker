package app.backend.interfaces;

import java.util.Collection;

public interface Category {
	
	public String getName();
	
	public String getImagePath();

	public Collection<Item> getItems();
}
