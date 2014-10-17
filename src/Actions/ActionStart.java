package Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


import Util.Parse;
import GUI.MainFrame;

public class ActionStart implements ActionListener {
	protected String s;
	protected String sv;

	static Timer timer;
	/**
	 * Proma ukupno vreme iscitano iz polja za unos u sekundama.
	 */
	protected Integer vremeUSec=0;
	MainFrame mfLocal ;
	public ActionStart(MainFrame mf){
		//s = mf.getJBrojac();
		mfLocal = mf;
	}

	@Override 
	public void actionPerformed(ActionEvent evt){
		System.out.println("Program se pokrece");
		s = mfLocal.getJBrojac();
		sv = mfLocal.getJtft();
		System.out.println(s);
		ActionTimer actTimer;
		
		vremeUSec = Parse.parsiraj(sv);

		actTimer = new ActionTimer(vremeUSec,mfLocal);
		
		timer = new Timer(1000, actTimer);
		timer.start();
	}

	public static void stopT(){
		if(timer != null)
			timer.stop();
	}


	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
}
