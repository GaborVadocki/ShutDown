package Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


import Util.Parse;
import GUI.MainFrame;

public class ActionStart implements ActionListener {
	private String s;
	private String sv;

	static Timer timer;
	/**
	 * Proma ukupno vreme iscitano iz polja za unos u sekundama.
	 */
	private Integer vremeUSec=0;
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
		//JOptionPane.showMessageDialog(null,"Tekst koji je unet u polje je: "+s+"\n masked texkt"+sv);


		vremeUSec = Parse.parsiraj(sv);
		/*
		Counter.brojac(vremeUSec);
		 */

		actTimer = new ActionTimer(vremeUSec,mfLocal);/*{
			@Override
			public void actionPerformed(ActionEvent event){

				System.out.println("Vreme je: "+ vremeUSec);
				mfLocal.setLVreme(vremeUSec);
				vremeUSec--;
				if(vremeUSec<2){
					Toolkit.getDefaultToolkit().beep();
					stopT();
				}
			}
		};*/

		timer = new Timer(1000, actTimer);
		timer.start();

		/** if(vremeUSec<2){
		    //	SYStem
		    	timer.stop();}*/
	}

	public static void stopT(){
		timer.stop();
	}




	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
}
