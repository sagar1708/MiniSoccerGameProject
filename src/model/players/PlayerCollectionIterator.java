package model.players;

import java.util.Iterator;
import java.util.List;

public class PlayerCollectionIterator implements Iterator<GamePlayer> {
	
	private List<GamePlayer> temp;
	private int position = 0;

	public PlayerCollectionIterator(List<GamePlayer> temp) {
		this.temp = temp;
	}

	public GamePlayer next() {
		GamePlayer z = temp.get(position);
		position++;
		return z;
	}
	
	public boolean hasNext() {
		if (temp.size() <= position) {
			return false;
		}
		return true;
	}
}