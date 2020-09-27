package me.nurio.events.demo.modules.censor;

import java.util.Arrays;
import java.util.List;

public class WordCensor {

    private static final String CENSORED_MARK = "****";
    private static List<String> censoredWords = Arrays.asList("retard", "fuck");

    public static String censor(String message) {
        for (String word : censoredWords) {
            message = message.replaceAll(word, CENSORED_MARK);
        }
        return message;
    }

    public static boolean containsCensoredWords(String message) {
        return censoredWords.stream()
            .anyMatch(message::contains);
    }

}