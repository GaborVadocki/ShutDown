package Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.MainFrame;

public class ActionExit implements ActionListener {
	private MainFrame frame;
	
	public ActionExit(){}
	
	public ActionExit(MainFrame frame){
		this.frame = frame;
	}
	
	
	public void actionPerformed(ActionEvent evt){
		System.out.println("Nje");
		frame.dispose();
		ActionStart.stopT();
		//close();
	}
	
}
