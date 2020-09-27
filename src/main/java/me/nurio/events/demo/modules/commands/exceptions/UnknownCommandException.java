package me.nurio.events.demo.modules.commands.exceptions;

public class UnknownCommandException extends Exception {

    private String command;

    public UnknownCommandException(String command) {
        super("Provided command '" + command + "' doesn't have an executor.");
        this.command = command;
    }

}