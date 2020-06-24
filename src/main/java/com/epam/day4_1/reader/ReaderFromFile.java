package com.epam.day4_1.reader;

import com.epam.day4_1.exception.CustomException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReaderFromFile {

    private static final String DEFAULT_FILE = "data\\defaultFile.txt";
    private final String REGEX = " ";

    public String[] readFromFile(String file) throws CustomException {
        Path path = Paths.get(file);
        if (Files.notExists(path)) {
            path = Paths.get(DEFAULT_FILE);
        }
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String stringLine = reader.readLine();
            String[] array = stringLine.split(REGEX);
            return array;
        } catch (IOException e) {
            throw new CustomException("reading issues", e);
        }
    }
}
