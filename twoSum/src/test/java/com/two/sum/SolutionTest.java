package com.two.sum;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void shouldReturnFirstAndSecondPositionForTargetNine() {
        int target = 9;
        int[] nums = {2, 7, 11, 15};

        int[] result = solution.twoSum(nums, target);

        assertEquals(Arrays.toString(new int[]{0, 1}), Arrays.toString(result));
    }

    @Test
    public void shouldReturnSecondAndThirdPositionForTargetSix() {
        int target = 6;
        int[] nums = {3, 2, 4};

        int[] result = solution.twoSum(nums, target);


        assertEquals(Arrays.toString(new int[]{1, 2}), Arrays.toString(result));
    }

    @Test
    public void shouldReturnFirstAndSecondPositionForTargetSix() {
        int target = 6;
        int[] nums = {3, 3};

        int[] result = solution.twoSum(nums, target);

        assertEquals(Arrays.toString(new int[]{0, 1}), Arrays.toString(result));
    }

    @Test
    public void shouldReturnOneBeforeLastAndLastPositionsForTargetNineteenThousandNineHundredNinetyNine() {
        int target = 19999;
        int[] nums = new int[10000];
        for (int i = 0; i < 10000; i++) {
            nums[i] = i + 1;
        }

        int[] result = solution.twoSum(nums, target);

        assertEquals(Arrays.toString(new int[]{9998, 9999}), Arrays.toString(result));
    }
}
