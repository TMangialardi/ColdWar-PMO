/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ColdWar.models.missions;

import ColdWar.models.player.IPlayer;
import ColdWar.models.player.Team;

/**
 * Tip mission interface.
 */
public interface TipMission extends IMission{
    
    /**
     * The method to play the current Tip mission.
     * 
     * @param  player - the current player to be excluded from the Tip.
     * 
     * @return the name of the drawn player.
     */
    String playMission(IPlayer player);
    
    /**
     * The method to get the team of the drawn player.
     *
     * @return the team of the drawn player.
     */
    Team getDrawnPlayerTeam();
}
