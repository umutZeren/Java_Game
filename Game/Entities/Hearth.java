package com.GameTry.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.GameTry.Entities.*;
public class Hearth extends Entity {
	private int health=0;
	boolean collision=false;
public static	ArrayList   <Hearth> hs=new ArrayList();	
	public Hearth(double x, double y) {

		super(x, y);
		bounds=new Rectangle(se.a.get(4).getWidth(null),se.a.get(4).getHeight(null));
		
	}

	public void update(PlayerBike pb) {
		this.bounds.x=(int)this.x;
		this.bounds.y=(int) this.y;
		onCollision(pb);
		this.y+=3;
	}


	public void render(Graphics g) {
	if(!this.collision)
		g.drawImage(se.a.get(4),(int)this.x,(int)this.y,null);
		//g.setColor(Color.BLUE);
		//z g.fillRect((int)this.bounds.x,(int)this.bounds.y, se.a.get(4).getWidth(null),se.a.get(4).getHeight(null));
		
	}

	public void onCollision(Entity a) {
		if(((PlayerBike)a).getRect().intersects(this.getRect())){
		
			if(((PlayerBike)a).gethealth()<=70)
				((PlayerBike)a).increaseHealth(30);

			else ((PlayerBike)a).setHeath(100);
		this.collision=true;
		}
	}
	public void update() {};




}
