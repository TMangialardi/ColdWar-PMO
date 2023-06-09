/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ColdWar.models;

import ColdWar.models.match.Match;
import ColdWar.models.player.Player;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Generic model template.
 */
public interface Model {
        
    /**
     * Set the list of players of the current game instance.
     * 
     * @param players - the list of players.
     */
    void setPlayers(ArrayList<Player> players);
    
    /**
     * Get the list of players of the current game instance.
     * 
     * @return the list of players.
     */
    Optional<ArrayList<Player>> getPlayers();
    
    /**
     * Add a player to the list of player of the current game instance.
     * 
     * @param player - the player to be added.
     */
    void addPlayer(Player player);
    
    /**
     * Get a specific player of the current game instance.
     * 
     * @param index - the index of a specific player
     * 
     * @return the selected specific player
     */
    Optional<Player> getPlayer(int index);
    
    /**
     * Set the match of the current game instance.
     * 
     * @param match - the match to be set.
     */
    void setMatch(Match match);
    
    /**
     * Get the match of the current game instance.
     * 
     * @return the match of the current game instance.
     */
    Optional<Match> getMatch();
}
