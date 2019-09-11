package main.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Objects.isNull;

public class UserInputReader implements Reader {

    private static Reader reader;
    private static Scanner sc;

    private UserInputReader() {
        this.sc = new Scanner(System.in);
    }

    public static Reader getInstance() {
        if(isNull(reader)) {
            reader = new UserInputReader();
        }

        return reader;
    }

    @Override
    public List<String> readValue() {
        List<String> lines = new ArrayList<>();
        while(true) {
            String nextLine = null;
                nextLine = sc.nextLine();
               if ( nextLine.equals("") ) {
                break;
            }
            lines.add(nextLine);
        }
        return lines;
    }
}
