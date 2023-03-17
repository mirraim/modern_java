package ru.mirraim.books.modern.basic.parameterization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.mirraim.books.modern.TestDataFactory;

import java.util.List;

class AbstractFilterTest {

    @Test
    void filterApples() {
        List<Apple> redApples = new AbstractFilter<Apple>()
                .filter(TestDataFactory.inventory(), (Apple apple) -> Color.RED.equals(apple.color()));

        Assertions.assertEquals(2, redApples.size());
    }

    @Test
    void filterNumbers() {
        List<Integer> evenNumbers = new AbstractFilter<Integer>()
                .filter(List.of(3, 8, 15, 169, 318), (Integer i) -> i % 2 == 0);

        Assertions.assertEquals(2, evenNumbers.size());
    }
}