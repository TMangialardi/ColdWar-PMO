/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.models.turn;

import ColdWar.models.ApplicationInstance;
import ColdWar.models.missions.MissionType;
import ColdWar.models.player.IPlayer;

/**
 * Abstract implementation of the ITurn interface.
 */
public abstract class Turn implements ITurn{
    
    public static final int POSSIBLE_MISSIONS_WITH_EXTRA = 7;
    public static final int POSSIBLE_MISSIONS_WITHOUT_EXTRA = 4;
    
    /**
     * {@inheritDoc}
     */
    public abstract IPlayer selectPlayer();
    
    /**
     * {@inheritDoc}
     */
    public abstract MissionType selectMission(IPlayer player);
    
    /**
     * {@inheritDoc}
     */
    public boolean turnCompleted(int turn){
        boolean ret = true;
        
        for(int i = 0; i < ApplicationInstance.getInstance().getPlayers().get().size(); i++){
            if(!(ApplicationInstance.getInstance().getPlayer(i).get().hasPlayedThisTurn(turn))){
                ret = false;
            }
        }
        return ret;
    }
}