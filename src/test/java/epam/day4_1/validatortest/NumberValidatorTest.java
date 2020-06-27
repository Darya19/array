package epam.day4_1.validatortest;

import com.epam.day4_1.validator.NumberValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class NumberValidatorTest {

    NumberValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new NumberValidator();
    }

    @Test
    public void validateNumberTrueTest() {
        assertTrue(validator.validateNumber(123));
    }

    @Test
    public void validateNumberLowBorderTrueTest() {
        assertTrue(validator.validateNumber(0));
    }

    @Test
    public void validateNumberHighBorderTrueTest() {
        assertTrue(validator.validateNumber(999));
    }

    @Test
    public void validateNumberFalseTest() {
        assertFalse(validator.validateNumber(1230266));
    }

    @Test
    public void validateNumberLowBorderFalseTest() {
        assertFalse(validator.validateNumber(1000));
    }
}
