package ru.mirraim.books.modern.basic.parameterization;

public class FilterUtils {
    public interface  ApplePredicate{
        boolean test(Apple apple);
    }

    public static class AppleHeavyWeightPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return apple.weight() > 150;
        }
    }

    public static class AppleGreenColorPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return Color.GREEN.equals(apple.color());
        }
    }

    public static class AppleRedAndHeavyPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return Color.RED.equals(apple.color()) && apple.weight() > 150;
        }
    }
}
