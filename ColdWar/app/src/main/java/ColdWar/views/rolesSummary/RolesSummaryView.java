/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.views.rolesSummary;

import ColdWar.controllers.rolesSummary.RolesSummaryController;
import ColdWar.models.player.Player;
import ColdWar.views.AbstractView;
import ColdWar.views.startup.FrameSingleton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * View to show separately to each player its role.
 */
public class RolesSummaryView extends AbstractView implements ActionListener{
    
    private int playerCounter;
    private boolean roleVisibility;
    private JLabel nameLabel;
    private JLabel roleLabel;
    
    public RolesSummaryView(RolesSummaryController ctr, ArrayList<Player> players){
        super.setController(ctr);
        JFrame mainFrame = FrameSingleton.getFrameSingleton();
        
        this.playerCounter = 0;
        this.roleVisibility = false;
        
        JPanel rolesSummaryPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        rolesSummaryPanel.setPreferredSize(new Dimension(FrameSingleton.FRAME_WIDTH, FrameSingleton.FRAME_HEIGHT));
        rolesSummaryPanel.setBackground(new Color(FrameSingleton.FRAME_BG));
        
        JLabel explanationLabel = new JLabel("<html><h2>The listed player must press the button<br>"
                                            + "to see his role, then press the button<br>"
                                            + "again and call the next selected player.</h2></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        rolesSummaryPanel.add(explanationLabel, gbc);
        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 1;
        rolesSummaryPanel.add(Box.createVerticalStrut(150), gbc);
        
        nameLabel = new JLabel("<html><h1>" + players.get(playerCounter).getName()
                + "</h1></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 2;
        rolesSummaryPanel.add(nameLabel, gbc);
        
        JLabel memberOfLabel = new JLabel("<html><h2>is a member of</h2></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 3;
        rolesSummaryPanel.add(memberOfLabel, gbc);
        
        roleLabel = new JLabel("<html><h1>" + players.get(playerCounter).getTeam().name()
                + "</h1></html>", SwingConstants.CENTER);
        roleLabel.setVisible(roleVisibility);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 4;
        rolesSummaryPanel.add(roleLabel, gbc);
        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 5;
        rolesSummaryPanel.add(Box.createVerticalStrut(150), gbc);
        
        JButton continueButton = new JButton("Continue");
        continueButton.setPreferredSize(new Dimension(400, 50));
        continueButton.addActionListener(this);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 6;
        rolesSummaryPanel.add(continueButton, gbc);
        
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().add(rolesSummaryPanel);
        mainFrame.revalidate();
        mainFrame.repaint();      
    }
    
    /**
     * Method to get the player counter.
     * 
     * @return the player counter.
     */
    public int getPlayerCounter(){
        return this.playerCounter;
    }
    
    /**
     * Method to increment the player counter.
     */
    public void incrementPlayerCounter(){
        this.playerCounter++;
    }
    
    /**
     * Method to get the role visibility.
     * 
     * @return the role visibility.
     */
    public boolean getRoleVisibility(){
        return this.roleVisibility;
    }
    
    /**
     * Method to set the role visibility.
     * 
     * @param visibility - the value to be set.
     */
    public void setRoleVisibility(boolean visibility){
        this.roleVisibility = visibility;
    }
    
    /**
     * Method to set the text of the Name label.
     * 
     * @param text - the text to be set.
     */
    public void setNameLabelText(String text){
        this.nameLabel.setText(text);
    }
    
    /**
     * Method set the visibility of the Role label.
     * 
     * @param visibility - the value to be set.
     */
    public void setRoleLabelVisibility(boolean visibility){
        this.roleLabel.setVisible(visibility);
    }
    
    /**
     * Method to set the text of the Role label.
     * 
     * @param text the text to be set.
     */
    public void setRoleLabelText(String text){
        this.roleLabel.setText(text);
    }
//    
    public void actionPerformed(ActionEvent ae) {
        super.getController().buttonPressed(null);
    }
    
}
