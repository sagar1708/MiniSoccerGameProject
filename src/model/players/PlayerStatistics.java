package model.players;

public class PlayerStatistics {
	
	private int value = 0;

	public Integer getStatistics() {
		return value;
	}

	public void setStatistics(Integer newStatistics) {
		value = newStatistics;
	}
	
	@Override
	public String toString() {
		return Integer.toString(value);
	}
}