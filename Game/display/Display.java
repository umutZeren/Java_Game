package com.GameTry.display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display {

	JButton soundb; 
	public static String getTitle() {
		return title;
	}

	public static int getHeight() {
		return height;
	}

	public static int getWidth() {
		return width;
	}

	Color randColor = new Color(201,200,0);
public Canvas getCanvas() {
	return canvas;
}
private JFrame frame;
private Canvas canvas;

private static   String  title="HARD DRIVE";// static fieldda static method ulaþabilir.
private  static int height=500,width=700;// in picsel HEIGHT,WIDTH

//Constructor of display
public Display () //sort of camera
{
 createDisplay();
}

private void createDisplay() {
	frame=new JFrame();
   
	frame.setTitle(title);
	frame.setSize(width,height);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.setResizable(true);
	frame.setLocationRelativeTo(null);// null olunca ortaya göre ayarlýyor.
	frame.setVisible(true);// as a default it setted to be false so non visible ?? 
	
    
	canvas=new Canvas();
	
	
    canvas.setPreferredSize(new Dimension(width,height));
    canvas.setMaximumSize(new Dimension(width,height));
    canvas.setMinimumSize(new Dimension(width,height));
    canvas.setFocusable(false);//by defauly its true dont show the movement
    frame.add(canvas);//adds canvas to our frame	
    
    frame.pack();
    
    
    
    
    
}
public JFrame getFrame(){
	return this.frame;
}
	
}
