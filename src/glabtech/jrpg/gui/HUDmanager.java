package glabtech.jrpg.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import glabtech.jrpg.game.states.world.World;
import glabtech.jrpg.main.Main;

public class HUDmanager {

	private boolean			callOnce	= false;
	private World			world;

	public static Polygon	up;
	public static Polygon	down;
	public static Polygon	left;
	public static Polygon	right;

	private static int		FPS			= 0;

	public HUDmanager(World world) {
		this.world = world;
		init();
	}

	private void init() {
		/* UP */
		int[] ux = new int[] {
				Main.width - 1, Main.width / 2, Main.width / 2, 0
		};
		int[] uy = new int[] {
				0, Main.height / 2, Main.height / 2, 0
		};
		up = new Polygon(ux, uy, ux.length);
		/* DOWN */
		int[] dx = new int[] {
				Main.width - 1, Main.width / 2, Main.width / 2, 0
		};
		int[] dy = new int[] {
				Main.height - 1, Main.height / 2, Main.height / 2, Main.height - 1
		};
		down = new Polygon(dx, dy, dx.length);
		/* RIGHT */
		int[] rx = new int[] {
				Main.width - 1, Main.width / 2, Main.width / 2, Main.width - 1
		};
		int[] ry = new int[] {
				Main.height, Main.height / 2, Main.height / 2, 0
		};
		right = new Polygon(rx, ry, rx.length);
		/* LEFT */
		int[] lx = new int[] {
				0, Main.width / 2, Main.width / 2, 0
		};
		int[] ly = new int[] {
				Main.height, Main.height / 2, Main.height / 2, 0
		};
		left = new Polygon(lx, ly, lx.length);
	}

	public void render(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Main.width, Main.height / 6);
		g.fillRect(0, 700, Main.width, Main.height / 6);
		g.setColor(Color.WHITE);

		if (world.getPlayer().isDebuging()) {
			g.drawString("[DEBUG]", 30, 30);
			g.drawString("[FPS] " + getFPS(), 500, 30);
			g.drawString("[MapXpos] " + world.getWorldXpos(), 30, 60);
			g.drawString("[MapYpos] " + world.getWorldYpos(), 30, 90);
			g.drawString("[Current World Blocks] " + world.getWorldBlocks().getBlocks().size(), 500, 60);
			g.drawString("[Current Loaded World Blocks] " + world.getWorldBlocks().getLoadedBlocks().size(), 500, 90);

			g.drawPolygon(right);
			g.drawPolygon(up);
			g.drawPolygon(down);
			g.drawPolygon(left);
		}
	}

	private int getFPS() {
		return FPS;
	}

	public static void setFPS(int fPS) {
		FPS = fPS;
	}

	public boolean isCallOnce() {
		return callOnce;
	}

	public void setCallOnce(boolean callOnce) {
		this.callOnce = callOnce;
	}

	public static Polygon getRight() {
		return right;
	}

	public static Polygon getUp() {
		return up;
	}

	public static Polygon getDown() {
		return down;
	}

	public static Polygon getLeft() {
		return left;
	}

}
