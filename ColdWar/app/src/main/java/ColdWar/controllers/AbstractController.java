/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.controllers;

import ColdWar.models.Model;
import ColdWar.views.View;

/**
 *Abstract implementation of the Controller interface.
 * Extended by the other controllers.
 */
public abstract class AbstractController implements Controller{
    
    private Model model;
    private View view;

    /**
     * {@inheritDoc}
     */
    public Model getModel() {
        return this.model;
    }

    /**
     * {@inheritDoc}
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * {@inheritDoc}
     */
    public View getView() {
        return this.view;
    }

    /**
     * {@inheritDoc}
     */
    public void setView(View view) {
        this.view = view;
    }
    
    /**
     * {@inheritDoc}
     */
    public abstract void buttonPressed(String action);
}
