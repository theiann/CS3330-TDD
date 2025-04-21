package game;

import java.util.Random;
import java.util.ArrayList;

import maze.Cell;
import maze.CellComponents;
import maze.Grid;
import maze.Row;
import player.Player;


public class Game {
	private Grid grid;
	private Player player;
	
	public Game() {
		Random random = new Random();
		int gridSize = random.nextInt(5)+3; 
		this.grid = makeGrid(gridSize);
		 this.player = new Player(grid.getRows().get(gridSize - 1), grid.getRows().get(gridSize - 1).getCells().get(gridSize- 1));		
	}
	
	private Grid makeGrid(int gridSize) {
		ArrayList<Row> rows= new ArrayList<>();
		Random rand1 = new Random();
		int exitRow = rand1.nextInt(gridSize); 
		
		for(int i = 0;i<gridSize; i++) {
			ArrayList<Cell> cells = new ArrayList<>();
			for(int j = 0; j<gridSize; j++) { 
				CellComponents right = randomComponent(rand1); 
				CellComponents left = randomComponent(rand1);  
				CellComponents down = randomComponent(rand1); 
				CellComponents up = randomComponent(rand1); 
				
				
				if(j ==0) {
					if(i==exitRow) {
						left = CellComponents.EXIT;
					}
				}
				
				if(left != CellComponents.APERTURE && right !=CellComponents.APERTURE && up!=CellComponents.APERTURE && down != CellComponents.APERTURE && !(j ==0 && i== exitRow)){
					int num = rand1.nextInt(4);
					if(num == 0) {
						up = CellComponents.APERTURE;
					}
					if(num ==1) {
						down = CellComponents.APERTURE;
					}
					if(num == 2) {
						left = CellComponents.APERTURE;
					}
					if(num == 3) {
						right = CellComponents.APERTURE;
					}
					
					
				}
				cells.add(new Cell(left,right,up,down));
				
			}
			rows.add(new Row(cells));
		}
		return new Grid(rows); 
	}

	
	private CellComponents randomComponent(Random rand1){
	if(rand1.nextBoolean()) {
		return CellComponents.APERTURE;
	}
	return CellComponents.WALL;
	}
	
	
	public Grid getGrid() {
		return grid; 
	}
	
	public Player getPlayer() {
		return player;
	}
	
	
	
	
	
}
