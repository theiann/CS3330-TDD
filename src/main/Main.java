package main;
import java.util.Scanner;

import hw4.game.*;
import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.*;

public class Main {

	public static void main(String[] args) {
		Game game = new Game(5);
		Grid grid = game.getGrid();
		System.out.println(grid.toString());
//		//Player player = new Player(grid.getRows().get(4),grid.getRows().get(4).getCells().get(4));
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Tears Despair and Debugging");
//		printGameInfo(grid,player);
//		while(true) {
//			System.out.println("Choose the direction you want to Move: UP, Down, Left or Right");
//			String move = scanner.nextLine().toUpperCase();
//			
//		try {
//			Movement direction = Movement.valueOf(move);
//			boolean status = game.play(direction, player);
//			if(status == true) {
//				System.out.println("Nice Move!");
//			}
//			else {
//				System.out.println("You Can't go there");
//			}
//			printGameInfo(grid,player);
//		}catch(IllegalArgumentException e){
//			System.out.println("Invalid Movement");
//		}
//		}
//}
//	private static void printGameInfo( Grid grid, Player player) {
//int size = grid.getRows().size();
//        
//        for (int i = 0; i < size; i++) {
//            Row row = grid.getRows().get(i);
//            for (int j = 0; j < size; j++) {
//                Cell cell = row.getCells().get(j);
//                if (player.getCurrentRow() == row && player.getCurrentCell() == cell) {
//                    System.out.print("A ");
//                } 
//                else if (j == 0 && cell.getLeft() == CellComponents.EXIT) {
//                    System.out.print("E ");
//                } 
//                else {
//                    System.out.print("S ");
//                }
//            }
//            System.out.println();
//        }
  }
} 