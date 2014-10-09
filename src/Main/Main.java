package Main;

import java.text.ParseException;

import GUI.MainFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			new MainFrame();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
