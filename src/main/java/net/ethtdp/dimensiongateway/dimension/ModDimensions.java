package net.ethtdp.dimensiongateway.dimension;

import net.ethtdp.dimensiongateway.DimensionGateway;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class ModDimensions {
    public static final ResourceKey<Level> TRIGGER_DIM = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(DimensionGateway.MODID, "triggerdim"));
}
