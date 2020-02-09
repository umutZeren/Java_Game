package com.GameTry.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.GameTry.display.jfx.Assets;

public class NormalCars  extends Entity{
long now,timeNow;
long timing;
public int xPos;
public int a;
private double firstY0;
	double acceleration=2.50;
	private int health=50;
	
	public NormalCars(double x, double y) {
		super(x, y);
		bounds=new Rectangle(50,75);
    //   System.out.println(se.a.get(2).getWidth(null)+" height"+se.a.get(2).getHeight(null));
		now=System.nanoTime();
		firstY0=this.y;

	}
	


	public void update() {
		this.timeNow=System.nanoTime();
		this.timing+=this.timeNow-this.now;
	
		// TODO Auto-generated method stub
		this.bounds.x=(int)this.x+50;
		this.bounds.y=(int) this.y+75;
		this.y+=acceleration; 
		 if(timing>1000000000*1000000000*60) {
		    	this.acceleration+=0.005;
		    	this.timing=0;
		    	
			}
		 if(Math.abs(firstY0-this.y)>=890) {
				rand();
			 randomX();
			   this.y=this.firstY0;
			   this.health=50;
		   }
		
		if(this.health<=0) {
			this.y=-500;
			this.health=50;
	rand();
	randomX();
			
 		}
		
		}
		//if()
	

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.a.get(2),(int)this.x,(int)this.y,null);
		g.setColor(Color.red);

	//g.fillRect(this.bounds.x,this.bounds.y,(int)bounds.getWidth(),(int)bounds.getHeight());
//g.fillRect((int)this.x,(int)this.y,50,75);
		
		g.setColor(Color.GREEN);
		g.fillRect((int)this.x+42,(int)this.y+160,this.health,10);
		g.setColor(Color.BLACK);
		g.drawRect((int)this.x+42,(int)this.y+160,this.health,10);
	}
	//collide(){

	public void rand() {
		   this.a=	(int) (Math.random()*3+1);
	}
  public void randomX() {
	
		this.xPos=this.a;
//System.out.println("tihs is a "+a);
switch(a) {
case 1:this.x=150;
break;
case 2:this.x=220;
break;
case 3:this.x=320;
break;



}
  }

	public void onCollision(PlayerBike pb) {
		
	
	pb.decreaseHealth(1);

	}
	public void manDown() {
		
	}
	public void decreaseHealth() {
		this.health-=10;
	}



}
