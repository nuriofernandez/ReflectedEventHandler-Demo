package me.nurio.events.demo.cli;

public interface IConsole {

    /**
     * Reads a console input message. (Locking process since one received)
     *
     * @return String with terminal inputted text.
     */
    String readLine();

    /**
     * Prints a terminal message.
     *
     * @param line Message to be displayed.
     */
    void printLog(String line);

    /**
     * Prints a terminal error message.
     *
     * @param line Message to be displayed.
     */
    void printError(String line);

    /**
     * Prints a terminal message (event-flow skipped).
     *
     * @param line Message to be displayed.
     */
    void printDebug(String line);

}