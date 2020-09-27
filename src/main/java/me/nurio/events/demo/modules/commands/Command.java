package me.nurio.events.demo.modules.commands;

/**
 * This class represents a generic command.
 */
public interface Command {

    /**
     * Executes command operation.
     *
     * @param command Command used by user at the terminal.
     */
    void execute(String command);

}