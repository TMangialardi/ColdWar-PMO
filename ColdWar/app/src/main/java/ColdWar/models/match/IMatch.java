/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ColdWar.models.match;

import ColdWar.models.turn.ITurn;

/**
 * Match interface.
 */
public interface IMatch {
    
    /**
     * Method to obtain the count of alive CIA members.
     * 
     * @return the count of alive CIA members.
     */
    int getCountCIA();
    
    /**
     * Method to obtain the count of alive KGB members.
     * 
     * @return the count of alive KGB members.
     */
    int getCountKGB();
    
    /**
     * Method to obtain the count of alive double agents.
     * 
     * @return the count of alive double agents.
     */
    int getCountDoubleAgents();
    
    /**
     * Method to decrease the count of alive CIA members.
     */
    void decreaseCountCIA();
    
    /**
     * Method to decrease the count of alive KGB members.
     */
    void decreaseCountKGB();
    
    /**
     * Method to decrease the count of alive double agents.
     */
    void decreaseCountDoubleAgents();
    
    /**
     * Method to get the first turn of the current match.
     * 
     * @return the first turn of the current match.
     */
    ITurn getFirstTurn();
    
    /**
     * Method to get the second turn of the current match.
     * 
     * @return the second turn of the current match.
     */
    ITurn getSecondTurn();
    
    /**
     * Method to get the current turn.
     * 
     * @return the current turn.
     */
    int getCurrentTurn();
    
    /**
     * Method to update the current turn.
     */
    void updateCurrentTurn();
    
    /**
     * Method to get the votes manager of the current match.
     * 
     * @return the votes manager of the current match.
     */
    IVotesManager getVotesManager();
}
