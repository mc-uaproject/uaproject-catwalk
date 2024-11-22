package dev.ua.ikeepcalm.catwalk.rest;

import dev.ua.ikeepcalm.catwalk.api.graylist.GraylistUpdateEvent;
import io.servertap.plugin.api.ServerTapWebserverService;
import org.bukkit.Bukkit;

public class GraylistController {

    private final ServerTapWebserverService service;

    public GraylistController(ServerTapWebserverService service) {
        this.service = service;
        grantPermission();
        revokePermission();
    }

    public void grantPermission() {
        service.post("/graylist/grant/<username>", context -> {
            String username = context.pathParam("username");
            if (username == null || username.isEmpty()) {
                context.status(400);
                context.result("Username is required. Please provide a username.");
            } else {
                GraylistUpdateEvent event = new GraylistUpdateEvent(username, true);
                Bukkit.getPluginManager().callEvent(event);
                context.status(200);
                context.result("Permission granted for " + username);
            }
        });
    }

    public void revokePermission() {
        service.post("/graylist/revoke/<username>", context -> {
            String username = context.pathParam("username");
            if (username == null || username.isEmpty()) {
                context.status(400);
                context.result("Username is required. Please provide a username.");
            } else {
                GraylistUpdateEvent event = new GraylistUpdateEvent(username, false);
                Bukkit.getPluginManager().callEvent(event);
                context.status(200);
                context.result("Permission revoked for " + username);
            }
        });
    }

}
