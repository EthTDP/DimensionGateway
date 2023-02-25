package net.ethtdp.dimensiongateway.blocks;

import net.ethtdp.dimensiongateway.DimensionGateway;
import net.ethtdp.dimensiongateway.blocks.custom.GatewayBlock;
import net.ethtdp.dimensiongateway.items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DimensionGateway.MODID);


    //blocks
    public static final RegistryObject<Block> TRIGGER_BLOCK = registerBlock("trigger_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(8.0f).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> GATEWAY_BLOCK = registerBlock("gateway_block",
            () -> new GatewayBlock(BlockBehaviour.Properties.of(Material.PORTAL).strength(9.0f).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> MAJESTIC_BLOCK = registerBlock("majestic_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(8.0f).requiresCorrectToolForDrops()));

    //Ores
    public static final RegistryObject<Block> TRIGGER_ORE = registerBlock("trigger_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(7.0f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MAJESTIC_ORE = registerBlock("majestic_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(7.0f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RARE_TRIGGER_ORE = registerBlock("rare_trigger_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(9.0f).requiresCorrectToolForDrops()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
