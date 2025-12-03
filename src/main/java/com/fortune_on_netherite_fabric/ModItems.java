package com.fortune_on_netherite_fabric;

import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.util.*;

public class ModItems{
    public static final Item RawDebris = register("raw_debris", new Item.Settings());

    // Called to initialize static constructors.
    public static void initialize(){}

    private static Item register(String name, Item.Settings settings) {
        return Registry.register(
            Registries.ITEM,
            Identifier.of(FortuneOnNetheriteMod.MOD_ID, name),
            new Item(settings)
        );
    }

    private static String prepare(String name) {
        return FortuneOnNetheriteMod.MOD_ID + ":" + name;
    }
}
