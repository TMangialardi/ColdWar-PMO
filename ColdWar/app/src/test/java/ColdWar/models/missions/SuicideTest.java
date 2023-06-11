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

class SuicideTest {
	
	private static Suicide suicide;
	private static Random rnd;
	
	@BeforeEach
	public void init() {
		suicide = new Suicide();
		ApplicationInstance.getInstance().setPlayers(new ArrayList<Player>());
		for(int i = 0; i < 13; i++) {
			ApplicationInstance.getInstance().addPlayer(new Player("Player_" + i));
		}
		rnd = new Random();		
	}

	@RepeatedTest(100)
	public void testSuicide() {
		IPlayer selectedPlayer = ApplicationInstance.getInstance().getPlayer(rnd.nextInt(ApplicationInstance.getInstance().getPlayers().get().size())).get();
		IPlayer targetPlayer = suicide.playMission(selectedPlayer);
		System.out.println("Selected: " + selectedPlayer.getName() + " Target: " + targetPlayer.getName());
		
		assertEquals(selectedPlayer, targetPlayer);
		assertTrue(selectedPlayer.hasExtraMission());
		assertEquals(MissionType.SUICIDE, selectedPlayer.getExtraMissionType());
		assertEquals(targetPlayer, selectedPlayer.getExtraMissionTarget());
	}

}
