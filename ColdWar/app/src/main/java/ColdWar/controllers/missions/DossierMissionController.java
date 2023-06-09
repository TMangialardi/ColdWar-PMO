/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.controllers.missions;

import ColdWar.controllers.AbstractController;
import ColdWar.controllers.nextPlayer.NextPlayerController;
import ColdWar.models.ApplicationInstance;
import ColdWar.models.missions.Dossier;
import ColdWar.models.player.IPlayer;
import ColdWar.models.player.Team;
import ColdWar.views.missions.DossierView;

/**
 * The controller for the Dossier mission.
 */
public class DossierMissionController extends AbstractController{
    
    private Dossier dossier;
    private Team selectedTeam;
    
    public DossierMissionController(){
        super.setModel(ApplicationInstance.getInstance());
    	this.dossier = new Dossier();
    	this.selectedTeam = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void buttonPressed(String action) {
        switch(action){
            case DossierView.SELECT_COMMAND:
                int selectedIndex = ((DossierView)super.getView()).getListSelectedIndex();
                if (selectedIndex != -1){
                    if (((DossierView)super.getView()).getFirstSelected() == -1){
                        ((DossierView)super.getView()).setFirstSelected(selectedIndex);
                    }else if(((DossierView)super.getView()).getSecondSelected() == -1){
                        ((DossierView)super.getView()).setSecondSelected(selectedIndex);
                    }
                    updateSelectButtonStatus();
                    updateVerifyButtonStatus();
                    updateContinueButtonStatus(); 
                }else {
                	((DossierView)super.getView()).showNotSelectedDialog();
                }
                break;
            case DossierView.RESET_COMMAND:
                ((DossierView)super.getView()).setFirstSelected(-1);
                ((DossierView)super.getView()).setSecondSelected(-1);
                updateSelectButtonStatus();
                updateVerifyButtonStatus();
                updateContinueButtonStatus();
                break;
            case DossierView.VERIFY_COMMAND:
                ((DossierView)super.getView()).setResetButtonEnabled(false);
                
                String selectedTeamButton = ((DossierView)super.getView()).getTeamSelection();
                if(selectedTeamButton != null && selectedTeamButton.equals(DossierView.DOUBLEAGENT_COMMAND)) {
                	this.selectedTeam = Team.DOUBLEAGENT;
                	playDossierMission();
                }else if(selectedTeamButton != null && selectedTeamButton.equals(DossierView.KGB_COMMAND)) {
                	this.selectedTeam = Team.KGB;
                	playDossierMission();
                }else if(selectedTeamButton != null && selectedTeamButton.equals(DossierView.CIA_COMMAND)) {
                	this.selectedTeam = Team.CIA;
                	playDossierMission();
                }else {
                	((DossierView)super.getView()).showNoTeamDialog();
                }
                /*if(((DossierView)super.getView()).getCiaButtonEnabled()){
                    this.selectedTeam = Team.CIA;
                    playDossierMission();
                }else if(((DossierView)super.getView()).getKgbButtonEnabled()){
                    this.selectedTeam = Team.KGB;
                    playDossierMission();
                }else if(((DossierView)super.getView()).getDoubleAgentButtonEnabled()){
                    this.selectedTeam = Team.DOUBLEAGENT;
                    playDossierMission();
                }else {
                	((DossierView)super.getView()).showNoTeamDialog();
                } */
                break;
            case DossierView.CONTINUE_COMMAND:
            	new NextPlayerController(super.getModel().getMatch().get().getCurrentTurn());
                break;

        }
    }

    /**
     * Update the status of the Select button in the Dossier view.
     */
    private void updateSelectButtonStatus() {
        if(((DossierView)super.getView()).getFirstSelected() != -1 && ((DossierView)super.getView()).getSecondSelected() != -1){
            ((DossierView)super.getView()).setSelectButtonEnabled(false);
        }else{
            ((DossierView)super.getView()).setSelectButtonEnabled(true);
        }
    }

    /**
     * Update the status of the Verify button in the Dossier view.
     */
    private void updateVerifyButtonStatus() {
        if(((DossierView)super.getView()).getFirstSelected() != -1 && ((DossierView)super.getView()).getSecondSelected() != -1){
            ((DossierView)super.getView()).setVerifyButtonEnabled(true);
        }else{
            ((DossierView)super.getView()).setVerifyButtonEnabled(false);
        }
    }

    /**
     * Update the status of the Continue button in the Dossier view.
     */
    private void updateContinueButtonStatus() {
        if(((DossierView)super.getView()).getResultLabelVisibility()){
            ((DossierView)super.getView()).setContinueButtonEnabled(true);
        }else{
            ((DossierView)super.getView()).setContinueButtonEnabled(false);
        }
    }
    
    /**
     * Method to let the controller play the Dossier mission.
     */
    private void playDossierMission() {
    	IPlayer one = super.getModel().getPlayer(((DossierView)super.getView()).getFirstSelected()).get();
        IPlayer two = super.getModel().getPlayer(((DossierView)super.getView()).getSecondSelected()).get();
        boolean result = this.dossier.playMission(one, two, selectedTeam);
        
        if(result){
            ((DossierView)super.getView()).setResultLabelText("<html><h2>At least one player belongs to the team.</h2></html>");
        }else{
            ((DossierView)super.getView()).setResultLabelText("<html><h2>The selected players don't belong to the team.</h2></html>");
        }
        ((DossierView)super.getView()).setResultLabelVisible(true);
        updateSelectButtonStatus();
        updateVerifyButtonStatus();
        updateContinueButtonStatus();
    }
}