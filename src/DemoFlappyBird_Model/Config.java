package DemoFlappyBird_Model;

public class Config {
	static final double gravity = 0.05;

	public static final double rotationDown = Math.toRadians(45);
	public static final double rotationUp = Math.toRadians(-45);

	static final int birdUp = 40;

	public static final int numberOfFrame = 4;

	public static final int playScreenWidth = 390;
	public static final int playScreenHeight = 700;

	public static int birdWidth = playScreenWidth / 10;
	public static int birdHeight = (playScreenHeight - playScreenHeight / 5) / 10;
	public static int birdX = playScreenWidth / 10;
	public static int birdY = -birdHeight;

	public static int groundWidth = playScreenWidth;
	public static int groundHeight = playScreenHeight / 5;

	public static int pipeWidth = 70;
	static int pipeHeight = playScreenHeight / 3;
	static int numberOfPipe = 6;
	static int distanceBetween2Pipe = 300;
	static int hole = birdHeight + 50;
}
