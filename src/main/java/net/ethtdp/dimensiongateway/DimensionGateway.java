package net.ethtdp.dimensiongateway;

import com.mojang.logging.LogUtils;
import net.ethtdp.dimensiongateway.blocks.ModBlocks;
import net.ethtdp.dimensiongateway.items.ModItems;
import net.ethtdp.dimensiongateway.items.ModTabs;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.stream.Stream;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DimensionGateway.MODID)
public class DimensionGateway {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "dimensiongateway";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public DimensionGateway() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::addCreative);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        addBlocks(event);
        addItems(event);
    }

    private void addBlocks(CreativeModeTabEvent.BuildContents event)
    {
        Iterable<Block> blocks = ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;

        if(event.getTab() == ModTabs.DimensionTab)
            blocks.forEach(event::accept);

        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.TRIGGER_BLOCK);
            event.accept(ModBlocks.TRIGGER_ORE);
            event.accept(ModBlocks.MAJESTIC_BLOCK);
        }

        if (event.getTab() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModBlocks.GATEWAY_BLOCK);
        }
    }

    private void addItems(CreativeModeTabEvent.BuildContents event)
    {
        Iterable<Item> items = ModItems.ITEMS.getEntries().stream().map(RegistryObject::get)::iterator;



        if (event.getTab() == ModTabs.DimensionTab)
            items.forEach(Item::getDefaultInstance);

        if (event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.EXAMPLE_ITEM);
            event.accept(ModItems.RAW_TRIGGER);
            event.accept(ModItems.TRIGGER);
            event.accept(ModItems.RAW_MAJESTIC);
            event.accept(ModItems.MAJESTIC);
            event.accept(ModItems.RAW_RARE_TRIGGER);
            event.accept(ModItems.RARE_TRIGGER);
        }
    }

}
