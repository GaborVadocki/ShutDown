package Util;

//import java.text.SimpleDateFormat;
//import java.util.Date;

//import java.util.StringTokenizer;
/**
 * 
 * @author Warrior
 *
 */
public class Parse {

	/**
	 * 
	 * @param input
	 * @return
	 */
	public static Integer parsiraj(String input){
		
		//StringTokenizer st = new StringTokenizer(input);
		
		String[] result = input.split(":");
		String s1="";
		String s2="";
		String s3="";
	/*	Date dt1;
		Date dt2;
		Date dt3;*/
		Integer satiUsec=0;
		Integer minutiUsec=0;
//		Integer sekundeUs=0;
		
		Integer ukupnoVreme=0;
		
//		SimpleDateFormat sdf = new SimpleDateFormat("HH:MM:SS");
		
		//sdf = String.parse input;
		
		Integer sati=0;
		Integer minuti=0;
		Integer sekunde=0;
		//for(String s : result)
		//	System.out.println("\n"+s);
			
			
			for(int i=0; i<3;i++){
				if(i==0){
				s1 = result[i];
				sati = Integer.parseInt(s1);
				satiUsec = sati*3600;
				}
				else if(i==1){
					s2 = result[i];
				minuti = Integer.parseInt(s2);
				minutiUsec = 60*minuti;
				}
				else if(i==2){
					s3 = result[i];
				sekunde = Integer.parseInt(s3);	
				}
				
				
				
			}
			System.out.println("Boj sati:"+s1);
			System.out.println("Boj minuta:"+s2);
			System.out.println("Boj sekundi:"+s3);
			
			ukupnoVreme = satiUsec+minutiUsec+sekunde;
			System.out.println("Ukupno vreme u sekundama:"+ukupnoVreme);
			
			return ukupnoVreme;
	}
}
