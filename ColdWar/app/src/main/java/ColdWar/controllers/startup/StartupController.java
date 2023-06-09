/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.controllers.startup;

import ColdWar.controllers.AbstractController;
import ColdWar.controllers.setup.SetupController;
import ColdWar.views.setup.SetupView;
import ColdWar.views.startup.StartupView;

/**
 * Controller for the StartupView.
 */
public class StartupController extends AbstractController{

    /**
     * {@inheritDoc}
     */
    @Override
    public void buttonPressed(String action) {
        switch(action){
            case StartupView.TOEXIT_COMMAND:
                System.exit(0);
                break;
            case StartupView.TOPLAY_COMMAND:
                SetupController setupController = new SetupController();
                SetupView setupView = new SetupView(setupController);
                setupController.setView(setupView);
                break;
        }
    }
}
