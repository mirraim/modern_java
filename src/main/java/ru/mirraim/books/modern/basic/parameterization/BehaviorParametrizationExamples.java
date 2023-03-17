package ru.mirraim.books.modern.basic.parameterization;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BehaviorParametrizationExamples {

    static class ComparatorExample {
        public static void main(String[] args) {
            List<Apple> apples = new ArrayList<>(List.of(new Apple(Color.GREEN, 150),
                    new Apple(Color.RED, 90),
                    new Apple(Color.GREEN, 200),
                    new Apple(Color.GREEN, 125),
                    new Apple(Color.RED, 84)));

            sortApples(apples, weightComparator());
            System.out.println(apples);

            sortApples(apples, (Apple a1, Apple a2) -> {
                if (a1.color().equals(a2.color())) {
                    return 0;
                }
                return Color.RED.equals(a1.color()) ? 1 : -1;
            });
            System.out.println(apples);
        }

        public static void sortApples(List<Apple> inventory, Comparator<Apple> comparator) {
            inventory.sort(comparator);
        }

        public static Comparator<Apple> weightComparator() {
            return new Comparator<Apple>() {
                @Override
                public int compare(Apple a1, Apple a2) {
                    if (a1.weight() == a2.weight()) {
                        return 0;
                    }

                    return a1.weight() > a2.weight() ? 1 : -1;
                }
            };
        }
    }

    static class RunnableExample {
        public static void main(String[] args) {
            //Анонимный класс
            Thread t = new Thread((new Runnable() {
                @Override
                public void run() {
                    System.out.println("Hello, world");
                }
            }));

            // Лямбда
            Thread thread = new Thread(() -> System.out.println("Hello, world"));
        }
    }

    static class CallableExample {
        public static void main(String[] args) {
            ExecutorService executorService = Executors.newCachedThreadPool();

            //Анонимный класс
            Future<String> threadName = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return Thread.currentThread().getName();
                }
            });

            // Лямбда
            threadName = executorService.submit(() -> Thread.currentThread().getName());
        }
    }

}
