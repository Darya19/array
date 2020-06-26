package epam.day4.servicetest;

import com.epam.day4_1.entity.IntArray;
import com.epam.day4_1.exception.CustomException;
import com.epam.day4_1.service.SearchService;
import com.epam.day4_1.service.SortService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Optional;
import java.util.OptionalInt;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class SearchServiceTest {

    SearchService service;

    @BeforeClass
    public void setUp() {
        service = new SearchService();
    }

    @DataProvider(name = "array - 2")
    public Object[][] createArray() {
        IntArray array = new IntArray(5);
        array.add(1);
        array.add(176);
        array.add(426);
        array.add(917);
        array.add(299);
        IntArray array1 = new IntArray(4);
        array1.add(187);
        array1.add(276);
        array1.add(1);
        array1.add(176);
        return new Object[][]{{array, 1}, {array1, 3}};
    }

    @Test(dataProvider = "array - 2")
    public void binarySearchPositiveTest(IntArray array, int expectedPosition) {
        try{
        Optional<Integer> actualPosition = service.binarySearch(array, 0, array.size(),176);
        assertEquals(actualPosition, Optional.of(expectedPosition));
        } catch (CustomException e) {
            fail();
        }
    }
    @Test
    public void binarySearchEmptyArrayTest() {
        try {
        IntArray array = new IntArray(0);
            Optional<Integer> actualPosition = service.binarySearch(array, 0, array.size(), 178);
        assertEquals(actualPosition, Optional.empty());
        } catch (CustomException e) {
            fail();
        }
    }

    @Test
    public void binarySearchArrayOfNullElementsTest() {
        try{
        IntArray array = new IntArray(3);
       Optional<Integer> actualPosition = service.binarySearch(array, 0, array.size(), 178);
        assertEquals(actualPosition, Optional.empty());
        } catch (CustomException e) {
            fail();
        }
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "array is null")
    public void binarySearchArrayIsNullTest() throws CustomException {
        IntArray array = null;
        service.binarySearch(array, 0, 5, 145);
    }

    @Test
    public void searchMinElementPositiveTest() {
        try {
                    IntArray array = new IntArray(3);
        array.set(0, 145);
        array.set(1, 351);
        array.set(2, 7);
        Optional<Integer> actualPosition = service.searchMinElement(array);
        assertEquals(actualPosition, Optional.of(7));
        } catch (CustomException e) {
            fail();
        }
    }
    @Test
    public void searchMinElementEmptyArrayTest() {
        try {
                IntArray array = new IntArray(0);
        Optional<Integer> actualPosition = service.searchMinElement(array);
        assertEquals(actualPosition, Optional.empty());
        } catch (CustomException e) {
            fail();
        }
    }

    @Test
    public void searchMinElementArrayOfNullElementsTest() {
        try{
        IntArray array = new IntArray(3);
        Optional<Integer> actualPosition = service.searchMinElement(array);
        assertEquals(actualPosition, Optional.empty());
        } catch (CustomException e) {
            fail();
        }
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "array is null")
    public void searchMinElementArrayIsNullTest() throws CustomException {
        IntArray array = null;
        service.searchMinElement(array);
    }

    @Test
    public void searchMaxElementPositiveTest() {
        try {
            IntArray array = new IntArray(3);
            array.set(0, 145);
            array.set(1, 351);
            array.set(2, 7);
            Optional<Integer> actualPosition = service.searchMaxElement(array);
            assertEquals(actualPosition, Optional.of(351));
        } catch (CustomException e) {
            fail();
        }
    }
    @Test
    public void searchMaxElementEmptyArrayTest() {
        try {
            IntArray array = new IntArray(0);
            Optional<Integer> actualPosition = service.searchMaxElement(array);
            assertEquals(actualPosition, Optional.empty());
        } catch (CustomException e) {
            fail();
        }
    }

    @Test
    public void searchMaxElementArrayOfNullElementsTest() {
        try{
            IntArray array = new IntArray(3);
            Optional<Integer> actualPosition = service.searchMinElement(array);
            assertEquals(actualPosition, Optional.empty());
        } catch (CustomException e) {
            fail();
        }
    }

    @Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = "array is null")
    public void searchMaxElementArrayIsNullTest() throws CustomException {
        IntArray array = null;
        service.searchMinElement(array);
    }
}
