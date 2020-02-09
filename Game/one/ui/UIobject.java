package com.GameTry.one.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public abstract class UIobject {
	protected Rectangle bounds;
	private double x,y;
	int width,height;
	protected boolean hovering =false;
	
		public UIobject(double x,double y,int w,int h){
			this.x=x;
			this.y=y;
		   this.height=h;
		   this.width=w;
		 bounds=new Rectangle((int)x,(int)y,w,h);
		 
		}
public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
public abstract void update();
public abstract void render(Graphics g);
public abstract void onClick();

public void OnMouseMove(MouseEvent e) {
	if(bounds.contains(e.getX(),e.getY())) {
		this.hovering=false;
	}
}
public void OnMouseRelease(MouseEvent e) {
	if(hovering)
		onClick();
}





















}
