package glabtech.jrpg.gui.inventory;

import java.awt.Graphics2D;
import java.util.concurrent.CopyOnWriteArrayList;

import glabtech.jge.maths.Vector2F;
import glabtech.jrpg.assets.Assets;
import glabtech.jrpg.entity.items.Item;

public class Inventory {

	private Vector2F					pos		= new Vector2F();

	private int							xDim;
	private int							yDim;

	private CopyOnWriteArrayList<Slot>	slots;

	private boolean						toggle	= false;

	public Inventory(float xpos, float ypos, int xDim, int yDim) {
		this.pos.xpos = xpos;
		this.pos.ypos = ypos;
		this.xDim = xDim;
		this.yDim = yDim;
	}

	public void init() {
		slots = new CopyOnWriteArrayList<Slot>();
		for (int x = 0; x < xDim; x++) {
			for (int y = 0; y < yDim; y++) {
				slots.add(new Slot(pos.xpos + y * 48, pos.ypos + x * 48));
			}
		}
	}

	public void toggle() {
		toggle = !toggle;
	}

	public void tick() {
		if (toggle) {
			for (Slot slot : slots) {
				slot.tick();
			}
		}
	}

	public void render(Graphics2D g) {
		if (toggle) {
			g.drawImage(Assets.getInventory_background(), (int) pos.xpos - 12, (int) pos.ypos - 12, Assets.getInventory_background().getWidth() * 2 + 24, 48 * 5 + 12, null);
			for (Slot slot : slots) {
				slot.render(g);
			}
		}
	}

	public void addItem(Item item) {
		for (Slot slot : slots) {
			if (slot.hasNoItem()) {
				slot.setItem(item);
				break;
			} else {
				if (slot.hasSameId(item)) {
					if (!slot.isFull()) {
						slot.addItemToStack(item);
						break;
					}
				}
			}
		}
	}

	public void addItem(Item item, int slotNum) {
		if (slotNum < slots.size()) {
			Slot slot = slots.get(slotNum);
			if (slot.hasNoItem()) {
				slot.setItem(item);
			} else {
				if (slot.hasSameId(item)) {
					if (!slot.isFull()) {
						slot.addItemToStack(item);
					}
				}
			}
		} else {
			System.err.println("Out of Bounds Inventory SlotNum: " + slotNum);
		}
	}
	
	public void addItem(Item item, int amount, int slotNum) {
		if (slotNum < slots.size()) {
			Slot slot = slots.get(slotNum);
			if (slot.hasNoItem()) {
				slot.setItem(item, amount);
			} else {
				if (slot.hasSameId(item)) {
					if (!slot.isFull()) {
						slot.addItemToStack(item);
					}
				}
			}
		} else {
			System.err.println("Out of Bounds Inventory SlotNum: " + slotNum);
		}
	}
}
