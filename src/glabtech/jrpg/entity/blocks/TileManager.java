package glabtech.jrpg.entity.blocks;

import glabtech.jrpg.entity.player.Player;
import glabtech.jrpg.game.states.world.World;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class TileManager {

	public static ArrayList<Block>	blocks		= new ArrayList<Block>();
	public static ArrayList<Block>	load_blocks	= new ArrayList<Block>();

	private World								world;

	public TileManager(World world) {
		this.world = world;
	}

	public ArrayList<Block> getBlocks() {
		return blocks;
	}

	public ArrayList<Block> getLoadedBlocks() {
		return load_blocks;
	}

	public void render(Graphics2D g) {
		for (Block block : blocks) {
			block.render(g);
		}
	}

	public void tick(double deltaTime) {
		for (Block block : blocks) {
			block.tick(deltaTime);

			if (Player.render.intersects(block)) {
				block.setAlive(true);

				if (!load_blocks.contains(block)) {
					load_blocks.add(block);
				}

			} else {
				if (load_blocks.contains(block)) {
					load_blocks.remove(block);
				}
				block.setAlive(false);
			}
		}
		if (!world.getPlayer().isDebuging()) {
			if (!load_blocks.isEmpty()) {
				load_blocks.clear();
			}
		}
	}

}
