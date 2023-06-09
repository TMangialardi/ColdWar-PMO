/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ColdWar.models.missions;

import ColdWar.models.player.IPlayer;
import ColdWar.models.player.Team;

/**
 * interface for the Confession mission.
 */
public interface ConfessionMission extends IMission {
    
    /**
     * The method to play the current Confession mission.
     * 
     * @param player - the player that must play the current Confession mission.
     * 
     * @return the team of the player who is playing the mission.
     */
    Team playMission(IPlayer player);
}
