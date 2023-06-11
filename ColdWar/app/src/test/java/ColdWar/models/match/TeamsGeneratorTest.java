package ColdWar.models.match;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import ColdWar.models.ApplicationInstance;
import ColdWar.models.player.Player;

class TeamsGeneratorTest {
	
	private TeamsGenerator teamsGenerator;

	@BeforeEach
	public void init() {
		teamsGenerator = new TeamsGenerator();
		ApplicationInstance.getInstance().setPlayers(new ArrayList<Player>());
		for(int i = 0; i < 13; i++) {
			ApplicationInstance.getInstance().addPlayer(new Player("Player_" + i));
		}	
	}
	
	@RepeatedTest(100)
	void test() {
		teamsGenerator.generateTeams();
		int teamsCount = teamsGenerator.getCountCIA() + teamsGenerator.getCountKGB() + teamsGenerator.getCountDoubleAgents();
		
		assertEquals(teamsGenerator.getCountCIA(), teamsGenerator.getCountKGB());
		assertEquals(teamsCount, ApplicationInstance.getInstance().getPlayers().get().size());
	}

}
