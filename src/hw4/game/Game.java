package hw4.game;

import java.util.Random;

import hw4.maze.*;
import hw4.maze.Row;
import hw4.player.*;

import java.util.ArrayList;


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
	
	public Boolean movePlayer(Movement direction) {
		int rowIndex = grid.getRows().indexOf(player.getCurrentRow()); 
		int columnIndex= player.getCurrentRow().getCells().indexOf(player.getCurrentCell());
		int nCol = columnIndex;
		int nRow = rowIndex; 
		
		Cell current = player.getCurrentCell();
		switch (direction) {
		case LEFT:
		if(current.getLeft() == CellComponents.APERTURE || current.getLeft() == CellComponents.EXIT && columnIndex > 0) nCol--; 
		else return false; 
		break;
		case RIGHT:
		if(current.getRight() == CellComponents.APERTURE && columnIndex < grid.getRows().get(0).getCells().size()-1) nCol++; 
		else return false; 
		break;
		case UP:
		if(current.getUp()==CellComponents.APERTURE && rowIndex>0) nRow--; 
		else return false;
		break;
		case DOWN:
		if(current.getDown() == CellComponents.APERTURE && rowIndex < grid.getRows().size()-1)nRow++;
		else return false;
		break;
		}
		player = new Player(grid.getRows().get(nRow), grid.getRows().get(nRow).getCells().get(nCol));
		return true; 
		 
		} 
		
		public void printGame() {
			for(int i = 0; i<grid.getRows().size(); i++) {
				Row row = grid.getRows().get(i);
				for(int j = 0; j<row.getCells().size();j++) {
					if(player.getCurrentRow() == row && player.getCurrentCell()== row.getCells().get(j)) {
						System.out.printf("A ");
					}
					else if(j == 0 && row.getCells().get(j).getLeft()==CellComponents.EXIT) {
						System.out.printf("E ");
					}
					else {
						System.out.printf("S ");
					}
					
				}
				System.out.println();
				
			}
			System.out.println();
		}
		
		public boolean playerStatus() {
			Cell current = player.getCurrentCell();
			int columnIndex = player.getCurrentRow().getCells().indexOf(current); 
			if(columnIndex == 0 && current.getLeft()==CellComponents.EXIT) {
				return true; 
			}
			return false; 
		}
	}
	
	
	

