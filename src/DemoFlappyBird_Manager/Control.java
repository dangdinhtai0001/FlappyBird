package DemoFlappyBird_Manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import DemoFlappyBird_JComponent.Bird;
import DemoFlappyBird_JComponent.Ground;
import DemoFlappyBird_JComponent.Score;
import DemoFlappyBird_Model.BirdEvent;
import DemoFlappyBird_Model.PipeGroup;
import DemoFlappyBird_Model.Rule;
import DemoFlappyBird_Model.Sound;
import DemoFlappyBird_Screen.EndScreen;
import DemoFlappyBird_Screen.HighScore;
import DemoFlappyBird_Screen.HowToPlay;
import DemoFlappyBird_Screen.PlayScreen;
import DemoFlappyBird_Screen.StartScreen;

public class Control implements Runnable {
	private PlayScreen playScreen;
	private Bird bird;
	private BirdEvent birdEvent;
	private Ground ground;
	private PipeGroup pipeGroup;
	private Rule rule;
	private StartScreen startScreen;
	private EndScreen endScreen;
	private Score score;
	private boolean touch;
	private boolean isPlaying;

	private Sound sound;
	private Map<String, Sound> soundPlayer;

	private Thread thread;

	public Control(PlayScreen screen, StartScreen startScreen, EndScreen endScreen) {
		// TODO Auto-generated constructor stub
		this.isPlaying = false;
		this.touch = true;
		this.startScreen = startScreen;
		this.endScreen = endScreen;

		this.playScreen = screen;
		this.birdEvent = screen.getBird().getBirdEvent();
		this.bird = screen.getBird();
		this.ground = screen.getGround();
		this.pipeGroup = screen.getPipeGroup();
		this.rule = new Rule(this.birdEvent, this.ground, this.pipeGroup, this.bird);
		screen.getBackGround();
		this.score = playScreen.getScore();

		soundPlayer = new HashMap<String, Sound>();
		setSounds();

		this.playScreen.addKeyListener(new KeyActionBird());

		this.playScreen.addMouseListener(new mouseActionBird());

		this.startScreen.addactionStart(new actionStart());
		this.startScreen.addActionHighScore(new actionHighScore());
		this.startScreen.addActionMinion(new actionMinion());

		this.endScreen.addActionPlayAgain(new actionPlayAgain());
		this.endScreen.addActionExit(new actionExit());
		this.endScreen.addActionMinion(new actionMinionExit());
	}

	private void setSounds() {
		this.sound = new Sound(new File("Assets\\sfx_hit.wav"));
		this.soundPlayer.put("Hit", sound);
		this.sound = new Sound(new File("Assets\\sfx_die.wav"));
		this.soundPlayer.put("Die", sound);
		this.sound = new Sound(new File("Assets\\sfx_swooshing.wav"));
		this.soundPlayer.put("Swooshing", sound);
		this.sound = new Sound(new File("Assets\\sfx_wing.wav"));
		this.soundPlayer.put("Wing", sound);
		this.sound = new Sound(new File("Assets\\Xayah-and-Rakan-RIOT.wav"));
		this.soundPlayer.put("StartSound", sound);
		this.sound = new Sound(new File("Assets\\China-X - [128kbps_MP3].wav"));
		this.soundPlayer.put("PlaySound", sound);
		this.sound = new Sound(new File("Assets\\Futari-no-kimochi-Inuyasha.wav"));
		this.soundPlayer.put("EndSound", sound);
	}
	

	@SuppressWarnings("deprecation")
	public void begin() {
		startScreen.setVisible(true);
		playScreen.disable();
		this.soundPlayer.get("StartSound").play();
		this.soundPlayer.get("StartSound").loop();
	}

	private void startGame() {
		if (this.thread == null || this.thread.isAlive() == false) {
			this.thread = new Thread(this);
			this.thread.setPriority(1);
			this.thread.start();
		}

		this.ground.startMove();
		this.bird.startAction();
		this.pipeGroup.StartMove();
		this.bird.setY(-this.bird.getHeight());
		this.birdEvent.setBirdY(this.bird.getY());
		this.birdEvent.setVelocity(1);

		this.soundPlayer.get("StartSound").close();
		this.soundPlayer.get("PlaySound").play();
		this.soundPlayer.get("PlaySound").loop(); 
	}

	private void pauseGame() {
		this.ground.pauseMove();
		this.pipeGroup.pauseMove();
		if (this.bird.getY() >= 10000) {
			this.endScreen.setVisible(true);
			this.playScreen.setVisible(false);
		}
	}

	private void resumeGame() {
		this.ground.resumeMove();
		this.pipeGroup.resumeMove();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while (true) {
			try {
				this.rule.saveHighScore();
			} catch (NullPointerException e) {
			}
			this.playScreen.getButton().setVisible(false);
			this.playScreen.getGetReady().setVisible(false);

			this.score.repaint();
			this.rule.setBestScore();
			this.score.setPoint(this.rule.getScore());
			if (this.rule.endGame() == true) {
				pauseGame();
				this.endScreen.getScore().setPoint(this.playScreen.getScore().getPoint());
				if (this.rule.isEndGame() == false) {
					this.soundPlayer.get("Hit").play();
					this.soundPlayer.get("Die").play();
				}
				this.rule.setEndGame(true);
				if (this.isPlaying == false) {
					this.soundPlayer.get("EndSound").play();
					this.soundPlayer.get("EndSound").loop();
					this.isPlaying = true;
				}
			}
			if (this.rule.isEndGame() == true) {
				this.soundPlayer.get("PlaySound").close();
			}

			this.rule.ScoreUp();
			this.birdEvent.birdDown();
			this.bird.updateCoordinates();

			if (this.bird.getCurrentPosition() < this.bird.getY()) {
				this.bird.setFlying(false);
			}

			if (this.rule.getScore() == 99) {
				JOptionPane.showMessageDialog(null, "You Win");
			}
			try {
				Thread.sleep(9);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private class KeyActionBird implements KeyListener {
		@SuppressWarnings("deprecation")
		@Override
		public void keyPressed(KeyEvent key) {
			// TODO Auto-generated method stub
			if (rule.endGame() == false && touch == true && rule.isEndGame() == false) {
				if (key.getKeyCode() == KeyEvent.VK_SPACE) {
					bird.setFlying(true);
					birdEvent.birdUp();
					bird.setCurrentPosition(bird.getY());

					soundPlayer.get("Wing").play();
					soundPlayer.get("Swooshing").play();
				}
			}
			if (key.getKeyCode() == KeyEvent.VK_P) {
				pauseGame();
				thread.suspend();
				touch = false;
			}
			if (key.getKeyCode() == KeyEvent.VK_R) {
				pauseGame();
				thread.resume();
				resumeGame();
				touch = true;
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
		}
	}

	private class mouseActionBird implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if (rule.endGame() == false && touch == true && rule.isEndGame() == false) {
				bird.setFlying(true);
				birdEvent.birdUp();
				bird.setCurrentPosition(bird.getY());

				soundPlayer.get("Wing").play();
				soundPlayer.get("Swooshing").play();
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
	}

	private class actionStart implements ActionListener {
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			startScreen.dispose();
			playScreen.setVisible(true);
			playScreen.enable();
			rule.setEndGame(false);
			startGame();
		}
	}

	private class actionHighScore implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			HighScore highScore = new HighScore();
			highScore.getRankBG().setBestScore(rule.showBestScore());
		}
	}

	private class actionMinion implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new HowToPlay();
		}
	}

	private class actionPlayAgain implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			playScreen.setVisible(true);
			endScreen.dispose();
			rule.resetGame();
			rule.setEndGame(false);
			playScreen.getButton().setVisible(true);
			playScreen.getGetReady().setVisible(true);

			resumeGame();
			playScreen.getScore().setPoint(0);

			soundPlayer.get("PlaySound").play();
			soundPlayer.get("EndSound").close();
			isPlaying = false;
		}
	}

	private class actionExit implements ActionListener {
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			playScreen.dispose();
			startScreen.setVisible(true);
			endScreen.dispose(); 

			rule.resetGame();
			ground.pauseMove();
			pipeGroup.pauseMove();
			thread.stop();
			endScreen.dispose();

			soundPlayer.get("StartSound").play();
			soundPlayer.get("StartSound").loop();
			soundPlayer.get("EndSound").close();
			isPlaying = false;
		}
	}

	private class actionMinionExit implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
//			new HowToPlay();
		}

	}
}
