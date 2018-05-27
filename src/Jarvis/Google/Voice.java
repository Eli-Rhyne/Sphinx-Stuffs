package Jarvis.Google;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.darkprograms.speech.synthesiser.SynthesiserV2;

public class Voice {
	private SynthesiserV2 voice;
	private Clip clip;
	Voice(int speed, int pitch) {
		voice = new SynthesiserV2(
				"AIzaSyD8GsBCn5bQnm7WCFCdYAdm6SrvU0Y1QPA");
		voice.setSpeed(speed);
		voice.setPitch(pitch);
		voice.setLanguage("en-US");
	}
	public void say(String toSay) {
		try {
			AudioInputStream audioInputStream =
					AudioSystem.getAudioInputStream(
							voice.getMP3Data(toSay));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} 
		catch (IOException e) {e.printStackTrace();} 
		catch (LineUnavailableException e) {e.printStackTrace();}
		catch (UnsupportedAudioFileException e) {e.printStackTrace();}
		
	}
}
