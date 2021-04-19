package model;

public class Apple extends Thing {
	// 충돌 상황을 위한 사이즈 값 정의
	public static final int WIDTH = 100;
	protected static final int HEIGHT = 100;
	
	public Apple(double velocity, int score) {
		super(0, velocity, score);
	}
}
