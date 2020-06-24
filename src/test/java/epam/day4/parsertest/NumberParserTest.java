package epam.day4.parsertest;

import com.epam.day4_1.exception.CustomException;
import com.epam.day4_1.parser.NumberParser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class NumberParserTest {

    NumberParser parser;

    @BeforeClass
    public void setUp() {
        parser = new NumberParser();
    }

    @DataProvider(name = "stringNumbers - 2")
    public Object[][] createArrayOfStringNumbers() {
        String[] array = {"123", "475", "958"};
        String[] array1 = {"247", "999", "0"};
        Integer[] parseNumbers = {123, 475, 958};
        Integer[] parseNumbers1 = {247, 999, 0};
        return new Object[][]{{array, parseNumbers}, {array1, parseNumbers1}};
    }

    @Test(dataProvider = "stringNumbers - 2")
    public void parseToIntPositiveTest(String[] stringNumbers, Integer[] expected) {
        Integer[] actual = new Integer[0];
        try {
            actual = parser.parseToInt(stringNumbers);
        } catch (CustomException e) {
            fail();
        }
        assertEquals(actual, expected);
    }

    @Test(enabled = true, expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "parsing issues")
    public void parseToIntNegativeTest() throws CustomException {
        String[] stringNumbers = {"1JH", "HJH", "yre"};
        parser.parseToInt(stringNumbers);
    }
}
