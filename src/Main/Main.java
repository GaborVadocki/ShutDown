package Main;

import java.text.ParseException;

import javax.swing.UIManager;

import GUI.MainFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		try {
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e){

		}
	*/	
		try {
			new MainFrame();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
