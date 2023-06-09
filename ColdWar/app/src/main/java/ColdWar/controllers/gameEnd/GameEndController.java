/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.controllers.gameEnd;

import ColdWar.controllers.AbstractController;
import ColdWar.models.ApplicationInstance;

/**
 *
 * @author tmang
 */
public class GameEndController extends AbstractController{

    public GameEndController() {
    	super.setModel(ApplicationInstance.getInstance());
    }
	
	/**
     * {@inheritDoc}
     */
	@Override
    public void buttonPressed(String action) {
        System.exit(0);
    }
    
}
