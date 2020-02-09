package com.GameTry.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.GameTry.states.*;
import com.GameTry.one.MainGameClass;

public class MainMenuState extends State {
GameState tempg;
	public MainMenuState(MainGameClass mg) {
		super(mg);
                                    
         }
	public Rectangle playButton=new Rectangle(this.mg.getDisplay().getWidth()/2-50,150,100,50);
	public Rectangle Market=new Rectangle(this.mg.getDisplay().getWidth()/2-50,250,100,50);
	public Rectangle credits =new Rectangle(this.mg.getDisplay().getWidth()/2-50,350,100,50);
	public Rectangle exit =new Rectangle(this.mg.getDisplay().getWidth()/2-50,420,100,50);
	GameState gs;
	public void update() {
		if(playButton.contains(mg.getMouse().getMousex(),mg.getMouse().getMousey())&&mg.getMouse().isLeftPressed()){
	        System.out.println(mg.getArra().size());
			gs=new GameState(this.mg);
	        mg.addGameState(gs);
	        for(GameState g:mg.getArra()) {
	        	tempg=g;
	        	State.setState(tempg);
	       
	        }
		           
			System.out.println(mg.getArra().size()+"size");
			
			
		}

		 if (exit.contains(mg.getMouse().getMousex(),mg.getMouse().getMousey())&&mg.getMouse().isLeftPressed()){
			System.exit(0);
		}
	}


	public void render(Graphics g) {
		Graphics2D g2d=(Graphics2D)g;

		Font f=new Font("arial",Font.BOLD,50);
		mg.getDisplay().getCanvas().setBackground(Color.WHITE);
		g.setFont(f);
		g.setColor(Color.BLACK);
		g.drawString("HARD DRIVE",this.mg.getDisplay().getWidth()/2-160,100 );
		Font fa=new Font("arial",Font.BOLD,20);
		g.setFont(fa);
		g.drawString("Play",playButton.x+15,playButton.y+33);
		g2d.draw(playButton);

		g2d.draw(Market);
		g.drawString("Market",Market.x+15,Market.y+33);

		g2d.draw(credits);
		g.drawString("Credits",credits.x+15, credits.y+33); 
		
		g2d.draw(exit);
		g.drawString("Exit",exit.x+15, exit.y+33); 


		
	}





}
