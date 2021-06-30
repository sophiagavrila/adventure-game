package com.revature;

import java.util.HashMap;
import java.util.Map;

/*
 * Location is a fully immutable class so that third party plugins
 * cannot modify the Location instances of their maps. 
 */
public final class Location {

	private final int locationId;
	private final String description;
	protected  Map<String, Integer> exits;

	public Location(int locationId, String description, Map<String, Integer> exits) {
		super();
		this.locationId = locationId;
		this.description = description;
		
		// The program will crash at runtime if we pass a null Map into the constructor,
		// Hence, we provide a check for whether exits is null or not.
		this.exits = (exits !=null) ? new HashMap<String, Integer>(exits) : new HashMap<String, Integer>();
		this.exits.put("Q", 0);

	}

	public Map<String, Integer> getExits() {
		
		return new HashMap<String, Integer>(exits);
		
		/*
		 * Instead of returning the real exits Map, we are creating a new HashMap
		 * The reason we're doing this is so that the calling program
		 * can't actually effect the real exits Map (we're creating a copy of references
		 * that point to the objects in the original Map)
		 * 
		 * When you call getExits(), it will be an immutable object,
		 * but you can still access all of the date within the HashMap returned
		 * (This data is, of course, references to the key-value pairs/EXITS)
		 * 
		 */
	}
	
	public int getLocationId() {
		return locationId;
	}

	public String getDescription() {
		return description;
	}

}
