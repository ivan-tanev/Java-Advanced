package Company_Roster;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        int n = Integer.parseInt(term.nextLine());
        Map<String, Department> newDepartmentEmployee = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Employee employee;

            String[] parts = term.nextLine().split("\\s+");
            String name = parts[0];
            double salary = Double.parseDouble(parts[1]);
            String position = parts[2];
            String department = parts[3];

            if (parts.length == 4){
                employee = new Employee(name, salary, position, department);

            } else if (parts.length == 6){
                String email = parts[4];
                int age = Integer.parseInt(parts[5]);
                employee = new Employee(name, salary, position, department, email, age);

            } else {
                try {
                    int age = Integer.parseInt(parts[4]);
                    employee = new Employee(name, salary, position, department, age);

                } catch (NumberFormatException myException){
                    String email = parts[4];
                    employee = new Employee(name, salary, position, department, email);

                }
            }

            newDepartmentEmployee.putIfAbsent(department, new Department(department));
            newDepartmentEmployee.get(department).getEmployeeList().add(employee);

        }

        Department maxAverageSalaryDepartment = newDepartmentEmployee.entrySet()
                .stream()
                .max(Comparator.comparingDouble(departmentName -> departmentName.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.println(String.format("Highest Average Salary: %s", maxAverageSalaryDepartment.getName()));
        maxAverageSalaryDepartment.getEmployeeList()
                .stream()
                .sorted((employee1, employee2) -> Double.compare(employee2.getSalary(), employee1.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));
    }
}
