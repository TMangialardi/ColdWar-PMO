package ColdWar.models.missions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ColdWar.models.player.IPlayer;
import ColdWar.models.player.Player;
import ColdWar.models.player.Team;

class DossierTest {

	private IPlayer ciaPlayer;
	private IPlayer kgbPlayer;
	private IPlayer doubleAgentPlayer;
	private Dossier dossier;
	
	@BeforeEach
	public void init() {
		this.ciaPlayer = new Player("ciaPlayer");
		this.ciaPlayer.setTeam(Team.CIA);
		this.kgbPlayer = new Player("kgbPlayer");
		this.kgbPlayer.setTeam(Team.KGB);
		this.doubleAgentPlayer = new Player("doubleAgentPlayer");
		this.doubleAgentPlayer.setTeam(Team.DOUBLEAGENT);
		this.dossier = new Dossier();
	}
	
	@Test
	void testDossier() {
		assertFalse(dossier.playMission(this.kgbPlayer, this.doubleAgentPlayer, Team.CIA));
		assertTrue(dossier.playMission(this.kgbPlayer, this.ciaPlayer, Team.CIA));
		assertTrue(dossier.playMission(this.ciaPlayer, this.doubleAgentPlayer, Team.CIA));
		assertTrue(dossier.playMission(this.ciaPlayer, this.ciaPlayer, Team.CIA));
		assertFalse(dossier.playMission(this.ciaPlayer, this.doubleAgentPlayer, Team.KGB));
		assertTrue(dossier.playMission(this.ciaPlayer, this.kgbPlayer, Team.KGB));
		assertTrue(dossier.playMission(this.kgbPlayer, this.doubleAgentPlayer, Team.KGB));
		assertTrue(dossier.playMission(this.kgbPlayer, this.kgbPlayer, Team.KGB));
		assertFalse(dossier.playMission(this.ciaPlayer, this.kgbPlayer, Team.DOUBLEAGENT));
		assertTrue(dossier.playMission(this.ciaPlayer, this.doubleAgentPlayer, Team.DOUBLEAGENT));
		assertTrue(dossier.playMission(this.doubleAgentPlayer, this.kgbPlayer, Team.DOUBLEAGENT));
		assertTrue(dossier.playMission(this.doubleAgentPlayer, this.doubleAgentPlayer, Team.DOUBLEAGENT));
	}

}
