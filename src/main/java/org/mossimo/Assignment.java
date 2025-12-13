package org.mossimo;

import lombok.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
public class Assignment {

    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;
    private static int nextId = 1;
  
    public Assignment(String assignmentName, double weight) {
        this.assignmentId = "A" + String.format("%03d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
    }

    /**
     * Calculates and returns the average score for this assignment.
     */
    public double calcAssignmentAvg() {
        if (scores.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (Integer s : scores) {
            if (s != null) {
                sum += s;
            }
        }

        return sum / scores.size();
    }

    /**
     * Generates random scores for each student based on the required rules.
     */
    public void generateRandomScore() {

        for (int i = 0; i < scores.size(); i++) {

            int category = (int) (Math.random() * 11);
            int generatedScore;

            if (category == 0) {
                generatedScore = (int) (Math.random() * 60);
            } else if (category == 1 || category == 2) {
                generatedScore = 60 + (int) (Math.random() * 10);
            } else if (category == 3 || category == 4) {
                generatedScore = 70 + (int) (Math.random() * 10);
            } else if (category >= 5 && category <= 8) {
                generatedScore = 80 + (int) (Math.random() * 10);
            } else { // 9 or 10
                generatedScore = 90 + (int) (Math.random() * 11);
            }

            scores.set(i, generatedScore);
        }
    }

    /**
     * Converts assignment to string.
     */
    @Override
    public String toString() {
        return "Assignment ID: " + assignmentId +
                ", Name: " + assignmentName +
                ", Weight: " + weight;
    }
}
