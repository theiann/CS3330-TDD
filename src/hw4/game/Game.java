package hw4.game;

import java.util.Random;
import hw4.maze.CellComponents;
import hw4.maze.Cell;
import hw4.maze.*;
import hw4.maze.Row;
import hw4.player.*;

import java.util.ArrayList;


public class Game {
private Grid grid;
/**
 * Constructor for the game with the specified grid
 * @param grid
 */
public Game(Grid grid) {
	this.grid=grid; 
}

/**
 * this method checks to see if the passed size value is valid to create
 * the grid, and if it is, sets the grid to the method call of createRandomGrid,
 * which creates the grid
 * @param size
 */
public Game (int size) {
	if(size>=3 && size<=7) {
		this.grid=createRandomGrid(size);
	}
	else {
		this.grid=null;
	}
}

/**
 * getter for the grid
 * @return grid
 */
public Grid getGrid() {
	return this.grid;
}

/**
 * setter for the grid
 * @param grid
 */
public void setGrid(Grid grid) {
	this.grid = grid; 
}

/**
 * After the move and player parameters are passed to this method, it
 * first checks if everything is valid, and then if the move is valid, it uses the 
 * passed player param to find its current location and perform the directional movement
 * using a switch case. Move fails if player moves into wall or outside grid
 * @param move
 * @param player
 * @return
 */
public boolean play(Movement move, Player player) {
	if(grid == null || player == null || move == null) {
		return false;
	}
	 ArrayList<Row> rows= grid.getRows();
	Row currRow = player.getCurrentRow();
	Cell currCell = player.getCurrentCell();
	int rowIndex=rows.indexOf(currRow);
	int colIndex= currRow.getCells().indexOf(currCell);
	
	switch (move) {
	case UP:
		if (currCell.getUp() == CellComponents.APERTURE && rowIndex > 0) {
		player.setCurrentRow(rows.get(rowIndex - 1));
		player.setCurrentCell(rows.get(rowIndex - 1).getCells().get(colIndex));
		return true;
		}
		break;
	case DOWN:
		if (currCell.getDown() == CellComponents.APERTURE && rowIndex < rows.size() - 1) {
		player.setCurrentRow(rows.get(rowIndex + 1));
		player.setCurrentCell(rows.get(rowIndex + 1).getCells().get(colIndex));
		return true;
		}
		break;
	case LEFT:
		if (currCell.getLeft() == CellComponents.APERTURE && colIndex > 0) {
		player.setCurrentCell(currRow.getCells().get(colIndex - 1));
		return true;
		} else if (currCell.getLeft() == CellComponents.EXIT && colIndex == 0) {
		player.setCurrentCell(currCell); 
		return true;
		}
		break;
	case RIGHT:
		if (currCell.getRight() == CellComponents.APERTURE && colIndex < currRow.getCells().size() - 1) {
		player.setCurrentCell(currRow.getCells().get(colIndex + 1));
		return true;
		}
		break;
} 
	return false;
} 

/**
 * this creates a random grid of the sent size value. This makes it so the grid will have 
 * one exit on the left most column, on a random row. It also makes it so each cell will have 
 * at least one APERTURE on one of its sides. Uses random number between 0 and 3 to pick which side the aperture
 * is it, after initially assigning everything to wall
 * 
 * @param size
 * @return a randomly generated grid
 */
public Grid createRandomGrid(int size) {
	if(size<3 || size>7) {
		return null;
	}
	Random rand = new Random();
	ArrayList<Row> rows = new ArrayList<>();

	int exitRow = rand.nextInt(size);

	for (int i = 0; i < size; i++) {
		ArrayList<Cell> cells = new ArrayList<>();
		for (int j = 0; j < size; j++) {
			CellComponents left = CellComponents.WALL;
			CellComponents right = CellComponents.WALL;
			CellComponents up = CellComponents.WALL;
			CellComponents down = CellComponents.WALL;

			if (j == 0 && i == exitRow) {
				left = CellComponents.EXIT;
			}

			int apertureSide = rand.nextInt(4);
			if (apertureSide == 0) {
				if(!(j==0 && i==exitRow)) {
					left = CellComponents.APERTURE;
				}
			}
			else if (apertureSide == 1) {
				right = CellComponents.APERTURE;
			}
			else if (apertureSide == 2) {
				up = CellComponents.APERTURE;
			}
			else { 
				down = CellComponents.APERTURE;
			}
			
			Cell cell = new Cell(left, right, up, down);
			cells.add(cell);
		}
		rows.add(new Row(cells));
	}
	Grid g = new Grid(rows);

	for (int i = 0; i < size; i++) {
		Row row = rows.get(i);
		for (int j = 0; j < size; j++) {
			Cell current = row.getCells().get(j);

			if (j < size - 1) {
			Cell rightCell = row.getCells().get(j + 1);
			current.setRight(rightCell.getLeft());
			rightCell.setLeft(current.getRight());
			}

			if (i < size - 1) {
			Cell below = rows.get(i + 1).getCells().get(j);
			current.setDown(below.getUp());
			below.setUp(current.getDown());
		}
		} 
	}

	return g; 
}


/**
 * This creates a visual representation of the grid, and can be called after every move. 
 * The player is represented by A, the Exit by E and cells by S
 * @param player
 */
public void printGame(Player player) {
	if(grid == null) {
		return ;
	}
	if(player == null) {
		return;
	}
	ArrayList<Row> rows = grid.getRows();
	
	
	for(int i =0;i<rows.size();i++) {
		ArrayList<Cell> cells = rows.get(i).getCells();
		for(int j=0;j<cells.size();j++) {
			Cell cell = cells.get(j);
			if(cell == player.getCurrentCell()) {
				System.out.print("A ");
			}
			else if(j==0 && cell.getLeft()==CellComponents.EXIT) {
				System.out.print("E ");
			}
			else {
				System.out.print("S " );
			}
		}
		System.out.println("");
	}
	
	System.out.print("\n");
}
 
/**
 * simply returns a string representation of the game
 */
@Override
public String toString() { 
	return "Game [grid="+grid+"]";
}

}
	
	
	

