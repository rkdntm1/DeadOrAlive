package controll;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import model.Apple;
import model.Board;
import model.Bomb;
import model.Player;
import view.DeadOrAliveWin;
import view.PanelOfBoard;

public class DeadOrAliveController {
	// 1초마다 한번씩 날아가는 모습을 보여줄 것임
	public static final int PERIOD = 10; 
	// 플레이어, 사과, 폭탄의 점수설정 
	public static final int BASIC_SCORE = 10;
	public static final int APPLE_SCORE = 3;
	public static final int BOMB_SCORE = -5;
	private Board board; 
	
	public DeadOrAliveController() {
		board = new Board(); // 보드 만들기
		Player player = new Player(Board.XPOSOFCHARACTER, Board.SPEED_PLAYER, BASIC_SCORE); // 캐릭터 만들기(위치, 속도, 점수 던져주기)
		Bomb bomb = new Bomb(Board.SPEED_BOMB_APPLE, BOMB_SCORE ); // 폭탄 만들기(속도, 점수)
		Apple apple = new Apple(Board.SPEED_BOMB_APPLE, APPLE_SCORE); // 사과 만들기(속도, 점수)
		
		// 화면 띄워보기 
		new DeadOrAliveWin();
	}

	public static void main(String[] args) {
		new DeadOrAliveController();
	}
}

