/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.views.setup;

import ColdWar.controllers.setup.SetupController;
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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

/**
 * The view where the players are added to the match.
 */
public class SetupView extends AbstractView implements ActionListener{
    
    public static final String ADD_COMMAND = "add";
    public static final String REMOVE_COMMAND = "remove";
    public static final String CONTINUE_COMMAND = "continue";
    private DefaultListModel<String> listModel;
    private JList<String> list;
    private JTextField textField;
    private JButton removeButton;
    private JButton addButton;
    private JButton continueButton;
    private JFrame mainFrame;
    
    public SetupView(SetupController ctr){
        super.setController(ctr);
        
        mainFrame = FrameSingleton.getFrameSingleton();
        
        JPanel setupPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setupPanel.setPreferredSize(new Dimension(FrameSingleton.FRAME_WIDTH, FrameSingleton.FRAME_HEIGHT));
        setupPanel.setBackground(new Color(FrameSingleton.FRAME_BG));
  
        JLabel titleLabel = new JLabel("<html><h1>Add 5 to 13 players to start a new game.</h1></html>", SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0; 
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        setupPanel.add(titleLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        setupPanel.add(Box.createVerticalStrut(50), gbc);

        listModel = new DefaultListModel<String>();
        list = new JList<String>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(list);
        listScrollPane.setPreferredSize(new Dimension(400, 300));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        setupPanel.add(listScrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        setupPanel.add(Box.createVerticalStrut(50), gbc);

        removeButton = new JButton("Remove");
        removeButton.setPreferredSize(new Dimension(120, 50));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        removeButton.addActionListener(this);
        removeButton.setActionCommand(REMOVE_COMMAND);
        setupPanel.add(removeButton, gbc);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 50));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        setupPanel.add(textField, gbc);

        addButton = new JButton("Add");
        addButton.setPreferredSize(new Dimension(120, 50));
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        addButton.addActionListener(this);
        addButton.setActionCommand(ADD_COMMAND);
        setupPanel.add(addButton, gbc);   
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        setupPanel.add(Box.createVerticalStrut(50), gbc);
        
        continueButton = new JButton("Start game");
        continueButton.setPreferredSize(new Dimension(400, 50));
        continueButton.setEnabled(false);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        continueButton.addActionListener(this);
        continueButton.setActionCommand(CONTINUE_COMMAND);
        gbc.anchor = GridBagConstraints.CENTER;
        setupPanel.add(continueButton, gbc);
        
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().add(setupPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
    
    /**
     * Method to enable or disable the Add button.
     * 
     * @param enabled - true if the button should be enabled, false otherwise.
     */
    public void setAddButtonEnabled(boolean enabled){
        this.addButton.setEnabled(enabled);
    }
    
    /**
     * Method to enable or disable the Remove button.
     * 
     * @param enabled - true if the button should be enabled, false otherwise.
     */
    public void setRemoveButtonEnabled(boolean enabled){
        this.removeButton.setEnabled(enabled);
    }
    
    /**
     * Method to enable or disable the Continue button.
     * 
     * @param enabled - true if the button should be enabled, false otherwise.
     */
    public void setContinueButtonEnabled(boolean enabled){
        this.continueButton.setEnabled(enabled);
    }
    
    /**
     * Method to search an element in the list model.
     * 
     * @param element - the element to be searched.
     * 
     * @return true if the element is present, false otherwise.
     */
    public boolean searchInListModel(String element){
        return this.listModel.contains(element);
    }
    
    /**
     * Method to add an element to the list model.
     * 
     * @param element - the element to be added.
     */
    public void addInListModel(String element){
        this.listModel.addElement(element);
    }
    
    /**
     * Method to remove an element from the list model.
     * 
     * @param element - the element to be removed.
     */
    public void removeFromListModel(int element){
        this.listModel.remove(element);
    }
    
    /**
     * Method to get the size of the list model.
     * 
     * @return the size of the list model.
     */
    public int getListModelSize(){
        return this.listModel.getSize();
    }
    
    /**
     * Method to get an element from the list model.
     * 
     * @param index - the index of the element.
     * 
     * @return the element that corresponds to the index.
     */
    public String getFromListModel(int index){
        return this.listModel.get(index);
    }
    
    /**
     * Method to get the selected index from the list.
     * 
     * @return the selected index from the list.
     */
    public int getListSelectedIndex(){
        return this.list.getSelectedIndex();
    }
    
    /**
     * Method to get the content of the text field.
     * 
     * @return the content of the text field.
     */
    public String getTextFieldText(){
        return this.textField.getText();
    }
    
    /**
     * Method to set the content of the text field.
     * 
     * @param text - the content to be set.
     */
    public void setTextFieldText(String text){
        this.textField.setText(text);
    }
    
    /**
     * Shows a dialog window if the player's name is empty.
     */
    public void showEmptyError() {
    	JOptionPane.showMessageDialog(mainFrame, "The player's name can't be empty.");
    }
    
    /**
     * Shows a dialog window if the player's name is not unique.
     */
    public void showDuplicateError() {
    	JOptionPane.showMessageDialog(mainFrame, "The name of every player must be unique.");
    }

    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        super.getController().buttonPressed(action);
    }
}
