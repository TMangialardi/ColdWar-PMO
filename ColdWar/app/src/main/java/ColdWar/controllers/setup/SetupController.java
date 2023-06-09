/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.controllers.setup;

import ColdWar.controllers.AbstractController;
import ColdWar.controllers.rolesSummary.RolesSummaryController;
import ColdWar.models.ApplicationInstance;
import ColdWar.models.match.Match;
import ColdWar.models.player.Player;
import ColdWar.views.rolesSummary.RolesSummaryView;
import ColdWar.views.setup.SetupView;
import java.util.ArrayList;

/**
 * Controller for the SetupView.
 */
public class SetupController extends AbstractController{

    public static final int MIN_PLAYERS = 5;
    public static final int MAX_PLAYERS = 13;
    
    public SetupController() {
    	super.setModel(ApplicationInstance.getInstance());
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void buttonPressed(String action) {
        switch(action){
            case SetupView.ADD_COMMAND:
                String newPlayer = ((SetupView)super.getView()).getTextFieldText();
                if(!newPlayer.isEmpty()){
                    if(!(((SetupView)super.getView()).searchInListModel(newPlayer))){
                        ((SetupView)super.getView()).addInListModel(newPlayer);
                        ((SetupView)super.getView()).setTextFieldText("");
                        updateContinueButtonStatus();
                        updateAddButtonStatus();
                        updateRemoveButtonStatus();
                    }else {
                    	((SetupView)super.getView()).showDuplicateError();
                    	((SetupView)super.getView()).setTextFieldText("");
                    }
                }else {
                	((SetupView)super.getView()).showEmptyError();
                }
                break;
            case SetupView.REMOVE_COMMAND:
                int selectedPlayer = ((SetupView)super.getView()).getListSelectedIndex();
                if(selectedPlayer != -1){
                    ((SetupView)super.getView()).removeFromListModel(selectedPlayer);
                    updateContinueButtonStatus();
                    updateAddButtonStatus();
                    updateRemoveButtonStatus();
                }
                break;
            case SetupView.CONTINUE_COMMAND:
                if((((SetupView)super.getView()).getListModelSize() >= MIN_PLAYERS) &&
                        (((SetupView)super.getView()).getListModelSize() <= MAX_PLAYERS)){
                    super.getModel().setPlayers(new ArrayList<Player>());
                    for(int i = 0; i < ((SetupView)super.getView()).getListModelSize(); i++){
                        super.getModel().addPlayer(new Player(((SetupView)super.getView()).getFromListModel(i)));
                    }
                    super.getModel().setMatch(new Match());
                    RolesSummaryController rolesSummaryController = new RolesSummaryController();
                    rolesSummaryController.setView(new RolesSummaryView(rolesSummaryController, rolesSummaryController.getModel().getPlayers().get()));
                    
                }
                break;
        }
    }
    
    /**
     * Update the status of the Continue button in the Setup view.
     */
    private void updateContinueButtonStatus(){
        if(((SetupView)super.getView()).getListModelSize() >= MIN_PLAYERS){
            ((SetupView)super.getView()).setContinueButtonEnabled(true);
        }else{
            ((SetupView)super.getView()).setContinueButtonEnabled(false);
        }
    }
    
    /**
     * Update the status of the Add button in the Setup view.
     */
    private void updateAddButtonStatus(){
        if(((SetupView)super.getView()).getListModelSize() < MAX_PLAYERS){
            ((SetupView)super.getView()).setAddButtonEnabled(true);
        }else{
            ((SetupView)super.getView()).setAddButtonEnabled(false);
        }
    }
    
    /**
     * Update the status of the Remove button in the Setup view.
     */
    private void updateRemoveButtonStatus(){
        if(((SetupView)super.getView()).getListModelSize() > 0){
            ((SetupView)super.getView()).setRemoveButtonEnabled(true);
        }else{
            ((SetupView)super.getView()).setRemoveButtonEnabled(false);
        }
    }
}
