package simpleUIApp;

import fr.ubordeaux.simpleUI.*;

public class Main {
	public static void main(String[] args) {
		Game myGame = new Game(2, 10, 3);
		myGame.init();
		Game.startGameAI(0);
		//Game.startGameAI(1);
		
		Manager manager = new Manager();
		Run r = new Run(1024, 768);

		/*
		 * Call the run method of Application providing an initial item Collection, an
		 * item manager and an ApplicationRunnable
		 */
		Application.run(Game.getItemList(), manager, r);
	}
}
