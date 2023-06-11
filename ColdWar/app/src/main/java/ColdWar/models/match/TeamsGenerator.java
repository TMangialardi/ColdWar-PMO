/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.models.match;

import ColdWar.models.ApplicationInstance;
import ColdWar.models.player.Team;
import java.util.Collections;

/**
 * Implementation of the TeamsGenerator interface.
 */
public class TeamsGenerator implements ITeamsGenerator{
    
    public static final int DOUBLE_AGENT_LIMIT = 10;
    public static final int DOUBLE_AGENTS_UNDER_LIMIT = 1;
    public static final int DOUBLE_AGENTS_EVEN = 2;
    public static final int DOUBLE_AGENTS_OVER_LIMIT = 3;
    
    private int countDoubleAgents;
    private int countCIA;
    private int countKGB;
    
    public TeamsGenerator(){
        this.countDoubleAgents = 0;
        this.countCIA = 0;
        this.countKGB = 0;
    }
    
    /**
     * {@inheritDoc}
     */
    public void generateTeams(){
        
        Collections.shuffle(ApplicationInstance.getInstance().getPlayers().get());
        
        int playersCount = ApplicationInstance.getInstance().getPlayers().get().size();
        
        if((playersCount % 2) == 0){
            this.countDoubleAgents = DOUBLE_AGENTS_EVEN;
        }else if(playersCount < DOUBLE_AGENT_LIMIT){
            this.countDoubleAgents = DOUBLE_AGENTS_UNDER_LIMIT;
        }else{
            this.countDoubleAgents = DOUBLE_AGENTS_OVER_LIMIT;
        }
        this.countCIA = this.countKGB = (ApplicationInstance.getInstance().getPlayers().get().size() - this.countDoubleAgents) / 2;
        
        for(int i = 0; i < this.countDoubleAgents; i++){
            ApplicationInstance.getInstance().getPlayer(i).get().setTeam(Team.DOUBLEAGENT);
        }
        for(int i = this.countDoubleAgents; i < (this.countDoubleAgents + this.countCIA); i++){
            ApplicationInstance.getInstance().getPlayer(i).get().setTeam(Team.CIA);
        }
        for(int i = (this.countDoubleAgents + this.countCIA); i < ApplicationInstance.getInstance().getPlayers().get().size(); i++){
            ApplicationInstance.getInstance().getPlayer(i).get().setTeam(Team.KGB);
        }
        
        Collections.shuffle(ApplicationInstance.getInstance().getPlayers().get());
    }
    
    /**
     * {@inheritDoc}
     */
    public int getCountCIA(){
        return this.countCIA;
    }
    
    /**
     * {@inheritDoc}
     */
    public int getCountKGB(){
        return this.countKGB;
    }
    
    /**
     * {@inheritDoc}
     */
    public int getCountDoubleAgents(){
        return this.countDoubleAgents;
    }
}
