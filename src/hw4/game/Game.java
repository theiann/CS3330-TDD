package hw4.game;

import java.util.Random;

import hw4.maze.*;
import hw4.maze.Row;
import hw4.player.*;

import java.util.ArrayList;


public class Game {
private Grid grid;

public Game(Grid grid) {
	this.grid=grid; 
}

public Game (int size) {
	if(size>=3 && size<=7) {
		this.grid=createRandomgrid()size;
	}
	else {
		this.grid=null;
	}
}

public Grid getGrid() {
	return grid;
}

public void setGrid(Grid grid) {
	this.grid = grid; 
}

public boolean play(Movement move, Player player) {
	if(grid == null || player == null || move == null) {
		return false;
	}
	
	int colIndex = player.getCurrentRow().getCells().indexOf(player.getCurrentCell());
	int rowIndex = grid.getRows().indexOf(player.getCurrentRow());
	int nRow = rowIndex;
	int nCol= colIndex;
	Cell current = player.getCurrentCell();
	
	switch(move) {
	case UP:
		if(current.getUp()== CellComponents.APERTURE && rowIndex>0) {
			nRow--;
		}
		else {
			return false;
		}
		break;
	case DOWN:
		if(current.getDown()==CellComponents.APERTURE && rowIndex<grid.getRows().size()-1) {
			nRow++;
		}
		else {
			return false; 
		}
		break;
	case LEFT:
		if(current.getLeft()==CellComponents.APERTURE || current.getLeft()==CellComponents.EXIT && colIndex>0) {
			nCol--;
		}
		else {
			return false; 
		}
		break;
	case RIGHT:
		if(current.getRight()==CellComponents.APERTURE && colIndex<grid.getRows().get(0).getCells().size()-1) {
			nCol++;
		}
		else {
			return false; 
		}
		break;
	}
	player.setCurrentRow(grid.getRows().get(nRow));
	player.setCurrentCell(grid.getRows().get(nRow).getCells().get(nCol));
	return true; 
}

}
	
	
	

