package com.github.leser.read;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
@RequiredArgsConstructor
public class ValidationReader {
    private final ConsoleReader consoleReader;

    public String rearInput(Predicate<String> validation) {
        String input;
        do {
            input = consoleReader.readInput();
        } while (!validation.test(input));
        return input;
    }
}
