package DemoFlappyBird_Screen;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BackGround.BackGround;
import DemoFlappyBird_JComponent.Bird;
import DemoFlappyBird_JComponent.Ground;
import DemoFlappyBird_JComponent.Score;
import DemoFlappyBird_Model.Config;
import DemoFlappyBird_Model.PipeGroup;

public class PlayScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private BackGround backGround;
	private Ground ground;
	private DemoFlappyBird_JComponent.getReady getReady;
	private JButton button;

	private Bird bird;
	private PipeGroup pipeGroup;
	private Score score;

	@SuppressWarnings("deprecation")
	public PlayScreen() {
		// TODO Auto-generated constructor stub
		setIconImage(Toolkit.getDefaultToolkit().getImage("Assets\\\\bird_sprite2.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Config.playScreenWidth, Config.playScreenHeight);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane); 
		contentPane.setLayout(null);

		button = new JButton("");
		button.setBounds(this.getWidth() / 2 - 60, this.getHeight() / 2 - 220, 120, 220);
		Icon icon = new ImageIcon("Assets\\touchMe.gif");
		button.setBorder(null);
		button.setBackground(Color.decode("#82C3D1"));
		button.setIcon(icon);
		button.disable();
//		button.setVisible(false);
		contentPane.add(button);

		getReady = new DemoFlappyBird_JComponent.getReady();
		contentPane.add(getReady, 0, 0);
		getReady.setBounds(this.getWidth() / 2 - 130, this.getHeight() / 2, 260, 100);
//		getReady.setVisible(false);

		pipeGroup = new PipeGroup();
		contentPane.add(pipeGroup, 0, 0);
		pipeGroup.setBounds(0, 0, this.getWidth(), this.getHeight());

		ground = new Ground();
		contentPane.add(ground, 0, 0);
		ground.setBounds(ground.getX1(), ground.getY(), ground.getWidth(), ground.getHeight());

		bird = new Bird();
		contentPane.add(bird, 0, 0);
		bird.setBounds(bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());

		score = new Score();
		contentPane.add(score, 0, 0);
		score.setBounds(this.getWidth() / 2 - 20, this.getHeight() / 20, score.getWidth(), score.getHeight());

		backGround = new BackGround();
		contentPane.add(backGround);

		setUndecorated(true);
	}

	@Override
	public synchronized void addKeyListener(KeyListener l) {
		// TODO Auto-generated method stub
		super.addKeyListener(l);
	}

	public Bird getBird() {
		return bird;
	}

	public Ground getGround() {
		return ground;
	}

	public PipeGroup getPipeGroup() {
		return pipeGroup;
	}

	public BackGround getBackGround() {
		return backGround;
	}

	public DemoFlappyBird_JComponent.getReady getGetReady() {
		return getReady;
	}

	public JButton getButton() {
		return button;
	}

	public Score getScore() {
		return score;
	}

}
