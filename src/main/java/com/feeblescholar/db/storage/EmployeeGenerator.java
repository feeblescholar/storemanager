package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.Employee;
import org.jetbrains.annotations.NotNull;

public class EmployeeGenerator implements ContainerDSLGenerator<Employee> {

    @Override
    public String objectToDSL(@NotNull Employee employee) {
        return "id: " + employee.getID() +
                " # name: " + employee.getName() +
                " # position: " + employee.getPosition() +
                " # salary: " + employee.getSalary() +
                " # hasTaxExemption: " + employee.hasTaxExemption() +
                " # exemptionName: " + employee.getExemptionName() +
                " # dateJoined: " + employee.getDateJoined() +
                " # dateTerminated: " + employee.getDateTerminated();
    }
}
