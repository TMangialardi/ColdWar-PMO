package ColdWar.models.match;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import ColdWar.models.ApplicationInstance;
import ColdWar.models.player.Player;

class MatchTest {

	private Match match;
	private Random rnd;
	
	@BeforeEach
	void init() {
		rnd = new Random();
		ApplicationInstance.getInstance().setPlayers(new ArrayList<Player>());
		for(int i = 0; i < 13; i++) {
			ApplicationInstance.getInstance().addPlayer(new Player("Player_" + i));
		}
		match = new Match();
	}
	
	@RepeatedTest(100)
	void testMatchDecrements() {
		
		int randomCount = rnd.nextInt(4);
		
		for (int i = 0; i < randomCount; i++) {
			match.decreaseCountCIA();
		}
		assertEquals((5 - randomCount), match.getCountCIA());
		
		randomCount = rnd.nextInt(4);
		
		for (int i = 0; i < randomCount; i++) {
			match.decreaseCountKGB();
		}
		assertEquals((5 - randomCount), match.getCountKGB());
		
		randomCount = rnd.nextInt(4);
		
		for (int i = 0; i < randomCount; i++) {
			match.decreaseCountDoubleAgents();
		}
		assertEquals((3 - randomCount), match.getCountDoubleAgents());
	}
	
	@Test
	void testUpdateTurn() {
		assertEquals(match.getCurrentTurn(), Match.FIRST_TURN);
		match.updateCurrentTurn();
		assertEquals(match.getCurrentTurn(), Match.SECOND_TURN);
	}

}
