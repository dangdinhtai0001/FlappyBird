package DemoFlappyBird_JComponent;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import DemoFlappyBird_Model.BirdEvent;
import DemoFlappyBird_Model.Config;

public class Bird extends JComponent implements Runnable {
	private static final long serialVersionUID = 1L;
	private BufferedImage bufferedImage;
	private Thread thread;

	private int currentFrame = 0;
	private int numberOfFrame = Config.numberOfFrame;
	private Image[] images = new Image[numberOfFrame];

	private BirdEvent birdEvent;

	private int x, y;

	private double rotation;
	private boolean isFlying;

	private int currentPosition;
	
	private int fly;

	public Bird() {
		// TODO Auto-generated constructor stub
		this.rotation = 0;
		this.isFlying = false;
		loadImages();
		this.x = Config.birdX;
		this.y = Config.birdY;

		setSize(Config.birdWidth + 19, Config.birdHeight);

		birdEvent = new BirdEvent(this);
		birdEvent.getCoordinates(this);
	}

	private Image[] loadImages() {
		try {
			bufferedImage = ImageIO.read(new File("Assets\\bird_sprite1.png"));
			images[0] = bufferedImage;

			bufferedImage = ImageIO.read(new File("Assets\\bird_sprite2.png"));
			images[1] = bufferedImage;

			bufferedImage = ImageIO.read(new File("Assets\\bird_sprite3.png"));
			images[2] = bufferedImage;

			bufferedImage = ImageIO.read(new File("Assets\\bird_sprite2.png"));
			images[3] = bufferedImage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return images;
	}

	private Image getImage() {
		Image image = null;
		try {
			image = images[currentFrame];
		} catch (Exception e) {
			// TODO: handle exception
			image = images[0];
		}
		return image;
	}

	private void updateFrame() {
		if (this.currentFrame >= numberOfFrame) {
			currentFrame = 0;
		}
		currentFrame++;
	}

	public void updateCoordinates() {
		this.x = this.birdEvent.getBirdX();
		this.y = this.birdEvent.getBirdY();
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return super.getBounds();
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		repaint();

		if (isFlying == true) {
			this.rotation = Config.rotationUp;
		} else {
			this.rotation = Config.rotationDown;
		}
		bufferedImage = (BufferedImage) getImage();
		AffineTransform affineTransform = new AffineTransform();
		affineTransform.rotate(rotation, bufferedImage.getWidth() / 2, bufferedImage.getHeight() / 2);

		AffineTransformOp affineTransformOp = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_BILINEAR);

		bufferedImage = affineTransformOp.filter(bufferedImage, null);
		g.drawImage(bufferedImage, 0, 0, null);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			updateFrame();
			this.setBounds(this.x, this.y, this.getWidth(), this.getHeight());
			if(this.isFlying == true) {
				this.fly = 60;
			}if(!this.isFlying) {
				this.fly = 100;
			}
			try {
				Thread.sleep(fly);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void startAction() {
		thread = new Thread(this);
		thread.setPriority(1);
		thread.start();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isFlying() {
		return isFlying;
	}

	public void setFlying(boolean isFlying) {
		this.isFlying = isFlying;
	}

	public BirdEvent getBirdEvent() {
		return birdEvent;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

}
