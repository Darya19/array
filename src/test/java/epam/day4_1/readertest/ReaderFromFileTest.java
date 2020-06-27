package epam.day4_1.readertest;

import com.epam.day4_1.exception.CustomException;
import com.epam.day4_1.reader.ReaderFromFile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ReaderFromFileTest {

    ReaderFromFile reader;

    @BeforeClass
    public void setUp() {
        reader = new ReaderFromFile();
    }

    @Test
    public void readNumbersFromActualFilePositiveTest() {
        try {
            String[] actual = reader.readFromFile("data\\arrayData.txt");
            String[] expected = {"5", "2", "3", "4", "5", "6"};
            assertEquals(actual, expected);
        } catch (CustomException e) {
            fail();
        }
    }

    @Test
    public void readNumbersFromDefaultFilePositiveTest() {
        try {
            String[] actual = reader.readFromFile("data\\rrayData.txt");
            String[] expected = {"5", "12", "145", "269", "756", "102"};
            assertEquals(actual, expected);
        } catch (CustomException e) {
            fail();
        }
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "reading issues")
    public void readNumbersFromFileNegativeTest() throws CustomException {
        reader.readFromFile("data\\data.mp3");
    }
}
