/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.views.startup;

import ColdWar.controllers.startup.StartupController;
import ColdWar.views.AbstractView;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * The view when the game is opened.
 */
public class StartupView extends AbstractView implements ActionListener{
    
    public static final int STARTUP_BTN_HEIGHT = 80;
    public static final int STARTUP_BTN_WIDTH = 350;
    public static final String TOEXIT_COMMAND = "toExit";
    public static final String TOPLAY_COMMAND = "toPlay";
    public static final String LOGO_FILE = "/logo/logo.png";
    
    private JLabel title;
    
    public StartupView(StartupController ctr){
        super.setController(ctr);
        
        JFrame mainFrame = FrameSingleton.getFrameSingleton();
        
        JPanel startupPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        startupPanel.setPreferredSize(new Dimension(FrameSingleton.FRAME_WIDTH, FrameSingleton.FRAME_HEIGHT));
        startupPanel.setBackground(new Color(FrameSingleton.FRAME_BG));
        
        BufferedImage logoPicture;
		try {
			logoPicture = ImageIO.read(this.getClass().getResourceAsStream(LOGO_FILE));
			title = new JLabel(new ImageIcon(logoPicture));
		} catch (IOException e) {
			title = new JLabel("<html><h1>Cold War</h1></html>");
		}
		title.setPreferredSize(new Dimension(550, 300));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        JButton toPlay = new JButton("Play");
        toPlay.setPreferredSize(new Dimension(STARTUP_BTN_WIDTH, STARTUP_BTN_HEIGHT));
        toPlay.addActionListener(this);
        toPlay.setActionCommand(TOPLAY_COMMAND);
        
        JButton toExit = new JButton("Exit");
        toExit.setPreferredSize(new Dimension(STARTUP_BTN_WIDTH, STARTUP_BTN_HEIGHT));
        toExit.addActionListener(this);
        toExit.setActionCommand(TOEXIT_COMMAND);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        startupPanel.add(title, c);
        
        c.gridx = 0;
        c.gridy = 1;
        startupPanel.add(Box.createVerticalStrut(100), c);
        
        c.gridx = 0;
        c.gridy = 2;
        startupPanel.add(toPlay, c);
        
        c.gridx = 0;
        c.gridy = 3;
        startupPanel.add(Box.createVerticalStrut(50), c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        startupPanel.add(toExit, c);

        mainFrame.add(startupPanel);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true); 
    }

    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        super.getController().buttonPressed(action);
    }
}
