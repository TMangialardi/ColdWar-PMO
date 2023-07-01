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

class TipTest {
	
	private static Tip tip;
	private static Random rnd;
	private IPlayer targetPlayer;
	
	@BeforeEach
	void init() {
		tip = new Tip();
		rnd = new Random();
		ApplicationInstance.getInstance().setPlayers(new ArrayList<Player>());
		for(int i = 0; i < 13; i++) {
			ApplicationInstance.getInstance().addPlayer(new Player("Player_" + i));
			int randomTeam = rnd.nextInt(Team.values().length);
			ApplicationInstance.getInstance().getPlayer(i).get().setTeam(Team.values()[randomTeam]);
		}
	}

	@RepeatedTest(100)
	void testTip() {
		IPlayer selectedPlayer = ApplicationInstance.getInstance().getPlayer(rnd.nextInt(ApplicationInstance.getInstance().getPlayers().get().size())).get();
		String targetPlayerName = tip.playMission(selectedPlayer);
		targetPlayer = null;
		for(IPlayer p : ApplicationInstance.getInstance().getPlayers().get()) {
			if(p.getName().equals(targetPlayerName)) {
				targetPlayer = p;
			}
		}
		System.out.println("Selected: " + selectedPlayer.getName() + " Target: " + targetPlayer.getName() + " Team: " + targetPlayer.getTeam().name());
		
		assertNotNull(targetPlayer);
		assertFalse(selectedPlayer.hasExtraMission());
	}

}
