package com.add.two.numbers;

import com.add.two.numbers.models.ListNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void shouldReturnSevenZeroAndEight() {
        ListNode listOne = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode listTwo = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode expected = new ListNode(7, new ListNode(0, new ListNode(8)));

        ListNode result = solution.addTwoNumbers(listOne, listTwo);

        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnZero() {
        ListNode listOne = new ListNode(0);
        ListNode listTwo = new ListNode(0);

        ListNode expected = new ListNode(0);

        ListNode result = solution.addTwoNumbers(listOne, listTwo);

        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnEightNineNineNineZeroZeroZeroAndOne() {
        ListNode listOne = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode listTwo = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        ListNode expected = new ListNode(8, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1))))))));

        ListNode result = solution.addTwoNumbers(listOne, listTwo);

        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnOneZeroZeroZeroZeroZeroZeroZeroZeroZero() {
        ListNode listOne = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        ListNode listTwo = new ListNode(9);

        ListNode expected = new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1)))))))))));

        ListNode result = solution.addTwoNumbers(listOne, listTwo);

        assertEquals(expected, result);
    }
}
