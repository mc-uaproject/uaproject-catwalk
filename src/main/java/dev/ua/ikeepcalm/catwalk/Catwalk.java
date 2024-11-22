package dev.ua.ikeepcalm.catwalk;

import dev.ua.ikeepcalm.catwalk.rest.GraylistController;
import io.servertap.plugin.api.ServerTapWebserverService;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Catwalk extends JavaPlugin {

    private final Logger logger = getLogger();
    private GraylistController graylistController;

    private ServerTapWebserverService serverTap;

    @Override
    public void onEnable() {
        log("|| C A T W A L K ||");
        log("Enabling Catwalk plugin...");
        try {
            this.serverTap = this.getServer().getServicesManager().load(ServerTapWebserverService.class);
        } catch (Exception e) {
            log("Error enabling Catwalk plugin: " + e.getMessage());
            log("Disabling Catwalk plugin...");
            this.getServer().getPluginManager().disablePlugin(this);
        }

        this.graylistController = new GraylistController(serverTap);
    }

    @Override
    public void onDisable() {
        log("Disabling Catwalk plugin...");
    }

    public void log(String message) {
        logger.info(message);
    }

}
