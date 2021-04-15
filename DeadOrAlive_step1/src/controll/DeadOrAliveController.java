package controll;

import model.Apple;
import model.Board;
import model.Bomb;
import model.Player;
import view.DeadOrAliveWin;

public class DeadOrAliveController {
	private Board board; 

	public DeadOrAliveController() {
		board = new Board(); // 보드 만들기
		Player player = new Player(Board.XPOSOFCHARACTER, Board.WIDTH / 5, 10); // 캐릭터 만들기(위치, 속도, 점수 던져주기)
		Bomb bomb = new Bomb(Board.BASICSPEED, -5 ); // 폭탄 만들기(속도, 점수)
		Apple apple = new Apple(Board.BASICSPEED, 3); // 사과 만들기(속도, 점수)
		// 보드에 캐릭터 폭탄 사과를 넣어주자. 
		board.load(player);
		board.load(bomb);
		board.load(apple);
		new DeadOrAliveWin(board); 
	}
	
	public static void main(String[] args) {
		new DeadOrAliveController();
	}

}
