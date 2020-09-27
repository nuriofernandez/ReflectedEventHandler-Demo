package me.nurio.events.demo.modules.censor;

import me.nurio.events.EventManager;
import me.nurio.events.demo.Main;
import me.nurio.events.demo.modules.Module;
import me.nurio.events.demo.modules.censor.listeners.CensorMessageListener;

public class CensorModule implements Module {

    private static EventManager eventManager = Main.getEventManager();

    /**
     * Necessary logic to initialize the module.
     */
    public static void init() {
        eventManager.registerEvents(new CensorMessageListener());
    }

}