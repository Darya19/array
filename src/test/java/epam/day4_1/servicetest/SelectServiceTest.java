package epam.day4_1.servicetest;

import com.epam.day4_1.entity.IntArray;
import com.epam.day4_1.exception.CustomException;
import com.epam.day4_1.service.SelectService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class SelectServiceTest {
    SelectService service;

    @BeforeClass
    public void setUp() {
        service = new SelectService();
    }

    @DataProvider(name = "array - 2")
    public Object[][] createArray() {
        IntArray array = new IntArray(5);
        array.add(17);
        array.add(176);
        array.add(8);
        array.add(917);
        array.add(299);
        IntArray array1 = new IntArray(4);
        array1.add(187);
        array1.add(7);
        array1.add(31);
        array1.add(99);
        IntArray expectedArray = new IntArray(1);
        expectedArray.set(0, 17);
        IntArray expectedArray1 = new IntArray(2);
        expectedArray1.set(0, 7);
        expectedArray1.set(1, 31);
        return new Object[][]{{array, expectedArray}, {array1, expectedArray1}};
    }

    @Test(dataProvider = "array - 2")
    public void selectPrimeNumbersPositiveTest(IntArray array, IntArray expectedArray) {
        try {
            Optional<IntArray> actualArray = service.selectPrimeNumbers(array);
            assertEquals(actualArray, Optional.of(expectedArray));
        } catch (CustomException e) {
            fail();
        }
    }

    @Test
    public void selectPrimeNumbersEmptyArrayTest() {
        try {
            IntArray array = new IntArray(0);
            Optional<IntArray> actualArray = service.selectPrimeNumbers(array);
            assertEquals(actualArray, Optional.empty());
        } catch (CustomException e) {
            fail();
        }
    }

    @Test
    public void selectPrimeNumbersArrayOfNullElementsTest() {
        try {
            IntArray array = new IntArray(3);
            Optional<IntArray> actualArray = service.selectPrimeNumbers(array);
            assertEquals(actualArray, Optional.empty());
        } catch (CustomException e) {
            fail();
        }
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "array is null")
    public void selectPrimeNumbersArrayIsNullTest() throws CustomException {
        IntArray array = null;
        service.selectPrimeNumbers(array);
    }

    @Test
    public void selectFibonacciNumbersPositiveTest() {
        IntArray array = new IntArray(4);
        array.set(0, 456);
        array.set(1, 987);
        array.set(2, 610);
        array.set(3, 569);
        IntArray expectedArray = new IntArray(2);
        expectedArray.set(0, 987);
        expectedArray.set(1, 610);
        try {
            Optional<IntArray> actualArray = service.selectFibonacciNumbers(array);
            assertEquals(actualArray, Optional.of(expectedArray));
        } catch (CustomException e) {
            fail();
        }
    }

    @Test
    public void selectFibonacciNumbersEmptyArrayTest() {
        try {
            IntArray array = new IntArray(0);
            Optional<IntArray> actualArray = service.selectFibonacciNumbers(array);
            assertEquals(actualArray, Optional.empty());
        } catch (CustomException e) {
            fail();
        }
    }

    @Test
    public void selectFibonacciNumbersArrayOfNullElementsTest() {
        try {
            IntArray array = new IntArray(3);
            Optional<IntArray> actualArray = service.selectFibonacciNumbers(array);
            assertEquals(actualArray, Optional.empty());
        } catch (CustomException e) {
            fail();
        }
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "array is null")
    public void selectFibonacciNumbersArrayIsNullTest() throws CustomException {
        IntArray array = null;
        service.selectFibonacciNumbers(array);
    }

    @Test
    public void findNumbersWithThreeDifferentDigitsPositiveTest() {
        IntArray array = new IntArray(4);
        array.set(0, 455);
        array.set(1, 987);
        array.set(2, 611);
        array.set(3, 566);
        IntArray expectedArray = new IntArray(1);
        expectedArray.set(0, 987);
        try {
            Optional<IntArray> actualArray = service.findNumbersWithThreeDifferentDigits(array);
            assertEquals(actualArray, Optional.of(expectedArray));
        } catch (CustomException e) {
            fail();
        }
    }

    @Test
    public void findNumbersWithThreeDifferentDigitsEmptyArrayTest() {
        try {
            IntArray array = new IntArray(0);
            Optional<IntArray> actualArray = service.findNumbersWithThreeDifferentDigits(array);
            assertEquals(actualArray, Optional.empty());
        } catch (CustomException e) {
            fail();
        }
    }

    @Test
    public void findNumbersWithThreeDifferentDigitsArrayOfNullElementsTest() {
        try {
            IntArray array = new IntArray(3);
            Optional<IntArray> actualArray = service.findNumbersWithThreeDifferentDigits(array);
            assertEquals(actualArray, Optional.empty());
        } catch (CustomException e) {
            fail();
        }
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "array is null")
    public void findNumbersWithThreeDifferentDigitsArrayIsNullTest() throws CustomException {
        IntArray array = null;
        service.findNumbersWithThreeDifferentDigits(array);
    }
}
