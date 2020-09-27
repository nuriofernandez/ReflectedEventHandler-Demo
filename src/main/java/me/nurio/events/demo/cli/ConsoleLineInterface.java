package me.nurio.events.demo.cli;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import me.nurio.events.demo.Main;

@NoArgsConstructor
public class ConsoleLineInterface {

    private static Console console = Main.getConsole();

    @SneakyThrows
    public static void startListeningMessages() {
        while (true) {
            Thread.sleep(1000);
            String message = console.answerString("Insert your message:");
            console.printLog("ECHO: %s", message); // Default behavior, this can be moved to a listener.
        }
    }

}