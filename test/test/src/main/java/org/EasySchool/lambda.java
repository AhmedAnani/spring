package org.EasySchool;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class lambda {
    public static List<Integer> transformStringLengths(List<String> strings)  {

        // Define a lambda expression using the Function functional interface
        Function<String,Integer> function= num->num.length();
        List<Integer>list= new ArrayList<>();
        for (String s:strings){
            list.add(function.apply(s));
        }
        // Apply the lambda expression to each string in the list
        //return function;
        return list;
    }
    public static List<Integer> incrementList(List<Integer> numbers, int incrementValue) {

        // Define a lambda expression using the UnaryOperator functional interface
        UnaryOperator<Integer> unaryOperator= num->num+incrementValue;
        // Apply the lambda expression to each integer in the list
        List<Integer>l=new ArrayList<>();
            for (int i:numbers){
                l.add(unaryOperator.apply(i));
            }
            return l;
    }
    public static void convertAndPrint(List<String> inputString) {

        Consumer<String> consumer=s-> System.out.println(s.toUpperCase());
        inputString.forEach(consumer);
    }

    public static String getCurrentDayNameSupplier() {

        // Write your logic below
        Supplier<String> stringSupplier=() -> LocalDate.now().getDayOfWeek().toString();
        return stringSupplier.get();
    }
}
