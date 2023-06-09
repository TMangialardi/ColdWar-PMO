/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.controllers.rolesSummary;

import ColdWar.controllers.AbstractController;
import ColdWar.controllers.nextPlayer.NextPlayerController;
import ColdWar.models.ApplicationInstance;
import ColdWar.models.match.Match;
import ColdWar.views.rolesSummary.RolesSummaryView;

/**
 * Controller for the RolesSummaryView.
 */
public class RolesSummaryController extends AbstractController{

    public RolesSummaryController() {
    	super.setModel(ApplicationInstance.getInstance());
    }
	/**
     * {@inheritDoc}
     */
    @Override
    public void buttonPressed(String action) {
        if(((RolesSummaryView)super.getView()).getPlayerCounter() < super.getModel().getPlayers().get().size()){
            if(!(((RolesSummaryView)super.getView()).getRoleVisibility())){
                ((RolesSummaryView)super.getView()).setRoleVisibility(true);
                ((RolesSummaryView)super.getView()).setRoleLabelVisibility(((RolesSummaryView)super.getView()).getRoleVisibility());
            }else{
                ((RolesSummaryView)super.getView()).setRoleVisibility(false);
                ((RolesSummaryView)super.getView()).setRoleLabelVisibility(((RolesSummaryView)super.getView()).getRoleVisibility());
                ((RolesSummaryView)super.getView()).incrementPlayerCounter();
                if(((RolesSummaryView)super.getView()).getPlayerCounter() < super.getModel().getPlayers().get().size()){
                    ((RolesSummaryView)super.getView()).setNameLabelText("<html><h1>"
                            + super.getModel().getPlayer(((RolesSummaryView)super.getView()).getPlayerCounter()).get().getName()
                            + "</h1></html>");
                    ((RolesSummaryView)super.getView()).setRoleLabelText("<html><h1>"
                            + super.getModel().getPlayer(((RolesSummaryView)super.getView()).getPlayerCounter()).get().getTeam().name()
                            + "</h1></html>");
                }else{
                    new NextPlayerController(Match.FIRST_TURN);
                }
            }
        }else{
            new NextPlayerController(Match.FIRST_TURN);
        }
    }
    
}
