package com.euphony.faster_climbing.utils;

import com.euphony.faster_climbing.FasterClimbing;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class ConfigUtils {
    public static <T> Option.Builder<T> getGenericOption(String name) {
        return Option.<T>createBuilder()
                .name(getOptionName(name))
                .description(OptionDescription.createBuilder()
                        .text(getDesc(name))
                        .build()
                );
    }

    public static Component getCategoryName(String category) {
        return Component.translatable(String.format("yacl3.config.%s:config.category.%s",  FasterClimbing.MOD_ID, category));
    }

    public static Component getGroupName(String category, String group) {
        return Component.translatable(String.format("yacl3.config.%s:config.category.%s.group.%s", FasterClimbing.MOD_ID, category, group));
    }

    private static Component getOptionName(String option) {
        return Component.translatable(String.format("yacl3.config.%s:config.%s", FasterClimbing.MOD_ID, option));
    }

    private static Component getDesc(String option) {
        MutableComponent component = Component.translatable(String.format("yacl3.config.%s:config.%s.desc", FasterClimbing.MOD_ID, option));
        return component;
    }
}
