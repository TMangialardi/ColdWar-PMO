/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.views.missions;

import ColdWar.controllers.missions.DossierMissionController;
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
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

/**
 * View for the Dossier mission.
 */
public class DossierView extends AbstractView implements ActionListener{
    
    public static final String SELECT_COMMAND = "select";
    public static final String RESET_COMMAND = "reset";
    public static final String VERIFY_COMMAND = "verify";
    public static final String CONTINUE_COMMAND = "continue";
    public static final String CIA_COMMAND = "cia";
    public static final String KGB_COMMAND = "kgb";
    public static final String DOUBLEAGENT_COMMAND = "doubleagent";
    
    private int firstSelected;
    private int secondSelected;
    private JFrame mainFrame;
    private JButton selectButton;
    private JButton resetButton;
    private JButton verifyButton;
    private JButton continueButton;
    private JRadioButton ciaButton;
    private JRadioButton kgbButton;
    private JRadioButton doubleAgentButton;
    private ButtonGroup group;
    private JList<String> list;
    private DefaultListModel<String> listModel;
    private JLabel resultLabel;
    private IPlayer selectedPlayer;
    private MissionType selectedMission;
    
    public DossierView(DossierMissionController ctr, IPlayer selectedPlayer){
        super.setController(ctr);
        this.selectedPlayer = selectedPlayer;
        this.selectedMission = MissionType.DOSSIER;
        this.firstSelected = -1;
        this.secondSelected = -1;
        
        mainFrame = FrameSingleton.getFrameSingleton();
        
        JPanel dossierPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        dossierPanel.setPreferredSize(new Dimension(FrameSingleton.FRAME_WIDTH, FrameSingleton.FRAME_HEIGHT));
        dossierPanel.setBackground(new Color(FrameSingleton.FRAME_BG));
        
        JLabel playerLabel = new JLabel ("<html><h1>" + this.selectedPlayer.getName() + "</h1></html>", SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0; 
        gbc.anchor = GridBagConstraints.CENTER;
        dossierPanel.add(playerLabel, gbc);
        
        JLabel missionText = new JLabel("<html><h2>is playing the mission</h2></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 1;
        dossierPanel.add(missionText, gbc);
        
        JLabel missionName = new JLabel("<html><h1>" + this.selectedMission.name() + "</h1></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 2;
        dossierPanel.add(missionName, gbc);
        
        JLabel missionDetails = new JLabel("<html><h2>and can pick a team and two players.<br>"
                                            + "After that, the player is informed whether<br>"
                                            + "or not at least one of them belongs to that team.</h2></html>", SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 3;
        dossierPanel.add(missionDetails, gbc);
        
        ciaButton = new JRadioButton("<html><h3>" + Team.CIA.name() + "</h3></html>", false);
        ciaButton.setOpaque(false);
        ciaButton.setActionCommand(CIA_COMMAND);
        kgbButton = new JRadioButton("<html><h3>" + Team.KGB.name() + "</h3></html>", false);
        kgbButton.setOpaque(false);
        kgbButton.setActionCommand(KGB_COMMAND);
        doubleAgentButton = new JRadioButton("<html><h3>" + Team.DOUBLEAGENT.name() + "</h3></html>", false);
        doubleAgentButton.setOpaque(false);
        doubleAgentButton.setActionCommand(DOUBLEAGENT_COMMAND);
        group = new ButtonGroup();
        group.add(ciaButton);
        group.add(kgbButton);
        group.add(doubleAgentButton);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_START;
        dossierPanel.add(doubleAgentButton, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        dossierPanel.add(kgbButton, gbc);
        gbc.anchor = GridBagConstraints.LINE_END;
        dossierPanel.add(ciaButton, gbc);
        
        listModel = new DefaultListModel<String>();
        for(int i = 0; i < super.getController().getModel().getPlayers().get().size(); i++){
            listModel.add(i, super.getController().getModel().getPlayer(i).get().getName());
        }
        list = new JList<String>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(list);
        listScrollPane.setPreferredSize(new Dimension(400, 200));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        dossierPanel.add(listScrollPane, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        dossierPanel.add(Box.createVerticalStrut(10), gbc);
        
        selectButton = new JButton("<html>Select<br>player</html>");
        selectButton.setPreferredSize(new Dimension(100, 50));
        selectButton.addActionListener(this);
        selectButton.setActionCommand(SELECT_COMMAND);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.LINE_START;
        dossierPanel.add(selectButton, gbc);
        
        resetButton = new JButton("Reset");
        resetButton.setPreferredSize(new Dimension(100, 50));
        resetButton.addActionListener(this);
        resetButton.setActionCommand(RESET_COMMAND);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.CENTER;
        dossierPanel.add(resetButton, gbc);
        
        verifyButton = new JButton("Verify");
        verifyButton.setPreferredSize(new Dimension(100, 50));
        verifyButton.setEnabled(false);
        verifyButton.addActionListener(this);
        verifyButton.setActionCommand(VERIFY_COMMAND);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.LINE_END;
        dossierPanel.add(verifyButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.CENTER;
        dossierPanel.add(Box.createVerticalStrut(10), gbc);
        
        resultLabel = new JLabel();
        resultLabel.setVisible(false);
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.CENTER;
        dossierPanel.add(resultLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.CENTER;
        dossierPanel.add(Box.createVerticalStrut(10), gbc);
        
        continueButton = new JButton("Continue");
        continueButton.setPreferredSize(new Dimension(400, 50));
        continueButton.setEnabled(false);
        continueButton.addActionListener(this);
        continueButton.setActionCommand(CONTINUE_COMMAND);
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.CENTER;
        dossierPanel.add(continueButton, gbc);
        
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().add(dossierPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
    
    /**
     * Method to get the index of the first selected player.
     * 
     * @return the index of the first selected player.
     */
    public int getFirstSelected(){
        return this.firstSelected;
    }
    
    /**
     * Method to set the index of the second selected player.
     * 
     * @param selected - the index to be set
     */
    public void setFirstSelected(int selected){
        this.firstSelected = selected;
    }
    
    /**
     * Method to get the index of the second selected player.
     * 
     * @return the index of the second selected player.
     */
    public int getSecondSelected(){
        return this.secondSelected;
    }
    
    /**
     * Method to set the index of the second selected player.
     * 
     * @param selected - the index to be set
     */
    public void setSecondSelected(int selected){
        this.secondSelected = selected;
    }

    /**
     * method to enable or disable the Select button
     * 
     * @param enabled - true if the button must be enabled, false otherwhise
     */
    public void setSelectButtonEnabled(boolean enabled){
        this.selectButton.setEnabled(enabled);
    }
    
    /**
     * method to enable or disable the Reset button
     * 
     * @param enabled - true if the button must be enabled, false otherwhise
     */
    public void setResetButtonEnabled(boolean enabled){
        this.resetButton.setEnabled(enabled);
    }
    
    /**
     * method to enable or disable the Verify button
     * 
     * @param enabled - true if the button must be enabled, false otherwhise
     */
    public void setVerifyButtonEnabled(boolean enabled){
        this.verifyButton.setEnabled(enabled);
    }
    
    /**
     * method to enable or disable the Continue button
     * 
     * @param enabled - true if the button must be enabled, false otherwhise
     */
    public void setContinueButtonEnabled(boolean enabled){
        this.continueButton.setEnabled(enabled);
    }
    
    /**
     * Method to get the status of the CIA radio button.
     * 
     * @return the status of the CIA radio button.
     */
    public boolean getCiaButtonEnabled(){
        return this.ciaButton.isEnabled();
    }
    
    /**
     * Method to get the status of the KGB radio button.
     * 
     * @return the status of the KGB radio button.
     */
    public boolean getKgbButtonEnabled(){
        return this.kgbButton.isEnabled();
    }
    
    /**
     * Method to get the status of the DOUBLEAGENT radio button.
     * 
     * @return the status of the DOUBLEAGENT radio button.
     */
    public boolean getDoubleAgentButtonEnabled(){
        return this.doubleAgentButton.isEnabled();
    }
    
    /********************************/
    public String getTeamSelection() {
    	if(this.group.getSelection() != null) {
    		return this.group.getSelection().getActionCommand();
    	}else {
    		return null;
    	}
    }
    
    /**
     * Method to get the selected index of the list.
     * 
     * @return the selected index of the list.
     */
    public int getListSelectedIndex(){
        return this.list.getSelectedIndex();
    }
    
    /**
     * Method to set the text of the Result label.
     * 
     * @param text - the text to be set.
     */
    public void setResultLabelText(String text){
        this.resultLabel.setText(text);
    }
    
    /**
     * Method to set the visibility of the Result label.
     * 
     * @param visible - the visibility to be set.
     */
    public void setResultLabelVisible(boolean visible){
        this.resultLabel.setVisible(visible);
    }
    
    /**
     * Method to get the visibility of the Result label.
     * 
     * @return the visibility of the Result label. 
     */
    public boolean getResultLabelVisibility(){
        return this.resultLabel.isVisible();
    }

    /**
     * Shows a dialog window if no player is selected.
     */
    public void showNotSelectedDialog() {
    	JOptionPane.showMessageDialog(mainFrame, "You must select a player.");
    }
    
    /**
     * Shows a dialog window if no team is selected.
     */
    public void showNoTeamDialog() {
    	JOptionPane.showMessageDialog(mainFrame, "You must select a team.");

    }
    
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        super.getController().buttonPressed(action);
    }
}
