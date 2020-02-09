package com.GameTry.one;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.ArrayList;

import com.GameTry.Entities.PlayerBike;
import com.GameTry.display.Display;
import com.GameTry.display.jfx.Assets;
import com.GameTry.display.jfx.sound;
import com.GameTry.one.Input.KeyMngr;
import com.GameTry.one.Input.MouseMngr;
import com.GameTry.states.GameState;
import com.GameTry.states.MainMenuState;
import com.GameTry.states.State;


public class MainGameClass implements Runnable {
	private boolean isRunning = false;
	private BufferStrategy bs;// render yaparken double buffurla canvas da display olayýný yönetiyor
	private Graphics gra;// draw için
 
	
	
	
	
	 private ArrayList <GameState>gms=new <GameState>ArrayList();

	
	private MainMenuState Ms= new MainMenuState(this);;
  // current state 
	private MouseMngr mous;
	private KeyMngr kym;
  private sound s;
	private Display display;
	private Thread thread;// Thread tipinde deðiþken thread
	public long time1;
	 public long sayaç;
	private void initial() throws IOException// because of imageloader throws ýo exception
	{  time1=System.nanoTime();
	
		mous=new MouseMngr();
		kym = new KeyMngr();
		display = new Display();// static yaparak tüm initializationdan kurtulduk. constructordaki
		display.getFrame().addKeyListener(kym);
		display.getFrame().addMouseListener(mous);
		display.getFrame().addMouseMotionListener(mous);
		display.getCanvas().addMouseListener(mous);
		display.getCanvas().addMouseMotionListener(mous);/// both of them
		Assets.init();
		
    s= new sound();
    s.playMusic("paranoid.wav");
 
		
	 
                                                  
			
				State.setState(Ms);
	}
	public MainMenuState getMm() {
		return this.Ms;
	}
	public ArrayList<GameState> getArra() {
		return this.gms;
	}
	public void addGameState(GameState g) {
		this.gms.add(g);
		
	}
	public void removeGameState(GameState g) {
		this.gms.remove(g);
	}
	   public Display getDisplay() {
		   return this.display;
	   }
	private void update() {
		kym.update();
						
		if (State.getState() != null)
			State.getState().update();

	}


public MouseMngr  getMouse() {
	return this.mous;
}
	private void render() {
		bs = display.getCanvas().getBufferStrategy();// double or triple buffer
		if (bs == null) // döngüde boþ mu bakmak için
		{
			display.getCanvas().createBufferStrategy(2);// ý go with 2 buffer after result check again,gerçek zamanda
														// sorun çýkarsa diye
			return;
		}
		gra = bs.getDrawGraphics();// returns graphics context for the drawing buffer,gra initializaion
		// 0,0 pixel at left most top corner y axis flipped
		
		gra.clearRect(0, 0, Display.getWidth(), Display.getHeight());
		// gra.setColor(Color.orange);
		// gra.fillRect(10,50,20,100);

		// gra.fillRect(x, y, width, height);

		if (State.getState() != null)
			State.getState().render(gra);
        
		bs.show();// makes visible //
		gra.dispose();// graphics garbage collector gibi
	}

	public void run() {
		try {
			initial();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // baþtan kurma kýsmý
		int fps = 60;// how many times we want to update and render
		double timePerUpdate = 1_000_000_000 / fps;// 1 billion nanosec in 1 sec ,maxx time for run update ad render
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();// jvm baþladýðýndan beri current time return ediyor
		long timer = 0;

		int updts = 0;

		while (isRunning) {
			
			now = System.nanoTime();
			sayaç+=(now-time1);
			delta += (now - lastTime) / timePerUpdate;
			// start time - line79 exucition time /max time to update and add to delta
			timer += now - lastTime;

			lastTime = now;
			// yeni zaman bu birr dahaki exucutiona kadar.
			if (delta >= 1) {
				update();
				render();
				delta--;
				updts++; // update sayýsýný tutmak için
			}
			if (timer > 1_000_000_000) {
				//System.out.println("Updates and frames  " + updts);
				updts = 0;
				timer = 0;
			}

		}
		stop();// synchronized method bizim yazdýðýmýza gidiyor.
	}

	// concurant proggramming
	public KeyMngr getKeyMngr() {
		return kym;
	}
	public Graphics getGra() {
		return this.gra;
	}

	public synchronized void start() {
		if (isRunning)
			return;

		isRunning = true;
		thread = new Thread(this);// initialized
		thread.start();
		
	}

	public synchronized void stop() {
		if (!isRunning)
			return;// zaten duruyorsa bir daha dur
		try {
			thread.join();
		}
		
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
