/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.views.discussionTimer;

import ColdWar.controllers.discussionTimer.DiscussionTimerController;
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
import javax.swing.Timer;

/**
 * The view where the players will discuss to decide the eliminations.
 */
public class DiscussionTimerView extends AbstractView implements ActionListener{
    
    public static final int TIME_AVAILABLE = 300;
    public static final String CONTINUE_COMMAND = "continue";
    public static final String TIMER_COMMAND = "timer";
    
    private int currentTime;
    private Timer timeLeft;
    private JLabel timer;
    
    public DiscussionTimerView(DiscussionTimerController ctr){
        super.setController(ctr);
        this.currentTime = 0;
        
        JFrame mainFrame = FrameSingleton.getFrameSingleton();
        
        JPanel discussionTimerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        discussionTimerPanel.setPreferredSize(new Dimension(FrameSingleton.FRAME_WIDTH, FrameSingleton.FRAME_HEIGHT));
        discussionTimerPanel.setBackground(new Color(FrameSingleton.FRAME_BG));
        
        JLabel infoText = new JLabel("<html><h2>The players will now have 5 minutes<br>"
                                    + "to discuss. Each player can share the<br>"
                                    + "information received and give information<br>"
                                    + "about its mission, with the possibility of lying.</h2></html>", SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        discussionTimerPanel.add(infoText, gbc);
        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 1;
        discussionTimerPanel.add(Box.createVerticalStrut(200), gbc);
        
        timer = new JLabel();
        timeLeft = new Timer(1000, this);
        timeLeft.setActionCommand(TIMER_COMMAND);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        discussionTimerPanel.add(timer, gbc);
        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 3;
        discussionTimerPanel.add(Box.createVerticalStrut(200), gbc);
        
        JButton continueButton = new JButton("Continue");
        continueButton.setPreferredSize(new Dimension(400, 50));
        continueButton.addActionListener(this);
        continueButton.setActionCommand(CONTINUE_COMMAND);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 4;
        discussionTimerPanel.add(continueButton, gbc);
        
        timeLeft.start();
        
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().add(discussionTimerPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    /**
     * Method to stop the timer.
     */
    public void stopTimer(){
        this.timeLeft.stop();
    }
    
    /**
     * Method to get the current time value.
     * 
     * @return the current time value.
     */
    public int getCurrentTime(){
        return this.currentTime;
    }
    
    /**
     * Method to increment the current time value.
     */
    public void incrementCurrentTime(){
        this.currentTime++;
    }
    
    /**
     * Method to set the text of the Timer label
     * 
     * @param text - the text to be set.
     */
    public void setTimerText(String text){
        this.timer.setText(text);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        super.getController().buttonPressed(action);
    }
    
}
