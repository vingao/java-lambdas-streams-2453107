package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Greeting greeting = new HelloWorldGreeting();
        greeting.sayHello();

        Greeting greeting2 = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello World");
            }
        };
        greeting2.sayHello();

        Greeting greeting3 = () -> System.out.println("Hello World");
        greeting3.sayHello();

        IntBinaryOperator calculator = (int x, int y) -> {
            Random random = new Random();
            int randomNumber = random.nextInt(50);

            return x * y + randomNumber;
        };
        System.out.println(calculator.applyAsInt(10, 20));

        Integer[] scores = new Integer[]{80, 66, 73, 92, 43};
        Stream<Integer> scoresStream = Arrays.stream(scores);

        List<String> shoppingList = new ArrayList<>();
        shoppingList.add("coffee");
        shoppingList.add("bread");
        shoppingList.add("pineapple");
        shoppingList.add("milk");
        shoppingList.add("pasta");

        List<String> sortedShoppingList = shoppingList.stream()
                .sorted()
                .map(s -> s.toUpperCase())
                .filter(s -> !s.startsWith("C"))
                .collect(Collectors.toList());
        System.out.println(sortedShoppingList);

        System.out.println(shoppingList);

        Stream<String> lettersStream = Stream.of("a", "b", "c");
    }
}
