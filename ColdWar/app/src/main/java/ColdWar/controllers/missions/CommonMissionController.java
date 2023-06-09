/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.controllers.missions;

import ColdWar.controllers.AbstractController;
import ColdWar.controllers.nextPlayer.NextPlayerController;
import ColdWar.models.ApplicationInstance;

/**
 * The controller for every Mission, except the Dossier mission.
 */
public class CommonMissionController extends AbstractController{

    public CommonMissionController() {
    	super.setModel(ApplicationInstance.getInstance());
    }
	
	/**
     * {@inheritDoc}
     */
    @Override
    public void buttonPressed(String action) {
        NextPlayerController nextPlayerController = new NextPlayerController(super.getModel().getMatch().get().getCurrentTurn());
        nextPlayerController.setModel(ApplicationInstance.getInstance());
    }
    
}
