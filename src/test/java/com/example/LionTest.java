package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

    final private String lionSex;
    final private boolean hasMane;
    private Feline feline;
    Lion lion;
    @Mock
    Feline felineMock;

    public LionTest(String lionSex, boolean hasMane) {
        this.lionSex = lionSex;
        this.hasMane = hasMane;
    }

    @Before
    public void createLion() {
        this.feline = new Feline();
        MockitoAnnotations.initMocks(this);
    }

    @Parameterized.Parameters(name = "Пол = {0}, male = {1}")
    public static Object[][] data() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
                {"Детеныш", true}
        };
    }

    @Test
    public void checkHaveMane() {
        try {
            lion = new Lion(lionSex, feline);
            boolean current = lion.doesHaveMane();
            Assert.assertEquals(hasMane, current);
        } catch (Exception ex) {
            Assert.assertEquals("Используйте допустимые значения пола животного - Самец или Самка", ex.getMessage());
        }
    }

    @Test
    public void lionGetKittens() {
        try {
            lion = new Lion(lionSex, feline);
            Assert.assertEquals(1, lion.getKittens());
        } catch (Exception ex) {
            Assert.assertEquals("Используйте допустимые значения пола животного - Самец или Самка", ex.getMessage());
        }
    }

    @Test
    public void checkGetFood() {
        try {
            lion = new Lion(lionSex, feline);
            Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            List<String> expected = felineMock.getFood("Хищник");
            List<String> current = lion.getFood();
            Assert.assertEquals(expected, current);
        } catch (Exception ex) {
            Assert.assertEquals("Используйте допустимые значения пола животного - Самец или Самка", ex.getMessage());
        }
    }
}
