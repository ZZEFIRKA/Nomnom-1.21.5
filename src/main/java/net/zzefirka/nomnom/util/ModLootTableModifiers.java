package net.zzefirka.nomnom.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.zzefirka.nomnom.item.ModItems;


public class ModLootTableModifiers {
    private static final Identifier OCEAN_RUIN_WARM_ARCHAEOLOGY
            = Identifier.of("minecraft", "archaeology/ocean_ruin_warm");
    private static final Identifier CREEPER_ID
            = Identifier.of("minecraft", "entities/creeper");


    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register(((key, tableBuilder, source, registry) -> {

            if(OCEAN_RUIN_WARM_ARCHAEOLOGY.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .with(ItemEntry.builder(ModItems.MIROLUM))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        }));

        LootTableEvents.MODIFY.register(((key, tableBuilder, source, registry) -> {

            if(CREEPER_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .with(ItemEntry.builder(ModItems.MIROLUM))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        }));



    }
}
