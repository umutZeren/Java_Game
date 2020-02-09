package com.GameTry.one.Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseMngr implements MouseListener,MouseMotionListener {
	private boolean leftPressed,rightPressed;
	  private int Mousex,Mousey;

  public boolean isLeftPressed() {
		return leftPressed;
	}

	public void setLeftPressed(boolean leftPressed) {
		this.leftPressed = leftPressed;
	}

	public boolean isRightPressed() {
		return rightPressed;
	}

	public void setRightPressed(boolean rightPressed) {
		this.rightPressed = rightPressed;
	}

	public int getMousex() {
		return Mousex;
	}

	public void setMousex(int mousex) {
		Mousex = mousex;
	}

	public int getMousey() {
		return Mousey;
	}

	public void setMousey(int mousey) {
		Mousey = mousey;
	}

	public void mouseDragged(MouseEvent e) {
		
	}

	public void mouseMoved(MouseEvent e) {
	 this.Mousex=e.getX();
		this.Mousey=e.getY();
	}

	public void mouseClicked(MouseEvent e) {
		
		
		
	}

	public void mousePressed(MouseEvent e) {
		
   if(e.getButton()==MouseEvent.BUTTON1){
	
	   leftPressed=true;
	   this.Mousex=e.getX();
		this.Mousey=e.getY();
	  }
   else if(e.getButton()==MouseEvent.BUTTON3) {
	   rightPressed=true;
   }
	}

	public void mouseReleased(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1){
			   leftPressed=false;
			  }
		   else if(e.getButton()==MouseEvent.BUTTON3) {
			   rightPressed=false	;
		   }		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
