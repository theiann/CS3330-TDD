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

public Game(Grid grid) {
	this.grid=grid; 
}

public Game (int size) {
	if(size>=3 && size<=7) {
		this.grid=createRandomGrid(size);
	}
	else {
		this.grid=null;
	}
}

public Grid getGrid() {
	return this.grid;
}

public void setGrid(Grid grid) {
	this.grid = grid; 
}

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

public Grid createRandomGrid(int size) {
	if(size<3 || size>7) {
		return null;
	}
	 ArrayList<Row> rows = new ArrayList<>();
	 Random rand1 = new Random(); 
	 int exitRow = rand1.nextInt(size); 
	
	for(int i=0;i<size;i++) {
		ArrayList<Cell> cells = new ArrayList<>();
		for(int j=0;j<size-1;j++) {
		CellComponents left = randomComponent(rand1);
        CellComponents right = randomComponent(rand1);
        CellComponents up = randomComponent(rand1);
        CellComponents down = randomComponent(rand1);
			
		if(j==0 && i== exitRow) {
			left = CellComponents.EXIT;
		}
		
		if(left!= CellComponents.APERTURE && right != CellComponents.APERTURE && up!= CellComponents.APERTURE && down != CellComponents.APERTURE && !(j==0 && i ==exitRow)) {
			int rand2 = rand1.nextInt(4);
			if(rand2==0) {
				down = CellComponents.APERTURE;
			}
			if(rand2==1) {
				left = CellComponents.APERTURE;
			}
			if(rand2==2) {
				right = CellComponents.APERTURE;
			}
			if(rand2==2) {  // Should be 3?
				up = CellComponents.APERTURE;
			}
		}
		cells.add(new Cell(left, right, up, down));
		}
		rows.add(new Row(cells));
	}
	
	for(int i=0;i<size;i++) {
		for(int j=0;j<size-1;j++) {
			Cell left = rows.get(i).getCells().get(j);
			Cell right = rows.get(i).getCells().get(j); //deleted +1 to j NEEDS FIXING
			left.setRight(right.getLeft());
		}
	}
	
	for(int i=0;i<size;i++) { // swapped j to i
		for(int j=0;j<size-1;j++) { //swapped i to j
			Cell top = rows.get(i).getCells().get(j);
			Cell bottom = rows.get(i).getCells().get(j); // deleted +1 to i NEEDS FIXING
			top.setDown(bottom.getUp());
		}
	}
	return new Grid(rows);
}

private CellComponents randomComponent(Random rand1) {
	if(rand1.nextBoolean()) {
		return CellComponents.APERTURE; 
	}
	else {
		return CellComponents.WALL;
	}	
}

@Override
public String toString() { 
	return "Game [grid="+grid.toString()+"]";
}

}
	
	
	

