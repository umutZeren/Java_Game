package com.GameTry.display.jfx;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.GameTry.one.MainGameClass;

public class sound {
	Clip clip;
	AudioInputStream audioIn;
public sound() {
	

			 
	}
	
public  void playMusic(String soundFile) {
	
	
	
	 try { 
		 File f = new File("./" + soundFile);
		     audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
		     
		     clip = AudioSystem.getClip();
		    clip.open(audioIn);
		    clip.start();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (LineUnavailableException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (UnsupportedAudioFileException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 

}


	


}
