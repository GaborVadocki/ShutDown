package Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.MainFrame;

public class ActionReset implements ActionListener {

	MainFrame mfLocal;
	public ActionReset(MainFrame mf){
		mfLocal = mf;
	}
	
	@Override
	public void actionPerformed(ActionEvent event){
		mfLocal.setJtft("000000");
		mfLocal.setLVreme("00:00:00");
		ActionStart.stopT();
	}
}
