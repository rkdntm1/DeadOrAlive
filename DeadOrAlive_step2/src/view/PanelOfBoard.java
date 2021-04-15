package view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Board;

public class PanelOfBoard extends JPanel {
	private Board board;
	// 캐릭터 아이콘 만들어주기
	ImageIcon PlayerIcon = new ImageIcon("Character.jpg");
	JLabel lbl4Player = new JLabel();

	PanelOfBoard(Board board) {
		this.board = board;
		this.setLayout(null); // 어디든 만들어지도록 레이아웃 null

		lbl4Player.setIcon(PlayerIcon); // 아이콘 설치
		lbl4Player.setLocation(Board.WIDTH / 2 - (PlayerIcon.getIconWidth() / 2), Board.HEIGHT - PlayerIcon.getIconHeight()); // 아이콘 초기 위치 설정 (맨아래 중앙)
		lbl4Player.setSize(200, 150); // 아이콘 size 정의

		this.add(lbl4Player);
		
		// 좌우 움직일 수 있도록 keyListener 장착 => 안움직임 why?
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e){
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					lbl4Player.setLocation(lbl4Player.getX() - Board.SPEED_CHARACTER, lbl4Player.getY());
					break;
				case KeyEvent.VK_RIGHT:
					lbl4Player.setLocation(lbl4Player.getX() + Board.SPEED_CHARACTER, lbl4Player.getY());
					break;
				}
			}
		});
	}
}

