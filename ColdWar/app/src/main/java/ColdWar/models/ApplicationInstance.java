/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.models;

import ColdWar.models.match.Match;
import ColdWar.models.player.Player;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Implementation of the model interface.
 * 
 * This implementation of the model interface is intended as a singleton class whose singular instance
 * provides the shared data to the other classes that belong to the model.
 * 
 */
public final class ApplicationInstance implements Model{
    
    private ArrayList<Player> players;
    private Match match;
    private static ApplicationInstance instance = null;
    
    /**
     * Private singleton constructor.
     */
    private ApplicationInstance(){}
    
    /**
     * Method to get the singular instance of the class.
     * 
     * @return the sincular instance of the class.
     */
    public static synchronized ApplicationInstance getInstance(){
        if(instance == null){
            instance = new ApplicationInstance();
        }
        return instance;
    }
    
    /**
     * {@inheritDoc} 
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * {@inheritDoc} 
     */    
    public Optional<ArrayList<Player>> getPlayers() {
        return Optional.ofNullable(this.players);
    }

    /**
     * {@inheritDoc} 
     */
    public void addPlayer(Player player) {
        this.players.add(player);
    }

    /**
     * {@inheritDoc} 
     */
    public Optional<Player> getPlayer(int index) {
        return Optional.ofNullable(this.players.get(index));
    }

    /**
     * {@inheritDoc} 
     */    
    public void setMatch(Match match) {
        this.match = match;
    }

    /**
     * {@inheritDoc} 
     */    
    public Optional<Match> getMatch() {
        return Optional.ofNullable(this.match);
    }
    
}
