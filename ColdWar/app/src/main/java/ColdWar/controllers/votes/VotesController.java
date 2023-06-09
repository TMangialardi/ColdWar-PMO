/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.controllers.votes;

import ColdWar.controllers.AbstractController;
import ColdWar.controllers.elimination.EliminationController;
import ColdWar.models.ApplicationInstance;
import ColdWar.models.player.Player;
import ColdWar.views.elimination.EliminationView;
import ColdWar.views.votes.VotesView;
import java.util.ArrayList;

/**
 *
 * @author tmang
 */
public class VotesController extends AbstractController{

	public VotesController() {
		super.setModel(ApplicationInstance.getInstance());
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
    public void buttonPressed(String action) {
        if(((VotesView)(super.getView())).getPlayerCounter() < ((VotesView)(super.getView())).getListMoelSize()){
            if(!(((VotesView)(super.getView())).getListScrollPaneVisibility())){
                ((VotesView)(super.getView())).setListScrollPaneVisibility(true);
                ((VotesView)(super.getView())).updateFrame();
            }else{
                int selectedIndex = ((VotesView)(super.getView())).getListSelectedIndex();
                if(selectedIndex != -1){
                    ((VotesView)(super.getView())).clearListSelection();
                    super.getModel().getPlayer(selectedIndex).get().addVote(super.getModel().getMatch().get().getCurrentTurn());
                    ((VotesView)(super.getView())).incrementPlayerCounter();
                    if(((VotesView)(super.getView())).getPlayerCounter() < ((VotesView)(super.getView())).getListMoelSize()){
                        ((VotesView)(super.getView())).setPlayerLabelText("<html><h1>"
                                + ((VotesView)(super.getView())).getFromListModel(((VotesView)(super.getView())).getPlayerCounter())
                                + "</h1></html>");
                        ((VotesView)(super.getView())).setListScrollPaneVisibility(false);
                        ((VotesView)(super.getView())).updateFrame();
                    }else{
                    	this.generateEliminatedView();
                    }
                }
            }
        }else{
            this.generateEliminatedView();
        }
    }
    
    /**
     * Method to move forward to the next view.
     */
    private void generateEliminatedView(){
        int currentTurn = super.getModel().getMatch().get().getCurrentTurn();
        ArrayList<Player> turnEliminated = super.getModel().getMatch().get().getVotesManager().getTurnEliminated(currentTurn);
        EliminationController eliminationController = new EliminationController();
        eliminationController.setView(new EliminationView(eliminationController, turnEliminated));
    }
    
}
