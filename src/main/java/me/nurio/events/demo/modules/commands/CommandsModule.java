package me.nurio.events.demo.modules.commands;

import lombok.Getter;
import me.nurio.events.EventManager;
import me.nurio.events.demo.Main;
import me.nurio.events.demo.cli.Console;
import me.nurio.events.demo.modules.Module;
import me.nurio.events.demo.modules.commands.cmds.ToggleDebugCommand;
import me.nurio.events.demo.modules.commands.events.CommandPreProcessEvent;
import me.nurio.events.demo.modules.commands.exceptions.UnknownCommandException;
import me.nurio.events.demo.modules.commands.listeners.CommandsMessageListener;

public class CommandsModule implements Module {

    private static Console console = Main.getConsole();
    private static EventManager eventManager = Main.getEventManager();

    @Getter private static CommandManager commandManager = new CommandManager();

    /**
     * Necessary logic to initialize the module.
     */
    public static void init() {
        // Register toggle debug command
        commandManager.registerCommand(new ToggleDebugCommand(), "debug", "toggledebug", "debugtoggle");

        // Register listeners
        eventManager.registerEvents(new CommandsMessageListener());
    }

    /**
     * Executes command operation.
     *
     * @param command Command used by user at the terminal.
     */
    public static void runCommand(String command) throws UnknownCommandException {
        // Assert command exists.
        if (!commandManager.exitsCommand(command)) {
            throw new UnknownCommandException(command);
        }

        // Call CommandPreProcessEvent before executing the event.
        CommandPreProcessEvent processEvent = new CommandPreProcessEvent(command);
        eventManager.callEvent(processEvent);

        // Execute command in case CommandPreProcessEvent was not cancelled.
        if (!processEvent.isCancelled()) {
            Command commandExecutor = commandManager.getCommand(command);
            commandExecutor.execute(command);
        }
    }

    /**
     * Checks if provided command exists.
     *
     * @param command Terminal command to trigger registered command.
     * @return true in case that command was registered. False otherwise.
     */
    public static boolean existsCommand(String command) {
        return commandManager.exitsCommand(command);
    }

}