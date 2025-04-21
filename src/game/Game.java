package game;

import java.util.Random;

import maze.Grid;
import player.Player;

public class Game {
	private Grid grid;
	private Player player;
	
	public Game() {
		Random random = new Random();
		int gridSize = random.nextInt(5)+3; 
		//this.grid = makeGrid(gridSize);
		 this.player = new Player(grid.getRows().get(gridSize - 1), grid.getRows().get(gridSize - 1).getCells().get(gridSize- 1));
				
	}

	public Grid getGrid() {
		return grid; 
	}
	
	public Player getPlayer() {
		return player;
	}
	
	
	
	
	
}
