/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.models.player;

import ColdWar.models.missions.MissionType;

/**
 * Implementation of the IPlayer interface.
 */
public class Player implements IPlayer{
    
    private final String name;
    private Team team;
    private boolean alive;
    private boolean hasPlayedFirstTurn;
    private boolean hasPlayedSecondTurn;
    private boolean extraMission;
    private MissionType extraMissionType;
    private IPlayer extraMissionTarget;
    private boolean extraMissionCompleted;
    private int votesFirstTurn;
    private int votesSecondTurn;

    public Player(String name){
        this.name = name;
        this.team = null;
        this.alive = true;
        this.hasPlayedFirstTurn = false;
        this.hasPlayedSecondTurn = false;
        this.extraMission = false;
        this.extraMissionType = null;
        this.extraMissionTarget = null;
        this.extraMissionCompleted = false;
        this.votesFirstTurn = 0;
        this.votesSecondTurn = 0;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * {@inheritDoc}
     */
    public void setTeam(Team team){
        this.team = team;
    }
    
    /**
     * {@inheritDoc}
     */
    public Team getTeam(){
        return this.team;
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean isAlive(){
        return this.alive;
    }
    
    /**
     * {@inheritDoc}
     */
    public void setDead(){
        this.alive = false;
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean hasPlayedThisTurn(int turn){
        switch (turn) {
            case 1:
                return this.hasPlayedFirstTurn;
            case 2:
                return this.hasPlayedSecondTurn;
            default:
                return true;
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean playTurn(int turn){
        switch (turn) {
            case 1:
                this.hasPlayedFirstTurn = true;
                return true;
            case 2:
                this.hasPlayedSecondTurn = true;
                return true;
            default:
                return false;
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean hasExtraMission(){
        return this.extraMission;
    }
    
    /**
     * {@inheritDoc}
     */
    public void setExtraMission(MissionType type, IPlayer target){
        this.extraMission = true;
        this.extraMissionType = type;
        this.extraMissionTarget = target;
    }
    
    /**
     * {@inheritDoc}
     */
    public MissionType getExtraMissionType(){
        return this.extraMissionType;
    }
    
    /**
     * {@inheritDoc}
     */
    public IPlayer getExtraMissionTarget(){
        return this.extraMissionTarget;
    }
    
    /**
     * {@inheritDoc}
     */
    public int getTurnVotes(int turn){
        switch (turn) {
            case 1:
                return this.votesFirstTurn;
            case 2:
                return this.votesSecondTurn;
            default:
                return 0;
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean addVote(int turn){
        switch (turn) {
            case 1:
                this.votesFirstTurn++;
                return true;
            case 2:
                this.votesSecondTurn++;
                return true;
            default:
                return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean getExtraMissionCompleted() {
        return this.extraMissionCompleted;
    }
    
    /**
     * {@inheritDoc}
     */
    public void setExtraMissionCompleted() {
        this.extraMissionCompleted = true;
    }
}
