package epam.day4.readertest;

import com.epam.day4_1.exception.CustomException;
import com.epam.day4_1.reader.ConsoleReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ConsoleReaderTest {

    ConsoleReader reader;

    @BeforeClass
    public void setUp() {
        reader = new ConsoleReader();
    }

    @Test
    public void readNumbersFromConsolePositiveTest() {
        try {
            String[] actual = reader.readNumbersFromConsole();
            String[] expected = {"2", "25", "17", "33"};
            assertEquals(actual, expected);
        } catch (CustomException e) {
            fail();
        }
    }
}
