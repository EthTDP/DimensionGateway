package net.ethtdp.dimensiongateway.items;

import net.ethtdp.dimensiongateway.DimensionGateway;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.openjdk.nashorn.api.linker.NashornLinkerExporter;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DimensionGateway.MODID);

    //items
    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
            () -> new Item(new Item.Properties()));

    //raw ingots
    public static final RegistryObject<Item> RAW_TRIGGER = ITEMS.register("raw_trigger",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_MAJESTIC = ITEMS.register("raw_majestic",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_RARE_TRIGGER = ITEMS.register("raw_rare_trigger",
            () -> new Item(new Item.Properties()));

    //ingots
    public static final RegistryObject<Item> TRIGGER = ITEMS.register("trigger",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MAJESTIC = ITEMS.register("majestic",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RARE_TRIGGER = ITEMS.register("rare_trigger",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
