package app.backend.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import app.backend.cv.ColorDetecting;
import app.backend.cv.ColorDetector;
import app.backend.interfaces.TagSuggesting;

public class StubTagger implements TagSuggesting, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2952969293913228384L;

	@Override
	public Collection<String> suggestTags(String imagePath) {
		Collection<String> result = new ArrayList<String>();
		result.add("Jeans");
		result.add("Blue");
		return result;
	}
	
	public String suggestColor(String imagePath){
		ColorDetecting detector = new ColorDetector();
		return detector.getObjectColor(imagePath);
	}

}
