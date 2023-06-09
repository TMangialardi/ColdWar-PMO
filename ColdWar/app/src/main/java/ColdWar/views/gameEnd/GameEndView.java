/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.views.gameEnd;

import ColdWar.controllers.gameEnd.GameEndController;
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
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

/**
 *
 * @author tmang
 */
public class GameEndView extends AbstractView implements ActionListener{
    
    private ArrayList<Player> players;
    
    public GameEndView(GameEndController ctr, ArrayList<Player> players){
        super.setController(ctr);
        this.players = players;
        
        JFrame mainFrame = FrameSingleton.getFrameSingleton();
        
        JPanel endPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        endPanel.setPreferredSize(new Dimension(FrameSingleton.FRAME_WIDTH, FrameSingleton.FRAME_HEIGHT));
        endPanel.setBackground(new Color(FrameSingleton.FRAME_BG));
        
        JLabel explanationLabel = new JLabel("<html><h2>Now every player can see each other's role.</h2></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        endPanel.add(explanationLabel, gbc);
        
        JLabel winnerTeamExplanation = new JLabel("<html><h2>Click Exit to close the game.</h2></html>");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        endPanel.add(winnerTeamExplanation, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        endPanel.add(Box.createVerticalStrut(80), gbc);
        
        String[] tableColumns = new String[]{"<html><h3>Name</h3></html>", "<html><h3>Team</h3></html>"};
        String[][]tableCells = new String[this.players.size()][2];
        for(int i = 0; i < this.players.size(); i++){
            tableCells[i][0] = "<html><h4>" + this.players.get(i).getName() + "</h4></html>";
            tableCells[i][1] = "<html><h4>" + this.players.get(i).getTeam().name() + "</h4></html>";
        }
        JTable table = new JTable(tableCells, tableColumns);
        table.setCellSelectionEnabled(false);
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setPreferredSize(new Dimension(400, 200));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        endPanel.add(tableScrollPane, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        endPanel.add(Box.createVerticalStrut(70), gbc);
        
        JButton exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(400, 50));
        exitButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        endPanel.add(exitButton, gbc);
        
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().add(endPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void actionPerformed(ActionEvent ae) {
        super.getController().buttonPressed(null);
    }
    
}
