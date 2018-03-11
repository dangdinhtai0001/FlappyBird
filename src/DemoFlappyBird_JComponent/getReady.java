package DemoFlappyBird_JComponent;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class getReady extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage bufferedImage;
	public getReady() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		try {
			bufferedImage = ImageIO.read(new File("Assets\\getReady.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(bufferedImage, 0, 0, null);
	}
}
