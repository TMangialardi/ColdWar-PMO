/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.models.missions;

import ColdWar.models.player.IPlayer;

/**
 * Abstract implementation of the ExtraMission interface.
 */
public abstract class AbstractExtraMission implements ExtraMission{
    
    private MissionType missionType;
    
    protected AbstractExtraMission(MissionType missionType){
        this.missionType = missionType;
    }
    
    /**
     * {@inheritDoc} 
     */
    public abstract IPlayer playMission(IPlayer player);
    
    /**
     * {@inheritDoc} 
     */
    public MissionType getMissionType(){
        return this.missionType;
    }
}
