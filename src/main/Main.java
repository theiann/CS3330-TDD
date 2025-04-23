package main;
import java.util.ArrayList;
import java.util.Scanner;

import hw4.game.*;
import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.*;

public class Main {

	
	/**
	 * The main method starts and runs the grid game. 
	 * It initially creates a 5x5 grid, and uses scanner to get player input
	 * It enters a while to process all the movement inputs until the player types EXIT to quit.
	 * It also uses a Try Catch to determine weather the input was valid or not. Prints invalid movemnt if not 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game(5);
		Grid grid = game.getGrid();
		Scanner scanner = new Scanner(System.in);
		ArrayList<Row> rows = grid.getRows();
		Player player = new Player(rows.get(rows.size() - 1), rows.get(rows.size() - 1).getCells().get(rows.size() - 1));
		
		System.out.println("Tears, Despair and Debugging");
		game.printGame(player);
		
		while(true) {
			System.out.println("Choose Direction UP DOWN LEFT RIGHT, or type EXIT");
			String input = scanner.nextLine().toUpperCase();
			if(input.equals("QUIT")) {
				System.out.println("Game Ended");
				break;
			}
			
			try {
				Movement direction = Movement.valueOf(input);
				boolean status = game.play(direction, player);
				if(status == true) {
					System.out.println("Nice Move!");
				}
				else {
					System.out.println("You Can't go there");
				}
				game.printGame(player);
			}catch(IllegalArgumentException e){
				System.out.println("Invalid Movement");
			}
			}
			
			
			
			scanner.close();
		}
  }
