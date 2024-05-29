package studio.ecoprojects.randomblocks;

import org.bukkit.plugin.java.JavaPlugin;
import studio.ecoprojects.randomblocks.Listeners.BlockBreakListener;
import studio.ecoprojects.randomblocks.utils.BlockManager;

public final class RandomBlocks extends JavaPlugin {

    public static RandomBlocks plugin;

    @Override
    public void onEnable() {
        plugin = this;
        BlockManager.Start();
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);

    }

}
