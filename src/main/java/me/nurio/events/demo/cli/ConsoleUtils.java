package me.nurio.events.demo.cli;

public abstract class ConsoleUtils implements IConsole {

    /**
     * Answer user to provide a String value on the terminal.
     * This method will lock the current thread until the user introduce a valid String value.
     *
     * @param message Help message to show to the user to specify what we are requesting.
     * @return String value of the valid introduced input.
     */
    public String answerString(String message) {
        printLog(message);

        String provided = readLine();
        if (!provided.isEmpty()) return provided;

        printError("You have entered an invalid value. Please provide a text.");
        return answerString(message);
    }

    /**
     * Prints a terminal formatted message.
     *
     * @param messageFormat Message format to be displayed.
     * @param messageParams Message params to be replaced at the messageFormat.
     */
    public void printLog(String messageFormat, Object... messageParams) {
        printLog(String.format(messageFormat, messageParams));
    }

    /**
     * Prints a terminal formatted error message.
     *
     * @param messageFormat Message format to be displayed.
     * @param messageParams Message params to be replaced at the messageFormat.
     */
    public void printError(String messageFormat, Object... messageParams) {
        printError(String.format(messageFormat, messageParams));
    }

    /**
     * Prints a terminal formatted debug message.
     *
     * @param messageFormat Message format to be displayed.
     * @param messageParams Message params to be replaced at the messageFormat.
     */
    public void printDebug(String messageFormat, Object... messageParams) {
        printDebug(String.format(messageFormat, messageParams));
    }


}