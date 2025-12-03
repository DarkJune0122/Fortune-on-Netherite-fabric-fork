package net.fon;

import net.minecraft.block.*;
import net.minecraft.registry.*;
import net.minecraft.util.*;

public class ModBlocks{
    public static final Block NetheriteScrapBlock;
    public static final Block RawDebrisBlock;

    static{
        Block.Settings settings = Block.Settings.create();
        settings.resistance(Blocks.ANCIENT_DEBRIS.getBlastResistance());
        NetheriteScrapBlock = register("netherite_scrap_block", settings);
        RawDebrisBlock = register("raw_debris_block", settings);
    }

    public static void construct(){
    }

    public static void initialize(){
    }

    private static Block register(String name, Block.Settings settings){
        return Registry.register(
            Registries.BLOCK,
            Identifier.of(FortuneOnNetheriteFabric.MOD_ID, name),
            new Block(settings)
        );
    }
}
