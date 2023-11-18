package glabtech.jrpg.game.states.world.villages.homevillage.buildings;

import java.awt.Graphics2D;

import glabtech.jrpg.entity.player.Player;
import glabtech.jrpg.game.GameState;
import glabtech.jrpg.game.GameStateManager;
import glabtech.jrpg.game.states.world.World;
import glabtech.jrpg.main.Main;

public class PlayerHouse extends GameState {

	public static World world;
	
	private String worldname;
	private String map_name;

	public PlayerHouse(GameStateManager gsm) {
		super(gsm);
	}

	public PlayerHouse(GameStateManager gsm, String worldname, String map_name) {
		super(gsm);
		this.worldname = worldname;
		this.map_name = map_name;
	}

	@Override
	public void init() {
		if (worldname == null) {
			worldname = "NULL";
			map_name = "home";
		}
		world = new World(worldname, gsm);
		world.setSize(16, 16);
		world.setWorldSpawn(8, 8);
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
