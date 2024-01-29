package com.sample;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {

        ArrayList<Integer> intArrayList = new ArrayList<>(); // Source
        intArrayList.add(10);
        intArrayList.add(20);
        intArrayList.add(40);
        intArrayList.add(40);
        intArrayList.add(70);
        intArrayList.add(9);
        intArrayList.add(1);
        intArrayList.add(13);
        intArrayList.add(30);// Add Element in sequence
        intArrayList.add(1,15); // add element at specific position, it will sift the existing elements
        System.out.println(intArrayList);
        intArrayList.stream()
                .sorted() // Intermediate Operation
                .filter(n->n%2==0)//Intermediate Operation
                .map(n->n*2) // Intermediate Operation
                .limit(4)// take only 4 elements
                .skip(2) // skip first 2 elements
                .distinct()//Intermediate Operation
                .forEach(ele-> System.out.println(ele)); // Terminal Operation

        double sizeOfList=intArrayList.stream()
                .sorted() // Intermediate Operation
                .filter(n->n%2==0)//Intermediate Operation
                .map(n->n*2) // Intermediate Operation
                .limit(4)// take only 4 elements
                .skip(2) // skip first 2 elements
                .distinct()//Intermediate Operation
                .count(); // Terminal Operation
        System.out.println("Size="+sizeOfList);
        System.out.println("*****");

       Optional<Integer> min= intArrayList.stream()
                .sorted() // Intermediate Operation
                .min((s1,s2)->s1.compareTo(s2)); // Find Min using terminal Operation
        System.out.println(min.get());

        Optional<Integer> max= intArrayList.stream()
                .max(Comparator.naturalOrder()); // Find Max using Terminal Operation
        System.out.println(max.get());

        Optional<Integer> firstValue=intArrayList.stream()
                  .findFirst(); // Find First Element using Terminal Operation
        System.out.println("FiratValue"+firstValue.get());

        Optional<Integer> anyValue=intArrayList.stream()
                .findAny(); // Terminal Operation
        System.out.println("AnyValue"+firstValue.get());

        List<Integer> arrayList=intArrayList.stream()
                .sorted() // Intermediate Operation
                .filter(n->n%2==0)//Intermediate Operation
                .map(n->n*2) // Intermediate Operation
                .limit(4)// take only 4 elements
                .skip(2) // skip first 2 elements
                .distinct()//Intermediate Operation
                .collect(Collectors.toList()); //Terminal Operation
        System.out.println(intArrayList);
        System.out.println(arrayList);

       // Example: we have an array List containing elements [2331,2,12,1345,345], get all elements starting with 1

        ArrayList<String > arrayList1=new ArrayList<>();
        arrayList1.add("2331");
        arrayList1.add("2");
        arrayList1.add("12");
        arrayList1.add("12");
        arrayList1.add("12");
        arrayList1.add("1345");
        arrayList1.add("345");
        System.out.println("Array List "+arrayList1);

        Set<String> newSet=arrayList1.stream()
                .filter(n->n.startsWith("1"))
                .collect(Collectors.toSet());
        System.out.println("SET"+newSet);


        // Get 2nd smallest and 2nd largest no.

        System.out.println("Array List"+intArrayList);

        System.out.println("2nd Smallest"+intArrayList.stream()
                .sorted()
                .skip(1)
                .findFirst().get());

        System.out.println("2nd Largest"+intArrayList.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get());

    }
}
