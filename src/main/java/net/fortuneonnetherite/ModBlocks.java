package net.fortuneonnetherite;

import net.fabricmc.fabric.api.itemgroup.v1.*;
import net.fabricmc.fabric.api.object.builder.v1.block.*;
import net.minecraft.block.*;
import net.minecraft.block.AbstractBlock.*;
import net.minecraft.block.enums.*;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.sound.*;
import net.minecraft.util.*;

public class ModBlocks{
    public static final Block RAW_DEBRIS_BLOCK;
    public static final Block NETHERITE_SCRAP_BLOCK;

    static{
        // Simply copies initialization of Netherite block and Ancient debris.
        NETHERITE_SCRAP_BLOCK = register("netherite_scrap_block", Block.Settings.create()
        .mapColor(MapColor.BROWN).instrument(NoteBlockInstrument.BELL).requiresTool().strength(10.0F, 1200.0F).sounds(BlockSoundGroup.NETHERITE));
        RAW_DEBRIS_BLOCK = register("raw_debris_block", Block.Settings.create()
        .mapColor(MapColor.BROWN).instrument(NoteBlockInstrument.BELL).requiresTool().strength(10.0F, 1200.0F).sounds(BlockSoundGroup.ANCIENT_DEBRIS));
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
