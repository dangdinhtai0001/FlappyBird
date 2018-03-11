package DemoFlappyBird_JComponent;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import DemoFlappyBird_Model.Config;

public class Score extends JComponent {
	private static final long serialVersionUID = 1L;
	private int point;
	private HashMap<String, Image> numbers;
	private BufferedImage bufferedImage;

	public Score() {
		// TODO Auto-generated constructor stub
		numbers = new HashMap<>();
		this.point = 0 ;
		try {
			loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setSize(Config.playScreenWidth / 10, Config.playScreenHeight / 10);

	}

	private HashMap<String, Image> loadImage() throws IOException {
		this.bufferedImage = ImageIO.read(new File("Assets\\number0.png"));
		this.numbers.put("0", this.bufferedImage);

		this.bufferedImage = ImageIO.read(new File("Assets\\number1.png"));
		this.numbers.put("1", this.bufferedImage);

		this.bufferedImage = ImageIO.read(new File("Assets\\number2.png"));
		this.numbers.put("2", this.bufferedImage);

		this.bufferedImage = ImageIO.read(new File("Assets\\number3.png"));
		this.numbers.put("3", this.bufferedImage);

		this.bufferedImage = ImageIO.read(new File("Assets\\number4.png"));
		this.numbers.put("4", this.bufferedImage);

		this.bufferedImage = ImageIO.read(new File("Assets\\number5.png"));
		this.numbers.put("5", this.bufferedImage);

		this.bufferedImage = ImageIO.read(new File("Assets\\number6.png"));
		this.numbers.put("6", this.bufferedImage);

		this.bufferedImage = ImageIO.read(new File("Assets\\number7.png"));
		this.numbers.put("7", this.bufferedImage);

		this.bufferedImage = ImageIO.read(new File("Assets\\number8.png"));
		this.numbers.put("8", this.bufferedImage);

		this.bufferedImage = ImageIO.read(new File("Assets\\number9.png"));
		this.numbers.put("9", this.bufferedImage);
		return this.numbers;
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D graphics2d = (Graphics2D) g;
		repaint();
		bufferedImage =(BufferedImage) getImage(getKey()[0]);
		
		graphics2d.drawImage(bufferedImage, 0, 0, this.getWidth() / 2, this.getHeight(),
				null);
		
		bufferedImage =(BufferedImage) getImage(getKey()[1]);
		graphics2d.drawImage(bufferedImage, this.getWidth() / 2, 0, this.getWidth() / 2,
				this.getHeight(), null);
	}
	
	private Image getImage(String key){
		return this.numbers.get(key);
	}

	public String[] getKey() {
		String key = String.valueOf(point);

		if (this.point < 10) {
			key = "0" + key;
		}

		String[] arrKey = key.split("");

		return arrKey;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}
