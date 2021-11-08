package model;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class SoccerBall {

	private static final SoccerBall soccerBall = new SoccerBall();

	private Point position;

	private double velocity;

	private final Color color;
	
	/**
	 * Constructor method
	 */
	private SoccerBall() {
		color = Color.white;
		resetSoccerBall();
	}
	
	/**
	 * Getter method for SoccerBall
	 * @return a SoccerBall object
	 */
	public static SoccerBall getSoccerBall() {
		return soccerBall;
	}

	/**
	 * Moves the ball using the parameters specified.
	 * @param initialDistance The initial distance of ball
	 * @param initialVelocity The initial velocity of ball
	 * @param acceleration Acceleration with which ball moves
	 */
	public void moveBall(int initialDistance, double initialVelocity, double acceleration) {
		moveBallY(initialDistance);
		setVelocity(initialVelocity);
		Timer timer = new Timer();
		TimerTask repaintTask = new TimerTask() {
			@Override
			public void run() {
				if (Math.abs(velocity) < 2) {
					velocity = 0.0;
					timer.cancel();
				} else {
					velocity = velocity - acceleration;
				}
				moveBallY((int) velocity);
			}
		};
		timer.schedule(repaintTask, 0, 10);
	}
	
	/**
	 * Method which moves ball in y-direction.
	 * @param distance by which ball needs to be moved
	 */
	public void moveBallY(int distance) {
		if (getPosition().y + distance < 510 && getPosition().y - distance > 20) {
			setPosition(new Point(getPosition().x, getPosition().y - distance));
		} else {
			setVelocity(0.0);
		}
	}
	
	/**
	 * Method to reset the velocity and position attribute as required
	 */
	public void resetSoccerBall() {
		setVelocity(0.0);
		setPosition(new Point(480, 500));
	}

	/**
	 * Checks if the ball is on Goalkeeper side
	 * @return true if ball is on the goalkeeper side, false otherwise
	 */
	public boolean onGoalkeeperSide() {
		return getPosition().y < 200;
	}

	/**
	 * Determines if an attempt is goal or not
	 * @return true if a goal is scored
	 */
	public boolean inGate() {
		return getPosition().x > 180 && getPosition().x < 400 && getPosition().y > 10 && getPosition().y < 60;
	}

	/**
	 * Setter method for velocity attribute
	 * @param velocity to be set
	 */
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	/**
	 * Getter method for position attribute
	 * @return the current position
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * Setter method for position attribute
	 * @param position to be set
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * Getter method for color attribute
	 * @return the color of the soccer ball
	 */
	public Color getColor() {
		return color;
	}
}
