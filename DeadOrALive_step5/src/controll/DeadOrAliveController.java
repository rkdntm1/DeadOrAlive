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
	// 10milliseconds마다 한번씩 날아가는 모습을 보여줄 것임
	public static final int PERIOD = 10; 
	// 플레이어, 사과, 폭탄의 점수설정 
	public static final int BASIC_SCORE = 10;
	public static final int APPLE_SCORE = 3;
	public static final int BOMB_SCORE = -5;
	
	public DeadOrAliveController() {
		new Board(); // 보드 만들기
		Player player = new Player(Board.XPOSOFCHARACTER, Board.SPEED_PLAYER, BASIC_SCORE); // 캐릭터 만들기(위치, 속도, 점수 던져주기)
		Bomb bomb = new Bomb(Board.SPEED_BOMB_APPLE, BOMB_SCORE ); // 폭탄 만들기(속도, 점수)
		Apple apple = new Apple(Board.SPEED_BOMB_APPLE, APPLE_SCORE); // 사과 만들기(속도, 점수)
		
		// 폭탄과 사과를 설정한 바닥높이까지 떨어뜨리고 그 이상 떨어질 경우 다시 올라와 랜덤한 위치에서 떨어진다.
		DeadOrAliveWin displayer = new DeadOrAliveWin(player, bomb, apple);
		startFallDown(bomb, apple, player, displayer);
	}
	
	/**
	 * Timer를 이용하여 시간이 지남에 따라서 플레이어, 폭탄, 사과를 위치 시킨다. 
	 * 그리고 폭탄과 사과의 yPos가 떨어진다.
	 * 그리고 그 이상 떨어질 경우 다시 올라와 랜덤한 위치에서 떨어진다.
	 * 그리고 폭탄과 사과의 충돌이 일어났을경우 폭탄과 사과를 초기위치로 되돌리며 플레이어의 점수를 경우에 맞게 변동시킨다.
	 * @param bomb
	 */
	private static void startFallDown(Bomb bomb, Apple apple, Player player, DeadOrAliveWin displayer) {
		ScheduledJob job = new ScheduledJob(bomb, apple, player);
		Timer jobScheduler = new Timer();
		jobScheduler.scheduleAtFixedRate(job, 0, PERIOD);  
		do {
			//폭탄이 떨어지는 도중. 다 떨어지면 위치 리셋 
			if (!bomb.isInSky()) {
				bomb.reset();	
			}
			//사과가 덜어지는 도중. 다 떨어지면 위치 리셋
			if (!apple.isInSky()) {
				apple.reset();
			}
			// 사과, 폭탄이 플레이어와 충돌이 일어났을경우 위치 리셋 및 점수 변동시키기
			if (player.crash(apple)) {
				apple.reset();
				player.changeScore(apple);
			}					
				
			if (player.crash(bomb)) {
				bomb.reset();
				player.changeScore(bomb);
			}
			
			// view 출력 
			displayer.display();
		} while (!(player.getScore() < 0)); // 점수가 0점 보다 아래일 경우 게임 중지.
		
	}

	public static void main(String[] args) {
		new DeadOrAliveController();
	}
}

class ScheduledJob extends TimerTask {
	private Bomb bomb;
	private Apple apple;
	private Player player;
	
	ScheduledJob(Bomb bomb, Apple apple, Player player){
		this.bomb = bomb;
		this.apple = apple;
		this.player = player;
	}
	public void run() {
		// 버튼이 눌러지면 실행
		if (player.isStart()) {
			// 시간이 지남에 따라 폭탄과 사과의 떨어짐을 구현 
			apple.fly(DeadOrAliveController.PERIOD);
			bomb.fly(DeadOrAliveController.PERIOD);

		}
	}
}