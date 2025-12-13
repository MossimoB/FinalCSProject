import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;

import org.mossimo.Address;
import org.mossimo.Assignment;
import org.mossimo.Department;
import util.Util;
import java.util.ArrayList;

public class UnitTests {

    // Address Class Tests
    @Test
    @DisplayName("Valid postal code: A1B2C3")
    void testValidPostalCode() {
        String postalCode = "A1B2C3";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Invalid postal code: 123456")
    void testInvalidPostalCode() {
        String postalCode = "123456";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }

    // Department Tests
    @Test
    @DisplayName("Valid department name: Computer Science")
    void testValidDepartmentName() {
        String name = "Computer Science";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(name);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Invalid department name: Math123")
    void testInvalidDepartmentName() {
        String name = "Math123";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(name);

        Assertions.assertEquals(expected, actual);
    }

    // Assignment Tests
    @Test
    @DisplayName("Assignment average calculation")
    void testAssignmentAverage() {
        Assignment assignment = new Assignment("Test Assignment", 50);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(80);
        scores.add(90);
        assignment.setScores(scores);

        double expected = 85.0;
        double actual = assignment.calcAssignmentAvg();

        Assertions.assertEquals(expected, actual);
    }
}
