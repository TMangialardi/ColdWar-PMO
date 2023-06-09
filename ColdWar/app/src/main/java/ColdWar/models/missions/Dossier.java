/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.models.missions;

import ColdWar.models.player.IPlayer;
import ColdWar.models.player.Team;

/**
 * Implementation of the DossierMission interface.
 */
public class Dossier implements DossierMission{

    /**
     * {@inheritDoc}
     */
    public boolean playMission(IPlayer one, IPlayer two, Team team) {
        return (one.getTeam() == team) || (two.getTeam() == team);
    }

    /**
     * {@inheritDoc}
     */
    public MissionType getMissionType() {
        return MissionType.DOSSIER;
    }
    
}
