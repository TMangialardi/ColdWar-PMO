/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.models.match;

import ColdWar.models.turn.FirstTurn;
import ColdWar.models.turn.ITurn;
import ColdWar.models.turn.SecondTurn;

/**
 * Implementation of the Match interface.
 */
public class Match implements IMatch{
    
    public final static int FIRST_TURN = 1;
    public final static int SECOND_TURN = 2;
    
    private int countCIA;
    private int countKGB;
    private int countDoubleAgents;
    private int currentTurn;
    private ITurn firstTurn;
    private ITurn secondTurn;
    private final ITeamsGenerator teamsGen;
    private IVotesManager votesManager;
    
    public Match(){
        teamsGen = new TeamsGenerator();
        teamsGen.generateTeams();
        this.countCIA = teamsGen.getCountCIA();
        this.countKGB = teamsGen.getCountKGB();
        this.countDoubleAgents = teamsGen.getCountDoubleAgents();
        this.currentTurn = FIRST_TURN;
        this.firstTurn = new FirstTurn();
        this.secondTurn = new SecondTurn();
        this.votesManager = new VotesManager();
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
    
    /**
     * {@inheritDoc}
     */
    public void decreaseCountCIA(){
        this.countCIA--;
    }
    
    /**
     * {@inheritDoc}
     */
    public void decreaseCountKGB(){
        this.countKGB--;
    }
    
    /**
     * {@inheritDoc}
     */
    public void decreaseCountDoubleAgents(){
        this.countDoubleAgents--;
    }

    /**
     * {@inheritDoc}
     */
    public ITurn getFirstTurn() {
        return this.firstTurn;
    }

    /**
     * {@inheritDoc}
     */
    public ITurn getSecondTurn() {
        return this.secondTurn;
    }

    /**
     * {@inheritDoc}
     */
    public int getCurrentTurn() {
        return this.currentTurn;
    }

    /**
     * {@inheritDoc}
     */
    public void updateCurrentTurn() {
        this.currentTurn = SECOND_TURN;
    }

    /**
     * {@inheritDoc}
     */
    public IVotesManager getVotesManager() {
        return this.votesManager;
    }
}
