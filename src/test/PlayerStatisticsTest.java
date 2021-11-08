package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.players.GamePlayer;
import model.players.PlayerFactory;

public class PlayerStatisticsTest {

	@Test
	public void StatisticsTest() {
		List<GamePlayer> temp = new ArrayList<GamePlayer>();
		GamePlayer p1 = new PlayerFactory().getPlayer("Striker");
		GamePlayer p2 = new PlayerFactory().getPlayer("Goalkeeper");
		temp.add(p1); temp.add(p2);
		
		assertEquals(temp.get(0).getPlayerStatistics(), 0);
		assertEquals(temp.get(1).getPlayerStatistics(), 0);
		
		p1.setPlayerStatistics(1);
		assertEquals(temp.get(0).getPlayerStatistics(), 1);
		
		p2.setPlayerStatistics(1);
		assertEquals(temp.get(1).getPlayerStatistics(), 1);	
	}
	
	@Test
	public void toStringTest() {
		List<GamePlayer> temp = new ArrayList<GamePlayer>();
		GamePlayer p1 = new PlayerFactory().getPlayer("Striker");
		GamePlayer p2 = new PlayerFactory().getPlayer("Goalkeeper");
		temp.add(p1); temp.add(p2);
		
		assertEquals(temp.get(0).getPlayerStatistics().toString(), "0");
		assertEquals(temp.get(1).getPlayerStatistics().toString(), "0");
		
		p1.setPlayerStatistics(1);
		assertEquals(temp.get(0).getPlayerStatistics().toString(), "1");
		
		p2.setPlayerStatistics(1);
		assertEquals(temp.get(1).getPlayerStatistics().toString(), "1");	
		
	}
}