package DemoFlappyBird_Screen;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BackGround.Sky;
import DemoFlappyBird_Model.Config;

public class StartScreen extends JFrame {
	private static final long serialVersionUID = -1218651063519252299L;

	private JPanel contentPane;
	private JButton startButton;
	private JButton highScoreButton;
	private JButton button;
	private Sky sky;

	public StartScreen() {
		// TODO Auto-generated constructor stub
		setIconImage(Toolkit.getDefaultToolkit().getImage("Assets\\\\bird_sprite2.png"));
		setTitle("FLAPPY BIRD");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Config.playScreenWidth, Config.playScreenHeight);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		button = new JButton("");
		button.setBounds(this.getWidth() / 2 - 100, 130, 200, 230);
		Icon icon = new ImageIcon("Assets\\Minions2.gif");
		button.setBorder(null);
		button.setBackground(Color.decode("#82C3D1"));
		button.setIcon(icon);
		button.setToolTipText("How To Play");
		contentPane.add(button);

		startButton = new JButton("");
		startButton.setBounds(20, 550, 140, 70);
		startButton.setBorder(null);
		startButton.setBackground(Color.decode("#92E37D"));
		startButton.setIcon(new ImageIcon(loadImage("Assets\\playAgainIcon.png")));
		startButton.setToolTipText("Start Game");
		contentPane.add(startButton);

		highScoreButton = new JButton("");
		highScoreButton.setBounds(this.getWidth() - 20 - 140, 550, 140, 70);
		highScoreButton.setBorder(null);
		highScoreButton.setBackground(Color.decode("#92E37D"));
		highScoreButton.setIcon(new ImageIcon(loadImage("Assets\\highScore.png")));
		highScoreButton.setToolTipText("Best Score");
		contentPane.add(highScoreButton);

		sky = new Sky();
		contentPane.add(sky);
		sky.setBounds(0, 0, this.getWidth(), this.getHeight());
	}

	private Image loadImage(String path) {
		ImageIcon imageIcon = new ImageIcon(path);
		Image image = imageIcon.getImage();
		Image imageCell = image.getScaledInstance(140, 70, Image.SCALE_SMOOTH);

		return imageCell;
	}

	public void addactionStart(ActionListener e) {
		startButton.addActionListener(e);
	}

	public void addActionHighScore(ActionListener e) {
		highScoreButton.addActionListener(e);
	}

	public void addActionMinion(ActionListener e) {
		button.addActionListener(e);
	}

}
