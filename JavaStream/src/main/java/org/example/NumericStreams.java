package org.example;

import java.util.Arrays;
import java.util.List;

public class NumericStreams {
    List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
    List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);

    public void CalculateSumOfList(){

        int sum=numbers.stream().reduce(0,Integer::sum);
        System.out.println(sum);

    }

    public void FindMaxAndMin(){
        int max=numbers.stream().max(Integer::compare).get();
        int min=numbers.stream().min(Integer::compare).get();
        System.out.println("Max is"+max+"----"+"Min is"+min);
    }

    public void CalculateAverage(){
        double average=numbers.stream().mapToDouble(x->x.doubleValue()).average().getAsDouble();
        System.out.println(average);

        // x->x.doubleValue() = Integer::doubleValue
    }


    public void MultiplyAllIntegers(){
        long res=numbers.stream().filter(x->x>0).reduce(1,(a, b) -> a * b);
        System.out.println(res);
    }

public void CountPositive(){
        long num=numbers.stream().filter(x->x>0).count();
    System.out.println(num);
}
}
