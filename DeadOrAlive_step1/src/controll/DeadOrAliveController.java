package controll;

import model.Apple;
import model.Board;
import model.Bomb;
import model.Player;
import view.DeadOrAliveWin;

public class DeadOrAliveController {
	//보드 크기 
	public static final int WIDTH = 1000, HEIGHT = 1000;
	//캐릭터 기본 위치
	private static final int XPOSOFCHARACTER = WIDTH / 2;
	//폭탄, 사과의 기본 속도 설정
	private static final int TIME = 4;
	private static final int BASICSPEED = HEIGHT / TIME; 
	
	private Board board; 

	public DeadOrAliveController() {
		Board board = new Board(); // 보드 만들기
		Player player = new Player(XPOSOFCHARACTER, WIDTH / 5, 10); // 캐릭터 만들기(위치, 속도, 점수 던져주기)
		Bomb bomb = new Bomb(BASICSPEED, -5 ); // 폭탄 만들기(속도, 점수)
		Apple apple = new Apple(BASICSPEED, 3); // 사과 만들기(속도, 점수)
		// 보드에 캐릭터 폭탄 사과를 넣어주자. 
		board.load(player);
		board.load(bomb);
		board.load(apple);
		new DeadOrAliveWin(); 
	}
	
	public static void main(String[] args) {
		new DeadOrAliveController();
	}

}
