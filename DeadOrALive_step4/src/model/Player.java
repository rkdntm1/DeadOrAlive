package model;

public class Player extends Thing {
	// 충돌 상황을 위한 사이즈 값 정의 
	public static final int WIDTH = 200;
	public static final int HEIGHT = 150;
	
	/**
	 * @param xPos 수평위치
	 * @param velocity 좌우 움직이는 속도
	 * @param score 기본 점수
	 */
	public Player(int xPos, double velocity, int score) {
		super(xPos, Board.HEIGHT - 200,  velocity, score);
	}
}
