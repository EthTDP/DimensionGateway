package net.ethtdp.dimensiongateway.datagen;

import net.ethtdp.dimensiongateway.blocks.ModBlocks;
import net.ethtdp.dimensiongateway.items.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.TRIGGER_BLOCK.get());
        dropSelf(ModBlocks.GATEWAY_BLOCK.get());
        dropSelf(ModBlocks.MAJESTIC_BLOCK.get());

        add(ModBlocks.TRIGGER_ORE.get(),
                (block) -> createOreDrop(ModBlocks.TRIGGER_BLOCK.get(), ModItems.RAW_TRIGGER.get()));
        add(ModBlocks.MAJESTIC_ORE.get(),
                (block) -> createOreDrop(ModBlocks.MAJESTIC_BLOCK.get(), ModItems.RAW_MAJESTIC.get()));
        add(ModBlocks.RARE_TRIGGER_ORE.get(),
                (block) -> createOreDrop(ModBlocks.RARE_TRIGGER_ORE.get(), ModItems.RAW_RARE_TRIGGER.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
