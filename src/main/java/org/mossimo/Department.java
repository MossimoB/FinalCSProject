package org.mossimo;

import lombok.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;


@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Department {

    private String departmentId;
    private String departmentName;
    private static int nextId = 1;

    /**
     * Constructor with only departmentName
     * @param departmentName determines that is departmentName is valid, then all fields are set to null
     */
    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentId = String.format("D%02d", nextId++);
        } else {
            this.departmentName = null;
            this.departmentId = null;
        }
    }

    /**
     * Checks if a department name is valid
     * @param departmentName is the name to check
     * @return true if valid, otherwise false
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) {
            return false;
        }

        for (int i = 0; i < departmentName.length(); i++) {
            char c = departmentName.charAt(i);
            if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == ' ')) {
                return false;
            }
        }

        return true;
    }
}
