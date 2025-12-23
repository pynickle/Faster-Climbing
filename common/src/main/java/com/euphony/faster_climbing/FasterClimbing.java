package com.euphony.faster_climbing;

import com.euphony.faster_climbing.client.ClientEvents;
import com.euphony.faster_climbing.config.FasterClimbingConfig;
import net.minecraft.resources.Identifier;

import java.util.Locale;

public final class FasterClimbing {
    public static final String MOD_ID = "faster_climbing";

    public static void init() {
        FasterClimbingConfig.load();
        ClientEvents.init();
    }

    public static Identifier prefix(String name) {
        return Identifier.fromNamespaceAndPath(MOD_ID, name.toLowerCase(Locale.ROOT));
    }
}
