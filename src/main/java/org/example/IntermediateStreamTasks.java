package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateStreamTasks {

    List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
    List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);

    public void CountStringsGreaterThan5(){
        long count=names.stream().filter(x->x!=null && x.length()>5).count();
        System.out.println(count);
    }
    public void FirstElementGreaterThan5(){
        Optional<Integer> first = numbers.stream().filter(x -> x > 5).findFirst();
        System.out.println(first);
    }
public void NumberDivisibleBy5(){
        boolean DivisibleBy5= numbers.stream().anyMatch(x->x%5==0);
    System.out.println(DivisibleBy5);
}

public void CollectToSet(){
    Set<Integer> set=numbers.stream().collect(Collectors.toSet());
    System.out.println(set);
}

public void SkipElement(){
        List<Integer> list=numbers.stream().skip(3).toList();
    System.out.println(list);
}


}
