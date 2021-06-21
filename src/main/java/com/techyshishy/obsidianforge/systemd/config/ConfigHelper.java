package com.techyshishy.obsidianforge.systemd.config;

import static com.techyshishy.obsidianforge.systemd.config.Config.sendNotify;
import static com.techyshishy.obsidianforge.systemd.config.Config.sendMainPid;

import net.minecraftforge.fml.config.ModConfig;

public final class ConfigHelper {

    public static void bakeCommon(final ModConfig config) {
        sendNotify = ConfigHolder.COMMON.sendNotify.get();
        sendMainPid = ConfigHolder.COMMON.sendMainPid.get();
    }

}
