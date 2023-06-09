/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ColdWar.models.turn;

import ColdWar.models.missions.MissionType;
import ColdWar.models.player.IPlayer;

/**
 * Generic turn interface.
 */
public interface ITurn {
    
    /**
     * Select a player to play the mission.
     * 
     * @return the player that must play the mission.
     */
    IPlayer selectPlayer();
    
    /**
     * Select a mission to be played.
     * 
     * @param player - the player who will receive the selected mission
     * 
     * @return the mission selected for the selected player.
     */
    MissionType selectMission(IPlayer player);
    
    
    /**
     * The method to check if all the players have completed the current turn.
     * 
     * @param turn - the number of the current turn.
     * 
     * @return true if the current turn is completed, false otherwise.
     */
    boolean turnCompleted(int turn);
    
}
