package main;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import entity.Player;
import poke.Pokedatnis;

public class WorldInteractionManager {

    private final Rectangle npcZone = new Rectangle(5 * 32, 5 * 32, 64, 64);
    private final Rectangle itemZone = new Rectangle(8 * 32, 4 * 32, 32, 32);
    private final Rectangle portalZone = new Rectangle(10 * 32, 7 * 32, 32, 32);

    private boolean itemCollected;
    private boolean interactionLatch;
    private boolean portalLatch;

    public void update(Player player, KeyHandler keyHandler) {
        Rectangle playerArea = new Rectangle(
                player.worldX + player.solidArea.x,
                player.worldY + player.solidArea.y,
                player.solidArea.width,
                player.solidArea.height);

        if (keyHandler.interactPressed && !interactionLatch) {
            interactionLatch = true;
            if (npcZone.intersects(playerArea)) {
                Pokedatnis.showStatusMessage("NPC: Keep training your fastest Pokémon for turn priority!");
            }
            if (!itemCollected && itemZone.intersects(playerArea)) {
                itemCollected = true;
                Pokedatnis.addPokeballs(1);
                Pokedatnis.showStatusMessage("You found a Pokéball on the ground.");
            }
        }

        if (!keyHandler.interactPressed) {
            interactionLatch = false;
        }

        if (portalZone.intersects(playerArea)) {
            if (!portalLatch) {
                portalLatch = true;
                player.worldX = 2 * 32;
                player.worldY = 2 * 32;
                Pokedatnis.showStatusMessage("You entered a portal and returned to spawn.");
            }
        } else {
            portalLatch = false;
        }
    }

    public void drawHints(Graphics2D g2, GamePanel gp) {
        int npcX = npcZone.x - gp.player.worldX + gp.player.screenX;
        int npcY = npcZone.y - gp.player.worldY + gp.player.screenY;
        int itemX = itemZone.x - gp.player.worldX + gp.player.screenX;
        int itemY = itemZone.y - gp.player.worldY + gp.player.screenY;
        int portalX = portalZone.x - gp.player.worldX + gp.player.screenX;
        int portalY = portalZone.y - gp.player.worldY + gp.player.screenY;

        g2.drawString("NPC (E)", npcX, npcY);
        if (!itemCollected) {
            g2.drawString("Item (E)", itemX, itemY);
        }
        g2.drawString("Portal", portalX, portalY);
    }

    public void restoreItemState(boolean collected) {
        this.itemCollected = collected;
    }

    public boolean isItemCollected() {
        return itemCollected;
    }
}
