package Actions;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

import GUI.MainFrame;
import Main.Main;

public class ActionBrojac implements ActionListener{
	
	MainFrame mfLocal;
	Integer vremeUSec;
	public ActionBrojac(){}
	
	String izlazZaLabel;
	Integer sa; // sati za ispis
	Integer mOSTATAK; // ostatak broja sekundi nakon sto smo aduzeli sate
	Integer m; // minuti za ispis
	Integer se; // sekunde za ispis
	public ActionBrojac(Integer vremeUSec,MainFrame mf){
		this.vremeUSec = vremeUSec;
		mfLocal = mf;
	}
	
	@Override
	public void actionPerformed(ActionEvent event){

		System.out.println("Vreme je: "+ vremeUSec);
		sa = vremeUSec/3600;
		mOSTATAK = vremeUSec%3600; // broj sekundi koliko ostane kad odbijemo sate
		
		m = mOSTATAK/60;
		
		se = mOSTATAK%60;
		
		System.out.println("BROJ SATI: "+ vremeUSec);
		System.out.println("BROJ MINUTA: "+ vremeUSec);
		System.out.println("BROJ SEKUNDI: "+ vremeUSec);
		
		izlazZaLabel = sa+":"+m+":"+se;
		
		mfLocal.setLVreme(izlazZaLabel);
		vremeUSec--;
		if(vremeUSec<1){
			Toolkit.getDefaultToolkit().beep();
			playSound("x");
			ActionStartTimer.stopT();
			//String shutdownCmd = "shutdown -s";
				/*	try {
						 Runtime.getRuntime().exec(shutdownCmd);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
		}
	}
	
 static	Clip clip;
	
	public static synchronized void playSound(final String url) {
		  new Thread(new Runnable() {
		  // The wrapper thread is unnecessary, unless it blocks on the
		  // Clip finishing; see comments.
		    public void run() {
		      try {
		    	 String url1 = "resources/AlarmClock.wav";
		    	// URL url = new URL("..\\resources\\AlarmClock.wav");
		       clip = AudioSystem.getClip();
		       // ClassLoader cl = new ClassLoader();
		      
		    /*   AudioInputStream inputStream = AudioSystem.getAudioInputStream(
		        		//ActionBrojac.class.getResourceAsStream(url1)
		        		this.getClass().getClassLoader().getResourceAsStream(url1)
		        		//url
		        		);*/
		     
		       AudioInputStream inputStream = AudioSystem.getAudioInputStream(
		        		//ActionBrojac.class.getResourceAsStream(url1)
		        		this.getClass().getClassLoader().getResource(url1)
		        		//url
		        		);
		       
		       JOptionPane.showMessageDialog(null, inputStream);
		        System.out.println(inputStream);
		        clip.open(inputStream);
		        clip.start(); 
		        
		      } catch (Exception e) {
		        e.printStackTrace();
		        JOptionPane.showMessageDialog(null, e.getStackTrace());
		      }
		    }
		  }).start();
		}
	
	public static void stopZvuk(){
		clip.stop();
	}
	
}
