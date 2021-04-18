package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import model.Board;

public class PanelOfBoard extends JPanel {
	PanelOfBoard() {
		setBackground(Color.GREEN); // 뒷배경색 설정 (구분용)
		setPreferredSize(new Dimension(Board.WIDTH, Board.HEIGHT)); // 패널의 선호 사이즈 생성
	}
}
