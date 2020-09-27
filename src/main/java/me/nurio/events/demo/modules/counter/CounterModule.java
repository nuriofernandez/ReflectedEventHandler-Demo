package me.nurio.events.demo.modules.counter;

import me.nurio.events.EventManager;
import me.nurio.events.demo.Main;
import me.nurio.events.demo.modules.Module;
import me.nurio.events.demo.modules.counter.listeners.CounterMessageListener;

public class CounterModule implements Module {

    private static EventManager eventManager = Main.getEventManager();

    /**
     * Necessary logic to initialize the module.
     */
    public static void init() {
        eventManager.registerEvents(new CounterMessageListener());
    }

}