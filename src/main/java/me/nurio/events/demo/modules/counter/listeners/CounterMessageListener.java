package me.nurio.events.demo.modules.counter.listeners;

import me.nurio.events.demo.Main;
import me.nurio.events.demo.cli.Console;
import me.nurio.events.demo.events.ConsoleMessageInputEvent;
import me.nurio.events.handler.EventHandler;
import me.nurio.events.handler.EventListener;

public class CounterMessageListener implements EventListener {

    private static Console console = Main.getConsole();

    @EventHandler
    public void onConsoleOutput(ConsoleMessageInputEvent event) {
        String message = event.getMessage();

        console.printDebug(
            "Message with %d characters has been intercepted by 'CounterMessageListener#onConsoleOutput'.",
            message.length()
        );
    }

}