package DemoFlappyBird_Model;

import java.util.Random;

import javax.swing.JComponent;

import DemoFlappyBird_JComponent.Pipe;

public class PipeGroup extends JComponent implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pipe[] pipes;
	private Thread thread;
	private Random random;
	private int temp;

	public PipeGroup() {
		// TODO Auto-generated constructor stub
		random = new Random();
		setSize(Config.playScreenWidth * 2, Config.playScreenHeight * 2);
		this.pipes = new Pipe[Config.numberOfPipe];

		pipes[0] = new Pipe(Config.pipeHeight);
		pipes[0].setSerial(0);
		pipes[0].setX(Config.playScreenWidth);
		pipes[0].setHeight(getHeightRandom());
		pipes[0].setY(0);

		this.add(pipes[0]);

		for (int i = 1; i < pipes.length; i++) {
			pipes[i] = new Pipe(Config.pipeHeight);
			pipes[i].setSerial(i);

			if (pipes[i].getSerial() % 2 != 0) {
				pipes[i].setX(pipes[i - 1].getX());
				pipes[i].setY(400);
				pipes[i].setHeight(Config.playScreenHeight - pipes[i - 1].getHeight() - Config.hole);
			} else {
				pipes[i].setX(pipes[i - 1].getX() + Config.distanceBetween2Pipe);
				pipes[i].setHeight(getHeightRandom());
				pipes[i].setY(0);
			}

			this.add(pipes[i]);
			pipes[i].setBounds(pipes[i].getX(), pipes[i].getY(), pipes[i].getWidth(), pipes[i].getHeight());
		}
	}

	private int getRandom() {
		return random.nextInt(100);
	}

	private int getHeightRandom() {
		temp = random.nextInt(Config.playScreenHeight / 3);
		if (temp < 100) {
			temp += 200;
		}
		return temp;
	}

	private void move() {
		for (int i = 0; i < pipes.length; i++) {
			pipes[i].setBounds(pipes[i].getX() - 1, pipes[i].getY(), pipes[i].getWidth(), pipes[i].getHeight());
			pipes[i].setX(pipes[i].getX() - 1);
		}
	}

	private void loop() {
		for (int i = 0; i < pipes.length - 1; i++) {
			if (pipes[i].getSerial() == 0) {
				if (pipes[i].getX() == -Config.pipeWidth) {

					pipes[i].setX(pipes[Config.numberOfPipe - 1].getX() + Config.distanceBetween2Pipe);
					pipes[i].setHeight(getHeightRandom());

					pipes[i + 1].setX(pipes[Config.numberOfPipe - 1].getX() + Config.distanceBetween2Pipe);
					pipes[i + 1].setY(pipes[i].getHeight() + Config.hole + getRandom());
					pipes[i + 1].setHeight(Config.playScreenHeight - pipes[i + 1].getY());

					pipes[i].setBehindBird(false);
				}
			} else if (pipes[i].getSerial() == 1) {

			} else if (1 < pipes[i].getSerial() && pipes[i].getSerial() <= Config.numberOfPipe - 1) {
				if (pipes[i].getSerial() % 2 == 0) {

					if (pipes[i].getX() == -Config.pipeWidth) {

						pipes[i].setX(pipes[i - 1].getX() + Config.distanceBetween2Pipe);
						pipes[i].setHeight(getHeightRandom());

						pipes[i + 1].setX(pipes[i - 1].getX() + Config.distanceBetween2Pipe);
						pipes[i + 1].setY(pipes[i].getHeight() + Config.hole + getRandom());

						pipes[i].setBehindBird(false);
					}

				}
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			move();
			loop();
			try {
				Thread.sleep( 1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void StartMove() {
		this.thread = new Thread(this);
		this.thread.setPriority(1);
		this.thread.start();
	}

	@SuppressWarnings("deprecation")
	public void pauseMove() {
		this.thread.suspend();
	}

	@SuppressWarnings("deprecation")
	public void resumeMove() {
		this.thread.resume();
	}

	public Pipe[] getPipes() {
		return pipes;
	}

}
