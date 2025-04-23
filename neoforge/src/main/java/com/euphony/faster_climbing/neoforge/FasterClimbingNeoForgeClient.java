package com.euphony.faster_climbing.neoforge;

import com.euphony.faster_climbing.FasterClimbing;
import com.euphony.faster_climbing.config.FasterClimbingConfig;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = FasterClimbing.MOD_ID, dist = Dist.CLIENT)
public class FasterClimbingNeoForgeClient {
    public FasterClimbingNeoForgeClient(IEventBus bus) {
        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () -> (client, screen) -> FasterClimbingConfig.makeScreen().generateScreen(screen));
    }
}
