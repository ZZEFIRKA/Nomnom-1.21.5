package net.zzefirka.nomnom;

import net.fabricmc.api.ModInitializer;

import net.zzefirka.nomnom.block.ModBlocks;
import net.zzefirka.nomnom.item.ModItems;
import net.zzefirka.nomnom.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Nomnom implements ModInitializer {
	public static final String MOD_ID = "nomnom";

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModLootTableModifiers.modifyLootTables();
	}
}