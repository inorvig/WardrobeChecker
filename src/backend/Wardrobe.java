public interface Wardrobe{

	public String getName();

	public Collection<Item> getItems();

	public void addItem(Item toAdd);

	public Item removeItem();
}