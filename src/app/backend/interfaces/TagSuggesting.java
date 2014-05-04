package app.backend.interfaces;

import java.util.Collection;

public interface TagSuggesting {

	Collection<String> suggestTags(String imagePath);
}
