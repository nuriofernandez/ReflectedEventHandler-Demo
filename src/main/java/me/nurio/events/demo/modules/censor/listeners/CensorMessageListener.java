package me.nurio.events.demo.modules.censor.listeners;

import me.nurio.events.demo.Main;
import me.nurio.events.demo.cli.Console;
import me.nurio.events.demo.events.ConsoleMessageOutputEvent;
import me.nurio.events.demo.modules.censor.WordCensor;
import me.nurio.events.handler.EventHandler;
import me.nurio.events.handler.EventListener;

public class CensorMessageListener implements EventListener {

    private static Console console = Main.getConsole();

    @EventHandler
    public void onConsoleOutput(ConsoleMessageOutputEvent event) {
        String message = event.getMessage();

        if (WordCensor.containsCensoredWords(message)) {
            // Censor the banned words from the message
            String censoredMessage = WordCensor.censor(message);
            event.setMessage(censoredMessage);

            // Sent a warning message to the sender user.
            console.printDebug("Console *OUTPUT* message has been censored by 'CensorMessageListener#onConsoleOutput'.");
        }
    }

}