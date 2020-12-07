package com.sample.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileReadWriteOnSameFile {
  class Employee {
    String name;
    int id;
    double salary;

    public Employee(final String name, final int id, final double salary) {
      this.name = name;
      this.id = id;
      this.salary = salary;
    }
  }

  public void writeToFile(List<Employee> employees, String fileName) {
    try (BufferedWriter fw = new BufferedWriter(new FileWriter(fileName))) {
      for (Employee employee : employees) {
        StringBuilder employeeString = new StringBuilder();
        employeeString.append(employee.name).append(" ");
        employeeString.append(employee.id).append(" ");
        employeeString.append(employee.salary);
        fw.write(employeeString.toString() + "\n");
      }
    } catch (Exception e) {
      System.out.println("Exception occurred while writing employees to file" + e);
    }
  }

  public List<Employee> readFromFile(String fileName) {
    List<Employee> employees = new ArrayList<>();

    try (BufferedReader fr = new BufferedReader(new FileReader(fileName))) {
      while (true) {
        String employeeString = fr.readLine();
        if (employeeString == null) break;
        String[] employee = employeeString.split(" ");
        Employee emp =
            new Employee(
                employee[0], Integer.parseInt(employee[1]), Double.parseDouble(employee[2]));
        employees.add(emp);
      }

    } catch (Exception e) {
      System.out.println("Exception occurred while reading employees from file" + e);
    }
    return employees;
  }

  public static void main(String[] args) {
    FileReadWriteOnSameFile f = new FileReadWriteOnSameFile();
    f.readWriteFile();
  }

  public void readWriteFile() {
    Employee emp1 = new Employee("Prabhu1", 123, 200000.90);
    Employee emp2 = new Employee("Prabhu2", 456, 300000.90);
    writeToFile(List.of(emp1, emp2), "out.txt");
    List<Employee> employees = readFromFile("out.txt");
    for (Employee employee : employees) {
      System.out.println(employee.name + " " + employee.id + " " + employee.salary);
    }
  }
}
