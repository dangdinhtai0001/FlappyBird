package BackGround;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class RankBG extends JComponent {
	private static final long serialVersionUID = 1L;
	private int bestScore;
	private BufferedImage bufferedImage;
	private HashMap<Integer, BufferedImage> map;

	public RankBG(int w, int h) {
		// TODO Auto-generated constructor stub
		setSize(w, h);
		bestScore = 0 ;
		setLayout(null);
		try {
			loadMap();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D graphics2d = (Graphics2D) g;
		if (this.bestScore <= 20) {
			bufferedImage = this.map.get(0);
		}
		if (this.bestScore > 20 && this.bestScore < 41) {
			bufferedImage = this.map.get(1);
		}
		if (this.bestScore > 40 && this.bestScore < 61) {
			bufferedImage = this.map.get(2);
		}
		if (this.bestScore > 60 && this.bestScore < 71) {
			bufferedImage = this.map.get(3);
		}
		if (this.bestScore > 70 && this.bestScore < 81) {
			bufferedImage = this.map.get(4);
		}
		if (this.bestScore > 80 && this.bestScore < 91) {
			bufferedImage = this.map.get(5);
		}
		if (this.bestScore > 91) {
			bufferedImage = this.map.get(6);
		}
		graphics2d.drawImage(bufferedImage, 0, 0, this.getWidth(), this.getHeight() - this.getHeight() / 5, null);
		
		graphics2d.setColor(Color.WHITE);
		graphics2d.setFont(new Font("Arial", Font.BOLD + Font.ITALIC + Font.CENTER_BASELINE, 30));
		graphics2d.drawString("Best: " + bestScore, 50, this.getHeight());
	}

	private void loadMap() throws IOException {
		map = new HashMap<>();
		bufferedImage = ImageIO.read(new File("Assets\\BronzeRank.png"));
		map.put(0, bufferedImage);

		bufferedImage = ImageIO.read(new File("Assets\\SilverRank.png"));
		map.put(1, bufferedImage);

		bufferedImage = ImageIO.read(new File("Assets\\GoldRank.png"));
		map.put(2, bufferedImage);

		bufferedImage = ImageIO.read(new File("Assets\\platinumRank.png"));
		map.put(3, bufferedImage);

		bufferedImage = ImageIO.read(new File("Assets\\diamondRank.png"));
		map.put(4, bufferedImage);

		bufferedImage = ImageIO.read(new File("Assets\\masterRank.png"));
		map.put(5, bufferedImage);

		bufferedImage = ImageIO.read(new File("Assets\\challengerRank.png"));
		map.put(6, bufferedImage);
	}

	public int getBestScore() {
		return bestScore;
	}

	public void setBestScore(int bestScore) {
		this.bestScore = bestScore;
	}

}
