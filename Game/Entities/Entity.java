package com.GameTry.Entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.GameTry.display.jfx.Assets;

public abstract class Entity{
	double x;
	protected double y;//calculation wont be int so float
	protected Rectangle bounds;
	
	Assets se=new Assets();
 
	public Entity(double x,double y) {
		this.x=x;
		this.y=y;
		
	 }
	
	public Rectangle getRect() {
		return this.bounds;
	}









	public abstract void update();
	public abstract void render(Graphics g);
	//public abstract  void onCollision(Entity a);
	

}
