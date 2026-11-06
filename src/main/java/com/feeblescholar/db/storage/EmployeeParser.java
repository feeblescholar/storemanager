package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.Employee;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class EmployeeParser implements ContainerDSLParser<Employee> {

    @Override
    public Employee objectFromDSL(@NotNull String dsl) {
        Employee employee = new Employee();
        String[] pairs = dsl.split("#");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":", 2);
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();
            if (value.isEmpty() || value.equalsIgnoreCase("null")) {
                continue;
            }
            switch (key) {
                case "name" -> employee.setName(value);
                case "position" -> employee.setPosition(value);
                case "salary" -> employee.setSalary(Integer.parseInt(value));
                case "hasTaxExemption" -> employee.setHasTaxExemption(Boolean.parseBoolean(value));
                case "exemptionName" -> employee.setExemptionName(value);
                case "dateJoined" -> employee.setDateJoined(LocalDate.parse(value));
                case "dateTerminated" -> employee.setDateTerminated(LocalDate.parse(value));
                default -> throw new IllegalStateException("Unexpected key: " + key);
            }
        }
        return employee;
    }
}
