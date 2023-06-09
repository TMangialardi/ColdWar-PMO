/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ColdWar.models.match;

/**
 * Team generator interface.
 */
public interface ITeamsGenerator {
    
    /**
     * Assign a team to each player of the match.
     */
    void generateTeams();
    
    /**
     * Method to get the number of CIA members.
     * 
     * @return the number of CIA members.
     */
    int getCountCIA();
    
    /**
     * Method to get the number of KGB members.
     * 
     * @return then number of KGB members. 
     */
    int getCountKGB();
    
    /**
     * Method to get the number of Double Agents.
     * 
     * @return the number of Double Agents.
     */
    int getCountDoubleAgents();
}
