package net.ethtdp.dimensiongateway.worldgen;

import net.ethtdp.dimensiongateway.DimensionGateway;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> TRIGGERORE_PLACED_KEY = createKey("triggerore_placed");
    public static final ResourceKey<PlacedFeature> RARE_TRIGGERORE_PLACED_KEY = createKey("rare_triggerore_placed");
    public static final ResourceKey<PlacedFeature> MAJESTICCORE_PLACED_KEY = createKey("majesticore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, TRIGGERORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TRIGGERDIM_TRIGGER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(16, // veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(20))));

        register(context, MAJESTICCORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TRIGGERDIM_MAJESTIC_ORE_KEY),
                ModOrePlacement.commonOrePlacement(16,
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(20))));

        register(context, RARE_TRIGGERORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TRIGGERDIM_RARE_TRIGGER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(8,
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(-20))));
    }


    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(DimensionGateway.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
