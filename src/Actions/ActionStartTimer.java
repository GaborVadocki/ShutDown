package Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import GUI.MainFrame;
import Util.Parse;

public class ActionStartTimer extends ActionStart {

	
	
	public ActionStartTimer(MainFrame mf) {
		super(mf);
		// TODO Auto-generated constructor stub
	}

	@Override 
	public void actionPerformed(ActionEvent evt){
		System.out.println("Program se pokrece");
		s = mfLocal.getJBrojac();
		sv = mfLocal.getJtft();
		System.out.println(s);
		ActionBrojac actTimer;
		//JOptionPane.showMessageDialog(null,"Tekst koji je unet u polje je: "+s+"\n masked texkt"+sv);


		vremeUSec = Parse.parsiraj(sv);
		

		actTimer = new ActionBrojac(vremeUSec,mfLocal);

		timer = new Timer(1000, actTimer);
		timer.start();

		/** if(vremeUSec<2){
		    //	SYStem
		    	timer.stop();}*/
	}

}
