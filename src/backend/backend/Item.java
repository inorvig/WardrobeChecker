package backend;

public interface Item{

	public String getName();

	public Collection<String> getTags();

	public Color whichColor();

	public void addTag(String newTag);

	public String removeTag(String tagToRemove);

	public Wardrobe whichWardrobe();

	public Collection<Outfit> whichOutfits();

	public void moveItem(Wardrobe destination);
}