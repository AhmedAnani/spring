package org.EasySchool;


import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
public class Main {
    public static void main(String[] args) {

        var scanner =new Scanner(System.in);
        int num1=scanner.nextInt();
        int num2=scanner.nextInt();
        if(num1>num2){
            System.out.println(num1-num2);
        }else System.out.println("0");
    }
}
       // List<String>s=List.of("hello", "world", "java", "lambda","lambda1","lembda");
//System.out.println(lambda.transformStringLengths(s));
//  lambda.convertAndPrint(s);
//System.out.println(lambda.getCurrentDayNameSupplier());

//        Stream<String> st=s.stream();
//      List<String> sl=  st.filter(a->a.contains("la")).collect(Collectors.toList());
//      sl.forEach(System.out::println);


//        var scanner =new Scanner(System.in);
//        long num1=scanner.nextLong();
//        long num2=scanner.nextLong();
//        long num3=scanner.nextLong();
//        long result=scanner.nextLong();
//        if(num1+num2*num3==result||
//                num1+num2-num3==result||
//                num1-num2*num3==result||
//                num1-num2+num3==result||
//                num1*num2+num3==result||
//                num1*num2-num3==result){
//            System.out.println("YES");
//        }else System.out.println("NO");