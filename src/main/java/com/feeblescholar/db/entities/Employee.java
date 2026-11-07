package com.feeblescholar.db.entities;

import java.time.LocalDate;

public class Employee extends AbstractEntity implements Transferable<EmployeeDTO> {
    private String name;
    private String position;
    private int salary;
    private boolean hasTaxExemption;
    private String exemptionName;
    private LocalDate dateJoined;
    private LocalDate dateTerminated;

    public Employee() {
        super();
    }

    public Employee(String name, String position, int salary, boolean hasTaxExemption, String exemptionName,
                    LocalDate dateJoined, LocalDate dateTerminated) {
        super();
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.hasTaxExemption = hasTaxExemption;
        this.exemptionName = exemptionName;
        this.dateJoined = dateJoined;
        this.dateTerminated = dateTerminated;
    }

    @Override
    public EmployeeDTO toDTO() {
        return new EmployeeDTO(id, name, position, salary, hasTaxExemption, exemptionName, dateJoined, dateTerminated);
    }

    @Override
    public void updateFromDTO(EmployeeDTO employeeDTO) {
        name = employeeDTO.name();
        position = employeeDTO.position();
        salary = employeeDTO.salary();
        hasTaxExemption = employeeDTO.hasTaxExemption();
        exemptionName = employeeDTO.exemptionName();
        dateJoined = employeeDTO.dateJoined();
        dateTerminated = employeeDTO.dateTerminated();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean hasTaxExemption() {
        return hasTaxExemption;
    }

    public void setHasTaxExemption(boolean hasTaxExemption) {
        this.hasTaxExemption = hasTaxExemption;
    }

    public String getExemptionName() {
        return exemptionName;
    }

    public void setExemptionName(String exemptionName) {
        this.exemptionName = exemptionName;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    public LocalDate getDateTerminated() {
        return dateTerminated;
    }

    public void setDateTerminated(LocalDate dateTerminated) {
        this.dateTerminated = dateTerminated;
    }
}
