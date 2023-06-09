/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.controllers.elimination;

import ColdWar.controllers.AbstractController;
import ColdWar.controllers.nextPlayer.NextPlayerController;
import ColdWar.controllers.winners.WinnersController;
import ColdWar.models.ApplicationInstance;
import ColdWar.models.match.Match;
import ColdWar.models.player.Player;
import ColdWar.models.player.Team;
import ColdWar.views.winners.WinnersView;
import java.util.ArrayList;

/**
 * Controller for the eliminationView.
 */
public class EliminationController extends AbstractController{

    public EliminationController() {
    	super.setModel(ApplicationInstance.getInstance());
    }
	
	/**
     * {@inheritDoc}
     */
	@Override
    public void buttonPressed(String action) {
        if((super.getModel().getMatch().get().getCurrentTurn() == Match.FIRST_TURN) &&
        		super.getModel().getMatch().get().getVotesManager().somePlayersStillAlive()){
            super.getModel().getMatch().get().updateCurrentTurn();
            new NextPlayerController(super.getModel().getMatch().get().getCurrentTurn());
        }else{
            Team winnerTeam = super.getModel().getMatch().get().getVotesManager().determineWinnersTeam();
            ArrayList<Player> winners = super.getModel().getMatch().get().getVotesManager().getWinners();
            WinnersController winnersController = new WinnersController();
            winnersController.setView(new WinnersView(winnersController, winnerTeam, winners));
        }
    }
    
}
