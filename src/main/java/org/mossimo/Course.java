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

    /**
     * Registers a student into the course.
     * Adds the student to registeredStudents and adds a null score placeholder
     * to each assignment.
     */
    public boolean registerStudent(Student student) {

        if (registeredStudents.contains(student)) {
            return false;
        }

        registeredStudents.add(student);

        // Add null placeholder for this student in every assignment
        for (Assignment a : assignments) {
            a.getScores().add(null);
        }

        return true;
    }

    /**
     * Adds a new assignment to the course.
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {

        Assignment newAssign = new Assignment(assignmentName, weight);

        // Add null for each existing student
        for (int i = 0; i < registeredStudents.size(); i++) {
            newAssign.getScores().add(null);
        }

        assignments.add(newAssign);
        return true;
    }

    /**
     * Generates random scores for every assignment and student.
     */
    public void generateScores() {
        for (Assignment a : assignments) {
            a.generateRandomScore();
        }
    }

    /**
     * Calculates each student's weighted average.
     */
    public int[] calcStudentsAverage() {
        int[] results = new int[registeredStudents.size()];

        for (int s = 0; s < registeredStudents.size(); s++) {

            double total = 0;

            for (Assignment a : assignments) {
                Integer score = a.getScores().get(s);

                if (score != null) {
                    total += score * (a.getWeight() / 100);
                }
            }

            results[s] = (int) Math.round(total);
        }

        return results;
    }

    /**
     * Displays the scores table for the course.
     */
    public void displayScores() {

        System.out.println("Course: " + courseName + " (" + courseId + ")");

        // Header row
        String header = "                ";
        for (Assignment a : assignments) {
            header += a.getAssignmentName() + "   ";
        }
        header += "Final Score";
        System.out.println(header);

        int[] finalScores = calcStudentsAverage();

        // Student rows
        for (int i = 0; i < registeredStudents.size(); i++) {
            Student s = registeredStudents.get(i);

            String row = s.getStudentName();
            while (row.length() < 18) {
                row += " ";
            }

            for (Assignment a : assignments) {
                Integer sc = a.getScores().get(i);
                row += sc + "            ";
            }

            row += finalScores[i];

            System.out.println(row);
        }

        // Averages row
        String avgRow = "Average          ";
        for (Assignment a : assignments) {
            avgRow += (int) Math.round(a.calcAssignmentAvg()) + "            ";
        }

        System.out.println(avgRow);
    }

    /**
     * Returns a simplified version of the course.
     */
    public String toSimplifiedString() {
        return courseId + " - " + courseName + " - " + credits + " - " + department.getDepartmentName();
    }

    @Override
    public String toString() {
        String text = "Course ID: " + courseId +
                "\nCourse Name: " + courseName +
                "\nCredits: " + credits +
                "\nDepartment: " + department.getDepartmentName() +
                "\nAssignments:\n";

        for (Assignment a : assignments) {
            text += "  - " + a.toString() + "\n";
        }

        text += "Registered Students:\n";
        for (Student s : registeredStudents) {
            text += "  - " + s.toSimplifiedString() + "\n";
        }

        text += "Assignment Weights Valid: " + isAssignmentWeightValid();

        return text;
    }
}
