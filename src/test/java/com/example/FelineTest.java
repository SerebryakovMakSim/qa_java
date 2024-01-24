package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private Feline feline;
    @Mock
    Feline felineMock;

    @Before
    public void createFeline() {
        this.feline = new Feline();
    }

    @Test
    public void checkEatMeat() throws Exception {
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(felineMock.eatMeat(), feline.eatMeat());
    }

    @Test
    public void checkGetFamily() {
        Mockito.when(felineMock.getFamily()).thenReturn("Кошачьи");
        Assert.assertEquals(felineMock.getFamily(), feline.getFamily());
    }

    @Test
    public void checkGetKittens() {
        Mockito.when(felineMock.getKittens()).thenReturn(1);
        Assert.assertEquals(felineMock.getKittens(), feline.getKittens());
    }

    @Test
    public void checkGetKittensCount() {
        int kittenCount = Mockito.anyInt();
        Mockito.when(felineMock.getKittens(kittenCount)).thenReturn(kittenCount);
        Assert.assertEquals(felineMock.getKittens(kittenCount), feline.getKittens(kittenCount));
    }
}
