package glabtech.jrpg.entity.blocks;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import glabtech.jge.maths.Vector2F;
import glabtech.jrpg.assets.Assets;

public class Block extends Rectangle {
	public Vector2F			pos			= new Vector2F();
	public int				BlockSize	= 32;
	private BlockType		blocktype;
	private BufferedImage	block;
	private boolean			isSolid;
	private boolean			isAlive;
	public boolean			droped		= false;

	public Block(Vector2F pos) {
		setBounds((int) pos.xpos, (int) pos.ypos, BlockSize, BlockSize);
		this.pos = pos;
		isAlive = true;
	}

	public Block(Vector2F pos, BlockType blocktype) {
		setBounds((int) pos.xpos, (int) pos.ypos, BlockSize, BlockSize);
		this.pos = pos;
		isAlive = true;
		this.blocktype = blocktype;
		init();
	}

	public Block isSolid(boolean isSolid) {
		this.isSolid = isSolid;
		return this;
	}

	public void init() {
		switch (blocktype) {
			case STONE_1:
				block = Assets.getStone_1();
				break;
			case GRASS_1:
				block = Assets.getGrass_1();
				break;

			/////////////////////////////////// WOOD 1/////////////////////////////////////////////
			case WOOD_DOWN_LEFT_BOTTOM:
				block = Assets.getWood_down_left_bottom();
				break;
			case WOOD_DOWN_LEFT_MID:
				block = Assets.getWood_down_left_mid();
				break;
			case WOOD_DOWN_LEFT_TOP:
				block = Assets.getWood_down_left_top();
				break;
			case WOOD_DOWN_MID_BOTTOM:
				block = Assets.getWood_down_mid_bottom();
				break;
			case WOOD_DOWN_MID_MID:
				block = Assets.getWood_down_mid_mid();
				break;
			case WOOD_DOWN_MID_TOP:
				block = Assets.getWood_down_mid_top();
				break;
			case WOOD_DOWN_RIGHT_BOTTOM:
				block = Assets.getWood_down_right_bottom();
				break;
			case WOOD_DOWN_RIGHT_MID:
				block = Assets.getWood_down_right_mid();
				break;
			case WOOD_DOWN_RIGHT_TOP:
				block = Assets.getWood_down_right_top();
				break;
		}
	}

	public void tick(double deltaTime) {
		if (isAlive) {
			setBounds((int) pos.xpos, (int) pos.ypos, BlockSize, BlockSize);
		}
	}

	public void render(Graphics2D g) {
		if (isAlive) {
			if (block != null) {
				g.drawImage(block, (int) pos.getWorldLocation().xpos, (int) pos.getWorldLocation().ypos, BlockSize, BlockSize, null);
			} else {
				g.fillRect((int) pos.getWorldLocation().xpos, (int) pos.getWorldLocation().ypos, BlockSize, BlockSize);
			}

			if (isSolid) {
				g.drawRect((int) pos.getWorldLocation().xpos, (int) pos.getWorldLocation().ypos, BlockSize, BlockSize);
			}
		}
	}

	public enum BlockType {
		STONE_1,
		GRASS_1,

		// WOOD 1###########################
		WOOD_DOWN_LEFT_TOP,
		WOOD_DOWN_LEFT_MID,
		WOOD_DOWN_LEFT_BOTTOM,
		WOOD_DOWN_MID_TOP,
		WOOD_DOWN_MID_MID,
		WOOD_DOWN_MID_BOTTOM,
		WOOD_DOWN_RIGHT_TOP,
		WOOD_DOWN_RIGHT_MID,
		WOOD_DOWN_RIGHT_BOTTOM,

	}

	public boolean isSolid() {
		return isSolid;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public Vector2F getBlockLocation() {
		return pos;
	}

	public BufferedImage getBlockType() {
		return block;
	}
}
