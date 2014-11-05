package Actions;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import GUI.MainFrame;

public class ActionTimer implements ActionListener{
	
	protected MainFrame mfLocal;
	protected Integer vremeUSec;
	public ActionTimer(){}
	
	protected String izlazZaLabel;
	protected Integer sa; // sati za ispis
	protected Integer mOSTATAK; // ostatak broja sekundi nakon sto smo aduzeli sate
	protected Integer m; // minuti za ispis
	protected Integer se; // sekunde za ispis
	public ActionTimer(Integer vremeUSec,MainFrame mf){
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
			//Toolkit.getDefaultToolkit().beep();
			//ActionStart.stopT();
			String shutdownCmd = "shutdown -s";
					try {
						 Runtime.getRuntime().exec(shutdownCmd);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}
	}
}
