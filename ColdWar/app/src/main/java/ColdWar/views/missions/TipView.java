/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.views.missions;

import ColdWar.controllers.missions.CommonMissionController;
import ColdWar.models.missions.MissionType;
import ColdWar.models.missions.Tip;
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
 * View for the Tip mission.
 */
public class TipView extends AbstractView implements ActionListener{
    
    private IPlayer selectedPlayer;
    private MissionType selectedMission;
    private Tip tip;
    private String tipPlayer;
    
    public TipView(CommonMissionController ctr, IPlayer selectedPlayer, Tip tip, String tipPlayer){
        super.setController(ctr);
        this.selectedPlayer = selectedPlayer;
        this.selectedMission = MissionType.TIP;
        this.tip = tip;
        this.tipPlayer = tipPlayer;
        
        JFrame mainFrame = FrameSingleton.getFrameSingleton();
        
        JPanel tipPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        tipPanel.setPreferredSize(new Dimension(FrameSingleton.FRAME_WIDTH, FrameSingleton.FRAME_HEIGHT));
        tipPanel.setBackground(new Color(FrameSingleton.FRAME_BG));
        
        JLabel currentName = new JLabel("<html><h1>" + this.selectedPlayer.getName() + "</h1></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        tipPanel.add(currentName, gbc);
        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 1;
        tipPanel.add(Box.createVerticalStrut(50), gbc);
        
        JLabel missionText = new JLabel("<html><h2>is playing the mission</h2></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 2;
        tipPanel.add(missionText, gbc);
        
        JLabel missionName = new JLabel("<html><h1>" + this.selectedMission.name() + "</h1></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 3;
        tipPanel.add(missionName, gbc);
        
        JLabel missionDetails = new JLabel("<html><h2>and is informed of another<br>"
                                            + "player's team.<br>"
                                            + "The selected player is</h2></html>", SwingConstants.CENTER);
        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 4;
        tipPanel.add(missionDetails, gbc);
        
        JLabel selectedPlayerLabel = new JLabel("<html><h1>" + this.tipPlayer + "</h1></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 5;
        tipPanel.add(selectedPlayerLabel, gbc);
        
        JLabel teamText = new JLabel("<html><h2>The selected player is a member of</h2></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 6;
        tipPanel.add(teamText, gbc);
        
        JLabel selectedPlayerTeam = new JLabel("<html><h1>" + this.tip.getDrawnPlayerTeam().name() + "</h1></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 7;
        tipPanel.add(selectedPlayerTeam, gbc);
        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 8;
        tipPanel.add(Box.createVerticalStrut(50), gbc);
        
        JButton continueButton = new JButton("Continue");
        continueButton.setPreferredSize(new Dimension(400, 50));
        continueButton.addActionListener(this);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 9;
        tipPanel.add(continueButton, gbc);
        
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().add(tipPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void actionPerformed(ActionEvent ae) {
        super.getController().buttonPressed(null);
    }
    
}
