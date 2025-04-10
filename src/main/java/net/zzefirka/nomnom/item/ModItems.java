package net.zzefirka.nomnom.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.zzefirka.nomnom.block.ModBlocks;

import java.util.function.Function;

public final class ModItems {
    private ModItems() {
    }

    public static final Item MIROLUM = register("mirolum", Item::new, new Item.Settings());
    public static final Item BLUE_TOPAZ = register("blue_topaz", Item::new, new Item.Settings());
    public static final Item ASTRALITE = register("astralite", Item::new, new Item.Settings());

    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("nomnom", path));
        return Items.register(registryKey, factory, settings);
    }

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.AMETHYST_SHARD, ModItems.MIROLUM);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(ModItems.MIROLUM, ModItems.BLUE_TOPAZ);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.NETHERITE_INGOT, ModItems.ASTRALITE);
        });
    }

//    public static void initialize() {
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
//            entries.addAfter(Items.AMETHYST_SHARD, ModItems.MIROLUM);
//        });
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
//            entries.addAfter(ModItems.MIROLUM, ModItems.BLUE_TOPAZ);
//        });
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
//            entries.addAfter(Items.NETHERITE_INGOT, ModItems.ASTRALITE);
//        });
//    }
}
