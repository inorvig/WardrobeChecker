package app.backend.interfaces;

public interface Savable {

	// Gets a specified user; either creates a new User object, or reads a User
	// from file
	public User getUser();

	// Should be called at the end of a working session to maintain all the data
	public void saveData();
}
