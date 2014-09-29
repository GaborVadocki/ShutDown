package Util;

import java.util.Timer;
import java.util.TimerTask;

//import javax.swing.Timer;


public class Counter {

	static Timer timer = new Timer();
	static int delay = 0;
	static int period = 1000;
	Integer interval;
	static int count=0;
	static Integer vreme=0;
//	public Counter(Integer delay){
	//	;
	//}
	
	public static void brojac(Integer delayX){
		//delay = 1000*delayX;
		vreme = delayX;
		timer.scheduleAtFixedRate(new TimerTask(){
			public void run(){
				count++;
				if(count>vreme){
					timer.cancel();
					timer.purge();
				}
				System.out.println("\n Broj sekundi:"+count);
			}
			}, delay, period);
	}
	
	public void dekrement(){
		
	}
}
