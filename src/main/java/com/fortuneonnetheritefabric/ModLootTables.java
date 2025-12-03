package com.fortuneonnetheritefabric;

import net.fabricmc.fabric.api.loot.v3.*;
import net.minecraft.block.*;
import net.minecraft.loot.*;
import net.minecraft.loot.entry.*;
import net.minecraft.loot.provider.number.*;

public class ModLootTables{
    public static void initialize(){
        LootTableEvents.REPLACE.register(((key, original, source, registries) -> {
            if (!source.isBuiltin()) return null;
            if (Blocks.ANCIENT_DEBRIS.getLootTableKey().equals(key)) {
                LootTable.Builder fabricBuilder = LootTable.builder();

                fabricBuilder.pool(LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .with(ItemEntry.builder(ModItems.RawDebris)));

                return fabricBuilder.build();
            }

            return null;
        }));
    }
}
