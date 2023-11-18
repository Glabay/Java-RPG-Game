package glabtech.jrpg.game.states.world.villages.homevillage;

import java.awt.Graphics2D;

import glabtech.jrpg.entity.player.Player;
import glabtech.jrpg.game.GameState;
import glabtech.jrpg.game.GameStateManager;
import glabtech.jrpg.game.states.world.World;
import glabtech.jrpg.main.Main;

public class HomeVillage extends GameState {

	public static World		world;

	private String			worldname;
	private String			map_name;

	public HomeVillage(GameStateManager gsm) {
		super(gsm);
	}

	public HomeVillage(GameStateManager gsm, String worldname, String map_name) {
		super(gsm);
		this.worldname = worldname;
		this.map_name = map_name;
	}

	@Override
	public void init() {
		if (worldname == null) {
			worldname = "NULL";
			map_name = "HomeVillage";
		}
		world = new World(worldname, gsm);
		world.setSize(90, 83);
		world.setWorldSpawn(17, 45);
		world.addPlayer(new Player());

		world.init();
		world.generate(map_name);
	}


	@Override
	public void render(Graphics2D g) {
		if (world.hasGenerated()) {
			world.render(g);
		}
		g.clipRect(0, 0, Main.width, Main.height);
	}

	@Override
	public void tick(double deltaTime) {
		if (world.hasGenerated()) {
			world.tick(deltaTime);
		}
	}

}
