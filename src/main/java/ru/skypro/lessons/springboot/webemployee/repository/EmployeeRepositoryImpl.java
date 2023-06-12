package ru.skypro.lessons.springboot.webemployee.repository;

import ru.skypro.lessons.springboot.webemployee.pojo.Employee;
import jakarta.annotation.PostConstruct;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class EmployeeRepositoryImpl implements EmployeeRepository{
    private final List<Employee> employeeList = new ArrayList<>();

    @PostConstruct
    public void init() {
        employeeList.add(new Employee("Лиля", 50_000));
        employeeList.add(new Employee("Алиса", 60_000));
        employeeList.add(new Employee("Женя", 70_000));
        employeeList.add(new Employee("Влад", 30_000));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return Collections.unmodifiableList(employeeList);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    @Override
    public void update(int id, Employee employee) {
        int index = -1;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            employeeList.set(index, employee);
        }
    }
    @Override
    public Optional<Employee> findById(int id) {
        return employeeList.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();
    }

    @Override
    public void delete(int id) {
        int index = -1;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            employeeList.remove(index);
        }
    }


}
