package DemoFlappyBird_Model;

import DemoFlappyBird_JComponent.Bird;

public class BirdEvent {
	private Bird bird;
	private int birdX;
	private int birdY;
	private double velocity;
	private boolean isDie = false;

	public BirdEvent(Bird bird) {
		// TODO Auto-generated constructor stub
		velocity = 1;
		this.bird = bird;
		getCoordinates(bird);
	}

	public void getCoordinates(Bird bird) {
		birdX = bird.getX();
		birdY = bird.getY();
	}

	public void birdUp() {
		birdY -= Config.birdUp;
		if (birdY <= 0) {
			birdY = 0;
		}
	}

	public void birdDown() {
		this.velocity += this.velocity * Config.gravity;
		this.birdY += this.velocity;
		if (this.bird.isFlying() == true) {
			this.velocity = 1;
		}
	}

	public int getBirdX() {
		return birdX;
	}

	public void setBirdX(int birdX) {
		this.birdX = birdX;
	}

	public int getBirdY() {
		return birdY;
	}

	public void setBirdY(int birdY) {
		this.birdY = birdY;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public boolean isDie() {
		return isDie;
	}

	public void setDie(boolean isDie) {
		this.isDie = isDie;
	}

}
