package de.neuefische.group1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> listOfNumbers = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(7);
            add(8);
            add(0);
        }};

        List<Integer> listOfEvenNumbers = listOfNumbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * 2)
                .sorted()
                .collect(Collectors.toList());

        listOfEvenNumbers.forEach(System.out::println);

        int sumOfNumbers = listOfEvenNumbers.stream()
                .reduce(0, Integer::sum);

        System.out.println(sumOfNumbers);

    }
}