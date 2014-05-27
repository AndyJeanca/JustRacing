package com.example.justracing;

import com.example.GeneticAlgorithm.Armory;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.view.View;
import android.widget.EditText;

public class gameLoop extends Thread{
	static final long FPS = 30; // Sets the fps of the game
	boolean running;
	private Context gameView;
	public gameLoop(Context pView){
		gameView = pView;
		
	}
	
	public void setRunning(boolean run){
		running = true;
	}
	
	@Override
	public void run(){
		long ticksPS = 1000/FPS;
		long startTime = 0;
		long sleepTime=100;
		while (running){
			Intent createNewWeapon = new Intent(gameView,PrintNewWeapon.class);
	    	EditText numberTextField =(EditText) findViewById(R.id.edit_text);
	        int amountOfWeaponsToCreate = Integer.parseInt(numberTextField.getText().toString());
	        Armory arsenal = new Armory();
	    	String cover = " ";
	        
	    	   for (int actualNewWeapon = 0; actualNewWeapon<amountOfWeaponsToCreate; actualNewWeapon++){
	           	arsenal.addNewWeapon();
	           	cover= cover +"Weapon #"+Integer.toString(amountOfWeaponsToCreate)+ " \n"+"Tracks That Cover "+ Integer.toString(arsenal.getActualWeapon().getTracksThatCover())
	           			+"\n Color "+Integer.toString(arsenal.getActualWeapon().getColor())+"\n Points"+Integer.toString(arsenal.getActualWeapon().getAmountOfPoints())
	           			+"\n Pixels"+Integer.toString(arsenal.getActualWeapon().getAmountOfPixels())+"/n";
	           }
	        createNewWeapon.putExtra(EXTRA_MESSAGE,cover);
	        createNewWeapon.putExtra(EXTRA_COLOR,arsenal.getActualWeapon().getColor());
	        
	        
	        startActivity(createNewWeapon);
	        
			
		}
			
	}
	
	}

