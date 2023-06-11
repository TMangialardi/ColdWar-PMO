package ColdWar.models.match;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import ColdWar.models.ApplicationInstance;
import ColdWar.models.player.Player;
import ColdWar.models.player.Team;

class VotesManagerTest {

	private Random rnd;
	
	@BeforeEach
	public void init() {
		rnd = new Random();	
		
		ApplicationInstance.getInstance().setPlayers(new ArrayList<Player>());
		for(int i = 0; i < 13; i++) {
			ApplicationInstance.getInstance().addPlayer(new Player("Player_" + i));
			for(int j = 0; j < rnd.nextInt(5); j++) {
				ApplicationInstance.getInstance().getPlayer(i).get().addVote(1);
			}
			for(int k = 0; k < rnd.nextInt(5); k++) {
				ApplicationInstance.getInstance().getPlayer(i).get().addVote(2);
			}
		}
		ApplicationInstance.getInstance().setMatch(new Match());
	}
	
	
	@RepeatedTest(100)
	public void testEliminated() {
		int maxVotesFirstTurn = -1;
		int maxVotesSecondTurn = -1;
        for(Player p : ApplicationInstance.getInstance().getPlayers().get()){
            if(p.getTurnVotes(1) > maxVotesFirstTurn){
                maxVotesFirstTurn = p.getTurnVotes(1);
            }
            if(p.getTurnVotes(2) > maxVotesSecondTurn){
                maxVotesSecondTurn = p.getTurnVotes(2);
            }
        }
        
        ArrayList<Player> eliminatedFirstTurn = ApplicationInstance.getInstance().getMatch().get().getVotesManager().getTurnEliminated(1);
        
        for(Player p : eliminatedFirstTurn) {
        	assertEquals(p.getTurnVotes(1), maxVotesFirstTurn);
        	assertFalse(p.isAlive());
        }

        for(Player q : ApplicationInstance.getInstance().getPlayers().get()) {
        	if(!(eliminatedFirstTurn.contains(q))) {
        		assertTrue(q.isAlive());
        	}
        }
        
        ArrayList<Player> eliminatedSecondTurn = ApplicationInstance.getInstance().getMatch().get().getVotesManager().getTurnEliminated(2);
        
        for(Player r : eliminatedFirstTurn) {
        	assertEquals(r.getTurnVotes(1), maxVotesFirstTurn);
        	assertFalse(r.isAlive());
        }
        for(Player s : ApplicationInstance.getInstance().getPlayers().get()) {
        	if(!(eliminatedSecondTurn.contains(s)) && !(eliminatedFirstTurn.contains(s))) {
        		assertTrue(s.isAlive());
        	}
        	if(eliminatedFirstTurn.contains(s)) {
        		assertFalse(eliminatedSecondTurn.contains(s));
        	}
        	if(eliminatedSecondTurn.contains(s)) {
        		assertFalse(eliminatedFirstTurn.contains(s));
        	}
        }
    }
	
	@RepeatedTest(100)
	public void testWinners() {
		System.out.println("*************************");
		int maxVotesFirstTurn = -1;
		int maxVotesSecondTurn = -1;
        for(Player p : ApplicationInstance.getInstance().getPlayers().get()){
            if(p.getTurnVotes(1) > maxVotesFirstTurn){
                maxVotesFirstTurn = p.getTurnVotes(1);
            }
            if(p.getTurnVotes(2) > maxVotesSecondTurn){
                maxVotesSecondTurn = p.getTurnVotes(2);
            }
        }
		ApplicationInstance.getInstance().getMatch().get().getVotesManager().getTurnEliminated(1);
		ApplicationInstance.getInstance().getMatch().get().getVotesManager().getTurnEliminated(2);
		Team winnerTeam = ApplicationInstance.getInstance().getMatch().get().getVotesManager().determineWinnersTeam();
		ArrayList<Player> winners = ApplicationInstance.getInstance().getMatch().get().getVotesManager().getWinners();
		System.out.println("Max1: " + maxVotesFirstTurn + " Max2: " + maxVotesSecondTurn);
		for(Player p : winners) {
			System.out.println("Name: " + p.getName() + " votes1: " + p.getTurnVotes(1) + " votes2: " + p.getTurnVotes(2) + " alive: " + p.isAlive());
			assertEquals(winnerTeam, p.getTeam());
		}
	}

}
