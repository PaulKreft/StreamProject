package de.neuefische.group1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
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

        // ----------------------------------------------------------------------------------
        // Bonus

        System.out.println();

        try (Stream<String> stream = Files.lines(Paths.get(Main.class.getResource("/students.csv").toURI()))) {
            stream
                    .skip(1)
                    .filter(line -> !line.isEmpty())
                    .distinct()
                    .map(student -> {
                        String[] studentData = student.split(",");
                        return new Student(Integer.parseInt(studentData[0]), studentData[1], studentData[2], Integer.parseInt(studentData[3]));
                    })
                    .forEach(System.out::println);
        }
    }
}