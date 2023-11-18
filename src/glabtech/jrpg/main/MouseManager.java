package glabtech.jrpg.main;

import glabtech.jrpg.assets.Assets;
import glabtech.jrpg.game.states.world.World;
import glabtech.jrpg.gui.HUDmanager;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseManager implements MouseListener, MouseMotionListener, MouseWheelListener {

	private static int		mouseMovedX, mouseMovedY;
	public static Point		mouse;

	public static boolean	leftMoseButtonClicked;
	public static boolean	rightMoseButtonClicked;

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			leftMoseButtonClicked = true;
			rightMoseButtonClicked = false;
		}
		if (e.getButton() == MouseEvent.BUTTON3) {
			rightMoseButtonClicked = true;
			leftMoseButtonClicked = false;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			leftMoseButtonClicked = false;
		}
		if (e.getButton() == MouseEvent.BUTTON3) {
			rightMoseButtonClicked = false;
		}	}

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
	public void mouseMoved(MouseEvent e) {
		mouseMovedX = e.getX();
		mouseMovedY = e.getY();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {}

	public void tick() {
		mouse = new Point(mouseMovedX, mouseMovedY);

		if (World.getPlayer() != null) {
			if(World.getPlayer().getPlayerActions().hasCompleted()) {
				if (!World.getPlayer().getPlayerActions().attacked()) {
					
					// Clicked in the TOP polly
					if (HUDmanager.getUp() != null) {
						if (HUDmanager.getUp().contains(mouse)) {
							if (leftMoseButtonClicked) {
							}
						}
					}
					
					// Clicked in the LEFT polly
					if (HUDmanager.getLeft() != null) {
						if (HUDmanager.getLeft().contains(mouse)) {
							if (leftMoseButtonClicked) {
							}
						}
					}
					
					// Clicked in the RIGHT polly
					if (HUDmanager.getRight() != null) {
						if (HUDmanager.getRight().contains(mouse)) {
							if (leftMoseButtonClicked) {
							}
						}
					}
					
					// Clicked in the BOTTOM polly
					if (HUDmanager.getDown() != null) {
						if (HUDmanager.getDown().contains(mouse)) {
							if (leftMoseButtonClicked) {
							}
						}
					}
					
				}
			}
		}
	}

	public void render(Graphics2D g) {
		g.fillRect(mouseMovedX, mouseMovedY, 4, 4);

		if (leftMoseButtonClicked) {
			g.drawImage(Assets.getMouse_pressed(), mouseMovedX, mouseMovedY, 32, 32, null);
		} else {
			g.drawImage(Assets.getMouse_unpressed(), mouseMovedX, mouseMovedY, 32, 32, null);
		}

	}
}
