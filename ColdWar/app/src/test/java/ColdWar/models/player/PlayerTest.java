package ColdWar.models.player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ColdWar.models.missions.MissionType;

class PlayerTest {

	private static final String NAME = "TestName";
	private IPlayer player;
	
	@BeforeEach
	void init() {
		player = new Player(NAME);
	}
	
	@Test
	public void getInitialData() {
		assertEquals(NAME, player.getName());
		assertEquals(null, player.getTeam());
		assertEquals(true, player.isAlive());
		assertEquals(false, player.hasPlayedThisTurn(1));
		assertEquals(false, player.hasPlayedThisTurn(2));
		assertEquals(true, player.hasPlayedThisTurn(3));
		assertEquals(false, player.hasExtraMission());
		assertEquals(null, player.getExtraMissionType());
		assertEquals(null, player.getExtraMissionTarget());
		assertEquals(false, player.getExtraMissionCompleted());
		assertEquals(0, player.getTurnVotes(1));
		assertEquals(0, player.getTurnVotes(2));
	}
	
	@Test
	public void playFirstTurn() {
		assertEquals(true, player.playTurn(1));
		assertEquals(true, player.hasPlayedThisTurn(1));
	}
	
	@Test
	public void playSecondTurn() {
		assertEquals(true, player.playTurn(2));
		assertEquals(true, player.hasPlayedThisTurn(2));
	}
	
	@Test
	public void playThirdTurn() {
		assertEquals(false, player.playTurn(3));
		assertEquals(true, player.hasPlayedThisTurn(3));
	}
	
	@Test
	public void testTeam() {
		player.setTeam(Team.CIA);
		
		assertEquals(Team.CIA, player.getTeam());
	}
	
	@Test
	public void testDeath() {
		player.setDead();
		
		assertEquals(false, player.isAlive());
	}
	
	@Test
	public void extraMission() {
		player.setExtraMission(MissionType.MURDER, new Player("TestMission"));
		
		assertEquals(true, player.hasExtraMission());
		assertEquals(MissionType.MURDER, player.getExtraMissionType());
		assertEquals("TestMission", player.getExtraMissionTarget().getName());
		assertEquals(false, player.getExtraMissionCompleted());
		
		player.setExtraMissionCompleted();
		
		assertEquals(true, player.getExtraMissionCompleted());
	}
	
	@Test
	public void votes() {
		player.addVote(1);
		player.addVote(1);
		player.addVote(1);
		player.addVote(1);
		
		player.addVote(2);
		player.addVote(2);
		
		assertEquals(4, player.getTurnVotes(1));
		assertEquals(2, player.getTurnVotes(2));
	}

}
