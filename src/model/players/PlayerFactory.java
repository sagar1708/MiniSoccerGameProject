package model.players;

import java.awt.Color;

public class PlayerFactory {

	/**
	 * Uses the factory method to create players
	 * @param string is the name of the player
	 * @return the player desired
	 */
	public GamePlayer getPlayer(String string) {
		if (string.equals("Striker")) {
			return new Striker("Striker", Color.BLUE);
		}
		else if (string.equals("Goalkeeper")) {
			return new Goalkeeper("Goalkeeper", Color.YELLOW);
		}
		return null;
	}
}