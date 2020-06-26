package epam.day4.creatortest;

import com.epam.day4_1.creator.ArrayCreator;
import com.epam.day4_1.entity.IntArray;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayCreatorTest {

    ArrayCreator creator;

    @BeforeClass
    public void setUp() {
        creator = new ArrayCreator();
    }

    @DataProvider(name = "creating")
    public Object[][] createArrays() {
        int[] values = {12, 49, 0, 999, 1000};
        int[] values1 = {10, 10256, 996, -1};
        int[] values2 = {-10, 1256, -996, 1000};
        IntArray expectedArray = new IntArray(4);
        expectedArray.set(0, 12);
        expectedArray.set(1, 49);
        expectedArray.set(2, 0);
        expectedArray.set(3, 999);
        IntArray expectedArray1 = new IntArray(2);
        expectedArray1.set(0, 10);
        expectedArray1.set(1, 996);
        IntArray expectedArray2 = new IntArray(10);
        return new Object[][]{{values1, expectedArray1}, {values, expectedArray}, {values2, expectedArray2}};
    }

    @Test
    public void fillUpRandomAssertPresentsArray() {
        IntArray actual = creator.fillUpRandom();
        assertNotNull(actual);
    }

    @Test
    public void fillUpRandomAssertArraySizeTest() {
        IntArray actual = creator.fillUpRandom();
        assertTrue(actual.size() <= 10);
    }

    @Test
    public void fillUpRandomAssertNotNullElementsTest() {
        IntArray actual = creator.fillUpRandom();
        assertTrue(actual.numberNotNullElements() == actual.size());
    }

    @Test
    public void fillUpRandomAssertBordersTest() {
        IntArray actual = creator.fillUpRandom();
        assertTrue(actual.getElement(0).getAsInt() >= 0
                && actual.getElement(0).getAsInt() < 1000);
    }

    @Test(dataProvider = "creating")
    public void fillUpFromReaderPositiveTest(int[] valuesForArray, IntArray expectedArray) {
        IntArray actual = creator.fillUpFromReader(valuesForArray);
        assertEquals(actual, expectedArray);
    }
}
