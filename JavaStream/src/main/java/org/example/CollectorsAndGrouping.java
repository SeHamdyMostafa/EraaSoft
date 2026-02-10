package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsAndGrouping {
    List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
    List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);
    List<Student> students = Arrays.asList(
            new Student("Ali", "IT", 85),
            new Student("Mona", "CS", 92),
            new Student("Ahmed", "IT", 60),
            new Student("Sara", "CS", 70),
            new Student("Omar", "IS", 45),
            new Student("Laila", "IS", 78)
    );
    List<Employee> employees = Arrays.asList(
            new Employee("Ali", 30, "HR", 5000),
            new Employee("Mona", 25, "IT", 7000),
            new Employee("Ahmed", 30, "HR", 5500),
            new Employee("Sara", 27, "IT", 7200),
            new Employee("Omar", 40, "Finance", 8000),
            new Employee("Laila", 35, "Finance", 8200)
    );

    public void GroupListStudents(){

        Map<String,List<Student>> byDept =
                students.stream()
                        .collect(Collectors.groupingBy(Student::getDepartment));
        System.out.println(byDept);
    }

public void EvenOdd(){
    Map<Boolean,List<Integer>> evenOdd =
            numbers.stream()
                    .collect(Collectors.partitioningBy(x -> x % 2 == 0));
    System.out.println(evenOdd);
}

public void CommaSeparated(){
    String result =
            names.stream()
                    .filter(x->x!=null)
                    .collect(Collectors.joining(", "));
    System.out.println(result);
}

public void GroupEmployeesByAge(){
    Map<Integer, Long> map=employees.stream().collect(Collectors.groupingBy(employee -> employee.getAge(),Collectors.counting()));
    System.out.println(map);
}

public void averageSalaryPerDepartment(){
    Map<String,Double> avgSalary =
            employees.stream()
                    .collect(Collectors.groupingBy(
                            Employee::getDepartment,
                            Collectors.averagingDouble(Employee::getSalary)
                    ));
    System.out.println(avgSalary);
}

 }
