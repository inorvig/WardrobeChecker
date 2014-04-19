package backend; 

public interface User{

	public Collection<Wardrobe> getWardrobes();

	public int howManyWardrobes();

	public Collection<Outfit> getOutfits();

	public int howManyOutfits();

	public void addItem(Item item);

	public void saveOutfit(Outfit outfit);

	public Item removeItem();

	public Collection<Outfit> search(Collection<String> searchTerms);

}
