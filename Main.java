package org.example;

import java.util.*;

class Employee {
    private String id;
    private String name;
    private double salary;
    private String department;

    public Employee(String id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Salary: " + salary + ", Department: " + department;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("100", "Surya Aanand", 50000, "HR"),
                new Employee("101", "Manjima A T", 50000, "HR"),
                new Employee("102", "Pranav Nair", 50000, "Finance"),
                new Employee("103", "Jyothi J", 50000, "IT"),
                new Employee("101", "Manjima A T", 50000, "HR"),
                new Employee("103", "Jyothi J", 50000, "IT")

        );


        Set<String> employeeIDs = employees.stream()
                .map(Employee::getId)
                .collect(HashSet::new, HashSet::add, HashSet::addAll);


        List<String> sortedEmployeeIDs = employeeIDs.stream()
                .sorted(Comparator.reverseOrder())
                .toList();


        Map<String, Employee> employeeMap = employees.stream()
                .collect(HashMap::new, (map, emp) -> map.put(emp.getId(), emp), HashMap::putAll);


        sortedEmployeeIDs.forEach(id -> {
            Employee emp = employeeMap.get(id);
            if (emp != null) {
                System.out.println(emp);
            }
        });
    }
}
