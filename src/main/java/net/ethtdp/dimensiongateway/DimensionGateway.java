package net.ethtdp.dimensiongateway;

import com.mojang.logging.LogUtils;
import net.ethtdp.dimensiongateway.blocks.ModBlocks;
import net.ethtdp.dimensiongateway.items.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DimensionGateway.MODID)
public class DimensionGateway {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "DimensionGateway";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public DimensionGateway() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
