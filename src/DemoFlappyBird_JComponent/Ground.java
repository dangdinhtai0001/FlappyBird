package DemoFlappyBird_JComponent;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import DemoFlappyBird_Model.Config;

public class Ground extends JComponent implements Runnable {
	private static final long serialVersionUID = 1L;
	private BufferedImage bufferedImage;
	private int x;
	private int y;

	private int x2, x1;

	private Thread thread;

	public Ground() {
		// TODO Auto-generated constructor stub

		try {
			bufferedImage = ImageIO.read(new File("Assets\\ground.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.x = 0;
		this.y = Config.playScreenHeight - Config.playScreenHeight / 6;
		this.x1 = 0;
		this.x2 = Config.groundWidth + 15;
		setSize(Config.groundWidth * 2, Config.groundHeight);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return super.getBounds();
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D graphics2d = (Graphics2D) g;

		graphics2d.drawImage(bufferedImage, x1, 0, this.getWidth(), this.getHeight(), null);
		graphics2d.drawImage(bufferedImage, x2, 0, this.getWidth(), this.getHeight(), null);
	}

	private void moveLeft() {
		this.x--;
		if (this.x == -Config.playScreenWidth) {
			this.x = 0;
		}
	}

	public void startMove() {
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			moveLeft();
			this.setBounds(x, y, this.getWidth(), this.getHeight());
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getX1() {
		return x1;
	}
}
