import java.util.Scanner;
import java.io.File;
import java.io.FileWriter; 
import java.io.IOException;
public class Infantry{
	private int damage; 
	private int numGreen;
	private int numVet;	
	public Infantry(){
		numGreen = 50;
		numVet = 50;
		damage = 0;
	}
	public int getNumGreen(){return numGreen;}
	public int getNumVet(){return numVet;}
	public int getNumSoldiers(){return numVet + numGreen;}
	public void setNumGreen(int t){numGreen = t;}
	public void setNumVet(int y){numVet = y;}	
	public int gainPeople(int gold){
		gold -= 3;
		numGreen ++;
		return gold;
	}
	public void ageUp(){
		numVet += numGreen;
		numGreen = 0;
	}
	public void printOut(){
		System.out.println("Infantry: ");
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
			damage = (3*numGreen + 4*numVet); 
		} else {
			damage = (5*numGreen + 4*numVet);
		}
		oppHealth -= damage;
		return oppHealth;
	}

}
