package net.ethtdp.dimensiongateway.datagen;

import net.ethtdp.dimensiongateway.DimensionGateway;
import net.ethtdp.dimensiongateway.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DimensionGateway.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RAW_TRIGGER);
        simpleItem(ModItems.RAW_MAJESTIC);
        simpleItem(ModItems.RAW_RARE_TRIGGER);

        simpleItem(ModItems.TRIGGER);
        simpleItem(ModItems.MAJESTIC);
        simpleItem(ModItems.RARE_TRIGGER);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DimensionGateway.MODID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(DimensionGateway.MODID, "item/" + item.getId().getPath()));
    }
}
