package epam.day4_2.servicetest;

import com.epam.day4_2.exception.ProjectException;
import com.epam.day4_2.service.JaggetArrayService;
import com.epam.day4_2.typesort.TypeOfSort;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class JaggetArrayServiceTest {

    JaggetArrayService service;

    @BeforeClass
    public void setUp() {
        service = new JaggetArrayService();
    }

    @DataProvider(name = "array - 1")
    public Object[][] createMatrix() {
        int[][] array = {{1, 2, 30}, {-85, 78902}, {14, 189, 12, 852}, {989, 852, 423, 129, 741}};
        return new Object[][]{{array}};
    }

    @Test(dataProvider = "array - 1")
    public void ascendingSortBySumOfElementsPositiveTes(int[][] array) {
        try {
            int[][] actual = service.ascendingSort(array, TypeOfSort.SUM_ELEMENTS);
            int[][] expected = {{1, 2, 30}, {14, 189, 12, 852}, {989, 852, 423, 129, 741}, {-85, 78902}};
            assertEquals(actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test(dataProvider = "array - 1")
    public void ascendingSortMaxElementPositiveTest(int[][] array) {
        try {
            int[][] actual = service.ascendingSort(array, TypeOfSort.MAX_ELEMENT);
            int[][] expected = {{1, 2, 30}, {14, 189, 12, 852}, {989, 852, 423, 129, 741}, {-85, 78902}};
            assertEquals(actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test(dataProvider = "array - 1")
    public void ascendingSortMinElementPositiveTest(int[][] array) {
        try {
            int[][] actual = service.ascendingSort(array, TypeOfSort.MIN_ELEMENT);
            int[][] expected = {{-85, 78902}, {1, 2, 30}, {14, 189, 12, 852}, {989, 852, 423, 129, 741}};
            assertEquals(actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test
    public void ascendingSortMinElementEmptyArrayPositiveTest() {
        int[][] emptyArray = {};
        try {
            int[][] actual = service.ascendingSort(emptyArray, TypeOfSort.MIN_ELEMENT);
            int[][] expected = {};
            assertEquals(actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test(expectedExceptions = ProjectException.class)
    public void ascendingSortNegativeTest() throws ProjectException {
        int[][] emptyArray = null;
        service.ascendingSort(emptyArray, TypeOfSort.SUM_ELEMENTS);
    }

    @Test(dataProvider = "array - 1")
    public void descendingSortBySumOfElementsPositiveTes(int[][] array) {
        try {
            int[][] actual = service.descendingSort(array, TypeOfSort.SUM_ELEMENTS);
            int[][] expected = {{-85, 78902}, {989, 852, 423, 129, 741}, {14, 189, 12, 852}, {1, 2, 30}};
            assertEquals(actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test(dataProvider = "array - 1")
    public void descendingSortMaxElementPositiveTest(int[][] array) {
        try {
            int[][] actual = service.descendingSort(array, TypeOfSort.MAX_ELEMENT);
            int[][] expected = {{-85, 78902}, {989, 852, 423, 129, 741}, {14, 189, 12, 852}, {1, 2, 30}};
            assertEquals(actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test(dataProvider = "array - 1")
    public void descendingSortMinElementPositiveTest(int[][] array) {
        try {
            int[][] actual = service.descendingSort(array, TypeOfSort.MIN_ELEMENT);
            int[][] expected = {{989, 852, 423, 129, 741}, {14, 189, 12, 852}, {1, 2, 30}, {-85, 78902}};
            assertEquals(actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test
    public void descendingSortSumElementEmptyArrayPositiveTest() {
        int[][] emptyArray = {};
        try {
            int[][] actual = service.descendingSort(emptyArray, TypeOfSort.SUM_ELEMENTS);
            int[][] expected = {};
            assertEquals(actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test(expectedExceptions = ProjectException.class)
    public void descendingSortNegativeTest() throws ProjectException {
        int[][] emptyArray = null;
        service.descendingSort(emptyArray, TypeOfSort.SUM_ELEMENTS);
    }
}
