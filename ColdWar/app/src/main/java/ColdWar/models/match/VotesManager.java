/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.models.match;

import ColdWar.models.ApplicationInstance;
import ColdWar.models.missions.MissionType;
import ColdWar.models.player.IPlayer;
import ColdWar.models.player.Player;
import ColdWar.models.player.Team;
import java.util.ArrayList;

/**
 * Implementation of the VotesManager interface.
 */
public class VotesManager implements IVotesManager{
    
    ArrayList<Player> eliminatedFirstTurn;
    ArrayList<Player> eliminatedSecondTurn;
    ArrayList<Player> winners;
    Team winnersTeam;
    
    public VotesManager(){
        this.eliminatedFirstTurn = new ArrayList<Player>();
        this.eliminatedSecondTurn = new ArrayList<Player>();
        this.winners = new ArrayList<Player>();
        this.winnersTeam = null;
    }
    
    /**
     * Method to get the maximum number of votes received by a player.
     * 
     * @param turn the number of votes has to be  checked for a specific turn.
     * 
     * @return the maximum number of votes received by a player in the selected turn.
     */
    private int getMaxVotes(int turn){
        int maxVotes = -1;
        for(Player p : ApplicationInstance.getInstance().getPlayers().get()){
            if(p.getTurnVotes(turn) > maxVotes){
                maxVotes = p.getTurnVotes(turn);
            }
        }
        return maxVotes;
    }
    
    /**
     * Method to remove an eliminated player from the count of members relative to the correct team.
     * 
     * @param p - an eliminated player.
     */
    private void removePlayerFromCount(IPlayer p){
        if(null != p.getTeam())switch (p.getTeam()) {
            case CIA:
                ApplicationInstance.getInstance().getMatch().get().decreaseCountCIA();
                break;
            case KGB:
                ApplicationInstance.getInstance().getMatch().get().decreaseCountKGB();
                break;
            case DOUBLEAGENT:
                ApplicationInstance.getInstance().getMatch().get().decreaseCountDoubleAgents();
                break;
            default:
                break;
        }
    }
    
    /**
     * {@inheritDoc} 
     */
    public ArrayList<Player> getTurnEliminated(int turn){
        int maxVotes = getMaxVotes(turn);
        switch (turn) {
            case 1:
                for(Player p : ApplicationInstance.getInstance().getPlayers().get()){
                    if(p.getTurnVotes(turn) == maxVotes){
                        p.setDead();
                        p.playTurn(2);
                        this.removePlayerFromCount(p);
                        this.eliminatedFirstTurn.add(p);
                    }
                }
                return this.eliminatedFirstTurn;
            case 2:
                for(Player p : ApplicationInstance.getInstance().getPlayers().get()){
                    if(p.getTurnVotes(turn) == maxVotes){
                        p.setDead();
                        this.removePlayerFromCount(p);
                        this.eliminatedSecondTurn.add(p);
                    }
                }
                return this.eliminatedSecondTurn;
            default:
                return null;
        }
    }
    
    /**
     * {@inheritDoc} 
     */
    public Team determineWinnersTeam(){
        if(ApplicationInstance.getInstance().getMatch().get().getCountCIA() > 
                ApplicationInstance.getInstance().getMatch().get().getCountKGB()){
            this.winnersTeam = Team.CIA;
        }else if(ApplicationInstance.getInstance().getMatch().get().getCountCIA() <
                ApplicationInstance.getInstance().getMatch().get().getCountKGB()){
            this.winnersTeam = Team.KGB;
        }else{
            this.winnersTeam = Team.DOUBLEAGENT;
        }
        return this.winnersTeam;
    }
    
    /**
     * Method to check if the player completed his extra mission, if assigned.
     * 
     * @param p - the player to be checked.
     * 
     * @return true if the player has completed an extra mission, false otherwise.
     */
    private boolean checkMissionComplete(IPlayer p){
        boolean missionComplete = false;
        if(p.hasExtraMission()){
            if((p.getExtraMissionType() == MissionType.MURDER) && !(p.getExtraMissionTarget().isAlive())){
                p.setExtraMissionCompleted();
                missionComplete = true;
            }else if((p.getExtraMissionType() == MissionType.SUICIDE) && !(p.isAlive())){
                p.setExtraMissionCompleted();
                missionComplete = true;
            }else if((p.getExtraMissionType() == MissionType.BODYGUARD) && (p.getExtraMissionTarget().isAlive())){
                p.setExtraMissionCompleted();
                missionComplete = true;
            }
        }
        return missionComplete;
    }
    
    /**
     * {@inheritDoc} 
     */
    public ArrayList<Player> getWinners(){
        Team win = this.determineWinnersTeam();
        for(Player p : ApplicationInstance.getInstance().getPlayers().get()){
            if(p.getTeam() == win || checkMissionComplete(p)){
                this.winners.add(p);
            }
        }
        return this.winners;
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
	public boolean somePlayersStillAlive() {
		boolean ret = false;
		for(Player p : ApplicationInstance.getInstance().getPlayers().get()) {
			if(p.isAlive()) {
				ret = true;
			}
		}
		return ret;
	}

}
