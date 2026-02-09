package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BasicStreamOperations {

    List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
    List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);

    public void EvenNumbers(){
        List<Integer> EvenNumbers= numbers.stream().filter(x->x%2==0).toList();
        System.out.println(EvenNumbers);

    }

    public void NamesStartWithA(){

        List<String> NamesStartWithA=names.stream().filter(x->x!=null&&x.startsWith("A")).toList();
        System.out.println(NamesStartWithA);


    }

    public void UppercaseStrings(){

        List<String> UppercaseStrings=names.stream().filter(x -> x != null).map(x -> x.toUpperCase()).toList();
        System.out.println(UppercaseStrings);

    }

    public void SortDescending(){

        List<Integer> SortDescending=numbers.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(SortDescending);

    }

    public void RemoveDuplicates(){
        List<Integer> RemoveDuplicates=numbers.stream().distinct().toList();
        System.out.println(RemoveDuplicates);

    }
}
