package glabtech.jrpg.gui.inventory;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class InventoryMouse implements MouseListener, MouseMotionListener {

	public static boolean	isLeftClicked;
	public static boolean	isRightClicked;
	

	private static int		mouseMovedX, mouseMovedY;
	public static Point		mouse;

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			isLeftClicked = true;
			isRightClicked = false;
		}
		if (e.getButton() == MouseEvent.BUTTON3) {
			isLeftClicked = false;
			isRightClicked = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			isLeftClicked = false;
		}
		if (e.getButton() == MouseEvent.BUTTON3) {
			isRightClicked = false;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseMovedX = e.getX();
		mouseMovedY = e.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent arg0) {}
}
