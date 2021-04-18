package model;

import controll.DeadOrAliveController;

public abstract class Thing {
	// 위치
	protected int xPos, yPos;
	// 속도
	private double velocity;
	// 점수 
	private int score;
	
	/** 플레이어의 상위클래스 생성자 */

	public Thing(int xPos, int yPos, double velocity, int score) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.velocity = velocity;
		this.score = score;
	}

	/** 사과, 폭탄의 상위클래스 생성자*/
	public Thing(int yPos, double velocity, int score) {
		this.xPos = (int) (Math.random() * (Board.WIDTH - Apple.WIDTH)); // x 좌표는 보드 width값 이내의 랜덤값을 줌.
		this.yPos = yPos;
		this.velocity = velocity;
		this.score = score;
	}

	
	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	/** 속도값에 따라 yPos를 변화시킴 */
	public void fly(int period) {
		yPos += Board.SPEED_BOMB_APPLE;
	}
	
	/** 보드 높이 범위 안에서 떨어지는 중일때 true 반환*/
	public boolean isInSky() {
		return yPos < Board.HEIGHT ;
	}
	
	/** 사과와 폭탄의 위치를 xPos에 랜덤값을 적용하여 리셋시킨다. */
	public void reset() {
		setyPos(0);
		setxPos((int) ((Board.WIDTH - Apple.WIDTH) * Math.random()));
	}
}
