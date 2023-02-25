package net.ethtdp.dimensiongateway;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> TRIGGER_ORE_REPLACEABLE = create("trigger_block_replaceable");

        public static final TagKey<Block> MAJESTIC_ORE_REPLACEABLE = create("majestic_ore_replaceable");
    }

    private static TagKey<Block> tag(String name) {
        return BlockTags.create(new ResourceLocation(DimensionGateway.MODID, name));
    }

    private static TagKey<Block> create(String name) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(DimensionGateway.MODID, name));
    }

    private static TagKey<Block> forgeTag(String name) {
        return BlockTags.create(new ResourceLocation("forge", name));
    }
}
