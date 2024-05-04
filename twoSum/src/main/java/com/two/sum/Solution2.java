package com.two.sum;

import java.util.*;

/*This solution was an attempt to improve the runtime of the code
* It didn't pass with too many numbers
* Probably was due to the cost of going through a map with more than 10 thousand keys and list with ten thousand positions*/

public class Solution2 {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, List<Integer>> positionsAlreadyCheckedMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> positionsAlreadyChecked = getPositionsAlreadyChecked(positionsAlreadyCheckedMap, i);
            for (int j = 0; j < nums.length; j++) {
                if (validateIfThisPositionWasCheckedBefore(positionsAlreadyChecked, j)) {
                    continue;
                }
                if (validateIfItIsTheSamePosition(i, j)) {
                    continue;
                }
                if (validateIfTargetWasReached(nums, target, i, j)) {
                    return new int[]{i, j};
                }
                addNewPositionsToTheMap(positionsAlreadyChecked, j, positionsAlreadyCheckedMap, i);
            }
        }

        throw new RuntimeException(
                "It was not possible to reach the target with the provided arrays of numbers: " + Arrays.toString(nums));
    }

    private List<Integer> getPositionsAlreadyChecked(Map<Integer, List<Integer>> positionsAlreadyCheckedMap, int i) {
        positionsAlreadyCheckedMap.putIfAbsent(i, new ArrayList<>());
        return positionsAlreadyCheckedMap.get(i);
    }

    private void addNewPositionsToTheMap(
            List<Integer> positionsAlreadyChecked,
            int j,
            Map<Integer, List<Integer>> positionsAlreadyCheckedMap,
            int i) {

        positionsAlreadyChecked.add(j);
        positionsAlreadyCheckedMap.put(i, positionsAlreadyChecked);
        positionsAlreadyCheckedMap.putIfAbsent(j, new ArrayList<>());
        positionsAlreadyCheckedMap.get(j).add(i);
    }

    private boolean validateIfTargetWasReached(int[] nums, int target, int i, int j) {
        return nums[i] + nums[j] == target;
    }

    private boolean validateIfThisPositionWasCheckedBefore(List<Integer> positionsAlreadyChecked, int j) {
        if (positionsAlreadyChecked.isEmpty()) {
            return false;
        }

        List<Integer> sortedPositions = positionsAlreadyChecked.stream().sorted().toList();

        int mid = sortedPositions.size() / 2;

        if (j > mid) {
            return sortedPositions.subList(0, mid).contains(j);
        }

        return sortedPositions.subList(mid, sortedPositions.size() - 1).contains(j);
    }

    private boolean validateIfItIsTheSamePosition(int i, int j) {
        return i == j;
    }
}
