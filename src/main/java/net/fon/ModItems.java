package net.fon;

import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.util.*;

public class ModItems{
    public static final Item RawDebris = register("raw_debris", new Item.Settings());
    public static final Item RawDebrisBlock = register("raw_debris_block", new Item.Settings());
    public static final Item NetheriteScrapBlock = register("netherite_scrap_block", new Item.Settings());

    public static void construct(){
    }

    public static void initialize(){
    }

    private static Item register(String name, Item.Settings settings){
        return Registry.register(
            Registries.ITEM,
            Identifier.of(FortuneOnNetheriteFabric.MOD_ID, name),
            new Item(settings)
        );
    }
}
