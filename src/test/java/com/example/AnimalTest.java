package com.example;


import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;


public class AnimalTest extends TestCase{
    private Animal animal;
    private static final String UNSUPPORTED_ANIMAL_KIND = "unsupported animal kind";
    private static final String TEXT_EXEPTION = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
    private static final String FAMILY = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void testGetFoodExeption() {
        Throwable throwable = catchThrowable(() -> {
            animal.getFood(UNSUPPORTED_ANIMAL_KIND);
        });
        assertThat(throwable)
                .isInstanceOf(Exception.class)
                .hasMessage(TEXT_EXEPTION);
    }

    @Test
    public void testGetFamily() {
        String actual = animal.getFamily();

        assertEquals("Ответ не соответствует ожидаемому",
                FAMILY, actual);
    }
}