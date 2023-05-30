package ru.skypro.lessons.springboot.webemployee.repository;

import ru.skypro.lessons.springboot.webemployee.pojo.Employee;

import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository{
    private final List<Employee> employeeList = List.of(
            new Employee("Андрей", 50_000),
            new Employee("Никита", 60_000),
            new Employee("Евгений", 70_000),
            new Employee("Антон", 30_000));

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }


}
