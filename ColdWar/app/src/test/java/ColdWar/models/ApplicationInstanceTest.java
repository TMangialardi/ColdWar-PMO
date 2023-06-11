package ColdWar.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import ColdWar.models.match.Match;
import ColdWar.models.player.Player;

class ApplicationInstanceTest {

	@Test
	public void testGetInstance() {
		assertNotNull(ApplicationInstance.getInstance());
	}
	
	@Test
	public void testPlayers() {
		ApplicationInstance.getInstance().setPlayers(new ArrayList<Player>());
		assertNotNull(ApplicationInstance.getInstance().getPlayers().get());
		for(int i = 0; i < 13; i++) {
			ApplicationInstance.getInstance().addPlayer(new Player("Player_" + i));
			assertNotNull(ApplicationInstance.getInstance().getPlayer(i).get());
		}
		assertEquals(13, ApplicationInstance.getInstance().getPlayers().get().size());
	}
	
	@Test
	public void testMatch() {
		assertEquals(Optional.empty(), ApplicationInstance.getInstance().getMatch());
		ApplicationInstance.getInstance().setPlayers(new ArrayList<Player>());
		for(int i = 0; i < 13; i++) {
			ApplicationInstance.getInstance().addPlayer(new Player("Player_" + i));
		}
		ApplicationInstance.getInstance().setMatch(new Match());
		assertNotNull(ApplicationInstance.getInstance().getMatch().get());
	}
	
	

}
