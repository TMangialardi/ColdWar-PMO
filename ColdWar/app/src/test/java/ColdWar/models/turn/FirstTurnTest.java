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

class FirstTurnTest {
	
	private FirstTurn firstTurn;
	private IPlayer selectedPlayer;
	private MissionType selectedMission;

	@BeforeEach
	public void init() {
		new Random();	
		firstTurn = new FirstTurn();
		ApplicationInstance.getInstance().setPlayers(new ArrayList<Player>());
		for(int i = 0; i < 13; i++) {
			ApplicationInstance.getInstance().addPlayer(new Player("Player_" + i));
		}	
	}
	@RepeatedTest(100)
	public void testFirstTurnSelection() {
		selectedPlayer = firstTurn.selectPlayer();
		selectedMission = firstTurn.selectMission(selectedPlayer);
		System.out.println("Player: " + selectedPlayer.getName() + " Mission: " + selectedMission.name());
		
		assertTrue(selectedPlayer.hasPlayedThisTurn(1));
		assertFalse(selectedPlayer.hasPlayedThisTurn(2));
	}
	
	@Test
	void testFirstTurnCompleted() {
		System.out.println("***************************************");
		for(int i = 0; i < ApplicationInstance.getInstance().getPlayers().get().size(); i++) {
			selectedPlayer = firstTurn.selectPlayer();
			selectedMission = firstTurn.selectMission(selectedPlayer);
			System.out.println("Player: " + selectedPlayer.getName() + " Mission: " + selectedMission.name());
		}
		
		assertTrue(firstTurn.turnCompleted(1));
		assertFalse(firstTurn.turnCompleted(2));
	}

}
