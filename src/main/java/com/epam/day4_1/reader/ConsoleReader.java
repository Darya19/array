package com.epam.day4_1.reader;

import com.epam.day4_1.exception.CustomException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

    private final String REGEX = " ";

    public String[] readNumbersFromConsole() throws CustomException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String stringLine = reader.readLine();
            return stringLine.split(REGEX);
        } catch (IOException e) {
            throw new CustomException("incorrect input data", e);
        }
    }
}

