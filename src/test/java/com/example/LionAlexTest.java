package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {

    private LionAlex lionAlex;
    @Mock
    Feline felineMock;

    @Before
    public void init() throws Exception {
        this.lionAlex = new LionAlex(felineMock);
    }

    @Test
    public void checkHasMane() {
        assertTrue("Проверка пола", lionAlex.doesHaveMane());
    }

    @Test
    public void checkGetFriends() {
        assertEquals("Список друзей", List.of("Зебра Марти", "Бегемотиха Глория", "Жираф Мелман"), lionAlex.getFriends());
    }

    @Test
    public void checkGetPlaceOfLiving() {
        assertEquals("Проверка места жительства", "Нью-Йоркский зоопарк", lionAlex.getPlaceOfLiving());
    }

    @Test
    public void checkGetKittens() {
        assertEquals("Проверка котят", 0, lionAlex.getKittens());
    }
}
