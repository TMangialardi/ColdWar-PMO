/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ColdWar.models.missions;

import ColdWar.models.player.IPlayer;

/**
 * Generic extra mission interface.
 * Extends the generic mission interface.
 */
public interface ExtraMission extends IMission{
    
    /**
     * The method to play the current mission.
     * 
     * @param player - the player that must play the current mission.
     * 
     * @return the selected target player
     */
    public IPlayer playMission(IPlayer player);
}
