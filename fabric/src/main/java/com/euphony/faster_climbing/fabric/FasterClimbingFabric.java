package com.euphony.faster_climbing.fabric;

import com.euphony.faster_climbing.FasterClimbing;
import net.fabricmc.api.ModInitializer;

public final class FasterClimbingFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        FasterClimbing.init();
    }
}
