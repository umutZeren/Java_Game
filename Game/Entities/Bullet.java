package com.GameTry.Entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.GameTry.display.jfx.Assets;
import com.GameTry.one.MainGameClass;
import com.GameTry.states.*;
import com.GameTry.Entities.*;
public class Bullet extends Entity {
	private MainGameClass mgc;
	Controller a;
	
	public boolean fired=false;
	public Bullet(double x, double y,State s,MainGameClass mg,Controller c) {
		super(x, y);
		this.mgc=mg;
	    this.y=y;
	    this.x=x;
	    this.a=c;
	    bounds=new Rectangle(se.a.get(3).getWidth(null),se.a.get(3).getHeight(null));
	}
	private int  health=10;
	

	
	public void update() {
		this.bounds.x=(int)this.x;
		this.bounds.y=(int) this.y;
		this.y-=2;
		

		
	}
	
	public void render(Graphics g) {
	if(fired=true)
		g.drawImage(Assets.a.get(3),(int)this.x,(int) this.y,null);
		
	}

	
	public void onCollision(Entity nc) {
	 ((NormalCars)nc).decreaseHealth();
	
	 
	}





	 



	



		
	}

	
	
	
