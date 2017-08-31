package sk.maha.colorwindow;

import javax.swing.JFrame;

public class ColorBackground extends JFrame {

	private static final long serialVersionUID = -4240939101393657305L;

	public ColorBackground() {
		add(new ColorBackgroundComponent());
		pack();
	}
}
