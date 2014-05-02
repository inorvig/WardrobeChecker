/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.backend.autosuggest;

import java.util.*;

/**
 * interface of three features (prefix, led, whitespace). Interface designs
 * these methods to be abstracted, and (potentially) more features to be added
 * 
 * @author sohumchatterjee
 */
public interface Feature {
	public void turnOnFeature(); // turns on functionality of feature

	public void resultSet(TreeSet<String> resultList, String word); // method is
																	// passed in
																	// a set and
																	// a word
																	// and using
																	// feature,
																	// returns
																	// the set
																	// with
																	// additions
}
