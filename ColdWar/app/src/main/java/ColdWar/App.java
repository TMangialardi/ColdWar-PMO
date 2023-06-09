/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar;

import ColdWar.controllers.startup.StartupController;
import ColdWar.views.startup.StartupView;

/**
 *
 * @author tmang
 */
public class App {
    
    public static void main(String[] args){
        StartupController startupController = new StartupController();
        startupController.setView(new StartupView(startupController));
    }
    
}
