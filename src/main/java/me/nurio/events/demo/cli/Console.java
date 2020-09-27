package me.nurio.events.demo.cli;

import me.nurio.events.EventManager;
import me.nurio.events.demo.Main;
import me.nurio.events.demo.events.ConsoleMessageInputEvent;
import me.nurio.events.demo.events.ConsoleMessageOutputEvent;

import java.io.PrintStream;
import java.util.Scanner;

public class Console extends ConsoleUtils implements IConsole {

    // This eventManager field should be the same instance of which register the listener classes.
    private static EventManager eventManager = Main.getEventManager();

    private Scanner reader = new Scanner(System.in);

    /**
     * Reads a console input message. (Locking process since one received)
     *
     * @return String with terminal inputted text.
     */
    public String readLine() {
        // Read scanner line.
        String line = reader.nextLine();

        // Process line with their event.
        ConsoleMessageInputEvent event = new ConsoleMessageInputEvent(line);
        eventManager.callEvent(event);

        // return event processed line.
        return event.getMessage();
    }

    /**
     * Prints a terminal message.
     *
     * @param line Message to be displayed.
     */
    public void printLog(String line) {
        // Process line with their event.
        ConsoleMessageOutputEvent event = new ConsoleMessageOutputEvent(MessageType.LOG, line);
        eventManager.callEvent(event);

        if (!event.isCancelled()) {
            printMessage(event);
        }
    }

    /**
     * Prints a terminal error message.
     *
     * @param line Message to be displayed.
     */
    public void printError(String line) {
        // Process line with their event.
        ConsoleMessageOutputEvent event = new ConsoleMessageOutputEvent(MessageType.ERROR, line);
        eventManager.callEvent(event);

        if (!event.isCancelled()) {
            printMessage(event);
        }
    }

    /**
     * Prints a terminal message (event-flow skipped).
     *
     * @param line Message to be displayed.
     */
    public void printDebug(String line) {
        System.out.println(line);
    }

    /**
     * Prints event message to terminal.
     *
     * @param event Console message event to print.
     */
    private void printMessage(ConsoleMessageOutputEvent event) {
        // Obtain output print stream from the message type.
        PrintStream printStream = event.getType().getPrinter();

        // Print message.
        printStream.println(event.getMessage());
    }

}