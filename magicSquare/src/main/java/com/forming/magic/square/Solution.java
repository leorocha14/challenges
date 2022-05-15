package com.forming.magic.square;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

    /* Challenge:
     * https://www.hackerrank.com/challenges/magic-square-forming/problem?isFullScreen=true
     *
     */

class Result {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {

        boolean areEquals = checkSum(s);

        if (areEquals) {
            return 0;
        }

        // for (int i = 0; i < s.size(); i++) {
        //     for (int j = 0; j < s.get(i).size(); j++) {
        //         Integer element = s.get(i).get(j);
        //         if (i == 0) {
                    
        //         }
        //     }
        // }


        return 7;
    }

    private static boolean checkSum(List<List<Integer>> square) {
        int rowOneSum = square.get(0).get(0) + square.get(0).get(1) + square.get(0).get(2);
        
        int rowTwoSum = square.get(1).get(0) + square.get(1).get(1) + square.get(1).get(2);
        int rowThreeSum = square.get(2).get(0) + square.get(2).get(1) + square.get(2).get(2);
        
        int colOneSum = square.get(0).get(0) + square.get(1).get(0) + square.get(2).get(0);
        int colTwoSum = square.get(0).get(1) + square.get(1).get(1) + square.get(2).get(1);
        int colThreeSum = square.get(0).get(2) + square.get(1).get(2) + square.get(2).get(2);
        
        int digOneSum = square.get(0).get(0) + square.get(1).get(1) + square.get(2).get(2);
        int digTwoSum = square.get(0).get(2) + square.get(1).get(1) + square.get(2).get(0);
        
        List<Integer> sumList = Arrays.asList(rowOneSum, rowTwoSum, rowThreeSum, colOneSum, colTwoSum, colThreeSum, digOneSum, digTwoSum);

        return sumList.stream().distinct().findAny().isEmpty();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
