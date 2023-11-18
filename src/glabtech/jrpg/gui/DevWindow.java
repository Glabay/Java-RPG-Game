package glabtech.jrpg.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import glabtech.jge.utils.TextFormatter;

public class DevWindow implements KeyListener {

	private int			xDim;
	private int			yDim;

	private boolean		toggle					= false;
	private String		consoleInput			= "test";
	private String[]	messages				= {
			"", "", "", "", "", "", "", ""
	};

	private long		consoleInputThrottler	= 0L;

	public DevWindow() {
	}

	public void init() {
	}

	public void toggle() {
		toggle = !toggle;
	}

	public void tick() {
	}

	public void render(Graphics2D g) {
		if (toggle) {
			g.setColor(Color.CYAN);
			for (int i = 0; i < messages.length; i++) {
				g.drawString(messages[messages.length - i - 1], 2, 720 - 58 - (i * 13));
			}
			g.drawString("Command: ", 1, 720 - 45);
			g.drawString(consoleInput + "*", 150, 720 - 45);

		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (toggle) {
				if (key == KeyEvent.VK_ENTER) {
					if (consoleInputThrottler <= System.currentTimeMillis() - 100) {
						consoleInputThrottler = System.currentTimeMillis();
						if (consoleInput.length() >= 1) {
							if (consoleInput.startsWith("/")) {
								String cmdInput = consoleInput.substring(1);
								String[] cmd = cmdInput.split(" ");
								if (cmd[0].equalsIgnoreCase("item")) {

								}
								return;
							}
							consoleInput = "";
						}
					}
				} else {
					consoleInput = TextFormatter.updateText(consoleInput, e.getKeyCode(), e.getKeyChar(), 64);
				}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
