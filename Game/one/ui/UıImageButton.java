package com.GameTry.one.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UýImageButton extends UIobject {
 private BufferedImage[]images;
 private ClickListener clicker;
	public UýImageButton(double x, double y, int w, int h,BufferedImage[]images) {
		
		super(x, y, w, h);
		this.images=images;
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void render(Graphics g) {
        if(this.hovering) {
        	g.drawImage(images[1],(int)this.getX(),(int)this.getY(),this.width,this.height,null);
        	 }
        else g.drawImage(images[0],(int)this.getX(),(int)this.getY(),this.width,this.height,null);
	}
	@Override
	public void onClick() {
        this.clicker.onClick();		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
