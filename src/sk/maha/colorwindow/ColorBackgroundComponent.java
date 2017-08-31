package sk.maha.colorwindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;

public class ColorBackgroundComponent extends JPanel {

	private static final long serialVersionUID = -8829461748633916287L;

	private static final int DEFAULT_WIDTH = 255;
	private static final int DEFAULT_HEIGHT = 255;

	private int x;
	private int y;
	private int z;
	private int scrollCount;

	/**
	 * Constructor of the class with size, MouseMotionListener and
	 * MouseWheelListener
	 */
	public ColorBackgroundComponent() {
		setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		addMouseMotionListener(new MouseMotionHandler());
		addMouseWheelListener(new MouseWheelHandler());
	}


	/**
	 * Setting x coordinate for color. It alters according to window width.
	 * 
	 * @param a
	 * @param e
	 * @return x coordinate
	 */
	public int setX(int a, MouseEvent e) {
		double xCoordinates = e.getX();
		double devide255 = a / (double) 255;
		return (xCoordinates == a ? x = 255 : (x = (int) (xCoordinates / devide255)));
	}

	/**
	 * Setting y coordinate for color. It alters according to window height.
	 * 
	 * @param b
	 * @param e
	 * @return y coordinate
	 */
	public int setY(int b, MouseEvent e) {
		double yCoordinates = e.getY();
		double devide255 = b / (double) 255;
		return (yCoordinates == b ? y = 255 : (y = (int) (yCoordinates / devide255)));
	}

	/**
	 * Algorithm of setting z coordinate for color. It alters according to
	 * number of mouse-scroll-rotation.
	 * 
	 * @param c
	 * @return z coordinate
	 */
	public int setZ(int c) {
		if (c < 0 && z == 0) {
			z = 0;
		} else if (c < 0 && z > 0) {
			z += c;
		} else if (z == 255 && c > 0) {
			z = 255;
		} else {
			z += c;
		}
		return z;
	}

	private class MouseMotionHandler implements MouseMotionListener {

		/**
		 * Setting background color. Takes x and y coordinates from the
		 * functions setX and setY.
		 */
		@Override
		public void mouseMoved(MouseEvent event) {
			int w = getWidth();
			int h = getHeight();

			setX(w, event);
			setY(h, event);
			setBackground(new Color(x, y, z));
		}

		@Override
		public void mouseDragged(MouseEvent e) {
		}
	}

	private class MouseWheelHandler implements MouseWheelListener {

		/**
		 * Setting z coordinate according to changing amount of
		 * mouse-scroll-rotation.
		 */
		@Override
		public void mouseWheelMoved(MouseWheelEvent event) {
			scrollCount = event.getWheelRotation();
			int w = getWidth();
			int h = getHeight();
			setX(w, event);
			setY(h, event);
			setZ(scrollCount);
			setBackground(new Color(x, y, z));
			scrollCount = 0;
		}
	}
}

