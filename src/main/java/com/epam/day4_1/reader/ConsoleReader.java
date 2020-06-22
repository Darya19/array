package com.epam.day4.task1.reader;

import com.epam.day4.task1.exception.CustomException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

    private final String REGEX = " ";

    public String[] readNumbersFromConsole() throws CustomException {
        BufferedReader reader = null;
        String[] array = null;
        String s = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            s = reader.readLine(); //TODO Can read only one line?
            reader.close();
            array = s.split(REGEX);
            return array;
        } catch (IOException e) {
            throw new CustomException("incorrect input data", e);
        }
    }
}

