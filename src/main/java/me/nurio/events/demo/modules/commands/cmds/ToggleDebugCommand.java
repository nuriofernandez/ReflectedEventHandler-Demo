package me.nurio.events.demo.modules.commands.cmds;

import me.nurio.events.EventManager;
import me.nurio.events.demo.Main;
import me.nurio.events.demo.cli.Console;
import me.nurio.events.demo.modules.commands.Command;

public class ToggleDebugCommand implements Command {

    private static Console console = Main.getConsole();
    private static EventManager eventManager = Main.getEventManager();

    /**
     * Executes command operation.
     *
     * @param command Command used by user at the terminal.
     */
    @Override
    public void execute(String command) {
        boolean status = !eventManager.isDebugLoggingEnabled();
        eventManager.setDebugLoggingEnabled(status);

        String statusName = status ? "enabled" : "disabled";
        console.printDebug("Event reflection debugs has been %s.", statusName);
    }

}