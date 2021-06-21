package com.techyshishy.obsidianforge.systemd.config;

import javax.annotation.Nonnull;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {

    @Nonnull
	final ForgeConfigSpec.BooleanValue sendNotify;

    CommonConfig(@Nonnull final ForgeConfigSpec.Builder builder) {
        builder.push("general");
        sendNotify =  builder
        .comment("If sd_notify() should be called on server load")
        .translation("obsidianforge-systemd.config.sendNotify")
        .define("sendNotify", true);
        
		builder.pop();
    }
}
