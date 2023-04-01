/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.3.2023 г.
 * Time: 8:15
 */
package P12_02CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfEmploys = Integer.parseInt(scanner.nextLine());
        List<Employee> employeeList = new ArrayList<>();
        List<String> departments = new ArrayList<>();

        for (int i = 0; i < numberOfEmploys; i++) {
            String[] inputs = scanner.nextLine().split("\\s+");

            if (inputs.length <= 4) {
                String name = inputs[0];
                double salary = Double.parseDouble(inputs[1]);
                String position = inputs[2];
                String department = inputs[3];
                departments.add(department);

                Employee currentEmployee = new Employee(name, salary, position, department);
                employeeList.add(currentEmployee);

            } else if (inputs.length == 5) {
                String name = inputs[0];
                double salary = Double.parseDouble(inputs[1]);
                String position = inputs[2];
                String department = inputs[3];
                String email = inputs[4];
                departments.add(department);

                Employee currentEmployee = new Employee(name, salary, position, department, email);
                employeeList.add(currentEmployee);

            } else if (inputs.length == 6) {
                String name = inputs[0];
                double salary = Double.parseDouble(inputs[1]);
                String position = inputs[2];
                String department = inputs[3];
                String email = inputs[4];
                int age = Integer.parseInt(inputs[5]);
                departments.add(department);

                Employee currentEmployee = new Employee(name, salary, position, department, email, age);
                employeeList.add(currentEmployee);
            }
        }

        String highDepartment = "";
        double average = 0;

        for (String department : departments) {
            int numberOfEmploysInThatDepartment = 0;
            double sum = 0;

            for (Employee employee : employeeList) {
                if (employee.getDepartment().equals(department)) {
                    numberOfEmploysInThatDepartment++;
                    sum += employee.getSalary();
                }
            }

            double tempAverage = sum / numberOfEmploysInThatDepartment;

            if (tempAverage > average) {
                average = tempAverage;
                highDepartment = department;
            }
        }

        String finalHighDepartment = highDepartment;
        List<Employee> sort = employeeList.stream()
                .filter(x-> x.getDepartment().contains(finalHighDepartment))
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        System.out.printf("Highest Average Salary: %s%n", finalHighDepartment);
        for (Employee employee : sort) {
            System.out.println(employee.toString());
        }
    }
}
