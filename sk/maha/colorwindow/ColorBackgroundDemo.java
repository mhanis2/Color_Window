package sk.maha.colorwindow;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ColorBackgroundDemo {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new ColorBackground();
			frame.setTitle("Color Background");
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
