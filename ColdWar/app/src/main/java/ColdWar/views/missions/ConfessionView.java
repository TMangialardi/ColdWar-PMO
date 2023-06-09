/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.views.missions;

import ColdWar.controllers.missions.CommonMissionController;
import ColdWar.models.missions.MissionType;
import ColdWar.models.player.IPlayer;
import ColdWar.models.player.Team;
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
 * View for the Confession mission.
 */
public class ConfessionView extends AbstractView implements ActionListener{
    
    private IPlayer selectedPlayer;
    private MissionType selectedMission;
    private Team selectedPlayerTeam;
    
    public ConfessionView(CommonMissionController ctr, IPlayer selectedPlayer, Team selectedPlayerTeam){
        super.setController(ctr);
        this.selectedPlayer = selectedPlayer;
        this.selectedMission = MissionType.CONFESSION;
        this.selectedPlayerTeam = selectedPlayerTeam;
        
        JFrame mainFrame = FrameSingleton.getFrameSingleton();
        
        JPanel confessionPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        confessionPanel.setPreferredSize(new Dimension(FrameSingleton.FRAME_WIDTH, FrameSingleton.FRAME_HEIGHT));
        confessionPanel.setBackground(new Color(FrameSingleton.FRAME_BG));
        
        JLabel currentName = new JLabel("<html><h1>" + this.selectedPlayer.getName() + "</h1></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        confessionPanel.add(currentName, gbc);
        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 1;
        confessionPanel.add(Box.createVerticalStrut(50), gbc);
        
        JLabel missionText = new JLabel("<html><h2>is playing the mission</h2></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 2;
        confessionPanel.add(missionText, gbc);
        
        JLabel missionName = new JLabel("<html><h1>" + this.selectedMission.name() + "</h1></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 3;
        confessionPanel.add(missionName, gbc);
        
        JLabel missionDetails = new JLabel("<html><h2>and has to show his role to a<br>"
                                            + "choosen player by showing this window.<br>"
                                            + "This player's team is</h2></html>", SwingConstants.CENTER);
        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 4;
        confessionPanel.add(missionDetails, gbc);
        
        JLabel roleLabel = new JLabel("<html><h1>" + this.selectedPlayerTeam.name() + "</h1></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 5;
        confessionPanel.add(roleLabel, gbc);
        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 6;
        confessionPanel.add(Box.createVerticalStrut(100), gbc);
        
        JButton continueButton = new JButton("Continue");
        continueButton.setPreferredSize(new Dimension(400, 50));
        continueButton.addActionListener(this);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 7;
        confessionPanel.add(continueButton, gbc);
        
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().add(confessionPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
        
    }

    public void actionPerformed(ActionEvent ae) {
        super.getController().buttonPressed(null);
    }
    
}
