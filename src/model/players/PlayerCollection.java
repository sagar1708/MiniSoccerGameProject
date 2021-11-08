package model.players;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class PlayerCollection implements Iterable<GamePlayer>{
	private List<GamePlayer> temp;
	
	/**
	 * Constructor method
	 */
	public PlayerCollection() {
		temp = new ArrayList<GamePlayer>();
	}
	
	/**
	 * Adds a player to the collection
	 * @param player to be added to the collection
	 */
	public void add(GamePlayer player) {
		temp.add(player);
	}

	/**
	 * Getter method to get player by name
	 * @param string is the name of the player
	 * @return a GamePlayer whose name attribute is the same as string
	 */
	public GamePlayer get(String string) {
		int counter = 0;
		while(counter < temp.size()) {
			if (temp.get(counter).getPlayerName().equals(string)) {
				return temp.get(counter);
			}
			counter++;
		}
		return null;
	}
	
	public void sort() {}

	public Iterator iterator() {		
		if (temp.size() != 0) {
			return new PlayerCollectionIterator(temp);
		}
		return null;
	}
}