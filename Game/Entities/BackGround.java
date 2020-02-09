package com.GameTry.Entities;

import java.awt.Graphics;

import com.GameTry.display.jfx.Assets;

public class BackGround extends Entity{
double acceleration=1;
private double firstY0;
long now;
long timing;
long timeNow;
	public BackGround(double x, double y) {
		super(x, y);
		firstY0=this.y;
		now=System.nanoTime();
	
	}

	
	public void update() {
		 this.timeNow=System.nanoTime();
		this.timing+=this.timeNow-this.now;
		
	this.y+=this.acceleration;
	this.now=this.timeNow;
    if(timing>1000000000*10) {
    	this.acceleration+=0.75;
    	this.timing=0;
	}
    
   if(Math.abs(firstY0-this.y)>=500) {
	   this.y=this.firstY0;
   }
	}
	public void stopUpdate() {
		;
	}

	@Override
	public void render(Graphics g) {
	g.drawImage(Assets.a.get(1),50,(int) this.y,null);

	}
	public int  getY() {
		return (int)this.y;
	}


	


	
	public void onCollision(Entity a) {
	 	}



}
