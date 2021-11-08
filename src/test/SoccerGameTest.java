package test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import model.SoccerBall;
import model.SoccerGame;
import model.players.Goalkeeper;
import model.players.Striker;

public class SoccerGameTest {

	@Test
	public void TimeRemainingTest() {
		SoccerGame g1 = new SoccerGame();
		Integer x = (int) Math.random() * 60;
		g1.setTimeRemaining(x);
		assertEquals(x, g1.getTimeRemaining());
		
		SoccerGame g2 = new SoccerGame();
		Integer y = 60;
		assertEquals(y, g2.getTimeRemaining());	
	}
	
	@Test
	public void GoalTest() {
		SoccerGame g1 = new SoccerGame();
		Integer zero = 0;
		assertEquals(zero, g1.getGoal());
		
		SoccerGame g2 = new SoccerGame();
		Integer random = (int) (Math.random() * 10);
		g2.setGoal(random);
		assertEquals(random, g2.getGoal());
	}
	
	@Test
	public void PausedTest() {
		SoccerGame g1 = new SoccerGame();
		assertEquals(false, g1.isPaused());
		
		SoccerGame g2 = new SoccerGame();
		g2.setPaused(true);
		assertEquals(true, g2.isPaused());
	}
	
	@Test
	public void OverTest() {
		SoccerGame g1 = new SoccerGame();
		assertEquals(false, g1.isOver());
		
		SoccerGame g2 = new SoccerGame();
		g2.setOver(true);
		assertEquals(true, g2.isOver());
	}
	
	@Test
	public void automateGoalkeeperTest() {
		SoccerGame game = new SoccerGame();
		Goalkeeper gk = (Goalkeeper) game.getGamePlayers().get("Goalkeeper");
		gk.setInitialPosition();
		Point temp = gk.getPlayerPosition();
		
		SoccerBall.getSoccerBall().setPosition(new Point (70,70));
		game.automateGoalkeeper();
		assertTrue(gk.getPlayerStatistics() > 0);
		
		SoccerBall.getSoccerBall().setPosition(new Point (80, 400));
		game.automateGoalkeeper();
		assertFalse(temp.x == gk.getPlayerPosition().x);
	}
	
	@Test
	public void isScoredTest() {
		SoccerGame game = new SoccerGame();
		Striker s = (Striker) game.getGamePlayers().get("Striker");
		Goalkeeper g = (Goalkeeper) game.getGamePlayers().get("Goalkeeper");
		SoccerBall.getSoccerBall().setPosition(new Point (292, 38));
		s.setPlayerStatistics(1);
		g.setPlayerStatistics(1);
		
		assertEquals(true, game.isScored());
		assertTrue(1 == g.getPlayerStatistics());
	}
	
	@Test
	public void getActivePlayerTest() {
		SoccerGame game = new SoccerGame();
		Striker s = (Striker) game.getActivePlayer();
		assertEquals("Striker", s.getPlayerName());
	}
}