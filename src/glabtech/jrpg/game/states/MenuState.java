package glabtech.jrpg.game.states;

import java.awt.Graphics2D;

import glabtech.jrpg.game.GameButtons;
import glabtech.jrpg.game.GameState;
import glabtech.jrpg.game.GameStateManager;
import glabtech.jrpg.game.states.world.villages.homevillage.HomeVillage;
import glabtech.jrpg.game.states.world.villages.homevillage.buildings.PlayerHouse;
import glabtech.jrpg.main.Main;
import glabtech.jrpg.main.MouseManager;

public class MenuState extends GameState {

	GameButtons	startGame;
	GameButtons	multiplayer;
	GameButtons	options;
	GameButtons	quit;
	MouseManager	mm;

	public MenuState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		mm = new MouseManager();
		startGame = new GameButtons(Main.width / 3, 200, new PlayerHouse(gsm), gsm, "StartGame");
		multiplayer = new GameButtons(Main.width / 3, 300, new HomeVillage(gsm), gsm, "Multiplayer");
		options = new GameButtons(Main.width / 3, 400, new HomeVillage(gsm), gsm, "Options");
		quit = new GameButtons(Main.width / 3, 500, new QuitState(gsm), gsm, "Quit");
	}

	@Override
	public void render(Graphics2D g) {
		startGame.render(g);
		multiplayer.render(g);
		options.render(g);
		quit.render(g);

		mm.render(g);
		g.clipRect(0, 0, Main.width, Main.height);
	}

	@Override
	public void tick(double deltaTime) {
		mm.tick();
		startGame.tick();
		multiplayer.tick();
		options.tick();
		quit.tick();
	}

}
