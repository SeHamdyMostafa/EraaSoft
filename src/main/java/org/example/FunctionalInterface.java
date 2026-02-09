package org.example;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterface {

    public void PredicateExample(){
        Predicate<Integer> predicate = x  -> x>10==true;
        System.out.println(predicate.test(15));
    }



    public void FunctionExample(){
        Function<String ,Integer> function=x-> x.length();
        System.out.println(function.apply("Hamdi"));
    }

    public void ConsumerExample(){
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("Hello");
    }

    public void SupplierExample(){
        Supplier<Double> supplier = () -> Math.random();
        System.out.println(supplier.get());
    }

}
