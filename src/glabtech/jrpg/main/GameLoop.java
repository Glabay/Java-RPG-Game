package glabtech.jrpg.main;

import glabtech.jge.gameloop.GTGameLoop;
import glabtech.jrpg.assets.Assets;
import glabtech.jrpg.game.GameStateManager;
import glabtech.jrpg.gui.HUDmanager;

public class GameLoop extends GTGameLoop {

	public static Assets	assets	= new Assets();
	GameStateManager		gsm;

	public GameLoop(int fwidth, int fheight) {
		super(fwidth, fheight);
	}

	@Override
	public void clear() {
		super.clear();
	}

	@Override
	public void init() {
		assets.init();
		gsm = new GameStateManager();
		gsm.init();
		super.init();
	}

	@Override
	public void render() {
		super.render();
		gsm.render(graphics2D);
		clear();
	}

	@Override
	public void tick(double deltaTime) {
		gsm.tick(deltaTime);
		HUDmanager.setFPS(getFps());
	}
	
}
