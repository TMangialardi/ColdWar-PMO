/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.views.votes;

import ColdWar.controllers.votes.VotesController;
import ColdWar.views.AbstractView;
import ColdWar.views.startup.FrameSingleton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

/**
 *
 * @author tmang
 */
public class VotesView extends AbstractView implements ActionListener{
    
    private int playerCounter;
    private DefaultListModel<String> listModel;
    private JList<String> list;
    private JScrollPane listScrollPane;
    private JFrame mainFrame;
    private JLabel playerLabel;
    
    public VotesView(VotesController ctr){
        super.setController(ctr);
        this.playerCounter = 0;
        
        mainFrame = FrameSingleton.getFrameSingleton();
        
        JPanel votesPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        votesPanel.setPreferredSize(new Dimension(FrameSingleton.FRAME_WIDTH, FrameSingleton.FRAME_HEIGHT));
        votesPanel.setBackground(new Color(FrameSingleton.FRAME_BG));
        
        JLabel explanationLabel = new JLabel("<html><h2>Every player will now get the opportunity<br>"
                                            + "to vote for another player's elimination.<br>"
                                            + "The players can also vote for themselves. Once<br>"
                                            + "the vote is submitted, it can't be undone.</h2></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        votesPanel.add(explanationLabel, gbc);
        
        listModel = new DefaultListModel<String>();
        for(int i = 0; i < super.getController().getModel().getPlayers().get().size(); i++){
            if(super.getController().getModel().getPlayer(i).get().isAlive()) {
            	listModel.addElement(super.getController().getModel().getPlayer(i).get().getName());
            }
        }
        list = new JList<String>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listScrollPane = new JScrollPane(list);
        listScrollPane.setPreferredSize(new Dimension(400, 200));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        listScrollPane.setVisible(false);
        votesPanel.add(listScrollPane, gbc);
        
        JLabel turnText = new JLabel("<html><h2>It's now the turn of the player</h2></html>");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        votesPanel.add(turnText, gbc);
        
        playerLabel = new JLabel("<html><h1>" + listModel.get(playerCounter) + "</h1></html>");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        votesPanel.add(playerLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        votesPanel.add(Box.createVerticalStrut(300), gbc);
        
        JButton continueButton = new JButton("Continue");
        continueButton.setPreferredSize(new Dimension(400, 50));
        continueButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        votesPanel.add(continueButton, gbc);
        
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().add(votesPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
    
    /**
     * Method to get the value of the player counter.
     * 
     * @return the value of the player counter.
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
     * Method to get the visibility of the listScrollPane.
     * 
     * @return the visibility of the listScrollPane.
     */
    public boolean getListScrollPaneVisibility(){
        return this.listScrollPane.isVisible();
    }
    
    /**
     * Method to set the visibility of the listScrollPane.
     * 
     * @param visibility - true if the listScrollPane should be visible, false otherwise.
     */
    public void setListScrollPaneVisibility(boolean visibility){
        this.listScrollPane.setVisible(visibility);
    }
    
    /**
     * Method to get an element from the listModel
     * 
     * @param index - the index of the required element.
     * 
     * @return the required element.
     */
    public String getFromListModel(int index){
        return this.listModel.get(index);
    }
    
    /**
     * Method to get the size of the listModel.
     * 
     * @return the size of the listModel.
     */
    public int getListModelSize() {
    	return this.listModel.size();
    }
    /**
     * Method to get the selected element of the list.
     * 
     * @return the selected element of the list.
     */
    public String getListSelected(){
        if(this.list.getSelectedIndex() != -1) {
        	return this.listModel.get(this.list.getSelectedIndex());
        }else {
        	return "";
        }
    }
    
    /**
     * Method to clean the list selection.
     */
    public void clearListSelection(){
        this.list.clearSelection();
    }
    
    /**
     * Method to update the frame.
     */
    public void updateFrame(){
        this.mainFrame.revalidate();
        this.mainFrame.repaint();
    }
    
    /**
     * Method to set the text of the player label.
     * 
     * @param text - the text to be set.
     */
    public void setPlayerLabelText(String text){
        this.playerLabel.setText(text);
    }
    
    /**
     * Method to show a dialog window if no player is selected.
     */
    public void showNoPlayerSelectedError() {
    	JOptionPane.showMessageDialog(mainFrame, "You must select a player.");

    }

    public void actionPerformed(ActionEvent ae) {
        super.getController().buttonPressed(null);
    }
    
}
