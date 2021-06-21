package com.techyshishy.obsidianforge.systemd;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.config.ModConfig.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.FMLNetworkConstants;

import com.techyshishy.obsidianforge.systemd.config.ConfigHelper;
import com.techyshishy.obsidianforge.systemd.config.ConfigHolder;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("obsidianforge-systemd")
public class ObsidianForgeSystemd {

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    
    public ObsidianForgeSystemd() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::configSync);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::dedicatedServerSetup);
        
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigHolder.COMMON_SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.debug("ObsidianForge coming online:  Systemd module");
    }

    private void configSync(final ModConfigEvent event) {
        LOGGER.debug("Config");
        ModConfig config = event.getConfig();
        config.getSpec();
        LOGGER.debug(config.getSpec().toString());
		if (config.getSpec() == ConfigHolder.COMMON_SPEC) {
			ConfigHelper.bakeCommon(config);
		}
    }

    private void dedicatedServerSetup(final FMLDedicatedServerSetupEvent event) {
        LOGGER.debug("Setting up server event handler");
        MinecraftForge.EVENT_BUS.register(new SystemdEventHandler());

        // Server only mod
        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST, () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));
    }
}
