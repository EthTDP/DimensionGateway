package net.ethtdp.dimensiongateway.datagen;

import net.ethtdp.dimensiongateway.DimensionGateway;
import net.ethtdp.dimensiongateway.blocks.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DimensionGateway.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.TRIGGER_BLOCK);
        blockWithItem(ModBlocks.TRIGGER_ORE);
        blockWithItem(ModBlocks.MAJESTIC_BLOCK);
        blockWithItem(ModBlocks.RARE_TRIGGER_ORE);
        blockWithItem(ModBlocks.MAJESTIC_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject)
    {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
