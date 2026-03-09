package ie.atu.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Java Streams!");

        System.out.println();
        System.out.println("Task 2");

        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        nums.stream()
             .filter(num -> num % 2 != 0)
             .forEach(num -> System.out.println(num + " "));

        System.out.println();
        System.out.println("Task 3");

        List<String> fruits = Arrays.asList("apple", "banana", "grape", "kiwi","orange","mango");

        List<String> filteredFruits = fruits.stream()
                .filter(fruit -> fruit.length()>4)
                .sorted()
                .collect(Collectors.toList());

        filteredFruits.forEach(fruit -> System.out.println(fruit.toUpperCase()));


        
        System.out.println();
        System.out.println("Task 4");

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        
        numbers.stream()
            .map(NumberUtils::doubleNumber)
            .forEach(System.out::println);

        System.out.println();
        System.out.println("Task 5");

        List<Integer> nomer = Arrays.asList(2,4,6,8,10);

        int min = nomer.stream()
                        .reduce(Integer.MAX_VALUE, (a,b) -> Math.min(a,b));
                        System.out.println("Min Value: " + min);

        int product = nomer.stream()
                            .reduce(1, (a,b) -> a * b);
                            System.out.println("Product: " + product);

        
        System.out.println();
        System.out.println("Task 6");

        String inputPath = "resources/input.txt";

        try(Stream<String> lines = Files.lines(Paths.get(inputPath))){
            lines.filter(line -> line.contains("drag"))
                    .map(String::trim)
                    .forEach(line -> System.out.println(line));
        }catch (IOException e){
            System.err.println("Error reading file: " + e.getMessage());
        }



    }
}
