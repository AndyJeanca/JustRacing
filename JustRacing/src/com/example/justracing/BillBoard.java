package com.example.justracing;

import java.util.ArrayList;
import java.util.Random;

import android.media.Image;


public class BillBoard {
	private int score;
	private int color;
	private Image advertisingImage;
	private String intersectionName;
	private int intersectionNumber;
	
	public BillBoard (int pIntersectionNumber) {
		score = 0;
		color = 000;		// default color
		advertisingImage = selectImage();
		intersectionName = selectName();
		intersectionNumber = pIntersectionNumber;
	}
	
	
	
	public Image selectImage () {
		ArrayList<Image> availableImages = new ArrayList<Image>();
		int randomPosition = (int) (Math.random()*availableImages.size() + 0);
		return availableImages.get(randomPosition);
	}
	
	public String selectName () {
		String intersectionName = "";
		
		
		return intersectionName;
	}
}
