package model;

public class Player extends Thing {
	// 충돌 상황을 위한 사이즈 값 정의 
	public static final int WIDTH = 200;
	public static final int HEIGHT = 150;
	
	public boolean start = false;
	public boolean restart = false;
	/**
	 * @param xPos 수평위치
	 * @param velocity 좌우 움직이는 속도
	 * @param score 기본 점수
	 */
	public Player(int xPos, double velocity, int score) {
		super(xPos, Board.HEIGHT - 200,  velocity, score);
	}
	
	public boolean isStart() {
		return start;
	}

	public boolean isRestart() {
		return restart;
	}

	public void setRestart(boolean restart) {
		this.restart = restart;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	
}
