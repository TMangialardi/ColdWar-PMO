/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ColdWar.models.missions;

/**
 * Colleagues mission interface.
 */
public interface ColleaguesMission extends IMission{
    
    /**
     * The method to play the current Colleagues mission.
     */
    void playMission();
    
    /**
     * The method to get the name of one of the drawn players.
     * 
     * @param num - to select between the two drawn players.
     * 
     * @return - the name of the selected player.
     */
    String getDrawnPlayerName(int num);
}
