/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.views.nextPlayer;

import ColdWar.controllers.nextPlayer.NextPlayerController;
import ColdWar.models.missions.MissionType;
import ColdWar.models.player.IPlayer;
import ColdWar.views.AbstractView;
import ColdWar.views.startup.FrameSingleton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * View to show the next selected player.
 */
public class NextPlayerView extends AbstractView implements ActionListener{
    
    private MissionType selectedMission;
    private IPlayer selectedPlayer;
    
    public NextPlayerView(NextPlayerController ctr, IPlayer selectedPlayer, MissionType selectedMission){
        super.setController(ctr);
        this.selectedMission = selectedMission;
        this.selectedPlayer = selectedPlayer;
        
        JFrame mainFrame = FrameSingleton.getFrameSingleton();
        
        JPanel nextPlayerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        nextPlayerPanel.setPreferredSize(new Dimension(FrameSingleton.FRAME_WIDTH, FrameSingleton.FRAME_HEIGHT));
        nextPlayerPanel.setBackground(new Color(FrameSingleton.FRAME_BG));
        
        JLabel theNextPlayer = new JLabel("<html><h2>The next selected player is</h2></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        nextPlayerPanel.add(theNextPlayer, gbc);
        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 1;
        nextPlayerPanel.add(Box.createVerticalStrut(100), gbc);
        
        JLabel actualPlayer = new JLabel("<html><h1>" + this.selectedPlayer.getName() + "</h1></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 2;
        nextPlayerPanel.add(actualPlayer, gbc);
        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 3;
        nextPlayerPanel.add(Box.createVerticalStrut(200), gbc);
        
        JButton continueButton = new JButton("Continue");
        continueButton.setPreferredSize(new Dimension(400, 50));
        continueButton.addActionListener(this);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 4;
        nextPlayerPanel.add(continueButton, gbc);
        
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().add(nextPlayerPanel);
        mainFrame.revalidate();
        mainFrame.repaint();        
    }
    
    /**
     * Method to get the selected player.
     * 
     * @return the selected player.
     */
    public IPlayer getSelectedPlayer(){
        return this.selectedPlayer;
    }
    
    /**
     * Method to get the selected mission.
     * 
     * @return the selected mission.
     */
    public MissionType getSelectedMission(){
        return this.selectedMission;
    }

    public void actionPerformed(ActionEvent ae) {
        super.getController().buttonPressed(null);
    }
}
