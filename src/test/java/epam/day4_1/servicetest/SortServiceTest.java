package epam.day4_1.servicetest;

import com.epam.day4_1.entity.IntArray;
import com.epam.day4_1.exception.CustomException;
import com.epam.day4_1.service.SortService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class SortServiceTest {

    SortService service;

    @BeforeClass
    public void setUp() {
        service = new SortService();
    }

    @DataProvider(name = "array - 2")
    public Object[][] createArray() {
        IntArray array = new IntArray(5);
        array.add(17);
        array.add(176);
        array.add(426);
        array.add(917);
        array.add(299);
        IntArray array1 = new IntArray(4);
        array1.add(187);
        array1.add(276);
        array1.add(1);
        array1.add(99);
        IntArray expectedArray = new IntArray(5);
        expectedArray.set(0, 17);
        expectedArray.set(1, 176);
        expectedArray.set(2, 299);
        expectedArray.set(3, 426);
        expectedArray.set(4, 917);
        IntArray expectedArray1 = new IntArray(4);
        expectedArray1.set(0, 1);
        expectedArray1.set(1, 99);
        expectedArray1.set(2, 187);
        expectedArray1.set(3, 276);
        return new Object[][]{{array, expectedArray}, {array1, expectedArray1}};
    }

    @Test(dataProvider = "array - 2")
    public void bubbleSortPositiveTest(IntArray array, IntArray expectedArray) {
        try {
            Optional<IntArray> actualArray = service.bubbleSort(array);
            assertEquals(actualArray, Optional.of(expectedArray));
        } catch (CustomException e) {
            fail();
        }
    }

    @Test
    public void bubbleSortEmptyArrayTest() {
        try {
            IntArray array = new IntArray(0);
            Optional<IntArray> actualArray = service.bubbleSort(array);
            assertEquals(actualArray, Optional.empty());
        } catch (CustomException e) {
            fail();
        }
    }

    @Test
    public void bubbleSortArrayOfNullElementsTest() {
        try {
            IntArray array = new IntArray(3);
            Optional<IntArray> actualArray = service.bubbleSort(array);
            assertEquals(actualArray, Optional.empty());
        } catch (CustomException e) {
            fail();
        }
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "array is null")
    public void bubbleSortArrayIsNullTest() throws CustomException {
        IntArray array = null;
        service.bubbleSort(array);
    }

    @Test(dataProvider = "array - 2")
    public void shuttleSortPositiveTest(IntArray array, IntArray expectedArray) {
        try {
            Optional<IntArray> actualArray = service.shuttleSort(array);
            assertEquals(actualArray, Optional.of(expectedArray));
        } catch (CustomException e) {
            fail();
        }
    }

    @Test
    public void shuttleSortEmptyArrayTest() {
        try {
            IntArray array = new IntArray(0);
            Optional<IntArray> actualArray = service.shuttleSort(array);
            assertEquals(actualArray, Optional.empty());
        } catch (CustomException e) {
            fail();
        }
    }

    @Test
    public void shuttleSortArrayOfNullElementsTest() {
        try {
            IntArray array = new IntArray(3);
            Optional<IntArray> actualArray = service.shuttleSort(array);
            assertEquals(actualArray, Optional.empty());
        } catch (CustomException e) {
            fail();
        }
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "array is null")
    public void shuttleSortArrayIsNullTest() throws CustomException {
        IntArray array = null;
        service.shuttleSort(array);
    }

    @Test(dataProvider = "array - 2")
    public void insertionSortPositiveTest(IntArray array, IntArray expectedArray) {
        try {
            Optional<IntArray> actualArray = service.insertionSort(array);
            assertEquals(actualArray, Optional.of(expectedArray));
        } catch (CustomException e) {
            fail();
        }
    }

    @Test
    public void insertionSortEmptyArrayTest() {
        try {
            IntArray array = new IntArray(0);
            Optional<IntArray> actualArray = service.insertionSort(array);
            assertEquals(actualArray, Optional.empty());
        } catch (CustomException e) {
            fail();
        }
    }

    @Test
    public void insertionSortArrayOfNullElementsTest() {
        try {
            IntArray array = new IntArray(3);
            Optional<IntArray> actualArray = service.insertionSort(array);
            assertEquals(actualArray, Optional.empty());
        } catch (CustomException e) {
            fail();
        }
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "array is null")
    public void insertionSortArrayIsNullTest() throws CustomException {
        IntArray array = null;
        service.insertionSort(array);
    }
}
