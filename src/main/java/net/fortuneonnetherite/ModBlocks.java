package net.fortuneonnetherite;

import net.fabricmc.fabric.api.itemgroup.v1.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.util.*;

public class ModBlocks{
    public static final Block RAW_DEBRIS_BLOCK;
    public static final Block NETHERITE_SCRAP_BLOCK;

    static{
        // Test: make sure that it DOES drop something, thanks to the loot tables.
        Block.Settings settings = Block.Settings.copy(Blocks.ANCIENT_DEBRIS).dropsNothing();

        NETHERITE_SCRAP_BLOCK = register("netherite_scrap_block", settings);
        RAW_DEBRIS_BLOCK = register("raw_debris_block", settings);
    }

    public static void construct(){
    }

    public static void initialize(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(RAW_DEBRIS_BLOCK);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(NETHERITE_SCRAP_BLOCK);
        });
    }

    private static Block register(String name, Block.Settings settings){
        return Registry.register(
            Registries.BLOCK,
            Identifier.of(FortuneOnNetheriteFabric.MOD_ID, name),
            new Block(settings)
        );
    }
}
