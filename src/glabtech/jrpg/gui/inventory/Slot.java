package glabtech.jrpg.gui.inventory;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import glabtech.jge.maths.Vector2F;
import glabtech.jrpg.entity.items.Item;
import glabtech.jrpg.main.MouseManager;

public class Slot extends Rectangle {

	private int			maxStack			= 64;
	private int			currentStackSize	= 0;
	private int			size				= 48;
	private int			slotItemID;

	private Vector2F	pos					= new Vector2F();

	private Item		item;

	private boolean		isHeldOver;

	private Font		font				= new Font("Calibri", 20, 20);

	public Slot(float slotXpos, float slotYpos) {
		this.pos.xpos = slotXpos;
		this.pos.ypos = slotYpos;
		setBounds((int) pos.xpos, (int) pos.ypos, size, size);
	}

	public void render(Graphics2D g) {
		if (item != null) {
			g.drawImage(item.getItemImage(), (int) pos.xpos + 2, (int) pos.ypos + 2, 42, 42, null);
			g.setFont(font);
			g.setColor(Color.YELLOW);
			g.drawString(currentStackSize + "", (int) pos.xpos + size / 2, (int) pos.ypos + size - 2);
			g.setColor(Color.WHITE);
		}
		if (isHeldOver) {
			g.setColor(Color.GREEN);
		}
		g.drawRect((int) pos.xpos, (int) pos.ypos, size - 1, size - 1);
		g.setColor(Color.WHITE);
	}

	public void tick() {
		setBounds((int) pos.xpos, (int) pos.ypos, size, size);
		if (currentStackSize == 0) {
			if (item != null) {
				clear();
			}
			if (this.contains(MouseManager.mouse)) {
				isHeldOver = true;
			} else {
				isHeldOver = false;
			}
		}
		
		if (isHeldOver) {
			if (isLeftClicked()) {
				if (currentStackSize > 0)
					// System.out.println("Clicked item: " + item.getItemName() + " You have: " + currentStackSize);
					System.err.println("Worked!");
				else
					System.err.println("Didn't Work!");
			}
			if (isRightClicked()) {
				System.out.println("RightClicked!!");
			}
		}
	}

	public void setItem(Item item) {
		this.item = item;
		slotItemID = item.getItemID();
		currentStackSize += 1;
	}

	public void setItem(Item item, int amount) {
		this.item = item;
		slotItemID = item.getItemID();
		currentStackSize += amount;
	}

	private void clear() {
		slotItemID = 0;
		item = null;
		currentStackSize = 0;
	}

	public Item getItem() {
		return item;
	}

	public boolean hasNoItem() {
		return (item == null && slotItemID == 0);
	}

	public boolean hasSameId(Item item) {
		if (item.getItemID() == slotItemID) {
			return true;
		} else {
			return false;
		}
	}

	public int getSlotID() {
		return slotItemID;
	}

	public int getCurrentStackSize() {
		return currentStackSize;
	}

	public void setCurrentStackSize(int currentStackSize) {
		this.currentStackSize = currentStackSize;
	}

	public void addItemToStack(Item item) {
		currentStackSize += 1;
	}

	public boolean isFull() {
		if (currentStackSize < maxStack) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isLeftClicked() {
		if (isHeldOver) {
			if (InventoryMouse.isLeftClicked) {
				InventoryMouse.isLeftClicked = false;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean isRightClicked() {
		if (isHeldOver) {
			if (InventoryMouse.isRightClicked) {
				InventoryMouse.isRightClicked = false;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean hasItem() {
		if (item != null) {
			if (slotItemID != 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
