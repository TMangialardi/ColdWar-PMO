/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.controllers.nextPlayer;

import ColdWar.controllers.AbstractController;
import ColdWar.controllers.discussionTimer.DiscussionTimerController;
import ColdWar.controllers.missions.CommonMissionController;
import ColdWar.controllers.missions.DossierMissionController;
import ColdWar.models.ApplicationInstance;
import ColdWar.models.match.Match;
import ColdWar.models.missions.Bodyguard;
import ColdWar.models.missions.Colleagues;
import ColdWar.models.missions.Confession;
import ColdWar.models.missions.MissionType;
import ColdWar.models.missions.Murder;
import ColdWar.models.missions.Suicide;
import ColdWar.models.missions.Tip;
import ColdWar.models.player.IPlayer;
import ColdWar.models.player.Team;
import ColdWar.models.turn.ITurn;
import ColdWar.views.discussionTimer.DiscussionTimerView;
import ColdWar.views.missions.ColleaguesView;
import ColdWar.views.missions.ConfessionView;
import ColdWar.views.missions.DossierView;
import ColdWar.views.missions.ExtraMissionView;
import ColdWar.views.missions.TipView;
import ColdWar.views.nextPlayer.NextPlayerView;

/**
 * Controller for the NextPlayerView.
 */
public class NextPlayerController extends AbstractController{
    
    public NextPlayerController(int currentTurn){
        super.setModel(ApplicationInstance.getInstance());
    	createNextView(currentTurn);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void buttonPressed(String action) {
        IPlayer selectedPlayer = ((NextPlayerView)this.getView()).getSelectedPlayer();
        MissionType selectedMission =((NextPlayerView)this.getView()).getSelectedMission();
        IPlayer targetPlayer = null;
        switch(selectedMission){
            case CONFESSION:
                Confession confession = new Confession();
                Team selectedPlayerTeam = confession.playMission(selectedPlayer);
                CommonMissionController confessionController = new CommonMissionController();
                confessionController.setView(new ConfessionView(confessionController, selectedPlayer, selectedPlayerTeam));
                break;
            case DOSSIER:
                DossierMissionController dossierController = new DossierMissionController();
                dossierController.setView(new DossierView(dossierController, selectedPlayer));
                break;
            case TIP:
                Tip tip = new Tip();
                String tipPlayer = tip.playMission(selectedPlayer);
                CommonMissionController tipController = new CommonMissionController();
                tipController.setView(new TipView(tipController, selectedPlayer, tip, tipPlayer));
                break;
            case COLLEAGUES:
                Colleagues colleagues = new Colleagues();
                colleagues.playMission();
                CommonMissionController colleaguesController = new CommonMissionController();
                colleaguesController.setView(new ColleaguesView(colleaguesController, selectedPlayer, colleagues));
                break;
            case MURDER:
                Murder murder = new Murder();
                targetPlayer = murder.playMission(selectedPlayer);
                CommonMissionController murderController = new CommonMissionController();
                murderController.setView(new ExtraMissionView(murderController, selectedPlayer, targetPlayer, selectedMission));
                break;
            case SUICIDE:
                Suicide suicide = new Suicide();
                targetPlayer = suicide.playMission(selectedPlayer);
                CommonMissionController suicideController = new CommonMissionController();
                suicideController.setView(new ExtraMissionView(suicideController, selectedPlayer, targetPlayer, selectedMission));
                break;
            case BODYGUARD:
                Bodyguard bodyguard = new Bodyguard();
                targetPlayer = bodyguard.playMission(selectedPlayer);
                CommonMissionController bodyguardController = new CommonMissionController();
                bodyguardController.setView(new ExtraMissionView(bodyguardController, selectedPlayer, targetPlayer, selectedMission));
                break;
        }
    }

    /**
     * Method to create the next view.
     * This method decides if the next view is a NextPlayer view or a DiscussionTimerView.
     * 
     * @param currentTurn - the current turn of the match.
     */
    private void createNextView(int currentTurn) {
        ITurn thisTurn;
        switch (this.getModel().getMatch().get().getCurrentTurn()) {
            case Match.FIRST_TURN:
                thisTurn = this.getModel().getMatch().get().getFirstTurn();
                break;
            case Match.SECOND_TURN:
                thisTurn = this.getModel().getMatch().get().getSecondTurn();
                break;
            default:
                thisTurn = null;
                break;
        }
        
        if(!(thisTurn.turnCompleted(currentTurn))){
            IPlayer selectedPlayer = thisTurn.selectPlayer();
            MissionType selectedMission = thisTurn.selectMission(selectedPlayer);
            this.setView(new NextPlayerView(this, selectedPlayer, selectedMission));
        }else{
            DiscussionTimerController discussionTimerController = new DiscussionTimerController();
            discussionTimerController.setView(new DiscussionTimerView(discussionTimerController));
        }
    }
}
