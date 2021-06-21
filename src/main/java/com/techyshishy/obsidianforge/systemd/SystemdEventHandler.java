package com.techyshishy.obsidianforge.systemd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import info.faljse.SDNotify.SDNotify;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;

import static com.techyshishy.obsidianforge.systemd.config.Config.sendNotify;

public class SystemdEventHandler {
    
    private static final Logger LOGGER = LogManager.getLogger();

    @SubscribeEvent
    public void serverStarted(FMLServerStartedEvent event){
        if(sendNotify) {
            LOGGER.info("Server initialized.  Notifying systemd");
            SDNotify.sendNotify();
        }
    }
}
