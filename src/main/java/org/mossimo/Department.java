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

    public Department(String departmentName) {
        if (isDepartmentNamevalid(departmentName)) {
            this.departmentName = toTitleCase(departmentName);
            this.departmentId = String.format("D%02d", nextId++);
        } else {
            this.departmentName = null;
            this.departmentId = null;
        }
    }
    
    public class boolean isDepartmentNameValid(String departmentName) {
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
