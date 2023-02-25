package net.ethtdp.dimensiongateway.worldgen;

import net.ethtdp.dimensiongateway.DimensionGateway;
import net.ethtdp.dimensiongateway.ModTags;
import net.ethtdp.dimensiongateway.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> TRIGGERDIM_TRIGGER_ORE_KEY = registerKey("triggerore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TRIGGERDIM_RARE_TRIGGER_ORE_KEY = registerKey("rare_triggerore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TRIGGERDIM_MAJESTIC_ORE_KEY = registerKey("majesticore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest triggerblockreplace = new TagMatchTest(ModTags.Blocks.TRIGGER_ORE_REPLACEABLE);
        RuleTest majesticblockreplace = new TagMatchTest(ModTags.Blocks.MAJESTIC_ORE_REPLACEABLE);

        List<OreConfiguration.TargetBlockState> triggerdimTriggerOre = List.of(OreConfiguration.target(triggerblockreplace,
                        ModBlocks.TRIGGER_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> triggerdimRareTriggerOre = List.of(OreConfiguration.target(triggerblockreplace,
                ModBlocks.RARE_TRIGGER_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> triggerdimMajesticOre = List.of(OreConfiguration.target(majesticblockreplace,
                ModBlocks.MAJESTIC_ORE.get().defaultBlockState()));

        register(context, TRIGGERDIM_TRIGGER_ORE_KEY, Feature.ORE, new OreConfiguration(triggerdimTriggerOre, 9));
        register(context, TRIGGERDIM_MAJESTIC_ORE_KEY, Feature.ORE, new OreConfiguration(triggerdimMajesticOre, 9));
        register(context, TRIGGERDIM_RARE_TRIGGER_ORE_KEY, Feature.ORE, new OreConfiguration(triggerdimRareTriggerOre, 6));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(DimensionGateway.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
