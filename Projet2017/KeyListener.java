package simpleUIApp;

import javax.swing.JFrame;

import fr.ubordeaux.simpleUI.KeyHandler;

public class KeyListener implements KeyHandler {
	private Game myGame;
	private JFrame mFrame;

	public KeyListener(JFrame frame, Game myGame) {
		mFrame = frame;
		this.myGame = myGame;
	}

	public JFrame getParentFrame() {
		return mFrame;
	}

	public void keyPressed(char arg0) {

	}

	public void keyReleased(char arg0) {

	}

	public void keyTyped(char arg0) {
		switch (arg0) {
		case '+':
			System.out.println("+ has been typed");
			break;
		case '-':
			System.out.println("- has been typed");
			break;
		case 's':
			myGame.saveGame();
			break;
		default:
			// do nothing
			break;
		}
	}

}
