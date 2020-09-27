package me.nurio.events.demo.modules.commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This class manages terminal commands mapping.
 */
public class CommandManager {

    private Map<String, Command> commandMap = new HashMap<>();

    /**
     * Register a command executor.
     *
     * @param commands        Terminal commands to trigger registered command.
     * @param commandExecutor Command class instance to perform command operations.
     */
    public void registerCommand(Command commandExecutor, String... commands) {
        Arrays.stream(commands).forEach(command -> commandMap.put(command, commandExecutor));
    }

    /**
     * Checks if provided command exists.
     *
     * @param command Terminal command to trigger registered command.
     * @return true in case that command was registered. False otherwise.
     */
    public boolean exitsCommand(String command) {
        return commandMap.containsKey(command);
    }

    /**
     * Obtain a command executor from terminal command.
     *
     * @param command Terminal command to trigger registered command.
     * @return Command class instance in case they are registered. null otherwise.
     */
    public Command getCommand(String command) {
        return commandMap.get(command);
    }

}