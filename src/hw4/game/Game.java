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
		if((current.getLeft()==CellComponents.APERTURE || current.getLeft()==CellComponents.EXIT) && colIndex>0) {
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
			if(rand2==2) {
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
			Cell right = rows.get(i).getCells().get(j+1);
			left.setRight(right.getLeft());
		}
	}
	
	for(int j=0;j<size;j++) {
		for(int i=0;i<size-1;i++) {
			Cell top = rows.get(i).getCells().get(j);
			Cell bottom = rows.get(i+1).getCells().get(j);
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
	
	
	

