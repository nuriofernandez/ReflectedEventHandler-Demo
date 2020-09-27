package me.nurio.events.demo.modules.commands.listeners;

import me.nurio.events.EventManager;
import me.nurio.events.demo.Main;
import me.nurio.events.demo.cli.Console;
import me.nurio.events.demo.events.ConsoleMessageInputEvent;
import me.nurio.events.demo.modules.commands.CommandManager;
import me.nurio.events.demo.modules.commands.CommandsModule;
import me.nurio.events.demo.modules.commands.exceptions.UnknownCommandException;
import me.nurio.events.handler.EventHandler;
import me.nurio.events.handler.EventListener;
import me.nurio.events.handler.EventPriority;

public class CommandsMessageListener implements EventListener {

    private static Console console = Main.getConsole();
    private static EventManager eventManager = Main.getEventManager();

    private static CommandManager commandManager = CommandsModule.getCommandManager();

    @EventHandler(priority = EventPriority.MONITOR)
    public void onMessage(ConsoleMessageInputEvent event) {
        // Stop execution flow if message is not a command.
        if (!event.getMessage().startsWith("/")) return;

        // Cause it's a command, cancel the message event.
        event.setCancelled(true);

        String command = event.getMessage().substring(1);
        if (!commandManager.exitsCommand(command)) {
            console.printError("Unknown command. Intercepted at 'CommandsMessageListener#onMessage'.");
            return;
        }

        try {
            CommandsModule.runCommand(command);
        } catch (UnknownCommandException e) {
            console.printError("Unknown command. Throw at 'CommandsMessageListener#onMessage'.");
            e.printStackTrace();
        }
    }

}