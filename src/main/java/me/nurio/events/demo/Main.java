package me.nurio.events.demo;

import lombok.Getter;
import me.nurio.events.EventManager;
import me.nurio.events.demo.modules.censor.CensorModule;
import me.nurio.events.demo.modules.commands.CommandsModule;
import me.nurio.events.demo.cli.Console;
import me.nurio.events.demo.cli.ConsoleLineInterface;
import me.nurio.events.demo.modules.counter.CounterModule;

public class Main {

    @Getter private static EventManager eventManager = new EventManager();

    @Getter private static Console console = new Console();

    public static void main(String[] args) {
        // Initialize modules. (They can register events)
        CommandsModule.init();
        CounterModule.init();
        CensorModule.init();

        // Welcome message
        console.printLog("Welcome to the ReflectedEventHandler demo!");
        console.printLog(" ");
        console.printLog("What to do?");
        console.printLog(" ");
        console.printLog("- Write anything on the terminal.");
        console.printLog("- Write '/debug' on the terminal.");
        console.printLog(" ");
        console.printLog("Enjoy events!");
        console.printLog(" ");

        // Init CLI
        ConsoleLineInterface.startListeningMessages();
    }

}