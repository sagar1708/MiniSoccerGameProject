package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import org.junit.jupiter.api.Test;

import model.players.GamePlayer;
import model.players.PlayerFactory;

public class PlayerFactoryTest {

	@Test
	public void getPlayerTest() {
		List<GamePlayer> temp = new ArrayList<GamePlayer>();
		GamePlayer p1 = new PlayerFactory().getPlayer("Striker");
		GamePlayer p2 = new PlayerFactory().getPlayer("Goalkeeper");
		GamePlayer p3 = new PlayerFactory().getPlayer("");
		temp.add(p1); temp.add(p2); temp.add(p3);
		
		assertEquals(temp.get(0).getPlayerName(), "Striker");
		assertEquals(temp.get(0).getPlayerColor(), Color.BLUE);
		assertEquals(temp.get(0).getPlayerPosition(), p1.getPlayerPosition());
		assertEquals(temp.get(0).getClass(), p1.getClass());
		
		
		assertEquals(temp.get(1).getPlayerName(), "Goalkeeper");
		assertEquals(temp.get(1).getPlayerColor(), Color.YELLOW);
		assertEquals(temp.get(1).getPlayerPosition(), p2.getPlayerPosition());
		assertEquals(temp.get(1).getClass(), p2.getClass());
		
		assertEquals(temp.get(2), null);
	}

}
