package model;

import java.util.Timer;
import java.util.TimerTask;

import model.players.*;

public class SoccerGame {

	private Integer timeRemaining;

	private Integer goal;

	private Boolean isPaused;

	private Boolean isOver;

	private final PlayerCollection gamePlayers;
	
	/**
	 * Constructor method
	 */
	public SoccerGame() {
		timeRemaining = 60;
		goal = 0;
		isPaused = false;
		isOver = false;
		SoccerBall.getSoccerBall().resetSoccerBall();
		PlayerFactory playerFactory = new PlayerFactory();
		gamePlayers = new PlayerCollection();
		gamePlayers.add(playerFactory.getPlayer("Striker"));
		gamePlayers.add(playerFactory.getPlayer("Goalkeeper"));
		startGame();
	}

	/**
	 * Initializes the game
	 */
	private void startGame() {
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				if (!isPaused()) {
					if (getTimeRemaining() <= 0) {
						setOver(true);
						timer.cancel();
					} else {
						setTimeRemaining(getTimeRemaining() - 1);
					}
					if (isScored()) {
						setPaused(true);
						setGoal(getGoal() + 1);
						getActivePlayer().setPlayerStatistics(getActivePlayer().getPlayerStatistics() + 1);
						getGamePlayers().get("Striker").setInitialPosition();
						SoccerBall.getSoccerBall().resetSoccerBall();
					} else {
						automateGoalkeeper();
					}
				}
			}
		};
		timer.schedule(timerTask, 1000, 1000);
	}

	/**
	 * Getter method for time remaining
	 * @return the time remaining
	 */
	public Integer getTimeRemaining() {
		return timeRemaining;
	}

	/**
	 * Setter method for time remaining
	 * @param timeRemaining to be set
	 */
	public void setTimeRemaining(Integer timeRemaining) {
		this.timeRemaining = timeRemaining;
	}

	/**
	 * Getter method for the number of goals
	 * @return goals scored by the striker
	 */
	public Integer getGoal() {
		return goal;
	}

	/**
	 * Setter method for the number of goals
	 * @param newGoal is the new value to be updated
	 */
	public void setGoal(Integer newGoal) {
		goal = newGoal;
	}

	/**
	 * Determines if the game is paused or not
	 * @return true if the game is paused
	 */
	public Boolean isPaused() {
		return isPaused;
	}

	/**
	 * Setter method for pausing or resuming the game
	 * @param paused is the boolean to be set
	 */
	public void setPaused(Boolean paused) {
		isPaused = paused;
	}
	
	/**
	 * Determines if the game is over or not
	 * @return true if the game is over
	 */
	public Boolean isOver() {
		return isOver;
	}

	/**
	 * Setter method for ending or not ending the game
	 * @param over
	 */
	public void setOver(Boolean over) {
		isOver = over;
	}

	/**
	 * Getter method for the players in the game
	 * @return a PlayerCollection of players
	 */
	public PlayerCollection getGamePlayers() {
		return gamePlayers;
	}

	/**
	 * Describes the behaviour of the goalkeeper
	 */
	public void automateGoalkeeper() {
		SoccerBall soccerBall = SoccerBall.getSoccerBall();
		Goalkeeper goalkeeper = (Goalkeeper) gamePlayers.get("Goalkeeper");
		if (soccerBall.onGoalkeeperSide()) {
			goalkeeper.grabsBall();
			goalkeeper.shootBall();
			goalkeeper.setPlayerStatistics(goalkeeper.getPlayerStatistics() + 1);
		} else {
			goalkeeper.moveRandomly();
		}
	}

	/**
	 * Checks whether a goal is scored or not
	 * @return True if the striker scored a goal, false otherwise.
	 */
	public boolean isScored() {
		return SoccerBall.getSoccerBall().inGate();
	}

	/**
	 * Getter method for the Striker
	 * @return the Striker
	 */
	public GamePlayer getActivePlayer() {
		return gamePlayers.get("Striker");
	}
}
