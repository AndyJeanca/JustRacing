package com.example.justracing;

import java.util.ArrayList;

import com.example.GeneticAlgorithm.Weapon;
import com.example.ObjectOnTrack.Enemy;

public class ActualTrackSector {
	private long id;
	private boolean status;
	private ArrayList<Enemy> enemies;
	private Weapon weapon;
	private BillBoard billBoard;
	
	public ActualTrackSector (long pId) {
		id = pId;
		status = false;
		enemies = generateEnemies();
		weapon = new Weapon();
		billBoard = new BillBoard((int) pId);
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@SuppressWarnings("static-access")
	public ArrayList<Enemy> generateEnemies() {
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		Lehmer _NumberOfEnemies = new Lehmer();
		_NumberOfEnemies.setMaxNumber(4);
		long randomAmountOfEnemies = _NumberOfEnemies.doLhemer(id);
		for (int amountOfEnemies = 0; amountOfEnemies < randomAmountOfEnemies; amountOfEnemies++) {
			_NumberOfEnemies.setMaxNumber(5);
			int x = (int) _NumberOfEnemies.doLhemer(id);
			_NumberOfEnemies.setMaxNumber(100);
			int y = (int) _NumberOfEnemies.doLhemer(id);
			Enemy newEnemy = new Enemy(x, y);
			enemies.add(newEnemy);
		}
		return enemies;
	}
	
	
	

}
