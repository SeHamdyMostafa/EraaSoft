package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class OptionalAndMapAndFlatMap {

    List<List<String>> nestedWords = Arrays.asList(
            Arrays.asList("Java", "Stream"),
            Arrays.asList("API", "Lambda"),
            Arrays.asList("FlatMap", "Map")
    );

    List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);

    public void FlattenList(){
        List<String> flat =
                nestedWords.stream()
                        .flatMap(list -> list.stream())
                        .toList();

        System.out.println(flat);
    }

    public void UniqueCharacters(){
        Set<Character> chars =
                names.stream()
                        .filter(x->x!=null)
                        .flatMap(s -> s.chars().mapToObj(c -> (char)c))
                        .collect(Collectors.toSet());
        System.out.println(chars);
    }
public void FilterAndCollectNonEmptyValues(){
    List<String> values =
            names.stream().filter(x->x!=null&& !names.isEmpty()).collect(Collectors.toList());
    System.out.println(values);

}
   public void MapStringsToLengths(){
       List<Integer> lengths =
               names.stream()
                       .filter(x->x!=null&& !names.isEmpty())
                       .map(x->x.length())
                       .toList();
       System.out.println(lengths);
   }


   public void UppercasedStartA(){
       List<String> AUpper  =
               names.stream()
                       .filter(x->x!=null && x.startsWith("A"))
                       .map(x->x.toUpperCase())
                       .toList();
       System.out.println(AUpper);
   }

}


