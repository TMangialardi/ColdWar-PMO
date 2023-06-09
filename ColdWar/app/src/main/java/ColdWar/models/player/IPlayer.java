/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ColdWar.models.player;

import ColdWar.models.missions.MissionType;

/**
 * Generic player interface.
 */
public interface IPlayer {
    
    /**
     * Method to get the name of the current player.
     * 
     * @return the name of the current player.
     */
    String getName();
    
    /**
     * Set the team of the current player.
     * 
     * @param team -the team of the current player.
     */
    void setTeam(Team team);
    
    /**
     * Get the team of the current player.
     * 
     * @return the team of the current player.
     */
    Team getTeam();
    
    /**
     * Check if the current player is alive.
     * 
     * @return true if the current player is alive, false otherwise.
     */
    boolean isAlive();
    
    /**
     * Set the current player as dead.
     */
    void setDead();
    
    /**
     * Check if the current player has played a turn.
     * 
     * @param turn - the number ot the turn to be checked.
     * 
     * @return true if the played has played the selected tur, false otherwise.
     */
    boolean hasPlayedThisTurn(int turn);
    
    /**
     * Make the player play a turn.
     * 
     * @param turn - the turn to be played.
     * 
     * @return true if the turn is played successfully, false otherwise.
     */
    boolean playTurn(int turn);
    
    /**
     * Check if the current player has an extra mission.
     * 
     * @return true if the current player has an extra mission, false otherwise. 
     */
    boolean hasExtraMission();
    
    /**
     * set an extra mission for the current player.
     * 
     * @param type - the type of the mission to be set.
     * 
     * @param target - the player who is the target of the extra mission.
     */
    void setExtraMission(MissionType type, IPlayer target);
    
    /**
     * Method to get the type of extra mission assigned to the current player.
     * 
     * @return the type of the extra mission assigned to the current player.
     */
    MissionType getExtraMissionType();
    
    /**
     * Method to get the target of the extra mission assigned to the current player.
     * 
     * @return the target of the extra mission assigned to the current player.
     */
    IPlayer getExtraMissionTarget();
    
    /**
     * Get the number of votes that the current player has received in a turn.
     * 
     * @param turn - the number of the selected turn.
     * 
     * @return the number of votes that the current player received in the selected turn.
     */
    int getTurnVotes(int turn);
    
    /**
     * Add a vote to the current player for a specified turn.
     * 
     * @param turn - the number of the selected turn.
     * 
     * @return true if the vote is added successfully, false otherwise.
     */
    boolean addVote(int turn);
    
    /**
     * Method to know if the current played has completed his extra mission.
     * 
     * @return true if the current player has completed his extra mission, false otherwise.
     */
    boolean getExtraMissionCompleted();
    
    /**
     * set the extra mission of the current player as completed.
     */
    void setExtraMissionCompleted();
}
