package com.euphony.faster_climbing.neoforge;

import com.euphony.faster_climbing.FasterClimbing;
import net.neoforged.fml.common.Mod;

@Mod(FasterClimbing.MOD_ID)
public final class FasterClimbingNeoForge {
    public FasterClimbingNeoForge() {
        // Run our common setup.
        FasterClimbing.init();
    }
}
