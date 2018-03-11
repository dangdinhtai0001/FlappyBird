package DemoFlappyBird_Screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HowToPlay extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private BufferedImage bufferedImage;

	public HowToPlay() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Assets\\\\bird_sprite2.png"));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton buttonOK = new JButton("OK");
		contentPane.add(buttonOK, BorderLayout.SOUTH);

		buttonOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D graphics2d = (Graphics2D) g;
		try {
			bufferedImage = ImageIO.read(new File("Assets\\zed.jpg"));
			graphics2d.drawImage(bufferedImage, 0, 0, this.getWidth(), this.getHeight(), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		graphics2d.setColor(Color.decode("#FFFFFF"));
		graphics2d.setFont(new Font("Arial", Font.BOLD + Font.ITALIC + Font.CENTER_BASELINE, 20));
		String text = "* Nhấn SPACE hoặc Click chuột trái để bay lên";
		graphics2d.drawString(text, 20, 70);

		text = "* P để tạm dừng game , R để tiếp tục chơi";
		graphics2d.drawString(text, 20, 100);

		text = "* Vượt qua các ống để đạt điểm";
		graphics2d.drawString(text, 20, 130);

		text = "* Có 7 bậc xếp hạng tương ứng với điểm";
		graphics2d.drawString(text, 20, 170);

		try {
			bufferedImage = ImageIO.read(new File("Assets\\BronzeRank.png"));
			graphics2d.drawImage(bufferedImage, 0, 190, this.getWidth() / 7, this.getWidth() / 7, null);

			bufferedImage = ImageIO.read(new File("Assets\\SilverRank.png"));
			graphics2d.drawImage(bufferedImage, this.getWidth() / 7, 190, this.getWidth() / 7, this.getWidth() / 7, null);

			bufferedImage = ImageIO.read(new File("Assets\\GoldRank.png"));
			graphics2d.drawImage(bufferedImage, (this.getWidth() / 7 )*2, 190, this.getWidth() / 7, this.getWidth() / 7, null);
			
			bufferedImage = ImageIO.read(new File("Assets\\platinumRank.png"));
			graphics2d.drawImage(bufferedImage, (this.getWidth() / 7 )*3, 190, this.getWidth() / 7, this.getWidth() / 7, null);
			
			bufferedImage = ImageIO.read(new File("Assets\\diamondRank.png"));
			graphics2d.drawImage(bufferedImage, (this.getWidth() / 7 )*4, 190, this.getWidth() / 7, this.getWidth() / 7, null);
			
			bufferedImage = ImageIO.read(new File("Assets\\masterRank.png"));
			graphics2d.drawImage(bufferedImage, (this.getWidth() / 7 )*5, 190, this.getWidth() / 7, this.getWidth() / 7, null);
			
			bufferedImage = ImageIO.read(new File("Assets\\challengerRank.png"));
			graphics2d.drawImage(bufferedImage, (this.getWidth() / 7 )*6, 190, this.getWidth()/7, this.getWidth()/7, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
