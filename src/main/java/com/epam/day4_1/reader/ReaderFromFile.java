package com.epam.day4.task1.reader;

import com.epam.day4.task1.exception.CustomException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReaderFromFile {

    private static final String DEFAULT_FILE = "C:\\Users\\admin\\IdeaProjects\\array\\src\\main\\resources\\defaultFile.txt";
    private final String REGEX = " ";

    public String[] readFromFile(String file) throws CustomException {
        BufferedReader reader = null;
        String s = null;
        String[] array = null;
        Path path = Paths.get(file);
        if (Files.notExists(path)) {
            path = Paths.get(DEFAULT_FILE);
        }
        try {
            reader = Files.newBufferedReader(path);
            s = reader.readLine();  //TODO Can read only one line?
            array = s.split(REGEX);
            reader.close();
            return array;
        } catch (IOException e) {
            throw new CustomException("reading issues", e);

        }
    }
}
