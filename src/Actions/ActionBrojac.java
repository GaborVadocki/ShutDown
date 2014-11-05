package Actions;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

import GUI.MainFrame;

public class ActionBrojac extends ActionTimer{
	
	
	
	public ActionBrojac(Integer vremeUSec, MainFrame mf) {
		super(vremeUSec, mf);
		// TODO Auto-generated constructor stub
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
		    	
		       clip = AudioSystem.getClip();
		 
		       AudioInputStream inputStream = AudioSystem.getAudioInputStream(
		        	this.getClass().getClassLoader().getResource(url1)
		        		
		        		);
		       
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
		if(clip != null)
		clip.stop();
	}
	
}
