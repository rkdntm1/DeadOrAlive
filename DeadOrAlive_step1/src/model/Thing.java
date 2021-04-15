package model;

import controll.DeadOrAliveController;

public abstract class Thing {
	// 위치
	private int xPos, yPos;
	// 속도
	private double velocity;
	// 점수 
	private int score;
	
	public Thing(int xPos, int yPos, double velocity, int score) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.velocity = velocity;
		this.score = score;
	}

	public Thing(double velocity, int score) {
		this.xPos = (int) (Math.random() * DeadOrAliveController.WIDTH);
		this.yPos = DeadOrAliveController.HEIGHT;
		this.velocity = velocity;
		this.score = score;
	}
	
}
