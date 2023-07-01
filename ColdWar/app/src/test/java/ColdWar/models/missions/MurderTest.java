package ColdWar.models.missions;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import ColdWar.models.ApplicationInstance;
import ColdWar.models.player.IPlayer;
import ColdWar.models.player.Player;

class MurderTest {
	
	private static Murder murder;
	private static Random rnd;

	@BeforeEach
	void init() {
		murder = new Murder();
		ApplicationInstance.getInstance().setPlayers(new ArrayList<Player>());
		for(int i = 0; i < 13; i++) {
			ApplicationInstance.getInstance().addPlayer(new Player("Player_" + i));
		}
		rnd = new Random();		
	}
	
	
	@RepeatedTest(100)
	void testMurder() {
		IPlayer selectedPlayer = ApplicationInstance.getInstance().getPlayer(rnd.nextInt(ApplicationInstance.getInstance().getPlayers().get().size())).get();
		IPlayer targetPlayer = murder.playMission(selectedPlayer);
		System.out.println("Selected: " + selectedPlayer.getName() + " Target: " + targetPlayer.getName());
		
		assertNotEquals(selectedPlayer, targetPlayer);
		assertTrue(selectedPlayer.hasExtraMission());
		assertEquals(MissionType.MURDER, selectedPlayer.getExtraMissionType());
		assertEquals(targetPlayer, selectedPlayer.getExtraMissionTarget());
	}

}
