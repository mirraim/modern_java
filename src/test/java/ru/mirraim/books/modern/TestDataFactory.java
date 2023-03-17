package ru.mirraim.books.modern;

import ru.mirraim.books.modern.basic.parameterization.Apple;

import java.util.List;

import static ru.mirraim.books.modern.basic.parameterization.Color.GREEN;
import static ru.mirraim.books.modern.basic.parameterization.Color.RED;

public class TestDataFactory {

    public static List<Apple> inventory() {
        return List.of(new Apple(GREEN, 150),
                new Apple(RED, 90),
                new Apple(GREEN, 200),
                new Apple(GREEN, 125),
                new Apple(RED, 84));
    }
}
