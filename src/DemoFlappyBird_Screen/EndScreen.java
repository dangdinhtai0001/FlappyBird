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

import BackGround.GameOver;
import DemoFlappyBird_JComponent.Score;
import DemoFlappyBird_Model.Config;

public class EndScreen extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton playAgain;
	private JButton exit;
	private GameOver gameOver;
	private JButton button;

	private Score score;

	public EndScreen() {
		// TODO Auto-generated constructor stub
		setIconImage(Toolkit.getDefaultToolkit().getImage("Assets\\\\bird_sprite2.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, Config.playScreenWidth, Config.playScreenHeight);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		button = new JButton("");
		button.setBounds(this.getWidth() / 2 - 100, 120, 200, 230);
		Icon icon = new ImageIcon("Assets\\Minions2.gif");
		button.setBorder(null);
		button.setBackground(Color.decode("#82C3D1"));
		button.setIcon(icon);
		contentPane.add(button);

		playAgain = new JButton("");
		playAgain.setToolTipText("Play Again");
		playAgain.setBounds(10, 600, 140, 70);
		playAgain.setBorder(null);
		playAgain.setBackground(Color.decode("#92E37D"));
		playAgain.setIcon(new ImageIcon(loadImage("Assets\\playAgainIcon.png")));
		contentPane.add(playAgain);

		exit = new JButton("");
		exit.setToolTipText("Return to top menu");
		exit.setBounds(this.getWidth() - 10 - 140, 600, 140, 70);
		exit.setBorder(null);
		exit.setBackground(Color.decode("#92E37D"));
		exit.setIcon(new ImageIcon(loadImage("Assets\\exitIcon.png")));
		contentPane.add(exit);

		score = new Score();
		contentPane.add(score, 0, 0);
		score.setBounds(this.getWidth() / 2 - 75, 360, 150, 100);

		gameOver = new GameOver();
		contentPane.add(gameOver);
		gameOver.setBounds(0, 0, this.getWidth(), this.getHeight());

		setUndecorated(true);

	}

	private Image loadImage(String path) {
		ImageIcon imageIcon = new ImageIcon(path);
		Image image = imageIcon.getImage();
		Image imageCell = image.getScaledInstance(140, 70, Image.SCALE_SMOOTH);

		return imageCell;
	}

	public void addActionPlayAgain(ActionListener e) {
		playAgain.addActionListener(e);
	}

	public void addActionExit(ActionListener e) {
		exit.addActionListener(e);
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public void addActionMinion(ActionListener e) {
		button.addActionListener(e);
	}
}
