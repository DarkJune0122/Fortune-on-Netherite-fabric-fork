package net.neoxfortuneonnetherite;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.resource.*;
import net.fabricmc.loader.api.*;
import net.minecraft.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FortuneOnNetheriteFabric implements ModInitializer {
    public static final String MOD_ID = "neoxfortuneonnetherite";

    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        ModItems.construct();
        ModBlocks.construct();

        // Initializes only after all references were created.
        ModItems.initialize();
        ModBlocks.initialize();

        var container = FabricLoader.getInstance().getModContainer("neoxfortuneonnetherite")
        .orElseThrow(() -> new IllegalStateException("Missing mod container"));

        ResourceManagerHelper.registerBuiltinResourcePack(
            Identifier.of("neoxfortuneonnetherite", "override"),
            container, ResourcePackActivationType.ALWAYS_ENABLED
        );

        LOGGER.info("[FoN Fabric] Mod was successfully registered.");
    }
}