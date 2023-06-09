/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.views.startup;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

/**
 * Class that realizes the custom dialog boxes to show missions, roles and rulebook.
 */
public class MenuBarDialog extends JDialog{
    
    private static final long serialVersionUID = 4789909526932475412L;
	private JEditorPane editorPane;
    private InputStream ioStream;
    
    public MenuBarDialog(String filePath){
        super();
        
        editorPane = new JEditorPane();
        editorPane.setEditable(false);
        
        try{
            ioStream = this.getClass().getClassLoader().getResourceAsStream(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(ioStream));
            String content = "";
            String readString;
            while((readString = reader.readLine()) != null){
                content = content + readString;
            }
            editorPane.setContentType("text/html");
            editorPane.setText(content);
        } catch (IOException e) {
            System.out.println(e);
        }
        
        editorPane.setCaretPosition(0);
        JScrollPane scrollPane = new JScrollPane(editorPane);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }
}
