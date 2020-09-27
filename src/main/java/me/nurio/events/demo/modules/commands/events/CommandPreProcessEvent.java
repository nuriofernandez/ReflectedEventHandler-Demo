package me.nurio.events.demo.modules.commands.events;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import me.nurio.events.handler.Event;
import me.nurio.events.handler.EventCancellable;

@RequiredArgsConstructor
public class CommandPreProcessEvent extends Event implements EventCancellable {

    @Getter @Setter private boolean cancelled;

    @NonNull @Getter private String command;

}