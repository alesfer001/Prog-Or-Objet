package simpleUIApp;

import java.util.Scanner;

import fr.ubordeaux.simpleUI.*;

public class Main {
	private static Scanner scanner;

	public static void main(String[] args) {
		Game myGame;
		scanner = new Scanner(System.in);
		String respond = "";
		System.out.println("Do you want to start a new game");
		respond=scanner.next();
		if(respond.equals("yes") || respond.equals("y")){
			 myGame = new Game(2, 5, 2);
			myGame.init();
		}else{
			
			 myGame = new Game();
			try{
				myGame = myGame.loadGame();
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Erreur");
			}
		}
		
		Game.startGameAI(0);
		Game.startGameAI(1);
		
		Manager manager = new Manager();
		Run r = new Run(1024, 768, myGame);

		/*
		 * Call the run method of Application providing an initial item Collection, an
		 * item manager and an ApplicationRunnable
		 */
		Application.run(Game.getItemList(), manager, r);
	}
}
