/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ColdWar.models.match;

import ColdWar.models.player.Player;
import ColdWar.models.player.Team;
import java.util.ArrayList;

/**
 *
 * Votes manager interface.
 */
public interface IVotesManager {
    
    /**
     * Method to get the list of eliminated players in a selected turn.
     * 
     * @param turn - the number of a selected turn.
     * 
     * @return the list of eliminated players in the selected turn.
     */
    ArrayList<Player> getTurnEliminated(int turn);
    
    /**
     * Method to determine the team that wins the match.
     * 
     * @return the team that wins the match.
     */
    Team determineWinnersTeam();
    
    /**
     * Method to get the complete list of players who won the match.
     * 
     * @return the complete list of players who won the match.
     */
    ArrayList<Player> getWinners();
    
    /**
     * Method to check if there are still alive players.
     * 
     * @return true if there are still alive players, false otherwise.
     */
    public boolean somePlayersStillAlive();
}
