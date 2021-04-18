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

public class PanelOfBoard extends JPanel {
	private JLabel lbl4Score;
	private JButton btnStart;
	private Player player;

	// 캐릭터 아이콘 가져오기
	ImageIcon PlayerIcon = new ImageIcon("Character.png");

	// 아이콘을 담을 라벨 만들기
	JLabel lbl4Player = new JLabel();

	// 점수판 라벨에 넣을 기본 점수 설정
	private int basicScore = DeadOrAliveController.BASIC_SCORE;
	

	PanelOfBoard(Player player) {
		this.player = player;
		this.setLayout(null); // 어디든 만들어지도록 레이아웃 null\

		// 플레이어 아이콘설정
		lbl4Player.setIcon(PlayerIcon); // 아이콘 설치
		lbl4Player.setSize(200, 150); // 아이콘 size 정의
		lbl4Player.setLocation(player.getxPos(), player.getyPos() - lbl4Player.getHeight() / 2); // 아이콘 초기 위치 설정 (맨아래 중앙)
		this.add(lbl4Player);

		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (player.getxPos() < 0) {
						player.setxPos(player.getxPos() + 20);
					}
					player.setxPos(player.getxPos() - Board.SPEED_PLAYER);
					break;
				case KeyEvent.VK_RIGHT:
					if (player.getxPos() > Board.WIDTH - lbl4Player.getWidth() + 20) {
						player.setxPos(player.getxPos() - 20);
					}
					player.setxPos(player.getxPos() + Board.SPEED_PLAYER);
					break;
				}
				lbl4Player.setLocation(player.getxPos(), player.getyPos() - lbl4Player.getHeight() / 2);
			}
		});
		this.requestFocus();
		this.setFocusable(true);
	}
}
