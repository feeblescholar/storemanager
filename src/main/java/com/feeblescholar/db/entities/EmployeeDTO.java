package com.feeblescholar.db.entities;

import java.time.LocalDate;

public record EmployeeDTO(String id, String name, String position, int salary, boolean hasTaxExemption,
                          String exemptionName, LocalDate dateJoined, LocalDate dateTerminated) {}