package com.GameTry.states;
import java.awt.Graphics;
import java.util.ArrayList;

import com.GameTry.Entities.BackGround;
import com.GameTry.Entities.Bullet;
import com.GameTry.Entities.Controller;
import com.GameTry.Entities.Entity;
import com.GameTry.Entities.Hearth;
import com.GameTry.Entities.NormalCars;
import com.GameTry.Entities.PlayerBike;
import com.GameTry.one.MainGameClass;
import com.GameTry.states.*;
public class GameState extends State {
	static int counter=0;
	private Bullet b;
	PlayerBike pb;
	private Controller ca;
	private MainMenuState ms;
	private BackGround back1,back2;
	
	NormalCars nm,nm2;
	private Hearth h;
      private int id;
	private ArrayList <NormalCars> ent=new  ArrayList<>();
	public GameState(MainGameClass mg) {
		super(mg);
		counter++;
		id=counter;
		this.pb= new PlayerBike(this.mg, 220,200);

		this.back1=new BackGround(50,000);
		this.back2=new BackGround(50,-500);
		this.nm=new NormalCars(150,-220);
		this.nm2=new NormalCars(320,-420);
		this.h=new Hearth(300,-1000);

		ca	=new Controller(this, mg);

		ent.add(this.nm);
		ent.add(this.nm2);

	}public PlayerBike getPb() {
		return this.pb;
	}



	public void update() {
      System.out.println("id"+this.id);
		
		{
			if(this.pb.gethealth()<=0) {
		
	       
	        
				
  

  
		back2.stopUpdate();
		back1.stopUpdate();

		
	
	
		mg.removeGameState(this.mg.getArra().get(0));
		State.setState(this.mg.getMm());

			
			
			}

			pb.update();

			back1.update();
			back2.update();
			nm.update();

			nm2.update();
			collision();
			if(nm.a==nm2.a) {
				if(nm.a<=2) {
					
					nm.a+=(int)Math.random()*2+1;
					
					nm.randomX();
				}

				else { 
					nm.a=  (nm2.a-(int)(Math.random()*2+1));
					nm.randomX();

				}

			}
			ca.update(this,mg);
			carCollide();
			h.update(pb);
			
			
		}
		
		



	}


	public void render(Graphics g) {


	back1.render(g);
	back2.render(g);
		pb.render(g);
		g.drawString(""+pb.gethealth()+"",20,300);
	nm.render(g);
		nm2.render(g);
		ca.render(g);
		h.render(g);

		
		if(pb.gethealth()<=0) {
			mg.getGra().drawString("GameOver bruh",100,200);
		}
	}

	private  void collision() {
		for(NormalCars e:ent) {
			while(this.pb.getRect().intersects(e.getRect())) {
				e.onCollision(pb);
           break;
			}

		}
	}

	public void carCollide() {
		ArrayList<Bullet> toRemove=new <Bullet>ArrayList();
		for (Bullet b:ca.bul) {

			for(Entity e:ent) {
				if(e.getRect().intersects(b.getRect())) {
					b.onCollision(e);
					toRemove.add(b); 	 

				}

			}
		}
		ca.bul.removeAll(toRemove);

	}




}
