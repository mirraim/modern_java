package ru.mirraim.books.modern.basic.parameterization;

import java.util.List;

public class AppleService {

    public void prettyPrintApple(List<Apple> inventory, ApplePrinter printer) {
        for (Apple apple: inventory) {
            printer.print(apple);
        }
    }

    public interface ApplePrinter {
        void print(Apple apple);
    }

    public static class AppleWeightPrinter implements ApplePrinter{
        public void print(Apple apple) {
            System.out.println("An apple of " + apple.weight() + " g");
        }
    }

    public static class AppleWeightAndDescriptionPrinter implements ApplePrinter{
        public void print(Apple apple) {
            String description = apple.weight() > 150 ? "heavy " : "light ";
            System.out.println("A " + description + apple.color() + " apple");
        }
    }
}
