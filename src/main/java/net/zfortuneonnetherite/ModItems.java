package net.zfortuneonnetherite;

import net.fabricmc.fabric.api.itemgroup.v1.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.util.*;

public class ModItems{
    public static final Item RAW_DEBRIS = item("raw_debris", new Item.Settings());

    public static final BlockItem RAW_DEBRIS_BLOCK = block("raw_debris_block", ModBlocks.RAW_DEBRIS_BLOCK, new BlockItem.Settings());
    public static final BlockItem NETHERITE_SCRAP_BLOCK = block("netherite_scrap_block", ModBlocks.NETHERITE_SCRAP_BLOCK, new BlockItem.Settings());

    public static void construct(){
    }

    public static void initialize(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAW_DEBRIS);
        });
    }

    private static Item item(String name, Item.Settings settings){
        return Registry.register(
        Registries.ITEM,
        Identifier.of(FortuneOnNetheriteFabric.MOD_ID, name),
        new Item(settings)
        );
    }

    private static BlockItem block(String name, Block block, BlockItem.Settings settings){
        return Registry.register(
        Registries.ITEM,
        Identifier.of(FortuneOnNetheriteFabric.MOD_ID, name),
        new BlockItem(block, settings)
        );
    }
}
