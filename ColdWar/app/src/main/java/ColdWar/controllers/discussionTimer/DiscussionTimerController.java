/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.controllers.discussionTimer;

import ColdWar.controllers.AbstractController;
import ColdWar.controllers.votes.VotesController;
import ColdWar.models.ApplicationInstance;
import ColdWar.views.discussionTimer.DiscussionTimerView;
import ColdWar.views.votes.VotesView;

/**
 * Controller from the DiscussionTimerView.
 */
public class DiscussionTimerController extends AbstractController{

    public DiscussionTimerController() {
    	super.setModel(ApplicationInstance.getInstance());
    }
	
	/**
     * {@inheritDoc}
     */
    @Override
    public void buttonPressed(String action) {
        switch(action){
            case DiscussionTimerView.TIMER_COMMAND:
                if(((DiscussionTimerView)(super.getView())).getCurrentTime() < DiscussionTimerView.TIME_AVAILABLE){
                    ((DiscussionTimerView)(super.getView())).incrementCurrentTime();
                    ((DiscussionTimerView)(super.getView())).setTimerText("<html><h1>" 
                            + (DiscussionTimerView.TIME_AVAILABLE - ((DiscussionTimerView)(super.getView())).getCurrentTime())
                            + " seconds remaining.</h1></html>");
                }else{
                    ((DiscussionTimerView)(super.getView())).stopTimer();
                    VotesController votesController = new VotesController();
                    votesController.setView(new VotesView(votesController));
                }
                break;
            case DiscussionTimerView.CONTINUE_COMMAND:
                ((DiscussionTimerView)(super.getView())).stopTimer();
                VotesController votesController = new VotesController();
                votesController.setView(new VotesView(votesController));
                break;
        }
    }
    
}
