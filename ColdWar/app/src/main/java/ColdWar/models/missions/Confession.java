/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.models.missions;

import ColdWar.models.player.IPlayer;
import ColdWar.models.player.Team;

/**
 * Implementation of the ConfessionMission interface.
 */
public class Confession implements ConfessionMission{

    /**
     * {@inheritDoc} 
     */
    public Team playMission(IPlayer player) {
        return player.getTeam();
    }

    /**
     * {@inheritDoc} 
     */
    public MissionType getMissionType() {
        return MissionType.CONFESSION;
    }
    
}
