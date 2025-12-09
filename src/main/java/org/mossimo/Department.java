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
    
    public class boolean isDepartmentNameValid(departmentName String) {
        
    }
}
