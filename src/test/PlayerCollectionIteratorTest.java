package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.players.GamePlayer;
import model.players.PlayerCollectionIterator;
import model.players.Striker;

public class PlayerCollectionIteratorTest {

	@Test
	public void test() {
		List<GamePlayer> temp = new ArrayList<GamePlayer>();
		GamePlayer p1 = new Striker("Striker", Color.BLUE);
		GamePlayer p2 = new Striker("Goalkeeper", Color.YELLOW);
		temp.add(p1); temp.add(p2);
		
		PlayerCollectionIterator temp1 = new PlayerCollectionIterator(temp);
		
		assertEquals(temp1.hasNext(), true);
		assertEquals(temp.get(0), temp1.next());
		assertEquals(temp1.hasNext(), true);
		assertEquals(temp.get(1), temp1.next());
		assertEquals(temp1.hasNext(), false);
	}
}
