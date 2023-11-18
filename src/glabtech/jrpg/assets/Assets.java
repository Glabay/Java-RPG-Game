package glabtech.jrpg.assets;

import java.awt.image.BufferedImage;

import glabtech.jge.graphics.io.LoadImageFrom;
import glabtech.jge.graphics.spritesheets.SpriteSheet;

public class Assets {
	
	public static SpriteSheet		tiles	= new SpriteSheet();
	public static SpriteSheet		player	= new SpriteSheet();
	public static SpriteSheet		items	= new SpriteSheet();

	public static BufferedImage		stone_1;
	public static BufferedImage		grass_1;

	// HUD
	private static BufferedImage	player_fast_equip;
	private static BufferedImage	health_g_bar;
	private static BufferedImage	hit_splat;

	// PLAYER ATTACK
	private static BufferedImage	up_attack;
	private static BufferedImage	down_attack;
	private static BufferedImage	right_attack;
	private static BufferedImage	left_attack;

	// BLOCK LIFE
	private static BufferedImage	b_life_100;
	private static BufferedImage	b_life_90;
	private static BufferedImage	b_life_80;
	private static BufferedImage	b_life_70;
	private static BufferedImage	b_life_60;
	private static BufferedImage	b_life_50;
	private static BufferedImage	b_life_40;
	private static BufferedImage	b_life_30;
	private static BufferedImage	b_life_20;
	private static BufferedImage	b_life_10;

	// MOUSE
	private static BufferedImage	mouse_pressed;
	private static BufferedImage	mouse_unpressed;

	// BUTTON
	private static BufferedImage	button_heldover;
	private static BufferedImage	button_notover;

	// WOOD 1
	private static BufferedImage	wood_down_right_top;
	private static BufferedImage	wood_down_left_top;
	private static BufferedImage	wood_down_mid_top;

	private static BufferedImage	wood_down_right_mid;
	private static BufferedImage	wood_down_left_mid;
	private static BufferedImage	wood_down_mid_mid;

	private static BufferedImage	wood_down_right_bottom;
	private static BufferedImage	wood_down_left_bottom;
	private static BufferedImage	wood_down_mid_bottom;

	// CHECKERBOARD
	private static BufferedImage	checkboard_down_right_top;
	private static BufferedImage	checkboard_down_left_top;
	private static BufferedImage	checkboard_down_mid_top;

	private static BufferedImage	checkboard_down_right_mid;
	private static BufferedImage	checkboard_down_left_mid;
	private static BufferedImage	checkboard_down_mid_mid;

	private static BufferedImage	checkboard_down_right_bottom;
	private static BufferedImage	checkboard_down_left_bottom;
	private static BufferedImage	checkboard_down_mid_bottom;

	private static BufferedImage	inventory_slot;
	private static BufferedImage    inventory_background;
	
	//ITEMS
	private static BufferedImage    item_sword;
	private static BufferedImage    item_iron_sword;
	private static BufferedImage    item_wooden_shield;
	private static BufferedImage    item_health_potion;
	private static BufferedImage    item_mana_potion;
	private static BufferedImage    item_empty_vial;

	public void init() {

		items.setSpritesheet(LoadImageFrom.loadImageFrom(Assets.class, "ItemSheet.png"));
		tiles.setSpritesheet(LoadImageFrom.loadImageFrom(Assets.class, "spritesheet.png"));
		player.setSpritesheet(LoadImageFrom.loadImageFrom(Assets.class, "PlayerSheet.png"));

		item_sword = items.getTile(0, 0, 16, 16);
		item_wooden_shield = items.getTile(16, 0, 16, 16);
		item_iron_sword = items.getTile(32, 0, 16, 16);
		item_mana_potion = items.getTile(48, 0, 16, 16);
		item_health_potion = items.getTile(64, 0, 16, 16);
		item_empty_vial = items.getTile(80, 0, 16, 16);
		

		player_fast_equip = player.getTile(64 * 2 + 48, 0, 64 * 2 + 64 + 16, 16);

		health_g_bar = player.getTile(96, 0, 41, 8);
		hit_splat = player.getTile(64, 32, 16, 16);
		inventory_slot = player.getTile(352, 16, 32, 32);
		inventory_background = player.getTile(112, 48, 96, 112);

		right_attack = player.getTile(16, 64 + 48, 16, 16);
		left_attack = player.getTile(16, 64 * 2, 16, 16);
		up_attack = player.getTile(16, 64 * 2 + 16, 16, 16);
		down_attack = player.getTile(16, 64 * 2 + 32, 16, 16);

		mouse_pressed = player.getTile(64 + 32 + 8, 8, 8, 8);
		mouse_unpressed = player.getTile(64 + 32, 8, 8, 8);
		button_heldover = player.getTile(64 + 64 + 32, 32, 48, 16);
		button_notover = player.getTile(64 + 48, 32, 48, 16);

		b_life_100 = tiles.getTile(64 * 2 + 16, 48 * 2, 16, 16);
		b_life_90 = tiles.getTile(64 * 2, 48 * 2, 16, 16);
		b_life_80 = tiles.getTile(64 + 48, 48 * 2, 16, 16);
		b_life_70 = tiles.getTile(64 + 32, 48 * 2, 16, 16);
		b_life_60 = tiles.getTile(64 + 16, 48 * 2, 16, 16);
		b_life_50 = tiles.getTile(64, 48 * 2, 16, 16);
		b_life_40 = tiles.getTile(48, 48 * 2, 16, 16);
		b_life_30 = tiles.getTile(32, 48 * 2, 16, 16);
		b_life_20 = tiles.getTile(16, 48 * 2, 16, 16);
		b_life_10 = tiles.getTile(0, 48 * 2, 16, 16);

		stone_1 = tiles.getTile(0, 0, 16, 16);
		grass_1 = tiles.getTile(16, 0, 16, 16);

		// WOOD 1
		wood_down_left_top = tiles.getTile(48, 0, 16, 16);
		wood_down_left_mid = tiles.getTile(48, 16, 16, 16);
		wood_down_left_bottom = tiles.getTile(48, 32, 16, 16);

		wood_down_mid_top = tiles.getTile(64, 0, 16, 16);
		wood_down_mid_mid = tiles.getTile(64, 16, 16, 16);
		wood_down_mid_bottom = tiles.getTile(64, 32, 16, 16);

		wood_down_right_top = tiles.getTile(64 + 16, 0, 16, 16);
		wood_down_right_mid = tiles.getTile(64 + 16, 16, 16, 16);
		wood_down_right_bottom = tiles.getTile(64 + 16, 32, 16, 16);

		// CHECKERBOARD
		checkboard_down_left_top = tiles.getTile(48, 0 + 48, 16, 16);
		checkboard_down_left_mid = tiles.getTile(48, 16 + 48, 16, 16);
		checkboard_down_left_bottom = tiles.getTile(48, 32 + 48, 16, 16);

		checkboard_down_mid_top = tiles.getTile(64, 0 + 48, 16, 16);
		checkboard_down_mid_mid = tiles.getTile(64, 16 + 48, 16, 16);
		checkboard_down_mid_bottom = tiles.getTile(64, 32 + 48, 16, 16);

		checkboard_down_right_top = tiles.getTile(64 + 16, 0 + 48, 16, 16);
		checkboard_down_right_mid = tiles.getTile(64 + 16, 16 + 48, 16, 16);
		checkboard_down_right_bottom = tiles.getTile(64 + 16, 32 + 48, 16, 16);

	}

	public static BufferedImage getRight_attack() {
		return right_attack;
	}

	public static BufferedImage getLeft_attack() {
		return left_attack;
	}

	public static BufferedImage getUp_attack() {
		return up_attack;
	}

	public static BufferedImage getDown_attack() {
		return down_attack;
	}

	public static BufferedImage getB_life_100() {
		return b_life_100;
	}

	public static BufferedImage getB_life_90() {
		return b_life_90;
	}

	public static BufferedImage getB_life_80() {
		return b_life_80;
	}

	public static BufferedImage getB_life_70() {
		return b_life_70;
	}

	public static BufferedImage getB_life_60() {
		return b_life_60;
	}

	public static BufferedImage getB_life_50() {
		return b_life_50;
	}

	public static BufferedImage getB_life_40() {
		return b_life_40;
	}

	public static BufferedImage getB_life_30() {
		return b_life_30;
	}

	public static BufferedImage getB_life_20() {
		return b_life_20;
	}

	public static BufferedImage getB_life_10() {
		return b_life_10;
	}

	public static BufferedImage getStone_1() {
		return stone_1;
	}

	public static BufferedImage getGrass_1() {
		return grass_1;
	}

	public static BufferedImage getMouse_pressed() {
		return mouse_pressed;
	}

	public static BufferedImage getMouse_unpressed() {
		return mouse_unpressed;
	}

	public static BufferedImage getButton_heldover() {
		return button_heldover;
	}

	public static BufferedImage getButton_notover() {
		return button_notover;
	}

	public static BufferedImage getPlayer_fast_equip() {
		return player_fast_equip;
	}

	public static BufferedImage getHealth_g_bar() {
		return health_g_bar;
	}

	public static BufferedImage getHit_Splat() {
		return hit_splat;
	}

	// WOOD 1
	public static BufferedImage getWood_down_right_top() {
		return wood_down_right_top;
	}

	public static BufferedImage getWood_down_right_mid() {
		return wood_down_right_mid;
	}

	public static BufferedImage getWood_down_right_bottom() {
		return wood_down_right_bottom;
	}

	public static BufferedImage getWood_down_mid_top() {
		return wood_down_mid_top;
	}

	public static BufferedImage getWood_down_mid_mid() {
		return wood_down_mid_mid;
	}

	public static BufferedImage getWood_down_mid_bottom() {
		return wood_down_mid_bottom;
	}

	public static BufferedImage getWood_down_left_top() {
		return wood_down_left_top;
	}

	public static BufferedImage getWood_down_left_mid() {
		return wood_down_left_mid;
	}

	public static BufferedImage getWood_down_left_bottom() {
		return wood_down_left_bottom;
	}

	// CHECKERBOARD
	public static BufferedImage getCheckboard_down_right_top() {
		return checkboard_down_right_top;
	}

	public static BufferedImage getCheckboard_down_right_mid() {
		return checkboard_down_right_mid;
	}

	public static BufferedImage getCheckboard_down_right_bottom() {
		return checkboard_down_right_bottom;
	}

	public static BufferedImage getCheckboard_down_mid_top() {
		return checkboard_down_mid_top;
	}

	public static BufferedImage getCheckboard_down_mid_mid() {
		return checkboard_down_mid_mid;
	}

	public static BufferedImage getCheckboard_down_mid_bottom() {
		return checkboard_down_mid_bottom;
	}

	public static BufferedImage getCheckboard_down_left_top() {
		return checkboard_down_left_top;
	}

	public static BufferedImage getCheckboard_down_left_mid() {
		return checkboard_down_left_mid;
	}

	public static BufferedImage getCheckboard_down_left_bottom() {
		return checkboard_down_left_bottom;
	}

	public static BufferedImage getSlot_Image() {
		return inventory_slot;
	}
	public static BufferedImage getHit_splat() {
		return hit_splat;
	}

	public static BufferedImage getInventory_slot() {
		return inventory_slot;
	}

	public static BufferedImage getInventory_background() {
		return inventory_background;
	}

	public static BufferedImage getItem_sword() {
		return item_sword;
	}

	public static BufferedImage getItem_iron_sword() {
		return item_iron_sword;
	}

	public static BufferedImage getItem_wooden_shield() {
		return item_wooden_shield;
	}

	public static BufferedImage getItem_mana_potion() {
		return item_mana_potion;
	}
	
	public static BufferedImage getItem_health_potion() {
		return item_health_potion;
	}
	
	public static BufferedImage getItem_empty_vial() {
		return item_empty_vial;
	}
}