/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ColdWar.views;

import ColdWar.controllers.Controller;

/**
 * Generic View template.
 */
public interface View {
    
    /**
     * Get the actual controller of this view.
     *
     * @return the instance of the controller attached to this view.
     */
    Controller getController();
    
    /**
     * Set the controller fot this view.
     * 
     * @param controller - the controller that has to be linked to this view.
     */
    void setController(Controller controller);
}
