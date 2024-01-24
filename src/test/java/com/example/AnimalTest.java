package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class AnimalTest {

    private Animal animal;
    private final String animalKind;
    private final List<String> foods;

    public AnimalTest(String animalKind, List<String> foods) {
        this.animalKind = animalKind;
        this.foods = foods;
    }

    @Parameterized.Parameters(name = "Вид животного = {0}, еда/ошибка = {1}")
    public static Object[][] data() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Насекомое", List.of("Неизвестный вид животного, используйте значение Травоядное или Хищник")}
        };
    }

    @Before
    public void createAnimal() {
        this.animal = new Animal();
    }

    @Test
    public void checkGetFood() {
        try {
            Assert.assertEquals(foods, animal.getFood(animalKind));
        } catch (Exception ex) {
            Assert.assertEquals(foods.get(0), ex.getMessage());
        }
    }

    @Test
    public void getFamily() {
        Assert.assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }
}
