package org.mossimo;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
public class Course {

    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private static int nextId = 1;


    /**
     * Constructor that auto-generates the course ID in format: C-Dxx-yy
     */
    public Course(String courseName, double credits, Department department) {
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;

        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();

        String twoDigit = String.format("%02d", nextId++);
        this.courseId = "C-" + department.getDepartmentId() + "-" + twoDigit;
    }

    /**
     * Checks if all assignment weights sum to 100.
     */
    public boolean isAssignmentWeightValid() {
        double sum = 0;

        for (Assignment a : assignments) {
            sum += a.getWeight();
        }

        return Math.abs(sum - 100) < 0.0001;
    }
}
