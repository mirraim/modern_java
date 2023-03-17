package ru.mirraim.books.modern.basic.parameterization;

import java.util.ArrayList;
import java.util.List;

import static ru.mirraim.books.modern.basic.parameterization.Color.GREEN;

public class AppleFilter {
    //private List<Apple> inventory;

    //фильтрация зеленых яблок
    public List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (GREEN.equals(apple.color())) {
                result.add(apple);
            }
        }
        return result;
    }

    //параметризация цвета.
    public List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (apple.color().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    //параметризация веса.
    public List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (apple.weight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    //фильтрация по всем возможным атрибутам. Говнокод, так не делать
    public List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if ((flag && apple.color().equals(color)) || (!flag && apple.weight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    //фильтрация по всем возможным атрибутам
    public List<Apple> filterApples(List<Apple> inventory, FilterUtils.ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
