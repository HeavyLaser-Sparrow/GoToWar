import java.util.Scanner;
import java.io.File;
import java.io.FileWriter; 
import java.io.IOException;
public class BattleDriver{
	public static void main(String[] args){

		Tools.startScreen();
		int gold = 100;
		Scanner input = new Scanner(System.in);
		Infantry i = new Infantry();
		Archers a = new Archers();
		Cavalry c = new Cavalry();	
		Tools.pause(10000);
		
		boolean battleRunning = true;
		while(battleRunning){
			boolean fightGo = true;
			boolean stillChoosing = true;
			while(stillChoosing){
				System.out.println("-------------------------------------------------------------");
				System.out.println("Gold: "+gold);
				i.printOut();
				a.printOut();
				c.printOut();
				System.out.println("-------------------------------------------------------------");
				System.out.println("1. Get More Infantry");
				System.out.println("2. Get More Archers");
				System.out.println("3. Get More Cavalry");
				System.out.println("4. Go To Battle");
				System.out.println("5. Leave (Save)");
				int choice = input.nextInt();	
				if(choice == 1 && gold >= 3 ){
					gold = i.gainPeople(gold);
				} else if(choice == 2 && gold >= 4){
					gold = a.gainPeople(gold);
				} else if(choice == 3 && gold >= 5){
					gold = c.gainPeople(gold);
				} else if(choice == 4){			
					System.out.println("Oh no.");
					stillChoosing = false;
				} else if(choice == 5){
					try{
						File myFile = new File("battleSaver.txt");
						if(myFile.createNewFile()){
							System.out.println("Your progress is being saved.");
						} else {
							System.out.println();
						}
						FileWriter myWriter = new FileWriter("battleSaver.txt");
						myWriter.write("Hello World");// write stuff in here
						myWriter.close();
					} catch (IOException e){
						System.out.println("An error has occurred");
						System.out.println("We apologize for the inconvenience.");
						System.out.println("The problem will be solved shortly");
						System.out.println("Your progress has not been saved.");
						e.printStackTrace();
					}
					
					System.out.println("Your progress has been saved, probably");
					stillChoosing = false;
					fightGo = false;
					battleRunning = false;
				}
			}
		
			int oppHealth = (int)(Math.random() * 7000)+500;
			int ogOppHealth = oppHealth;
		       	int speed = (int)(Math.random() * 3) + 1;
			int range = 10;	
			while(fightGo){
				System.out.println("Opponent Health: "+oppHealth);
				System.out.println("Range: "+range);
				System.out.println("Speed: "+speed);
				System.out.println("Which unit do you want to send out?");
				System.out.println("1.Infantry");
				System.out.println("2.Archers");
				System.out.println("3.Cavalry");
				int coolChoice = input.nextInt();
				if(coolChoice == 1 && i.getNumSoldiers() > 0){
					oppHealth = i.doBattle(oppHealth, range);
					i.subPeople();
				} else if(coolChoice == 2 && a.getNumSoldiers() > 0){
					oppHealth = a.doBattle(oppHealth, range);
					if(range <= 3){
						a.subPeople();
					} 
				} else if(coolChoice == 3 && c.getNumSoldiers() > 0){
					oppHealth = c.doBattle(oppHealth, range);
					c.subPeople();
				} else{
					System.out.println("Not in opptions or not enough soldiers");
					range ++;
				}
				range -= speed;
				if(oppHealth <= 0){
					gold += ogOppHealth;
					a.ageUp();
					i.ageUp();
					c.ageUp();
					fightGo = false;	
				} else if(oppHealth > 0 && range < 3 && i.getNumSoldiers()  <= 0 && c.getNumSoldiers() <= 0){
					System.out.println("You have lost the battle.");
					fightGo = false;
					battleRunning = false;
					System.out.println("You have failed Lord Eldersworth, forever changing the course of ducky history");
				}

			}
		
		
		}

	}
}
