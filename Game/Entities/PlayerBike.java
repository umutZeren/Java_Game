package com.GameTry.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.GameTry.display.jfx.Assets;
import com.GameTry.one.MainGameClass;

public class PlayerBike extends Entity{
	public  boolean fired=false;
  private int health=100;
  private boolean isGameOver=false;
	private MainGameClass mgc;
	public PlayerBike(MainGameClass mg ,double x, double y) {
		super(x, y);
		this.mgc=mg;
		bounds=new Rectangle(50,75);
	
	}
	public void setXy(int a,int b) {
		this.x=a;
		this.y=b;
	}
	public double getY() {
		return this.y;
	}
	public double getX() {
		return  this.x;
	}
	
	public void update() {
		this.bounds.x=(int)this.x;
		this.bounds.y=(int) this.y;
	if(mgc.getKeyMngr().left) {
        if(bounds.getX()>205)
		this.x-=20;

        
	}else if (mgc.getKeyMngr().right) {
		 if(bounds.getX()<350)  
		    this.x+=20;
		  }

	
	}	
	public void render(Graphics g) {
			g.drawImage(Assets.a.get(0),(int)this.x,(int)this.y,null);
			g.setColor(Color.gray);
			g.fillRect(560,400,100,25);
		
		g.setColor(Color.GREEN);
		g.fillRect(560,400,this.health,25);
		g.setColor(Color.BLACK);
		g.drawRect(560, 400,100,25);
		
 // g.setColor(Color.BLUE);
  //g.fillRect(bounds.x,bounds.y,(int)bounds.getWidth(),(int)bounds.getHeight());
	}

	/*public gainHealth() {
		if(iscollide())
			health+=10;
	}*/
public int gethealth() {
	return this.health;
}
public void increaseHealth(int a) {
	this.health+=a;
}
public void decreaseHealth(int b) {
	if(this.health>0)
	this.health-=b;
}

public void onCollision(Entity pb) {

}
public void setHeath(int a) {
	this.health=a;
}




}
