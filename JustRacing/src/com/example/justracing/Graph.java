package com.example.justracing;

import java.util.ArrayList;
import java.util.Hashtable;


public class Graph {
	private Hashtable<Integer, Long> nodes;
	private int level;
	private long startSeed;
	private Lehmer randomClass;
	
	
	public Graph () {
		nodes = new Hashtable<Integer, Long>();
		level = 0;
		startSeed = 897987;
		randomClass = new Lehmer();
	}
	
	//-----------------------------------------------------------------------------------//
	
	// This function is to get the startSeed
	public long getStartSeed() {
		return startSeed;
	}
	
	//-----------------------------------------------------------------------------------//
	
	// This function allow us to insert elements into a specific level
	// Receives a seed which will be inserted
	public ArrayList<Long> generateGraph(long pActualSeed) {
		ArrayList<Long> seeds = new ArrayList<Long>();
		level++;
		int newKey = level-1;
		nodes.put(newKey, pActualSeed);
		if (verifyIfSuggestRoad(level)){
			long randomSeed = suggestRoad(pActualSeed);
			seeds.add(pActualSeed);
			seeds.add(randomSeed);
			return seeds;
		}
		seeds.add(pActualSeed);
		return seeds;
	}
	
	//-----------------------------------------------------------------------------------//
	
	// This function is to get a random seed, of seeds that have been visited
	public long suggestRoad (long pSeed) {
		randomClass.setMaxNumber(4);
		int randomKey = (int) randomClass.doLhemer(pSeed);
		long randomSeed = nodes.get(randomKey);
		randomClass.setMaxNumber(2^60);
		clearHashTable();
		return randomSeed;
	}
	
	//-----------------------------------------------------------------------------------//
	
	// This function is to reset the hashtable.
	public void clearHashTable () {
		for (int actualLevel = 0; actualLevel<4; actualLevel++) {
			nodes.remove(actualLevel);
		}
		level = 0;
	}
	
	//-----------------------------------------------------------------------------------//
	
	// This function is to verify if a number
	public boolean verifyIfSuggestRoad(int pLevel) {
		if ((pLevel % 4) == 0)
			return true;
		else
			return false;
	}
	
	//-----------------------------------------------------------------------------------//
	
	
}
