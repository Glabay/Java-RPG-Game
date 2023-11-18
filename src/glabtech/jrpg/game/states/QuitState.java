package glabtech.jrpg.game.states;

import java.awt.Graphics2D;

import glabtech.jrpg.game.GameButtons;
import glabtech.jrpg.game.GameState;
import glabtech.jrpg.game.GameStateManager;
import glabtech.jrpg.main.Main;
import glabtech.jrpg.main.MouseManager;

public class QuitState extends GameState {

	GameButtons	yes;
	GameButtons	no;
	MouseManager	mm;

	public QuitState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		mm = new MouseManager();
		yes = new GameButtons(Main.width / 3, 100, "Yes!");
		no = new GameButtons(Main.width / 3 + 200, 100, "No!");
	}

	@Override
	public void render(Graphics2D g) {
		yes.render(g);
		no.render(g);
		mm.render(g);
		g.clipRect(0, 0, Main.width, Main.height);
	}

	@Override
	public void tick(double deltaTime) {
		mm.tick();
		yes.tick();
		no.tick();

		if (yes.isHeldOver()) {
			if (yes.isPressed()) {
				System.exit(1);
			}
		}
		if (no.isHeldOver()) {
			if (no.isPressed()) {
				gsm.states.push(new MenuState(gsm));
				gsm.states.peek().init();
			}
		}
	}

}
