      package DemoFlappyBird_Run;

import DemoFlappyBird_Manager.Control;
import DemoFlappyBird_Screen.EndScreen;
import DemoFlappyBird_Screen.PlayScreen;
import DemoFlappyBird_Screen.StartScreen;

// TODO from UCDetector: Class "Runner" has 0 references
public class Runner { // NO_UCD (unused code)
	public static void main(String[] args) {
		StartScreen startScreen = new StartScreen();
		PlayScreen playScreen = new PlayScreen();
		EndScreen endScreen = new EndScreen();

		Control control = new Control(playScreen, startScreen, endScreen);
		control.begin();
	}
}
