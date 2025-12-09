package org.mossimo;

import lombok.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import java.util.ArrayList;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1;

    public enum Gender {
      MALE, FEMALE
    }

    /**
     * Constructor with name, gender, address, and department
     * Automaticlaly generates studentId and initializes registeredCourses list
     */
    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("S%06d", nextId++);
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    /**
     * Registers a course for the student
     * Adds student to course's registeredStudents list
     * Appends null for each assignment score
     * @param course is the course to register
     * @return true if successfully registered, false if already registered
     */
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }
    
        registeredCourses.add(course);
        course.registerStudent(this);
    
        for (Assignment a : course.getAssignments()) {
            a.getScores().add(null);
        }
    
        return true;
    }

    /**
     * Drops a course for the student
     * Removes student from course's registeredStudents list
     * @param course is the course to drop
     * @return true if successfully dropped, false if not registered
     */
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);

        for (Assignment a : course.getAssignments()) {
            int index = course.getRegisteredStudents().indexOf(this);

            if (index >= 0 && index < a.getScores().size()) {
                a.getScores().remove(index);
            }
        }

        return true;
    }

    /**
     * Converts student to a simplified string (studentId, studentName, departmentName)
     * @return the simplified string
     */
    public String toSimplifiedString() {
        String deptName = (department != null) ? department.getDepartmentName() : "N/A";
        return studentId + " - " + studentName + " (" + deptName + ")";
    }
}
