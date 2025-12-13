import org.mossimo.*;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;

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

    // Course Tests
    @Test
    @DisplayName("Register student to course successfully")
    void testRegisterStudent() {
        Department department = new Department("Math");
        Course course = new Course("Algebra", 3.0, department);

        Address address = new Address(
                10, "Main", "Toronto",
                Address.Province.ON, "A1B2C3"
        );

        Student student = new Student(
                "Alice",
                Student.Gender.FEMALE,
                address,
                department
        );

        boolean expected = true;
        boolean actual = course.registerStudent(student);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Assignment weights sum to 100")
    void testAssignmentWeightValid() {
        Department department = new Department("Computer Science");
        Course course = new Course("Programming", 3.0, department);

        course.addAssignment("Quiz", 20, 100);
        course.addAssignment("Midterm", 30, 100);
        course.addAssignment("Final", 50, 100);

        boolean expected = true;
        boolean actual = course.isAssignmentWeightValid();

        Assertions.assertEquals(expected, actual);
    }


    // Util Tests
    @Test
    @DisplayName("Convert string to Title Case")
    void testToTitleCase() {
        String input = "computer science AND math";
        String expected = "Computer Science And Math";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected, actual);
    }
}
