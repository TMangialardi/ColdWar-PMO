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

class ColleaguesTest {
	
	private static Colleagues colleagues;
	private static Random rnd;
	
	@BeforeEach
	void init() {
		colleagues = new Colleagues();
		rnd = new Random();
		ApplicationInstance.getInstance().setPlayers(new ArrayList<Player>());
		for(int i = 0; i < 13; i++) {
			ApplicationInstance.getInstance().addPlayer(new Player("Player_" + i));
			int randomTeam = rnd.nextInt(Team.values().length);
			ApplicationInstance.getInstance().getPlayer(i).get().setTeam(Team.values()[randomTeam]);
		}
	}

	@RepeatedTest(100)
	void testColleagues() {
		colleagues.playMission();
		String firstTargetName = colleagues.getDrawnPlayerName(1);
		String secondTargetName = colleagues.getDrawnPlayerName(2);
		String thirdTargetName = colleagues.getDrawnPlayerName(3);
		IPlayer firstTarget = null;
		IPlayer secondTarget = null;
		for(IPlayer p : ApplicationInstance.getInstance().getPlayers().get()) {
			if(p.getName().equals(firstTargetName)) {
				firstTarget = p;
			}
			if(p.getName().equals(secondTargetName)) {
				secondTarget = p;
			}
		}
		System.out.println("First: " + firstTargetName + " Second: " + secondTargetName + " Team: " + firstTarget.getTeam().name());
		
		assertFalse(firstTargetName.isEmpty());
		assertFalse(secondTargetName.isEmpty());
		assertTrue(thirdTargetName.isEmpty());
		assertNotNull(firstTarget);
		assertNotNull(secondTarget);
		assertEquals(firstTarget.getTeam(), secondTarget.getTeam());
		assertNotEquals(firstTarget, secondTarget);

	}

}
