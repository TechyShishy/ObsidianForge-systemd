package com.techyshishy.obsidianforge.systemd;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.FMLNetworkConstants;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("obsidianforge-systemd")
public class ObsidianForgeSystemd {

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    
    public ObsidianForgeSystemd() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::dedicatedServerSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.debug("ObsidianForge coming online:  Systemd module");
    }
    private void dedicatedServerSetup(final FMLDedicatedServerSetupEvent event) {
        LOGGER.debug("Setting up server event handler");
        MinecraftForge.EVENT_BUS.register(new SystemdEventHandler());

        // Server only mod
        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST, () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));
    }
}
