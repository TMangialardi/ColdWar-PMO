/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ColdWar.models.missions;

import ColdWar.models.player.IPlayer;
import ColdWar.models.player.Team;

/**
 *
 * Dossier mission interface.
 */
public interface DossierMission extends IMission{
    
    /**
     * The method to play the current Dossier mission.
     * 
     * @param one - the first player to check.
     * 
     * @param two - the second player to check.
     * 
     * @param team - the method will check if the players belong to this team
     * 
     * @return the result of the verification
     */
    boolean playMission(IPlayer one, IPlayer two, Team team); 
}
