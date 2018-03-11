package DemoFlappyBird_Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

import DemoFlappyBird_JComponent.Bird;
import DemoFlappyBird_JComponent.Ground;

public class Rule {
	private BirdEvent birdEvent;
	private Ground ground;
	private PipeGroup pipeGroup;
	private Bird bird;
	private int score;
	private Sound sound;
	private HashMap<String, Sound> soundPlayer;
	private boolean endGame;

	private int bestScore;

	public Rule(BirdEvent birdEvent, Ground ground, PipeGroup pipeGroup, Bird bird) {
		// TODO Auto-generated constructor stub
		this.birdEvent = birdEvent;
		this.ground = ground;
		this.pipeGroup = pipeGroup;
		this.bird = bird;
		this.score = 0;
		this.bestScore = 0;

		soundPlayer = new HashMap<>();
		sound = new Sound(new File("Assets\\sfx_point.wav"));
		soundPlayer.put("Point", sound);
		sound = new Sound(new File("Assets\\sfx_hit.wav"));
		soundPlayer.put("Hit", sound);
	}

	public void resetGame() {
		this.score = 0;
		for (int i = 0; i < this.getPipeGroup().getPipes().length; i++) {
			this.getPipeGroup().getPipes()[i]
					.setX(this.getPipeGroup().getPipes()[i].getX() + this.getPipeGroup().getWidth());
		}
		this.bird.setY(0);
		this.birdEvent.setBirdY(this.bird.getY());
		this.bird.setX(50);
		this.birdEvent.setVelocity(1);
	}

	public void ScoreUp() {
		for (int i = 0; i < this.getPipeGroup().getPipes().length; i++) {
			if (this.bird.getX() >= this.getPipeGroup().getPipes()[i].getX() + Config.pipeWidth
					&& this.getPipeGroup().getPipes()[i].isBehindBird() == false) {
				this.score++;
				this.soundPlayer.get("Point").play();
				this.getPipeGroup().getPipes()[i].setBehindBird(true);
			}
		}
	}

	public boolean endGame() {
		if (this.bird.getY() + this.bird.getHeight() >= (Config.playScreenHeight - Config.playScreenHeight / 6)) {
			return true;
		}
		for (int i = 0; i < this.getPipeGroup().getPipes().length; i++) {
			if (this.bird.getBounds().intersects(this.getPipeGroup().getPipes()[i].getBounds())) {
				return true;
			}
		}
		return false;
	}

	public void saveHighScore() {
		if (this.bestScore > loadHighScore()) {
			FileWriter fileWriter = null;
			try {
				fileWriter = new FileWriter("highScore.txt");
				fileWriter.write(String.valueOf(bestScore));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fileWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private int loadHighScore() {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("highScore.txt"));
			return Integer.parseInt(sc.nextLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
		}finally {
			sc.close();
		}
		return 0;
	}

	public int showBestScore() {
		if (bestScore > loadHighScore()) {
			return bestScore;
		} else {
			return loadHighScore();
		}
	}

	public BirdEvent getBirdEvent() {
		return birdEvent;
	}

	public Ground getGround() {
		return ground;
	}

	public PipeGroup getPipeGroup() {
		return pipeGroup;
	}

	public Bird getBird() {
		return bird;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getBestScore() {
		return bestScore;
	}

	public void setBestScore() {
		if (this.score > this.bestScore) {
			this.bestScore = this.score;
		}
	}

	public boolean isEndGame() {
		return endGame;
	}

	public void setEndGame(boolean endGame) {
		this.endGame = endGame;
	}

}
