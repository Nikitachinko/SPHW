package service;

import ru.skypro.lessons.springboot.webemployee.pojo.Employee;
import ru.skypro.lessons.springboot.webemployee.repository.EmployeeRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Integer salarySum() {
        int sumSalary = 0;
        List<Integer> salaryList = employeeRepository.getAllEmployees()
                .stream()
                .map(Employee::getSalary)
                .toList();
        for (Integer salary : salaryList) {
            sumSalary = sumSalary + salary;
        }
        return sumSalary;
    }

    @Override
    public Employee findEmployeeWithMinSalary() {
        return employeeRepository.getAllEmployees()
                .stream()
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee findEmployeeWithMaxSalary() {
        return employeeRepository.getAllEmployees()
                .stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public List<Employee> aboveAverageSalary() {
        int sizeRepository = employeeRepository.getAllEmployees().size();
        int averageSalary = salarySum() / sizeRepository;
        return employeeRepository.getAllEmployees()
                .stream()
                .filter(employee -> employee.getSalary() > averageSalary)
                .collect(Collectors.toList());
    }
}
