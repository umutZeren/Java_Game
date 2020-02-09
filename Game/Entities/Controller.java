package com.GameTry.Entities;
import java.awt.Graphics;
import java.util.*;
import com.GameTry.one.MainGameClass;
import com.GameTry.states.*;

public class Controller {
	public ArrayList <Bullet>bul =new ArrayList();
	Bullet Tembullet;

	
	public void update(GameState gm,MainGameClass mg) {
		if(mg.getKeyMngr().space) {
			addBullet(new Bullet(gm.getPb().getX()+20,gm.getPb().getY(),gm,mg,this));
		}	
		if(bul.size()!=0) {
			for(Bullet b:bul) {
				Tembullet =b;
				Tembullet.update();
			}
		}
	}

	public void render(Graphics g) {

		for(Bullet b:bul) {
			Tembullet =b;
			Tembullet.render(g);
		}

	}

	public void addBullet(Bullet b) {
		bul.add(b);	
	}
	public void removeBullet(Bullet b)	{
		bul.remove(b);
	}
	public Controller(GameState gm,MainGameClass mg) {

	}












}
