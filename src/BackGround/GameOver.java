package BackGround;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import DemoFlappyBird_Model.Config;

public class GameOver extends JPanel {
	private static final long serialVersionUID = 1L;
	private BufferedImage bufferedImage;
	public GameOver() {
		setSize(Config.playScreenWidth, Config.playScreenHeight);
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		try {
			bufferedImage = ImageIO.read(new File("Assets\\Sky.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(bufferedImage, 0, 0, this.getWidth(), this.getHeight(), null);

		try {
			bufferedImage = ImageIO.read(new File("Assets\\GameOver.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(bufferedImage, 0, 20, this.getWidth(), 100, null);

		try {
			bufferedImage = ImageIO.read(new File("Assets\\play_again.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(bufferedImage, 100, 470, this.getWidth() / 2, this.getHeight() / 6, null);
	}
}
