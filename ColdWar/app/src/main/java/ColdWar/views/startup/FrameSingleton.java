/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.views.startup;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

/**
 * This class generates the JFrame using the Singleton pattern.
 */
public class FrameSingleton extends JFrame{
    
    private static final long serialVersionUID = 1513721050621059575L;
	private static FrameSingleton instance = null;
    public final static int FRAME_HEIGHT = 800;
    public final static int FRAME_WIDTH = 600;
    public final static String FRAME_NAME = "Cold War";
    public final static int FRAME_BG = 13434880;
    
    private FrameSingleton(){
    }
    
    /**
     * Method to get the FrameSingleton instance.
     * 
     * @return the FrameSingleton instance.
     */
    public static synchronized FrameSingleton getFrameSingleton(){
        if(instance == null){
            instance = new FrameSingleton();
            configureInstance();
        }
        return instance;
    }
    
    /**
     * Method to configure the singleton instance of the frame.
     */
    private static void configureInstance() {
    	instance.setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        instance.setDefaultCloseOperation(EXIT_ON_CLOSE);
        instance.setResizable(true);
        instance.setBackground(new Color(FRAME_BG));
        instance.setTitle(FRAME_NAME);
        
        JMenuBar menuBar = MenuBarSingleton.getMenuBarSingleton();
        instance.setJMenuBar(menuBar);
    }
}
