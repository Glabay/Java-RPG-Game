package glabtech.jrpg.main;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;

import glabtech.jge.gamewindow.GameWindow;
import glabtech.jrpg.entity.player.Player;
import glabtech.jrpg.gui.inventory.InventoryMouse;

public class Main {

	public static int	width	= 1280;
	public static int	height	= 720;

	public static void main(String[] args) {
		GameWindow frame = new GameWindow("Project Penguin ~GLABTECH", width, height);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Cursor cursor = toolkit.createCustomCursor(toolkit.getImage(""), new Point(0, 0), "Cursor");
		frame.setCursor(cursor);

		frame.addMouseListener(new InventoryMouse());
		frame.addMouseListener(new MouseManager());
		frame.addMouseMotionListener(new MouseManager());
		frame.addMouseWheelListener(new MouseManager());

		frame.addKeyListener(new Player());
		frame.add(new GameLoop(width, height));
		frame.setVisible(true);
	}

}
