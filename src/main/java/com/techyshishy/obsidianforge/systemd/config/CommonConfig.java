package com.techyshishy.obsidianforge.systemd.config;

import javax.annotation.Nonnull;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {

    @Nonnull
	final ForgeConfigSpec.BooleanValue sendNotify;
    @Nonnull
	final ForgeConfigSpec.BooleanValue sendMainPid;

    CommonConfig(@Nonnull final ForgeConfigSpec.Builder builder) {
        builder.push("general");
        sendNotify =  builder
        .comment("If sd_notify() should be called on server load")
        .translation("obsidianforge-systemd.config.sendNotify")
        .define("sendNotify", true);
        sendMainPid =  builder
        .comment("If we should send the pid of the java process to systemd on initialization.  Can help with forking type systems")
        .translation("obsidianforge-systemd.config.sendMainPid")
        .define("sendMainPid", false);
        
		builder.pop();
    }
}
