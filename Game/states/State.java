package com.GameTry.states;

import java.awt.Graphics;

import com.GameTry.one.MainGameClass;

public abstract class State {

	
private static State currentSt=null;//-currentSt:State
protected MainGameClass mg;
	public State(MainGameClass	mg) {
		this.mg=mg;
	}

public static void setState(State state	) {
	currentSt=state;
}
	public  static State getState() {
		return  currentSt;
		}
public abstract void update();
public abstract void render(Graphics g);
 
	

}
