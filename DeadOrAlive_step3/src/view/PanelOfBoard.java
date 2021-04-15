package view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.Board;

public class PanelOfBoard extends JPanel {
	private static final int START_OF_APPLE_BOMB = (int) (Math.random() * Board.WIDTH);
	private Board board;
	// 캐릭터 아이콘 만들어주기
	ImageIcon playerIcon = new ImageIcon("Character.jpg");
	JLabel lbl4Player = new JLabel();
	private BufferedImage image;
	private BufferedImage image2;
	private int xPosApple, yPosApple, xPosBomb, yPosBomb;
	private Timer timer;

	PanelOfBoard(Board board) {
		this.board = board;
		this.setLayout(null); // 어디든 만들어지도록 레이아웃 null

		lbl4Player.setIcon(playerIcon); // 아이콘 설치
		lbl4Player.setLocation(Board.WIDTH / 2 - (playerIcon.getIconWidth() / 2),
				Board.HEIGHT - playerIcon.getIconHeight()); // 아이콘 초기 위치 설정 (맨아래 중앙)
		System.out.println("Player = " + lbl4Player.getX());
		lbl4Player.setSize(200, 150); // 아이콘 size 정의

		this.add(lbl4Player);

		// 좌우 움직일 수 있도록 keyListener 장착
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					lbl4Player.setLocation(lbl4Player.getX() - Board.SPEED_CHARACTER, lbl4Player.getY());
					System.out.println("Player = " + lbl4Player.getX());
					break;
				case KeyEvent.VK_RIGHT:
					lbl4Player.setLocation(lbl4Player.getX() + Board.SPEED_CHARACTER, lbl4Player.getY());
					break;
				}
				lbl4Player.setLocation(lbl4Player.getX(), lbl4Player.getY());
			}
		});
		this.requestFocus();
		this.setFocusable(true);

		new Thread(new MyThread("Apple.png", 200, 0)).start();
		new Thread(new MyThread("Bomb.png", 400, 0)).start();
	}
	
	public class MyThread implements Runnable {
		private int x, y;
		private JLabel lbl;
		
		public MyThread(String apple_bomb, int xPos, int yPos) {
			this.x = x;
			this.y = y;
			lbl = new JLabel();
			ImageIcon icon = new ImageIcon(apple_bomb);
			lbl.setIcon(icon);
			add(lbl);
		}

		@Override
		public void run() {
			while(true) {
				y += Board.SPEED_BOMB_APPLE;				
				lbl.setBounds(x, y, 200, 200);
				if (y > Board.HEIGHT) {
					y = 0;
					x = (int) (Math.random() * (Board.WIDTH - 100));
				}
				repaint();
				try {
					Thread.sleep(Board.SPEED_BOMB_APPLE);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

		
	
}
