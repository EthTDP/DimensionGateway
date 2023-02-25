package net.ethtdp.dimensiongateway.items;

import net.ethtdp.dimensiongateway.DimensionGateway;
import net.ethtdp.dimensiongateway.blocks.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DimensionGateway.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModTabs {

    public static CreativeModeTab DimensionTab;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        DimensionTab = event.registerCreativeModeTab(new ResourceLocation(DimensionGateway.MODID, "dimensiongateway_tab"),
                builder -> builder.icon(() -> new ItemStack(ModBlocks.GATEWAY_BLOCK.get()))
                        .title(Component.translatable("creativemodetab.dimensiongateway_tab")));
    }
}
