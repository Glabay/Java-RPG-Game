package glabtech.jrpg.entity.player;

import glabtech.jrpg.entity.blocks.Block;
import glabtech.jrpg.entity.blocks.TileManager;

import java.awt.Point;

public class Collision {

	public static boolean CollisionPlayerBlock(Point p1, Point p2) {
		for (Block block : TileManager.blocks) {
			if (block.isSolid()) {
				if (block.contains(p1) || block.contains(p2)) {
					return true;
				}
			}
		}
		return false;
	}

}
