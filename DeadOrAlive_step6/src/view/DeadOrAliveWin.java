package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Apple;
import model.Board;
import model.Bomb;
import model.Player;

public class DeadOrAliveWin extends JFrame {
	private Player player;
	private Bomb bomb;
	private Apple apple;

	public DeadOrAliveWin(Player player, Bomb bomb, Apple apple) {
		this.player = player;
		this.bomb = bomb;
		this.apple = apple;
	}

	public void display() {
		this.setTitle("DeadOrAlive");
		this.setSize(Board.WIDTH, Board.HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 상단 - 점수판 게임시작버튼 배치
		JPanel pnl4Score = new JPanel(new GridLayout(0, 3));
		JLabel lbl4Score = new JLabel("점수판");
		Font s = new Font("Serif", Font.ITALIC, 30);
		lbl4Score.setFont(s);
		pnl4Score.add(lbl4Score);
		
		// 게임 시작 버튼
		JButton btnStart = new JButton("Game Start");
		pnl4Score.add(btnStart);
		// 게임 재시작 버튼 ( 게임 오버 상태 일때 나오도록)
		JButton btnReStart = new JButton("Game ReStart");
		if (player.getScore() < 0)
			pnl4Score.add(btnReStart);

		this.add(pnl4Score, BorderLayout.NORTH);
		// 중단 - 게임이 돌아갈 보드판넬 배치
		this.add(new PanelOfBoard(bomb, player, apple, lbl4Score, btnStart, btnReStart), BorderLayout.CENTER);

		this.setVisible(true);
	}
}
