/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ColdWar.controllers;

import ColdWar.models.Model;
import ColdWar.views.View;

/**
 * Generic controller template.
 */
public interface Controller {
    
    /**
     * Get the actual model of this controller.
     * 
     * @return the instance of model attached to this Controller.
     */
    Model getModel();
    
    /**
     * Set the model for this controller.
     * 
     * @param model - the model that has to be linked to this controller.
     */
    void setModel(Model model);
    
    /**
     * Get the actual view of this controller.
     * 
     * @return the instance of view attached to this Controller.
     */
    View getView();
    
    /**
     * Set the view for this controller.
     * 
     * @param view - the view that has to be linked to this controller.
     */
    void setView(View view);

    /**
     * Method to manage a pressed button.
     * 
     * @param action - the type of pressed button.
     */
    public void buttonPressed(String action);
}
