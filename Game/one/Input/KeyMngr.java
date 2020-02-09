package com.GameTry.one.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
// keyListener jFRAME Ölene kadar çalýþýyor sanýrým
public class KeyMngr implements KeyListener {
private boolean keys[];
public boolean right,left,space,control;
public void update() {
	right=keys[KeyEvent.VK_RIGHT];
	left =keys[KeyEvent.VK_LEFT];
	space=keys[KeyEvent.VK_SPACE];
	control=keys[KeyEvent.VK_C];
}
	public KeyMngr() {
		keys=new boolean[256];
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/// whenever someone press a key its called
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyCode()]=true;
	    
	}

	//when released ,not pressed
	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyCode()]=false;//true da kalmasýn diye
	}
	

}
