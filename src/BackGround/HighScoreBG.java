package BackGround;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;


public class HighScoreBG extends JComponent {
	private static final long serialVersionUID = 1L;
	private BufferedImage bufferedImage;
	
	public HighScoreBG(int w, int h) {
		setSize(w,h);
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D graphics2d = (Graphics2D) g;
		 try {
			bufferedImage = ImageIO.read(new File("Assets\\TF.jpg"));
			graphics2d.drawImage(bufferedImage, 0, 0, this.getWidth(), this.getHeight(), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
