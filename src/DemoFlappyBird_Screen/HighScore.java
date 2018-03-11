package DemoFlappyBird_Screen;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import BackGround.HighScoreBG;
import BackGround.RankBG;

public class HighScore extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private RankBG rankBG;
	private HighScoreBG bg;
	private JButton buttonOK;

	public HighScore() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Assets\\\\bird_sprite2.png"));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);

		rankBG = new RankBG(100, 100);
		contentPane.add(rankBG, 0, 0);
		rankBG.setBounds(300, 0, 200, 200);

		bg = new HighScoreBG(this.getWidth(), this.getHeight());
		contentPane.add(bg);

		buttonOK = new JButton("OK");
		contentPane.add(buttonOK, 0, 0);
		buttonOK.setBounds(390, 255, 100, 40);
		buttonOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		setVisible(true);
	}

	public RankBG getRankBG() {
		return rankBG;
	}
}
