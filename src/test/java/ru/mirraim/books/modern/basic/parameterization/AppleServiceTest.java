package ru.mirraim.books.modern.basic.parameterization;

import org.junit.jupiter.api.Test;
import ru.mirraim.books.modern.TestDataFactory;

class AppleServiceTest {
    private AppleService appleService = new AppleService();

    @Test
    void printApple() {
        appleService.prettyPrintApple(TestDataFactory.inventory(), new AppleService.AppleWeightPrinter());
        System.out.println("__________________________________________");
        appleService.prettyPrintApple(TestDataFactory.inventory(), new AppleService.AppleWeightAndDescriptionPrinter());

    }

}