 package com.GameTry.display.jfx;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Assets {

	public static ArrayList<Image> a=new ArrayList<Image>(); 
	BufferedImage [] btnStart;

	// will load everything once then use everywhere 
	public static void init() {
	try {
		Image background1= ImageLoader.loadImage("/ýmg/realBackgr.jpeg");
		//Image randomImg=ImageLoader.loadImage("/ýmg/bike.png");
		Image bike1= ImageLoader.loadImage("/ýmg/ourcar.png");
		bike1=  bike1.getScaledInstance(50,75,((BufferedImage) bike1).getType());//
	//	background1=background1.getScaledInstance(500,500,((BufferedImage) background1).getType());
		 Image newcar=ImageLoader.loadImage("/ýmg/newcar.png");
		newcar= newcar.getScaledInstance(50,75,((BufferedImage) newcar).getType());//
		 Image car1=ImageLoader.loadImage("/ýmg/police.png");
	     Image bullet=ImageLoader.loadImage("/ýmg/bulleta.png/");
	     bullet=bullet.getScaledInstance(10,10, 0);
		 Image hearth=ImageLoader.loadImage("/ýmg/hearth.png");
		 Image oyunbitti=ImageLoader.loadImage("/ýmg/GAMEOVER.png");
		 
	    
	     a.add(bike1);
		 a.add(background1);
		 a.add(car1);
		 a.add(bullet);
		 a.add(hearth);
		a.add(newcar);
		a.add(oyunbitti);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
         
	}

public   int getWidthBike() {
	return a.get(0).getWidth(null);
}



}
