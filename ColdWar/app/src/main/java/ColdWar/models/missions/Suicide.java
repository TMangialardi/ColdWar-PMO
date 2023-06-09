/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.models.missions;

import ColdWar.models.player.IPlayer;

/**
 * Suicide mission.
 * Extends the AbstractExtraMission abstract class.
 */
public class Suicide extends AbstractExtraMission {
    
    
    public Suicide(){
        super(MissionType.SUICIDE);
    }

    /**
     * {@inheritDoc} 
     */
    @Override
    public IPlayer playMission(IPlayer player) {
        player.setExtraMission(super.getMissionType(), player);
        return player;
    }
}
