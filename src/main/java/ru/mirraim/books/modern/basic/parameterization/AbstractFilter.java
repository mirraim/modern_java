package ru.mirraim.books.modern.basic.parameterization;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AbstractFilter<T> {

    //фильтрация по всем возможным атрибутам без привязки к классу и типам параметров
    public List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t: list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
