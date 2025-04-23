package com.euphony.faster_climbing.config;

import com.euphony.faster_climbing.FasterClimbing;
import com.euphony.faster_climbing.utils.ConfigUtils;
import com.google.gson.GsonBuilder;
import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.BooleanControllerBuilder;
import dev.isxander.yacl3.api.controller.DoubleSliderControllerBuilder;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.minecraft.network.chat.Component;

import java.nio.file.Path;
import java.util.List;

public class FasterClimbingConfig {
    public static ConfigClassHandler<FasterClimbingConfig> HANDLER = ConfigClassHandler.createBuilder(FasterClimbingConfig.class)
            .id(FasterClimbing.prefix("config"))
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .appendGsonBuilder(GsonBuilder::setPrettyPrinting)
                    .setPath(Path.of("config", "faster_climbing.json")).build()
            )
            .build();

    public static void load() {
        HANDLER.load();
    }

    public static void save() {
        HANDLER.save();
    }

    private static final String FASTER_CLIMBING_CATEGORY = "faster_climbing";


    @SerialEntry public boolean enableFasterUpward = true;
    @SerialEntry public boolean enableFasterDownward = true;
    @SerialEntry public double speedMultiplier = 2.0D;

    public static YetAnotherConfigLib makeScreen() {
        return YetAnotherConfigLib.create(HANDLER, (defaults, config, builder) -> {
            Option<Boolean> enableFasterUpwardOpt = ConfigUtils.<Boolean>getGenericOption("enableFasterUpward")
                    .binding(defaults.enableFasterUpward,
                            () -> config.enableFasterUpward,
                            newVal -> config.enableFasterUpward = newVal)
                    .controller(opt -> BooleanControllerBuilder.create(opt).trueFalseFormatter())
                    .build();

            Option<Boolean> enableFasterDownwardOpt = ConfigUtils.<Boolean>getGenericOption("enableFasterDownward")
                    .binding(defaults.enableFasterDownward,
                            () -> config.enableFasterDownward,
                            newVal -> config.enableFasterDownward = newVal)
                    .controller(opt -> BooleanControllerBuilder.create(opt).trueFalseFormatter())
                    .build();

            Option<Double> speedMultiplierOpt = ConfigUtils.<Double>getGenericOption("speedMultiplier")
                    .binding(defaults.speedMultiplier,
                            () -> config.speedMultiplier,
                            newVal -> config.speedMultiplier = newVal)
                    .controller(opt -> DoubleSliderControllerBuilder.create(opt)
                            .range(1.0, 10.0).step(0.5))
                    .build();

            return builder
                    .title(Component.translatable("yacl3.config.faster_climbing:config"))
                    .category(ConfigCategory.createBuilder()
                            .name(ConfigUtils.getCategoryName(FASTER_CLIMBING_CATEGORY))
                            .options(List.of(
                                    enableFasterUpwardOpt,
                                    enableFasterDownwardOpt,
                                    speedMultiplierOpt
                            ))
                            .build())
                    .save(FasterClimbingConfig::save);
        });
    }
}
