package studio.ecoprojects.randomblocks.Listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import studio.ecoprojects.randomblocks.utils.BlockManager;

import java.util.NoSuchElementException;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        // Sets up the variables and cancels drops
        Block originalBlock = e.getBlock();
        Material newMaterial = BlockManager.GetCounterMaterial(originalBlock.getType());
        e.setDropItems(false);

        // Trys to drop the item with fortune extra items, if it catches a NoSuchElementException it will just drop it without.
        ItemStack oldItem;
        try {
            oldItem = originalBlock.getDrops(e.getPlayer().getItemInUse()).stream().iterator().next();
        }
        catch (NoSuchElementException exception) {
            originalBlock.getWorld().dropItemNaturally(originalBlock.getLocation(), new ItemStack(newMaterial));
            return;
        }
        ItemStack newItem = new ItemStack(newMaterial, oldItem.getAmount());
        originalBlock.getWorld().dropItemNaturally(originalBlock.getLocation(), newItem);
    }
}
