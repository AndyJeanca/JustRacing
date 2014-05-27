package com.example.GeneticAlgorithm;

import java.util.ArrayList;

import android.graphics.Color;

public class Weapon {	
	private int tracksThatCover;
	private int color;
	private int amountOfPixels;
	private int amountOfPoints;
	
	//Chromosomes 
	private WeaponADN ADN; 
	
	public Weapon(){
		ADN = new WeaponADN();
		
		//When it create a new weapon, it has random traits 
		byte tracksThatCoverChromosome = (byte)((Math.random() * 254)-127);
		ADN.setTracksThatCover(tracksThatCoverChromosome);
		
		byte colorChromosome = (byte)((Math.random() * 254)-127);
		ADN.setColor(colorChromosome);
		
		byte amountOfPixelsChromosome = (byte)((Math.random() * 254)-127);
		ADN.setAmountOfPixels(amountOfPixelsChromosome);
		
		byte amountOfPointsChromosome = (byte)((Math.random() * 254)-127);
		ADN.setAmountOfPoints(amountOfPointsChromosome);
		
		//Then it gets its traits values according to its chromosomes
		this.traitsValues();
		
		
	}
	//Getters and setters
	public WeaponADN getADN() {
		return ADN;
	}
	public void setADN(WeaponADN aDN) {
		ADN = aDN;
	}
	public int getTracksThatCover() {
		return tracksThatCover;
	}
	
	public void setTracksThatCover(int tracksThatCover) {
		this.tracksThatCover = tracksThatCover;
	}
	
	public int getColor() {
		return color;
	}
	
	public void setColor(int color) {
		this.color = color;
	}
	
	public int getAmountOfPixels() {
		return amountOfPixels;
	}

	public void setAmountOfPixels(int amountOfPixels) {
		this.amountOfPixels = amountOfPixels;
	}

	public int getAmountOfPoints() {
		return amountOfPoints;
	}
	
	public void setAmountOfPoints(int amountOfPoints) {
		this.amountOfPoints = amountOfPoints;
	}
	
	
	//Traits values is a method that give values to the traits of the weapon according to the chromosomes
	public void traitsValues(){
		setTracksThatCover(Math.round((ADN.getTracksThatCover() +127)/85)+1);
		setAmountOfPixels(Math.round((ADN.getAmountOfPixels() +127)/25)+5);
		setAmountOfPoints(Math.round((ADN.getAmountOfPoints() +127)/85)+3);

		this.getColorTrait();
	}
	public void getColorTrait(){
		ArrayList<Integer> weaponPosibleColorsInt = new ArrayList<Integer>();
		
		//Green 
		weaponPosibleColorsInt.add(Color.rgb(177, 255, 102));
		//Red
		weaponPosibleColorsInt.add(Color.rgb(255, 102, 102));
		//Yellow
		weaponPosibleColorsInt.add(Color.rgb(255, 255, 102));
		//RandomColor
		int randomRed = (int)(Math.random() * 256);
		int randomGreen = (int)(Math.random() * 256);
		int randomBlue = (int)(Math.random() * 256);
						
		weaponPosibleColorsInt.add(Color.rgb(randomRed, randomGreen, randomBlue));
		
		int whatColorRepresent = Math.round((ADN.getColor() +127)/64);
		setColor(weaponPosibleColorsInt.get(whatColorRepresent));
		
	}
	

}
