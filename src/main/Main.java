package main;
import java.util.Scanner;

import hw4.game.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Game game = new Game();
		
		System.out.println("Tears, Despair and Debugging!");
		game.printGame();
		
		boolean status = game.playerStatus();
		while(status != true) {
			System.out.println("Choose weather you want to move UP,DOWN,LEFT, or RIGHT!");
			String input = scanner.nextLine().toUpperCase();
			
			try {
				Movement move = Movement.valueOf(input);
				Boolean status2 = game.movePlayer(move);
				if(status2 == false) {
					System.out.println("Are you an idiot? You can't move there!");
				}
			}catch(IllegalArgumentException e) { 
				System.out.println("Your Input was Invalid. Try again");
			}
			game.printGame();
		}
		
		System.out.println("You Escaped the matrix! Grrr, You won't be so lucky next time");
		scanner.close();
	}

}
