package ru.mirraim.books.modern.basic.parameterization;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ru.mirraim.books.modern.TestDataFactory.inventory;

class AppleFilterTest {
    AppleFilter filter = new AppleFilter();
    @Test
    void filterApplesByColor() {
        assertEquals(3, filter.filterApplesByColor(inventory(), Color.GREEN).size());
        assertEquals(2, filter.filterApplesByColor(inventory(), Color.RED).size());
    }

    @Test
    void filterApplesByWeight() {
        assertEquals(1, filter.filterApplesByWeight(inventory(), 150).size());
        assertEquals(3, filter.filterApplesByWeight(inventory(), 120).size());
    }

    @Test
    void filterApples() {
        assertEquals(3, filter.filterApples(inventory(), new FilterUtils.AppleGreenColorPredicate()).size());
        assertEquals(1, filter.filterApples(inventory(), new FilterUtils.AppleHeavyWeightPredicate()).size());
        assertEquals(0, filter.filterApples(inventory(), new FilterUtils.AppleRedAndHeavyPredicate()).size());
    }

    @Test
    void filter() {
        // Анонимный класс
        FilterUtils.ApplePredicate predicate = new FilterUtils.ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return Color.RED.equals(apple.color());
            }
        };
        assertEquals(2, filter.filterApples(inventory(), predicate).size());

        // Лямбда
        assertEquals(3, filter.filterApples(inventory(), (Apple apple) -> Color.GREEN.equals(apple.color())).size());

        assertEquals(0, filter.filterApples(inventory(), new FilterUtils.AppleRedAndHeavyPredicate()).size());
    }
}