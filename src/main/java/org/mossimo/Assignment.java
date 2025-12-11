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

            int category = (int) (Math.random() * 11); // 0 to 10
            int generatedScore;

            if (category == 0) {
                generatedScore = (int) (Math.random() * 60); // [0,60)
            } else if
}
