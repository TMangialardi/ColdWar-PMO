/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.views.startup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

/**
 * Singleton implementation of a custom menu bar.
 */
public class MenuBarSingleton extends JMenuBar implements ActionListener{
  
    private static final long serialVersionUID = 5570787419697962385L;
	public static final String ROLES_FILE = "text/roles.html";
    public static final String MISSIONS_FILE = "text/missions.html";
    public static final String RULEBOOK_FILE = "text/rulebook.html";
    private static MenuBarSingleton instance = null;
    
    private static JMenu gameInfo;
    private static JMenuItem toExit;
    private MenuBarDialog dialogWindow;
    
    private MenuBarSingleton(){
        gameInfo = new JMenu("About the game");
        
        JMenuItem toRoles = new JMenuItem("Game roles");
        toRoles.addActionListener(this);
        toRoles.setActionCommand(MenuBarAction.ROLES.name());
        
        JMenuItem toMissions = new JMenuItem("Game missions");
        toMissions.addActionListener(this);
        toMissions.setActionCommand(MenuBarAction.MISSIONS.name());
        
        JMenuItem toRulebook = new JMenuItem("Full rulebook");
        toRulebook.addActionListener(this);
        toRulebook.setActionCommand(MenuBarAction.RULEBOOK.name());
        
        toExit = new JMenuItem("Exit");
        toExit.addActionListener(this);
        toExit.setActionCommand(MenuBarAction.EXIT.name());
        
        gameInfo.add(toRoles);
        gameInfo.add(toMissions);
        gameInfo.add(toRulebook);
    }
    
    /**
     * Method to get the MenuBarSingleton instance.
     * 
     * @return the MenuBarSingleton instance.
     */
    public static synchronized MenuBarSingleton getMenuBarSingleton(){
        if(instance == null){
            instance = new MenuBarSingleton();
            instance.add(gameInfo);
            instance.add(toExit);
        }
        return instance;
    }

    public void actionPerformed(ActionEvent ae) {
       String action = ae.getActionCommand();
       if(action.equals(MenuBarAction.ROLES.name())){
            dialogWindow = new MenuBarDialog(ROLES_FILE);
            SwingUtilities.invokeLater(new Runnable() {
            	public void run() {
            		dialogWindow.setVisible(true);
            	}
            });
        } else if (action.equals(MenuBarAction.MISSIONS.name())){
            dialogWindow = new MenuBarDialog(MISSIONS_FILE);
            SwingUtilities.invokeLater(new Runnable() {
            	public void run() {
            		dialogWindow.setVisible(true);
            	}
            });
        } else if (action.equals(MenuBarAction.RULEBOOK.name())){
            dialogWindow = new MenuBarDialog(RULEBOOK_FILE);
            SwingUtilities.invokeLater(new Runnable() {
            	public void run() {
            		dialogWindow.setVisible(true);
            	}
            });
        } else if (action.equals(MenuBarAction.EXIT.name())){
            System.exit(0);
        }
    }
}
