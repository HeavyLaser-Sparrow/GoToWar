import java.util.Scanner;
import java.io.File;
import java.io.FileWriter; 
import java.io.IOException;
public class Cavalry{
	private int damage; 
	private int numGreen;
	private int numVet;

	public Cavalry(){
		numGreen = 50;
		numVet = 50;
	}

	public void ageUp(){
		numVet += numGreen;
		numGreen = 0;
	}

	public int NumGreen(){return numGreen;}
	public int getNumVet(){return numVet;}	
	public void setNumGreen(int t){numGreen = t;}
	public void setNumVet(int y){numVet = y;}	
	public int getNumSoldiers(){return numVet + numGreen;}

	public int gainPeople(int gold){
		gold -= 5;
		numGreen += 1;
		return gold;
	}


	public void printOut(){
		System.out.println("Cavalry:");
		System.out.println("	Greens: "+numGreen);
		System.out.println("	Veterans: "+numVet);
	}
	public void subPeople(){
		if(numGreen >= 20){
			numGreen -= 20;
		} else {
			numGreen = 0;
		} 

		if(numVet >= 10){
			numVet -= 10;
		} else {
			numVet = 0;
		}
	}
	public int doBattle(int oppHealth, int range){
		if(range > 7){
			damage = 0;
		} else if(range > 3){
			damage = (5*numGreen + 6*numVet); 
		} else {
			damage = (3*numGreen + 4*numVet);
		}
		oppHealth -= damage;
		return oppHealth;
	}


}
