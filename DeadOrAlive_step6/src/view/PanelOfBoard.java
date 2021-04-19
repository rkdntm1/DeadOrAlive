package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import controll.DeadOrAliveController;
import model.Apple;
import model.Board;
import model.Bomb;
import model.Player;

public class PanelOfBoard extends JPanel implements ActionListener {
	private JLabel lbl4Score;
	private JButton btnStart;
	private JButton btnReStart;

	// 캐릭터, 사과, 폭탄, 게임종료 아이콘 만들어주기
	ImageIcon PlayerIcon = new ImageIcon("Character.png");
	ImageIcon AppleIcon = new ImageIcon("Apple.png");
	ImageIcon BombIcon = new ImageIcon("Bomb.png");
	ImageIcon gameoverIcon = new ImageIcon("Gameover.png");

	// 아이콘을 담을 라벨 만들기
	JLabel lbl4Player = new JLabel();
	JLabel lbl4Apple = new JLabel();
	JLabel lbl4Bomb = new JLabel();
	JLabel lbl4Gameover = new JLabel();

	private Timer timer;
	private int basicScore = DeadOrAliveController.BASIC_SCORE;
	private Bomb bomb;
	private Player player;
	private Apple apple;

	PanelOfBoard(Bomb bomb, Player player, Apple apple, JLabel lbl4Score, JButton btnStart, JButton btnReStart) {
		this.player = player;
		this.apple = apple;
		this.bomb = bomb;
		this.btnStart = btnStart;
		this.btnReStart = btnReStart;

		// 버튼을 눌렀을때 리스너가 실행되도록
		btnStart.addActionListener(this);
		btnReStart.addActionListener(this);

		// 점수를 담아줄 라벨
		this.lbl4Score = lbl4Score;
		lbl4Score.setText("" + player.getScore());

		this.setLayout(null); // 어디든 만들어지도록 레이아웃 null\

		// 플레이어 아이콘설정
		lbl4Player.setIcon(PlayerIcon); // 아이콘 설치
		lbl4Player.setLocation(player.getxPos(), player.getyPos() - Player.HEIGHT / 5); // 아이콘 초기 위치 설정 (맨아래 중앙)
		lbl4Player.setSize(200, 150); // 아이콘 size 정의
		this.add(lbl4Player);

		// 사과 아이콘 설정
		lbl4Apple.setIcon(AppleIcon); // 아이콘 설치
		lbl4Apple.setSize(100, 100); // 아이콘 size 정의
		lbl4Apple.setLocation(apple.getxPos(), apple.getyPos()); // 아이콘 초기 위치 설정 보드 범위 내
		this.add(lbl4Apple);

		// 폭탄 아이콘 설정
		lbl4Bomb.setIcon(BombIcon); // 아이콘 설치
		lbl4Bomb.setSize(100, 100); // 아이콘 size 정의
		lbl4Bomb.setLocation(bomb.getxPos(), bomb.getyPos()); // 아이콘 초기 위치 설정 보드 범위 내 랜덤
		this.add(lbl4Bomb);

		// 점수가 0점 아래로 내려가면 게임 오버 아이콘 출력
		if (player.getScore() < 0) {
			lbl4Gameover.setIcon(gameoverIcon);
			lbl4Gameover.setLocation(Board.WIDTH / 2 - Player.WIDTH, Board.HEIGHT / 2 - Player.HEIGHT);
			lbl4Gameover.setSize(400, 300);
			this.add(lbl4Gameover);
		}
	}

	/** 버튼을 눌렀을때 게임이 시작되도록 설정 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼 눌렀을때 true가 되도록
		player.setStart(true);
		btnStart.setEnabled(false);
		
		// 재시작 버튼이 눌러졌을 경우   
		if (e.getActionCommand().toString() == "Game ReStart") {
			player.setRestart(true);
		}

		// 좌우 움직일 수 있도록 keyListener 장착
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (player.getxPos() < 0) {
						player.setxPos(player.getxPos() + Board.SPEED_PLAYER);
					}
					player.setxPos(player.getxPos() - Board.SPEED_PLAYER);
					break;
				case KeyEvent.VK_RIGHT:
					if (player.getxPos() > Board.WIDTH - lbl4Player.getWidth() + 20) {
						player.setxPos(player.getxPos() - Board.SPEED_PLAYER);
					}
					player.setxPos(player.getxPos() + Board.SPEED_PLAYER);
					break;
				}
			}
		});

		this.requestFocus();
		this.setFocusable(true);

		lbl4Apple.setLocation(apple.getxPos(), apple.getyPos()); // 사과 위치 변경
		lbl4Bomb.setLocation(bomb.getxPos(), bomb.getyPos()); // 폭탄 위치 변경

	}
}
