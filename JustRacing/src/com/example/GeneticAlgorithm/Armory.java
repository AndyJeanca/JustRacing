package com.example.GeneticAlgorithm;

import java.util.ArrayList;

public class Armory {
	private ArrayList<Weapon> weapons;
	private Weapon actualWeapon;
	private int  MAX_POPULATION_SIZE;
    
	public Armory(){
		this.weapons = new ArrayList<Weapon>();
		this.MAX_POPULATION_SIZE = 20;
		Weapon newWeapon = new Weapon();
		this.weapons.add(newWeapon);
		
	}
	
	// Getters and setters
	
	public Weapon getActualWeapon() {
		return actualWeapon;
	}

	public void setActualWeapon(Weapon actualWeapon) {
		this.actualWeapon = actualWeapon;
	}

	//This function create the initial population. All the individuals will have all the traits in 0
	public void addNewWeapon(){
		Weapon newWeapon = new Weapon();
		this.populationCycle(newWeapon);
	}
	/*This is the adaptability function it sum all the weapon's tracks that cover
	 * and get an avarage of all amount of all of them. Then it will return an array with all the the individuals on the population 
	 * that are above the avarage because they are the fittest to cruze. */
	public ArrayList<Weapon> adaptabilityFunction(){
		
		ArrayList<Weapon> fittestWeapons = new ArrayList<Weapon>();
		int fitAvarage = calculatePopulationFitAvarage();
		for(int actualWeaponPosition = 0; actualWeaponPosition<weapons.size(); actualWeaponPosition++){
			Weapon actualWeapon = weapons.get(actualWeaponPosition);
			if (actualWeapon.getTracksThatCover() >= fitAvarage){
				fittestWeapons.add(actualWeapon);
			}
		
		}
		return fittestWeapons;
		
	}
	
	//This function calculate the population fit avarage adding all the amount of tracks that each weapon cover an then divided them by the amount of weapons in the arsenal
	public int calculatePopulationFitAvarage(){
		int fitAvarage = 0;
		for(int populationSize = 0; populationSize<weapons.size(); populationSize++){
			Weapon actualWeapon = weapons.get(populationSize);
			fitAvarage += actualWeapon.getTracksThatCover();
		
		}
		return fitAvarage/weapons.size();	
	}
	
	//this function takes two weapons and cruze the to create a child Weapon with traits of both parents.
	public Weapon cruzeWeapon (Weapon parent1, Weapon parent2){
		//Parents Traits
		byte parent1TrackReach = parent1.getADN().getTracksThatCover();
		byte parent1Color = parent1.getADN().getColor();
		byte parent1Points = parent1.getADN().getAmountOfPoints();
		
		byte parent2TrackReach = parent2.getADN().getTracksThatCover();
		byte parent2Color = parent2.getADN().getColor();
		byte parent2Points = parent2.getADN().getAmountOfPoints();
		

		Weapon childWeapon = new Weapon();
		
		byte childTrackReachChromosome = this.cruzeChromosome(parent1TrackReach, parent2TrackReach);
		childWeapon.getADN().setTracksThatCover(childTrackReachChromosome);
		
		byte childColor = this.cruzeChromosome(parent1Color, parent2Color);
		childWeapon.getADN().setColor(childColor);
		
		byte childPoints = this.cruzeChromosome(parent1Points, parent2Points);
		childWeapon.getADN().setAmountOfPoints(childPoints);
		
		byte childPixels = this.cruzeChromosome(parent1Points, parent2Points);
		childWeapon.getADN().setAmountOfPoints(childPixels);
		
		childWeapon.traitsValues();
		return childWeapon;
	}
	
	//Cruze chromosomes take two individals and cruze all their chromosomes.
	public byte cruzeChromosome (byte parent1Chromosome, byte parent2Chromosome){
		 byte parent1Half;
	     byte parent2Half;
	     parent1Half = (byte)(parent1Chromosome<<4);
	     parent2Half = (byte)(parent2Chromosome>>4);
	     byte childChromosome = (byte)(parent1Half | parent2Half);
	     //Mutation 

	     int mutationChance = (int)(Math.random() * 101);
	     if (mutationChance<10){
	    	 //Mutation auxiliar = 0001 0000 and it will help to change the 4th bit making an XOR with the child chromosome
	    	 byte mutationAuxiliar = (byte)(16);
	    	 childChromosome = (byte)(childChromosome ^ mutationAuxiliar);	    	 
	     }
	     return childChromosome;
	        
	}
	
	//PopulationCycle recive a new individual, then it take the fittest match and cruze them. It return the offspring and then it eliminate some random 
	//individual from the population.
	public void populationCycle(Weapon newWeapon){
		
		//Get the fittest by the adaptabilityFormula
		ArrayList<Weapon> fittestWeaponsList = this.adaptabilityFunction();
		int randomWeaponFromFittestList = (int)(Math.random() * fittestWeaponsList.size());
		
		Weapon fittestWeapon = fittestWeaponsList.get(randomWeaponFromFittestList);
		
		
		//cruzeWeapon
		Weapon childWeapon = cruzeWeapon(newWeapon, fittestWeapon);
		setActualWeapon(childWeapon);
		this.weapons.add(childWeapon);
		populationControl();
		
	}
	//Randomly eliminate weapons from the population until it get to the MAX_POPULATION_SIZE 
	public void populationControl(){
		int amountOfExtraWeapons = this.weapons.size() - this.MAX_POPULATION_SIZE;
		for (int actualExtraWeapon = 0; actualExtraWeapon<amountOfExtraWeapons;actualExtraWeapon++){
		    int weaponToEliminate = (int)(Math.random() * weapons.size());
		    this.weapons.remove(weaponToEliminate);
		}
	}
}
