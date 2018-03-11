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

public class Pipe extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage bufferedImage;
	private int x, y;
	private int serial;
	private int height, width;

	private boolean isBehindBird;

	public Pipe(int height) {
		// TODO Auto-generated constructor stub
		this.height = height;
		width = Config.pipeWidth;
		this.isBehindBird = false;
		setSize(this.width, this.height);
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
		Graphics2D graphics2d = (Graphics2D) g;
		if (this.serial % 2 == 0) {
			try {
				bufferedImage = ImageIO.read(new File("Assets\\PIPE1.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			graphics2d.drawImage(bufferedImage, 0, 0, this.getWidth(), this.getHeight(), null);
		} else {
			try {
				bufferedImage = ImageIO.read(new File("Assets\\PIPE2.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			graphics2d.drawImage(bufferedImage, 0, 0, this.getWidth(), this.getHeight(), null);
		}
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

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public boolean isBehindBird() {
		return isBehindBird;
	}

	public void setBehindBird(boolean isBehindBird) {
		this.isBehindBird = isBehindBird;
	}

}
