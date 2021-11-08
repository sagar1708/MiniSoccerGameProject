package test;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;
import java.awt.Point;

import org.junit.jupiter.api.Test;

import model.players.GamePlayer;
import model.players.Goalkeeper;
import model.players.Striker;

public class GamePlayerTest {

	@Test
	public void gpTest() {
		GamePlayer p1 = new Striker("Striker", Color.BLUE);
		assertEquals("Striker", p1.getPlayerName());
		assertEquals(Color.BLUE, p1.getPlayerColor());
		assertEquals(0, p1.getPlayerStatistics());
		
		GamePlayer p2 = new Goalkeeper("Goalkeeper", Color.YELLOW);
		assertEquals("Goalkeeper", p2.getPlayerName());
		assertEquals(Color.YELLOW, p2.getPlayerColor());
		assertEquals(0, p2.getPlayerStatistics());
	}
	
	@Test
	public void isPlayedHasBallTest() {
		GamePlayer p1 = new Striker("Striker", Color.BLUE);
		p1.setPlayerStatistics(1);
		assertTrue(p1.isPlayerHasBall());
		
		GamePlayer p2 = new Goalkeeper("Goalkeeper", Color.BLUE);
		p2.setPlayerStatistics(1);
		assertFalse(p2.isPlayerHasBall());
		assertTrue(p1.isPlayerHasBall());
	}
	
	@Test
	public void movementTest() {
		GamePlayer p1 = new Striker("Striker", Color.BLUE);
		p1.setInitialPosition();
		Point initial = p1.getPlayerPosition();
		p1.moveUp(); p1.moveLeft(); p1.moveDown(); p1.moveRight();
		assertEquals(initial, p1.getPlayerPosition());
		
		GamePlayer p2 = new Goalkeeper("Goalkeeper", Color.BLUE);
		p2.setInitialPosition();
		Point init = p2.getPlayerPosition();
		p2.moveUp(); p2.moveLeft(); p2.moveDown(); p2.moveRight();
		assertEquals(init, p2.getPlayerPosition());
	}
	
	@Test
	public void compareToTest() {
		GamePlayer p1 = new Striker("Striker", Color.BLUE);
		GamePlayer p2 = new Goalkeeper("Goalkeeper", Color.BLUE);
		
		p1.setPlayerStatistics(2);
		p2.setPlayerStatistics(3);
		
		assertEquals(-1, p1.getPlayerStatistics().compareTo(p2.getPlayerStatistics()));
	}

}
