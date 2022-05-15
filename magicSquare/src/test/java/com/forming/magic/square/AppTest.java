package com.forming.magic.square;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    @Test
    public void shouldReturnZeroWhenAlreadyIsAMagicSquare() {
        List<List<Integer>> magicSquare = List.of(List.of(8, 3 ,4), List.of(1, 5, 9), List.of(6, 7, 2));
        int result = Result.formingMagicSquare(magicSquare);
        Assert.assertEquals(0, result);
    }

    @Test
    public void shouldReturnSevenWhenFirstInputSquare() {
        List<List<Integer>> magicSquare = List.of(List.of(5, 3 ,4), List.of(1, 5, 8), List.of(6, 4, 2));
        int result = Result.formingMagicSquare(magicSquare);
        Assert.assertEquals(7, result);
    }

    @Test
    public void shouldReturnOneWhenSecondInputSquare() {
        List<List<Integer>> magicSquare = List.of(List.of(4, 9 ,2), List.of(3, 5, 7), List.of(8, 1, 5));
        int result = Result.formingMagicSquare(magicSquare);
        Assert.assertEquals(1, result);
    }
}
