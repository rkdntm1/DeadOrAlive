package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Board;

public class DeadOrAliveWin extends JFrame {
	
	public DeadOrAliveWin() {
		this.setTitle("DeadOrAlive");
		this.setSize(Board.WIDTH, Board.HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 상단 - 점수판 왼쪽상단 배치
		JPanel pnl4Score = new JPanel(new GridLayout(1, 0));
		JLabel lbl4Score = new JLabel("점수판");
		pnl4Score.add(lbl4Score);
		this.add(pnl4Score, BorderLayout.NORTH);

		// 중단 - 게임이 돌아갈 보드판넬 배치
		this.add(new PanelOfBoard(), BorderLayout.CENTER);

		this.setVisible(true);
	}
}
