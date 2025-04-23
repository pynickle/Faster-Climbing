package com.euphony.faster_climbing.client;

import com.euphony.faster_climbing.client.events.FasterClimbingEvent;
import dev.architectury.event.events.common.TickEvent;

public class ClientEvents {
    public static void init() {
        TickEvent.PLAYER_PRE.register(FasterClimbingEvent::playerPre);
    }
}
