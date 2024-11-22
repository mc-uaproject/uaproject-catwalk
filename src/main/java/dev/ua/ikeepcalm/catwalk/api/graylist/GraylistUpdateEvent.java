package dev.ua.ikeepcalm.catwalk.api.graylist;

import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@Getter
public class GraylistUpdateEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final String playerName;
    private final boolean granted;


    public GraylistUpdateEvent(String playerName, boolean granted) {
        this.playerName = playerName;
        this.granted = granted;
    }


    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}

