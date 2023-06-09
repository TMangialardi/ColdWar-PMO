/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.views.missions;

import ColdWar.controllers.missions.CommonMissionController;
import ColdWar.models.missions.Colleagues;
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
 * View for the Colleagues mission.
 */
public class ColleaguesView extends AbstractView implements ActionListener{
    
    private IPlayer selectedPlayer;
    private MissionType selectedMission;
    private Colleagues colleagues;
    
    public ColleaguesView(CommonMissionController ctr, IPlayer selectedPlayer, Colleagues colleagues){
        super.setController(ctr);
        this.selectedPlayer = selectedPlayer;
        this.selectedMission = MissionType.COLLEAGUES;
        this.colleagues = colleagues;

        
        JFrame mainFrame = FrameSingleton.getFrameSingleton();
        
        JPanel colleaguesPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        colleaguesPanel.setPreferredSize(new Dimension(FrameSingleton.FRAME_WIDTH, FrameSingleton.FRAME_HEIGHT));
        colleaguesPanel.setBackground(new Color(FrameSingleton.FRAME_BG));
        
        JLabel currentName = new JLabel("<html><h1>" + this.selectedPlayer.getName() + "</h1></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        colleaguesPanel.add(currentName, gbc);
        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 1;
        colleaguesPanel.add(Box.createVerticalStrut(50), gbc);
        
        JLabel missionText = new JLabel("<html><h2>is playing the mission</h2></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 2;
        colleaguesPanel.add(missionText, gbc);
        
        JLabel missionName = new JLabel("<html><h1>" + this.selectedMission.name() + "</h1></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 3;
        colleaguesPanel.add(missionName, gbc);
        
        JLabel missionDetails = new JLabel("<html><h2>and can see the names of two<br>"
                                            + "players who belong to the same team<br>"
                                            + "without seeing the name of their team.<br>"
                                            + "The player</h2></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 4;
        colleaguesPanel.add(missionDetails, gbc);
        
        JLabel firstPlayerLabel = new JLabel("<html><h1>" + this.colleagues.getDrawnPlayerName(1) + "</h1></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 5;
        colleaguesPanel.add(firstPlayerLabel, gbc);
        
        JLabel teamText = new JLabel("<html><h2>Belongs to the same team of</h2></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 6;
        colleaguesPanel.add(teamText, gbc);
        
        JLabel secondPlayerTeam = new JLabel("<html><h1>" + this.colleagues.getDrawnPlayerName(2)+ "</h1></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 7;
        colleaguesPanel.add(secondPlayerTeam, gbc);
        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 8;
        colleaguesPanel.add(Box.createVerticalStrut(50), gbc);
        
        JButton continueButton = new JButton("Continue");
        continueButton.setPreferredSize(new Dimension(400, 50));
        continueButton.addActionListener(this);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 9;
        colleaguesPanel.add(continueButton, gbc);
        
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().add(colleaguesPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void actionPerformed(ActionEvent ae) {
        super.getController().buttonPressed(null);
    }
    
}
