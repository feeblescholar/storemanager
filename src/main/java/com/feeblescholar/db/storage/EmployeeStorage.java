package com.feeblescholar.db.storage;

import com.feeblescholar.db.entities.Employee;
import com.feeblescholar.db.entities.EmployeeDTO;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeStorage extends AbstractStorage<Employee> implements StorageCommand<EmployeeDTO> {
    public EmployeeStorage(@NotNull ContainerDSLParser<Employee> parserStrategy,
                           @NotNull ContainerDSLGenerator<Employee> generatorStrategy) {
        super(parserStrategy, generatorStrategy);
    }

    @Override
    public void create(@NotNull EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.updateFromDTO(dto);
        storage.add(employee);
    }

    @Override
    public EmployeeDTO read(@NotNull String uuid) {
        return storage.get(findFirstWithID(uuid)).toDTO();
    }

    @Override
    public List<EmployeeDTO> readAll() {
        return storage.stream().map(Employee::toDTO).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void update(@NotNull String uuid, @NotNull EmployeeDTO dto) {
        storage.get(findFirstWithID(uuid)).updateFromDTO(dto);
    }

    @Override
    public void delete(@NotNull String uuid) {
        storage.remove(findFirstWithID(uuid));
    }
}
