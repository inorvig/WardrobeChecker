package app.backend.autosuggest;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import app.backend.interfaces.Item;

public class Autosuggest implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6889241739311488761L;
	Trie trie;
	//HashMap<String, Integer> unigram;
	//HashMap<String, Integer> bigram;
	Prefix prefix;
	Whitespace whitespace;
	LED led;
	HashSet<String> alltags;
	HashMap<String, HashSet<Item>> tagsMap;
	
	public Autosuggest(HashMap<String, HashSet<Item>> usertagsmap){
		
		this.tagsMap = usertagsmap;
		
		//initialize prefix matching
		this.trie = new Trie();
		this.prefix = new Prefix(trie);
		prefix.turnOnFeature();
		
		//initialize led matching
		this.led = new LED(alltags);
		led.turnOnFeature();
		led.inputDistance(1);
		this.alltags = new HashSet<String>();
		
		//initialize whitespace matching
		this.whitespace = new Whitespace(alltags);
		whitespace.turnOnFeature();
	}
	
	/**
	 * useful when tag is added after setup is done
	 * @param tag
	 */
	public void addTag(String tag){
		this.trie.insert(tag);
		this.alltags.add(tag);
		
	}
	
	/**
	 * retrieve past stored tags and initialize prefix and led matching
	 * @param tagsMap
	 */
	public void setUp(){
			
		Set<String> usersTags = tagsMap.keySet();
		
		for (String tag:usersTags){
			trie.insert(tag);
			
		}
		
		alltags.addAll(usersTags);
		
	}
	
	
	public Set<String> lookup(String query){
		
		HashSet<Item> toReturn = new HashSet<Item>();
		
		Set<String> matchingTags = new HashSet<String>();

		
		String queryWords = query.trim();
		
		String[] queryArray = query.split(" ");
		
		if (queryArray.length >=1){
			for (int i=0; i < queryArray.length; i++){
				String word = queryArray[i];
				
				//get prefix, led and whitespace results
				prefix.resultSet(matchingTags, word);
				led.resultSet(matchingTags, word);
				whitespace.resultSet(matchingTags, word);

			}
		}

		
		return matchingTags;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//USE SUFFIX TREES for search
	
	
	
	
	
	
	
	
	
	
//	public void setUp(Set<String> tags, ArrayList<Item> allItems){
//		
//		for (Item item : allItems){
//			String itemName = item.getName();
//			
//			trie.insert(itemName);
//			
//			splitForParts(itemName);
//		}
//		
//		for (String tag: tags){
//			trie.insert(tag);
//			
//			splitForParts(tag);
//		}
//	}
//	
//	public void splitForParts(String entry){
//		
//		String name = entry.trim();
//		
//		String[] nameArray = name.split(" ");
//		
//		if (nameArray.length > 1){
//			
//			for (int i=0; i< nameArray.length; i++){
//				String part = nameArray[i];
//				
//				if (unigram.containsKey(part))
//					unigram.put(part, unigram.get(part)+1);
//				else unigram.put(part, 1);
//				
//				if (i+1 < nameArray.length){
//					String part2 = nameArray[i+1];
//					
//					String bi = part + " " + part2;
//					
//					if (bigram.containsKey(bi))
//						bigram.put(part, bigram.get(bi)+1);
//					else bigram.put(bi, 1);
//					
//				}
//			}
//		}
//	}
}
