package com.techyshishy.obsidianforge.systemd.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnull;

public class ConfigHolder {
    
	@Nonnull
	public static final ForgeConfigSpec COMMON_SPEC;
	@Nonnull
	static final CommonConfig COMMON;
	static {
		{
			final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
			COMMON = specPair.getLeft();
			COMMON_SPEC = specPair.getRight();
		}
    }
}
