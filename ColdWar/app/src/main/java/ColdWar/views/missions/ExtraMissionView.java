/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.views.missions;

import ColdWar.controllers.missions.CommonMissionController;
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
 * View for the extra missions (Murder, Suicide, Bodyguard).
 */
public class ExtraMissionView extends AbstractView implements ActionListener{
    
    public final static String MURDER_TEXT = "<html><h2>and must cause the elimination of the<br>"
                                            + "selected player. If the mission is completed<br>"
                                            + "within the entire match, the player wins.<br>"
                                            + "The selected player is</h2></html>";
    public final static String SUICIDE_TEXT= "<html><h2>and must get eliminated by the other players.<br>"
                                            + "If the mission is completed within the entire<br>"
                                            + "match, the player wins.</h2></html>";
    public final static String BODYGUARD_TEXT = "<html><h2>and must avoid the elimination of the<br>"
                                            + "selected player, regardless of that player's<br>"
                                            + "team. If the mission is completed within<br>"
                                            + "the entire match, the player wins.<br>"
                                            + "The selected player is</h2></html>";
    private IPlayer selectedPlayer;
    private IPlayer targetPlayer;
    private MissionType missionType;
    
    public ExtraMissionView(CommonMissionController ctr, IPlayer selectedPlayer, IPlayer targetPlayer, MissionType missionType){
        super.setController(ctr);
        this.selectedPlayer = selectedPlayer;
        this.targetPlayer = targetPlayer;
        this.missionType = missionType;
        
        JFrame mainFrame = FrameSingleton.getFrameSingleton();
        
        JPanel extraMissionPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        extraMissionPanel.setPreferredSize(new Dimension(FrameSingleton.FRAME_WIDTH, FrameSingleton.FRAME_HEIGHT));
        extraMissionPanel.setBackground(new Color(FrameSingleton.FRAME_BG));
        
        JLabel currentName = new JLabel("<html><h1>" + this.selectedPlayer.getName() + "</h1></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        extraMissionPanel.add(currentName, gbc);
        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 1;
        extraMissionPanel.add(Box.createVerticalStrut(50), gbc);
        
        JLabel missionText = new JLabel("<html><h2>is playing the mission</h2></html>");
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 2;
        extraMissionPanel.add(missionText, gbc);
        
        JLabel missionName = new JLabel("<html><h1>" + this.missionType.name() + "</h1></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 3;
        extraMissionPanel.add(missionName, gbc);
        
        JLabel missionDetails = new JLabel();
        switch(missionType){
            case MURDER:
                missionDetails.setText(MURDER_TEXT);
                break;
            case SUICIDE:
                missionDetails.setText(SUICIDE_TEXT);
                break;
            case BODYGUARD:
                missionDetails.setText(BODYGUARD_TEXT);
                break;
            default:
            	break;
        }
        missionDetails.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 4;
        extraMissionPanel.add(missionDetails, gbc);
        
        JLabel missionTarget = new JLabel("<html><h1>" + this.targetPlayer.getName() + "</h1></html>", SwingConstants.CENTER);
        missionTarget.setVisible((this.missionType == MissionType.MURDER) || (this.missionType == MissionType.BODYGUARD));
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 5;
        extraMissionPanel.add(missionTarget, gbc);
        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 6;
        extraMissionPanel.add(Box.createVerticalStrut(100), gbc);
        
        JButton continueButton = new JButton("Continue");
        continueButton.setPreferredSize(new Dimension(400, 50));
        continueButton.addActionListener(this);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 7;
        extraMissionPanel.add(continueButton, gbc);
        
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().add(extraMissionPanel);
        mainFrame.revalidate();
        mainFrame.repaint();    
    }

    public void actionPerformed(ActionEvent ae) {
        super.getController().buttonPressed(null);
    }
    
}
