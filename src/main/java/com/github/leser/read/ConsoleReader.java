package com.github.leser.read;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleReader {
    public String readInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
