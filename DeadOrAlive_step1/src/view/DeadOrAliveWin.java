package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controll.DeadOrAliveController;

public class DeadOrAliveWin extends JFrame {
	private BufferedImage image;
	public DeadOrAliveWin() {
		this.setTitle("DeadOrAlive");
		this.setSize(DeadOrAliveController.WIDTH, DeadOrAliveController.HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 상단
		JPanel pnl4Score = new JPanel(new GridLayout(1, 0));
		JLabel lbl4Score = new JLabel("점수판");
		pnl4Score.add(lbl4Score);
		this.add(pnl4Score, BorderLayout.NORTH);

		// 중단
		this.add(new PanelOfBoard(), BorderLayout.CENTER);

		this.setVisible(true);
	}
}
