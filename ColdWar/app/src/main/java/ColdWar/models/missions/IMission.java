/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ColdWar.models.missions;

/**
 * Generic mission interface.
 */
public interface IMission {
        
    /**
     * Get the type of the current mission.
     * 
     * @return the type of the current mission
     */
    public MissionType getMissionType();
}
