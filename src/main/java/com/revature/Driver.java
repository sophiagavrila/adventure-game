package com.revature;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import com.revature.Location;

public class Driver {

	private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * This is a console based "Adventure Game" in which the User will begin 
		 * in room zero and be presented with a list of possible exits.
		 * 
		 * The logic of this game is designed so that the user can enter commands like
		 * "run south" and the program will parse the "S" from south, thus
		 * moving the user to another room and presenting them with the respective exits.
		 * 
		 * Your job is to migrate this application from a console based application
		 * to one in which the user is capable 
		 */

		Map<String, Integer> tempExit = new HashMap<String, Integer>();

		locations.put(0, new Location(0, "You are sitting in front of a computer learning Java\n", tempExit));

		// Room 1
		tempExit = new HashMap<String, Integer>();
		tempExit.put("W", 2);
		tempExit.put("E", 3);
		tempExit.put("S", 4);
		tempExit.put("N", 5);
		locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExit)); // 4 exits: N, E, S, W

		// Room 2
		tempExit = new HashMap<String, Integer>();
		tempExit.put("N", 5);
		locations.put(2, new Location(2, "You are at the top of a hill", tempExit)); // 1 exit: N

		// Room 3
		tempExit = new HashMap<String, Integer>();
		tempExit.put("W", 1);
		locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit)); // 1 exit: W

		// Room 4
		tempExit = new HashMap<String, Integer>();
		tempExit.put("N", 1);
		tempExit.put("W", 2);
		locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit)); // 2 exits: N, W
		

		// Room 5
		tempExit = new HashMap<String, Integer>();
		tempExit.put("S", 1);
		tempExit.put("W", 2);
		locations.put(5, new Location(5, "You are in the forest", tempExit)); // 2 exits: S, W

		commandPrompt();

	}

	public static void commandPrompt() {

		// Map for Directions to read from input
		Map<String, String> vocab = new HashMap<String, String>();
		vocab.put("NORTH", "N");
		vocab.put("SOUTH", "S");
		vocab.put("EAST", "E");
		vocab.put("WEST", "W");
		vocab.put("QUIT", "Q");

		int loc = 1;

		while (true) {

			// Current room that you're in
			System.out.println(locations.get(loc).getDescription());
			if (loc == 0) {
				break;
			}

			// all available exits of current location
			Map<String, Integer> exits = locations.get(loc).getExits();

			System.out.println("Available exits are:");

			/*
			 * This method takes in a map and returns each key with a comma after it, except
			 * for the last one. Yes, it may seem simple, but determining the last element
			 * of a HashMap requires additional logic.
			 */
			printAndFormatKeySet(exits);

			System.out.println("Where would you like to go?");

			// Take user input, clean special chars
			String direction = scanner.nextLine().replaceAll("[^a-zA-Z0-9\\s]", "");
			direction = direction.toUpperCase();

			// Check if input is greater than one letter
			if (direction.length() > 1) {
				String[] words = direction.split(" ");
				/*
				 * Isolate individual words throughout the array and return that letter if the
				 * key exists in the map.
				 */
				for (String w : words) {
					if (vocab.containsKey(w)) {
						direction = vocab.get(w);
						break;
					}
				}
			}

			// Check the exit array
			if (exits.containsKey(direction)) {
				loc = exits.get(direction);

			} else {
				// Warn the user in the case they enter an unavailable direction
				System.out.println("You cannot go in that direction.");
			}
		}

		scanner.close();
	}

	/*
	 * A method that coverts a HashMap into a LinkedHashMap (to maintain order), and
	 * then converts the LinkedHashMap into a Set (in order to grab an iterator).
	 * 
	 * The point of doing all of this is so that the iterator can capture the last
	 * element within the keyset so that we can format the values nicely.
	 */
	public static void printAndFormatKeySet(Map<String, Integer> map) {

		Map<String, Integer> orderedExits = new LinkedHashMap<String, Integer>(map);

		Set<String> keySet = orderedExits.keySet();

		// Get iterator for the keySet
		Iterator<String> iterator = keySet.iterator();

		String entry = null, firstEntry = null, lastEntry = null;

		// Iterate through the entries to determine the last entry.
		while (iterator.hasNext()) {

			entry = iterator.next();

			if (firstEntry == null) {
				firstEntry = entry;
			}

			lastEntry = entry;

		}

		/*
		 * The above code was only necessary for this,
		 * printing each exit + ", " except for last element.
		 */
		for (String e : keySet) {
			if (e != lastEntry) {
				System.out.print(e + ", ");
			} else {
				System.out.print(e);
			}
		}

		System.out.println("\n");

	}

}
