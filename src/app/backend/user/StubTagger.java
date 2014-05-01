package app.backend.user;

import java.util.ArrayList;
import java.util.Collection;

import app.backend.interfaces.TagSuggesting;

public class StubTagger implements TagSuggesting {

	@Override
	public Collection<String> suggestTags(String imagePath) {
		Collection<String> result = new ArrayList<String>();
		result.add("Jeans");
		result.add("Blue");
		return result;
	}

}
