package com.example.ObjectOnTrack;

public class Vehicle extends ObjectOnTrack{

	public Vehicle (int pX, int pY) {
		// pX and pY will have a default value to start in the center
		super(pX, pY);
	}
	
	public boolean isInRange() {
		// Modify this
		return true;
	}
	
	public void moveToLeft() {
		
	}
	
	public void moveToRight() {
		
	}
}
