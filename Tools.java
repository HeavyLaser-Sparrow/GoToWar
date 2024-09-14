import java.util.Scanner;
import java.io.File;
import java.io.FileWriter; 
import java.io.IOException;
public class Tools{
	public static void startScreen(){
		System.out.println("You are a warlord hired by Lord Eldersworth to serve as his mercenary army.");
		System.out.println("You have 4 things to consider: gold, infantry, archers, and cavalry.");
		System.out.println("You have 100 of each at the start.");
		System.out.println("Gold is used to buy more units, 3 for infantry, 4 for archers, and 5 for cavalry.");
		System.out.println("Infantry does 3 damage at medium range, 5 at short range, and 0 at far range.");
		System.out.println("Archers do 5 damage at long range, 3 at medium range, and 0 at short range."); 	
		System.out.println("Cavalry does 5 damage at medium range, 3 at short range, and 0 at long range.");		
		System.out.println("Veterans do 1 more damage than greens");
	}

	public static void pause(int time){
		try{
			Thread.sleep(time);
			for(int z = 0 ; z < 30 ; z++){
				System.out.println();
			}
		} catch (InterruptedException e){
			for(int x = 0 ; x < 20 ; x++){
				System.out.println();
			}	
		}
	}


}
