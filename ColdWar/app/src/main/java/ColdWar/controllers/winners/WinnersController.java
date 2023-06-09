/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.controllers.winners;

import ColdWar.controllers.AbstractController;
import ColdWar.controllers.gameEnd.GameEndController;
import ColdWar.models.ApplicationInstance;
import ColdWar.views.gameEnd.GameEndView;

/**
 * Controller for the WinnersView.
 */
public class WinnersController extends AbstractController{

    public WinnersController() {
    	super.setModel(ApplicationInstance.getInstance());
    }
	
	/**
     * {@inheritDoc}
     */
	@Override
    public void buttonPressed(String action) {
        GameEndController gameEndController = new GameEndController();
        gameEndController.setView(new GameEndView(gameEndController, gameEndController.getModel().getPlayers().get()));
    }
    
}
