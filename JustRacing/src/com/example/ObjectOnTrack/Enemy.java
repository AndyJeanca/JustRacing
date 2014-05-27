package com.example.ObjectOnTrack;

public class Enemy extends ObjectOnTrack{
	private int amountOfShots;
	
	public Enemy(int pX, int pY) {
		super(pX, pY);
		amountOfShots = 0;
	}
	
	public int getAmountOfShots() {
		return amountOfShots;
	}
	
}
