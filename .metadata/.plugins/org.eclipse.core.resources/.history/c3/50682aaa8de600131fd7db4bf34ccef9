package com.example.justracing;

import java.util.ArrayList;
import java.util.Hashtable;


@SuppressWarnings("rawtypes")
public class Graph {
	// private long key;
	private Hashtable<Long, ArrayList> nodes;
	private int level;
	private long startSeed;
	
	
	public Graph () {
		nodes = new Hashtable<Long, ArrayList>();
		level = 0;
		startSeed = 897987;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int pLevel) {
		level = pLevel;
	}
	
	public void initializeGraph(long pSeed) {
		ArrayList<ActualTrackSector> nodesByLevel = new ArrayList<ActualTrackSector>();
		
		Lehmer initialNode = new Lehmer();
		long initialRandomId = initialNode.doLhemer(pSeed);
		
		ActualTrackSector initialSector = new ActualTrackSector(initialRandomId);
		nodesByLevel.add(initialSector);
		nodes.put((long) (level-1), nodesByLevel);
		
		level++;
		// see if level % 4 == 0 (incomplete)
		
		// Here we will to clear all elements in nodesByLevel
		nodesByLevel.clear();
		
		initialNode.setMaxNumber(3);
		long amountOfRoads = initialNode.doLhemer(initialRandomId);
		amountOfRoads += 1;				// amount of roads to create
		
		initialNode.setMaxNumber(2^60);
		
		for (int amountOfNodes = 0; amountOfNodes < amountOfRoads ; amountOfNodes++) {
			long newRandomId = initialNode.doLhemer(initialRandomId);
			
			initialRandomId = newRandomId;
			
			ActualTrackSector newSector = new ActualTrackSector(newRandomId);
			nodesByLevel.add(newSector);
		}
		level++;
		// see if level % 4 == 0 (incomplete)	
		
		initializeGraph(initialRandomId); // Check this
		
	}
	
	public boolean verifyIfSuggestRoad(int pLevel) {
		if ((pLevel % 4) == 0)
			return true;
		else
			return false;
	}
	
	
	
	
}
