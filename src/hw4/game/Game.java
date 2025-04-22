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


}
	
	
	

