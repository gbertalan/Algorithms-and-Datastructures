import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Player extends Thread{

	AudioInputStream audioInputStream;
	Clip clip;
	private String filePath;
	
	FloatControl gainControl;  // for volume
	
	float currDB = 6F;
	float targetDB = 0F;
	float fadePerStep = .04F;   // .1 works for applets, 1 is okay for apps
	boolean fading = false;

	public void play(int i) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		System.out.println("playing");

		filePath = "resources/note" + (i + 1) + ".wav";
		audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
		clip = AudioSystem.getClip();
		clip.open(audioInputStream);

		// clip.open(FORMAT, audioInputStream, 0, 20);
		System.out.println("i: " + i);
		
		
		gainControl = 
			    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		
		clip.start();
//		setVolume(1);
		shiftVolumeTo(0.0001);
		
		System.out.println("-> " + clip.getMicrosecondPosition());

//		clip.stop();
//		clip.close();
	}
	
	/**
	 * Set the volume to a value between 0 and 1.
	 */
	public void setVolume(double value) {
	    // value is between 0 and 1
	    value = (value<=0.0)? 0.0001 : ((value>1.0)? 1.0 : value);
	    try {
	        float dB = (float)(Math.log(value)/Math.log(10.0)*20.0);
	        gainControl.setValue(dB);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	
	public void shiftVolumeTo(double value) {
	    // value is between 0 and 1
	    value = (value<=0.0)? 0.0001 : ((value>1.0)? 1.0 : value);
	    targetDB = (float)(Math.log(value)/Math.log(10.0)*20.0);
//	    targetDB = 0.001F;
	    if (!fading) {
	        Thread t = new Thread(this);  // start a thread to fade volume
	        t.start();  // calls run() below
	    }
	}
	
	/**
	 * Run by thread, this will step the volume up or down to a target level.
	 * Applets need fadePerStep=.1 to minimize clicks.
	 * Apps can get away with fadePerStep=1.0 for a faster fade with no clicks.
	 */
	public void run()
	{
	    fading = true;   // prevent running twice on same sound
	    if (currDB > targetDB) {
	        while (currDB > targetDB) {
	            currDB -= fadePerStep;
	            gainControl.setValue(currDB);
	            try {Thread.sleep(10);} catch (Exception e) {}
	            System.out.println("DB: " + currDB);
	        }
	    }
	    else if (currDB < targetDB) {
	        while (currDB < targetDB) {
	            currDB += fadePerStep;
	            gainControl.setValue(currDB);
	            try {Thread.sleep(10);} catch (Exception e) {}
	        }
	    }
	    fading = false;
	    currDB = targetDB;  // now sound is at this volume level
	}
	
}
