package org.example;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Lambda Expressions
        Calculator calculator = (x, y) -> x + y;
        System.out.println(calculator.add(5, 3)); // 8

        FunctionalInterface functionalInterface = new FunctionalInterface();
        System.out.println("PredicateExample");
        functionalInterface.PredicateExample();
        System.out.println("FunctionExample");
        functionalInterface.FunctionExample();
        System.out.println("ConsumerExample");
        functionalInterface.ConsumerExample();
        System.out.println("SupplierExample");
        functionalInterface.SupplierExample();

        BasicStreamOperations basicStreamOperations = new BasicStreamOperations();
        System.out.println("Filter even numbers from a list of integers.");
        basicStreamOperations.EvenNumbers();
        System.out.println("Find names starting with a specific letter from a list of strings.");
        basicStreamOperations.NamesStartWithA();
        System.out.println("Convert all strings to uppercase using stream.");
        basicStreamOperations.UppercaseStrings();
        System.out.println("Sort a list of integers in descending order using streams.");
        basicStreamOperations.SortDescending();
        System.out.println("Remove duplicate elements from a list using distinct().");
        basicStreamOperations.RemoveDuplicates();

        IntermediateStreamTasks intermediateStreamTasks = new IntermediateStreamTasks();
        System.out.println("Count the number of strings longer than 5 characters.");
        intermediateStreamTasks.CountStringsGreaterThan5();
        System.out.println("Find the first element in a stream that matches a given condition.");
        intermediateStreamTasks.FirstElementGreaterThan5();
        System.out.println("Check if any number is divisible by 5 in a list.");
        intermediateStreamTasks.NumberDivisibleBy5();
        System.out.println("Collect elements into a Set instead of a List.");
        intermediateStreamTasks.CollectToSet();
        System.out.println("Skip the first 3 elements and return the rest.");
        intermediateStreamTasks.SkipElement();

        NumericStreams numericStreams = new NumericStreams();
        System.out.println("Calculate the sum of a list of integers using reduce.");
        numericStreams.CalculateSumOfList();
        System.out.println("Find the maximum and minimum value in a list.");
        numericStreams.FindMaxAndMin();
        System.out.println("Calculate the average of a list of doubles..");
        numericStreams.CalculateAverage();
        System.out.println("Multiply all integers in a list together using reduce.");
        numericStreams.MultiplyAllIntegers();
        System.out.println("Count how many numbers are positive in a list.");
        numericStreams.CountPositive();

        CollectorsAndGrouping collectorsAndGrouping = new CollectorsAndGrouping();
        System.out.println("Group a list of students by their department.");
        collectorsAndGrouping.GroupListStudents();
        System.out.println("Partition a list of numbers into even and odd using partitioningBy.");
        collectorsAndGrouping.EvenOdd();
        System.out.println("Create a comma-separated string from a list of strings.");
        collectorsAndGrouping.CommaSeparated();
        System.out.println("Group employees by age and count how many per age.");
        collectorsAndGrouping.GroupEmployeesByAge();
        System.out.println("Find the average salary per department in a list of employees.");
        collectorsAndGrouping.averageSalaryPerDepartment();
    }


}