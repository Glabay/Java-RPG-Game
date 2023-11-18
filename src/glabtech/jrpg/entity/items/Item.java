package glabtech.jrpg.entity.items;

import java.awt.image.BufferedImage;

import glabtech.jrpg.assets.Assets;

public enum Item {

	STARTER_SWORD(1, "Starter Sword", "A sword to begin your adventure.", Assets.getItem_sword()),
	WOODEN_SHIELD(2, "Wodden Shield", "A shield made of wood.", Assets.getItem_wooden_shield()),
	IRON_SWORD(3, "Iron Sword", "A sword crafted from Iron.", Assets.getItem_iron_sword()),
	MANA_POTION(4, "Mana Potion", "A potion to restore some Mana.", Assets.getItem_mana_potion()),
	HEALTH_POTION(5, "Health Potion", "A potion to restore some Health.", Assets.getItem_health_potion()),
	EMPTY_VIAL(6, "Empty Vial", "A vial to hold liquads.", Assets.getItem_empty_vial());
	
	private int itemID;
	private String itemName;
	private String itemExamine;
	private BufferedImage itemImage;
	
	private Item(int itemId, String itemName, String itemExamine, BufferedImage itemImage) {
		this.itemID = itemId;
		this.itemName = itemName;
		this.itemExamine = itemExamine;
		this.itemImage = itemImage;
	}
	
	public int getItemID() {
		return itemID;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public String getItemExamine() {
		return itemExamine;
	}
	public BufferedImage getItemImage() {
		return itemImage;
	}
	
}
