package me.nurio.events.demo.events;

import lombok.*;
import me.nurio.events.handler.Event;
import me.nurio.events.handler.EventCancellable;

@Data
@RequiredArgsConstructor
public class ConsoleMessageInputEvent extends Event implements EventCancellable {

    @Getter @Setter private boolean cancelled;

    @NonNull private String message;

}