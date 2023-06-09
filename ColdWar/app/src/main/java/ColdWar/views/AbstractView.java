/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.views;

import ColdWar.controllers.Controller;

/**
 * Abstract implementation of the View interface.
 * Extended by the other views.
 */
public abstract class AbstractView implements View{
    
    private Controller controller;
    
    /**
     * {@inheritDoc}
     */
    public Controller getController() {
        return this.controller;
    }
    
    /**
     * {@inheritDoc}
     */
    public void setController(final Controller controller) {
        this.controller = controller;
    }
    
}
