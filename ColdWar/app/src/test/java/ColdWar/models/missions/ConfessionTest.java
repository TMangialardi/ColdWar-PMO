package ColdWar.models.missions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import ColdWar.models.ApplicationInstance;
import ColdWar.models.player.IPlayer;
import ColdWar.models.player.Player;
import ColdWar.models.player.Team;

class ConfessionTest {

	private static Random rnd;
	private static Confession confession;

	@BeforeEach
	void init() {
		confession = new Confession();
		rnd = new Random();	
		ApplicationInstance.getInstance().setPlayers(new ArrayList<Player>());
		for(int i = 0; i < 13; i++) {
			ApplicationInstance.getInstance().addPlayer(new Player("Player_" + i));
			int randomTeam = rnd.nextInt(Team.values().length);
			ApplicationInstance.getInstance().getPlayer(i).get().setTeam(Team.values()[randomTeam]);
		}	
	}
	
	@RepeatedTest(100)
	void testConfession() {
		IPlayer selectedPlayer = ApplicationInstance.getInstance().getPlayer(rnd.nextInt(ApplicationInstance.getInstance().getPlayers().get().size())).get();
		Team selectedTeam = confession.playMission(selectedPlayer);
		System.out.println("Player: " + selectedPlayer.getName() + " Team: " + selectedTeam.name());
		
		assertEquals(selectedPlayer.getTeam(), selectedTeam);
		assertFalse(selectedPlayer.hasExtraMission());
	}

}
