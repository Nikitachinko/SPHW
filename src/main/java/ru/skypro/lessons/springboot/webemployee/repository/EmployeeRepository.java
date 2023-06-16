package ru.skypro.lessons.springboot.webemployee.repository;

import ru.skypro.lessons.springboot.webemployee.pojo.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
     List<Employee> getAllEmployees();
    Employee addEmployee(Employee employee);
     void update(int id, Employee employee);
     Optional<Employee> findById(int id);
     void delete(int id);
}
