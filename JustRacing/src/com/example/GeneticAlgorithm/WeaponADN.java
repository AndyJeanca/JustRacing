package com.example.GeneticAlgorithm;

//Weapon is the individual of the population it have three chromosomes 
/*
 *---------TRACKS TO COVER--------- 
 * from		 to 	tracksAmount 		
 * -127		-42		1					
 * -42		 43		2					
 * 43		127		3					
 * 
 * ---------COLORS---------
 * 
 * from		 to 	color 				
 * -127		-61		green						
 * -61	  	3	    red				
 * 3		67 		yellow				
 * 67		127		random color
 * 
 * ---------AMOUNTS OF POINTS---------
 * 
 * from		 to 	amount Of Points 
 * -127		-42		3
 * -42		43		4
 * 43		127		5
 * 
 * ---------AMOUNT OF PIXELS-----------
 * from		to 		amountOfPixels
 * -127	   -104			5
 * -104    -81			6
 * -81		-58			7
 * -58		-35			8
 * -35		-12			9
 * -12		11			10
 * 11		34			11
 * 34		57			12
 * 57		80			13
 * 80		103			14
 * 103		127			15
 * 
 * 
 * 
 * 
 */
public class WeaponADN {
	
	//Chromosomes 
	private byte tracksThatCoverChromosome;
	private byte color;
	private byte amountOfPoints;
	private byte amountOfPixels;
	
	public WeaponADN(){
		this.tracksThatCoverChromosome = (byte)0;
		this.color = (byte)0;
		this.amountOfPoints = (byte)0;
		this.amountOfPixels = (byte)0;
	}
	//Getters and setters
	public byte getAmountOfPixels() {
		return amountOfPixels;
	}
	public void setAmountOfPixels(byte amountOfPixels) {
		this.amountOfPixels = amountOfPixels;
	}
	public byte getAmountOfPoints() {
		return amountOfPoints;
	}
	public byte getColor() {
		return color;
	}
	public byte getTracksThatCover() {
		return tracksThatCoverChromosome;
	}
	public void setAmountOfPoints(byte amountOfPoints) {
		this.amountOfPoints = amountOfPoints;
	}
	public void setColor(byte color) {
		this.color = color;
	}
	public void setTracksThatCover(byte tracksThatCover) {
		this.tracksThatCoverChromosome = tracksThatCover;
	}

}
