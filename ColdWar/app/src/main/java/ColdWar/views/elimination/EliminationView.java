/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.views.elimination;

import ColdWar.controllers.elimination.EliminationController;
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
 * In this view there will be a list of eliminated players.
 */
public class EliminationView extends AbstractView implements ActionListener{
    
    public EliminationView(EliminationController ctr, ArrayList<Player> turnEliminated){
        super.setController(ctr);
        JFrame mainFrame = FrameSingleton.getFrameSingleton();
        
        JPanel eliminationPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        eliminationPanel.setPreferredSize(new Dimension(FrameSingleton.FRAME_WIDTH, FrameSingleton.FRAME_HEIGHT));
        eliminationPanel.setBackground(new Color(FrameSingleton.FRAME_BG));
        
        JLabel explanationLabel = new JLabel("<html><h2>The turn is now concluded.</h2></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        eliminationPanel.add(explanationLabel, gbc);
        
        JLabel eliminatedText = new JLabel("<html><h2>The following players have been eliminated.</h2></html>");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        eliminationPanel.add(eliminatedText, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        eliminationPanel.add(Box.createVerticalStrut(100), gbc);
        
        String[] tableColumns = new String[]{"<html><h3>Name</h3></html>", "<html><h3>Team</h3></html>"};
        String[][]tableCells = new String[turnEliminated.size()][2];
        for(int i = 0; i < turnEliminated.size(); i++){
            tableCells[i][0] = "<html><h4>" + turnEliminated.get(i).getName() + "</h4></html>";
            tableCells[i][1] = "<html><h4>" + turnEliminated.get(i).getTeam().name() + "</h4></html>";
        }
        JTable table = new JTable(tableCells, tableColumns);
        table.setCellSelectionEnabled(false);
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setPreferredSize(new Dimension(400, 150));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        eliminationPanel.add(tableScrollPane, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        eliminationPanel.add(Box.createVerticalStrut(100), gbc);
        
        JButton continueButton = new JButton("Continue");
        continueButton.setPreferredSize(new Dimension(400, 50));
        continueButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        eliminationPanel.add(continueButton, gbc);
        
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().add(eliminationPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void actionPerformed(ActionEvent ae) {
        super.getController().buttonPressed(null);
    }
    
}
