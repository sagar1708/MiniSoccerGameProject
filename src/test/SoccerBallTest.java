package test;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;

import org.junit.jupiter.api.Test;

import model.SoccerBall;

public class SoccerBallTest {

	@Test
	public void SoccerBallTest() {
		SoccerBall temp = SoccerBall.getSoccerBall();
		
		assertEquals(temp.getColor(), Color.WHITE);
		temp.resetSoccerBall();
		assertTrue(temp.getPosition().x == 480);
		assertTrue(temp.getPosition().y == 500);
	}

}
