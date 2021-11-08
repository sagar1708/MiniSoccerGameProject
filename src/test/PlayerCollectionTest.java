package test;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.players.GamePlayer;
import model.players.Goalkeeper;
import model.players.PlayerCollection;
import model.players.Striker;

public class PlayerCollectionTest {

	@Test
	public void addTest() {
		List<GamePlayer> temp = new ArrayList<GamePlayer>();
		GamePlayer p1 = new Striker("Striker", Color.BLUE);
		temp.add(p1);
		
		assertEquals(1, temp.size());
	}
	
	@Test
	public void getTest() {
		PlayerCollection temp = new PlayerCollection();
		GamePlayer p1 = new Striker("Striker", Color.BLUE);
		GamePlayer p2 = new Goalkeeper("Goalkeeper", Color.YELLOW);
		temp.add(p1); temp.add(p2);
		
		assertEquals(p1, temp.get("Striker"));
		assertEquals(p2, temp.get("Goalkeeper"));
		assertEquals(null, temp.get(""));
	}

}
