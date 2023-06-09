/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.views.winners;

import ColdWar.controllers.winners.WinnersController;
import ColdWar.models.player.Player;
import ColdWar.models.player.Team;
import ColdWar.views.AbstractView;
import ColdWar.views.startup.FrameSingleton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

/**
 * In this view the winning team and the winner players will be announced.
 */
public class WinnersView extends AbstractView implements ActionListener{
    
    private Team winnerTeam;
    private ArrayList<Player> winners;
    
    public WinnersView(WinnersController ctr, Team winnerTeam, ArrayList<Player> winners){
        super.setController(ctr);
        this.winnerTeam = winnerTeam;
        this.winners = winners;
        
        JFrame mainFrame = FrameSingleton.getFrameSingleton();
        
        JPanel winnersPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        winnersPanel.setPreferredSize(new Dimension(FrameSingleton.FRAME_WIDTH, FrameSingleton.FRAME_HEIGHT));
        winnersPanel.setBackground(new Color(FrameSingleton.FRAME_BG));
        
        JLabel explanationLabel = new JLabel("<html><h2>This is the end of the match.</h2></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        winnersPanel.add(explanationLabel, gbc);
        
        JLabel winnerTeamExplanation = new JLabel("<html><h2>The winner team is</h2></html>");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        winnersPanel.add(winnerTeamExplanation, gbc);
        
        JLabel winnerTeamText = new JLabel("<html><h1>" + this.winnerTeam.name() + "</h1></html>");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        winnersPanel.add(winnerTeamText, gbc);
        
         JLabel winnersList = new JLabel("<html><h2>The following players won the match.<br>"
                                        + "The list includes the members of the winning team<br>"
                                        + "and the players who completed an extra mission.</h2></html>");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        winnersPanel.add(winnersList, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        winnersPanel.add(Box.createVerticalStrut(50), gbc);
        
        String[] labels = new String[]{"<html><h3>Name</h3></html>", "<html><h3>Team</h3></html>", "<html><h3>Extra mission</h3></html>"};
        String[][] tableValues = new String[this.winners.size()][3];
        for(int i = 0; i < tableValues.length; i++){
            tableValues[i][0] = "<html><h4>" + this.winners.get(i).getName() + "</h4></html>";
            tableValues[i][1] = "<html><h4>" + this.winners.get(i).getTeam().name() + "</h4></html>";
            if(this.winners.get(i).getExtraMissionCompleted()){
                tableValues[i][2] = "<html><h4>" + this.winners.get(i).getExtraMissionType().name() + "</h4></html>";
            }
        }
        JTable table = new JTable(tableValues, labels);
        table.setCellSelectionEnabled(false);
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setPreferredSize(new Dimension(400, 200));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        winnersPanel.add(tableScrollPane, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        winnersPanel.add(Box.createVerticalStrut(100), gbc);
        
        JButton continueButton = new JButton("Continue");
        continueButton.setPreferredSize(new Dimension(400, 50));
        continueButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.CENTER;
        winnersPanel.add(continueButton, gbc);
        
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().add(winnersPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
    
    public void actionPerformed(ActionEvent ae) {
        super.getController().buttonPressed(null);
    }
    
}
