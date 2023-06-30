package ColdWar.models.turn;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import ColdWar.models.ApplicationInstance;
import ColdWar.models.missions.MissionType;
import ColdWar.models.player.IPlayer;
import ColdWar.models.player.Player;

class SecondTurnTest {

	private SecondTurn secondTurn;
	private IPlayer selectedPlayer;
	private MissionType selectedMission;

	@BeforeEach
	public void init() {
		new Random();	
		secondTurn = new SecondTurn();
		ApplicationInstance.getInstance().setPlayers(new ArrayList<Player>());
		for(int i = 0; i < 13; i++) {
			ApplicationInstance.getInstance().addPlayer(new Player("Player_" + i));
			ApplicationInstance.getInstance().getPlayer(i).get().playTurn(1);
			if(i % 2 == 0) {
				ApplicationInstance.getInstance().getPlayer(i).get().setExtraMission(MissionType.MURDER, new Player("Target_" + i));
			}
			if(i % 5 == 0) {
				ApplicationInstance.getInstance().getPlayer(i).get().setDead();
			}
		}	
	}
	@RepeatedTest(100)
	public void testSecondTurnSelection() {
		
		selectedPlayer = secondTurn.selectPlayer();
		
		if(selectedPlayer.hasExtraMission()) {
			assertNotEquals(MissionType.MURDER, secondTurn.selectMission(selectedPlayer));
			assertNotEquals(MissionType.SUICIDE, secondTurn.selectMission(selectedPlayer));
			assertNotEquals(MissionType.BODYGUARD, secondTurn.selectMission(selectedPlayer));
		}
		
		selectedMission = secondTurn.selectMission(selectedPlayer);
		System.out.println("Player: " + selectedPlayer.getName() + " Mission: " + selectedMission.name());
		
		assertTrue(selectedPlayer.isAlive());
		assertTrue(selectedPlayer.hasPlayedThisTurn(1));
		assertTrue(selectedPlayer.hasPlayedThisTurn(2));
	}
	
	@Test
	void testSecondTurnCompleted() {
		System.out.println("***************************************");
		for(int i = 0; i < ApplicationInstance.getInstance().getPlayers().get().size(); i++) {
			selectedPlayer = secondTurn.selectPlayer();
			selectedMission = secondTurn.selectMission(selectedPlayer);
			System.out.println("Player: " + selectedPlayer.getName() + " Mission: " + selectedMission.name());
		}
		
		assertTrue(secondTurn.turnCompleted(1));
		assertTrue(secondTurn.turnCompleted(2));
	}
}
