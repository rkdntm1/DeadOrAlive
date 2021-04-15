package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import controll.DeadOrAliveController;
import model.Board;

public class PanelOfBoard extends JPanel {
	private BufferedImage appleImg, bombImg;
	private int x, y;
	private Timer timer;
	private Board board;

	public PanelOfBoard(Board board) {
		setBackground(Color.GREEN); // 뒷배경색 설정
		setPreferredSize(new Dimension(Board.WIDTH, Board.HEIGHT)); // 패널의 선호 사이즈 생성
	}
}
