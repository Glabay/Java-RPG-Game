package glabtech.jrpg.entity.player.stats;

import java.awt.Color;
import java.awt.Graphics2D;

import glabtech.jrpg.assets.Assets;
import glabtech.jrpg.entity.player.Player;

public class PlayerStats {

	private Player	player;

	// HEALTH
	private float	health		= 149;
	private float	maxHealth	= 1;
	private float	healthScale	= health / maxHealth;
	private float	dmrt		= health / maxHealth;
	private int		waitTime	= 20;

	public PlayerStats(Player player) {
		this.player = player;
	}

	public void tick() {
	}

	public void render(Graphics2D g) {
		g.setColor(Color.RED);
		if (!player.damaged) {
			if (dmrt > healthScale) {
				if (waitTime != 0) {
					waitTime--;
				}
				if (waitTime == 0) {
					dmrt -= 1f;
					if (dmrt < healthScale) {
						waitTime = 20;
					}
				}
			}
			g.fillRect((int) player.getPos().xpos + 4 - 32 * 5 / 2 + 32 / 2, (int) player.getPos().ypos - 32 * 2 - 11, (int) dmrt, 20);
		}

		g.setColor(Color.GREEN);
		g.fillRect(
				(int) player.getPos().xpos + 4 - 32 * 5 / 2 + 32 / 2, 
				(int) player.getPos().ypos - 32 * 2 - 11, 
				(int) maxHealth * (int) healthScale, 20);

		g.drawImage(Assets.getHealth_g_bar(), (int) (player.getPos().xpos + 4 - 32 * 5 / 2 + 32 / 2) - 4, (int) player.getPos().ypos - 32 * 2 - 11, (32 * 5) - 3, 20, null);

	}

	public void damage(float amount) {
		if (healthScale > 0 && !player.isDamaged()) {
			healthScale -= amount;
			player.setDamaged(true);
		}
	}
}
