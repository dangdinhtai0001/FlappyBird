package BackGround;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import DemoFlappyBird_Model.Config;

public class Sky extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage bufferedImage;

	/**
	 * Create the panel.
	 */
	public Sky() {
		setSize(Config.playScreenWidth, Config.playScreenHeight);
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D graphics2d = (Graphics2D) g;
		try {
			bufferedImage = ImageIO.read(new File("Assets\\Sky.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		graphics2d.drawImage(bufferedImage, 0, 0, this.getWidth(), this.getHeight(), null);

		try {
			bufferedImage = ImageIO.read(new File("Assets\\Flappybird.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		graphics2d.drawImage(bufferedImage, 0, 10, getWidth(), 100, null);

	}

}
