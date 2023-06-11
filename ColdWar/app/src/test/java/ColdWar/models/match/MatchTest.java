package ColdWar.models.match;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ColdWar.models.ApplicationInstance;
import ColdWar.models.player.Player;

class MatchTest {

	private Match match;
	
	@BeforeEach
	public void init() {
		ApplicationInstance.getInstance().setPlayers(new ArrayList<Player>());
		for(int i = 0; i < 13; i++) {
			ApplicationInstance.getInstance().addPlayer(new Player("Player_" + i));
		}
		match = new Match();
	}
	
	@Test
	void testMatchDecrements() {
		match.decreaseCountCIA();
		match.decreaseCountCIA();
		match.decreaseCountCIA();
		
		match.decreaseCountKGB();
		match.decreaseCountKGB();
		match.decreaseCountKGB();
		match.decreaseCountKGB();
		
		match.decreaseCountDoubleAgents();
		match.decreaseCountDoubleAgents();
		
		assertEquals(2, match.getCountCIA());
		assertEquals(1, match.getCountKGB());
		assertEquals(1, match.getCountDoubleAgents());
	}
	
	@Test
	void testUpdateTurn() {
		assertEquals(match.getCurrentTurn(), Match.FIRST_TURN);
		match.updateCurrentTurn();
		assertEquals(match.getCurrentTurn(), Match.SECOND_TURN);
	}

}
