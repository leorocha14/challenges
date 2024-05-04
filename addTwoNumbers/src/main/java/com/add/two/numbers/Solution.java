package com.add.two.numbers;

import com.add.two.numbers.models.ListNode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        List<BigInteger> firstNodeIntegerList = getNodeListAsIntegerList(l1);
        BigInteger firstNumber = getAllPositionAsSingleNumber(firstNodeIntegerList);

        List<BigInteger> secondNodeIntegerList = getNodeListAsIntegerList(l2);
        BigInteger secondNumber = getAllPositionAsSingleNumber(secondNodeIntegerList);

        BigInteger sumOfTheNumbers = firstNumber.add(secondNumber);

        return getSumAsListNode(sumOfTheNumbers);
    }

    private ListNode getSumAsListNode(BigInteger sumOfTheNumbers) {
        char[] sumAsCharArray = sumOfTheNumbers.toString().toCharArray();

        ListNode sumAsListNode = new ListNode(getIntParsedChar(sumAsCharArray[sumAsCharArray.length - 1]));

        ListNode currentNode = sumAsListNode;
        for (int i = sumAsCharArray.length - 2; i >= 0; i--) {
            currentNode.next = new ListNode();
            currentNode = currentNode.next;
            currentNode.val = getIntParsedChar(sumAsCharArray[i]);
        }
        return sumAsListNode;
    }

    private int getIntParsedChar(char character) {
        return Integer.parseInt(String.valueOf(character));
    }

    private BigInteger getAllPositionAsSingleNumber(List<BigInteger> integerNodeList) {

        StringBuilder stringBuilder = new StringBuilder();
        integerNodeList.forEach(stringBuilder::append);

        StringBuilder reversedNumberAsString = stringBuilder.reverse();

        return new BigInteger(reversedNumberAsString.toString());
    }

    private List<BigInteger> getNodeListAsIntegerList(ListNode listNode) {
        List<BigInteger> nodes = new ArrayList<>();
        nodes.add(BigInteger.valueOf(listNode.val));
        ListNode currentNode = listNode.next;
        while (currentNode != null) {
            nodes.add(BigInteger.valueOf(currentNode.val));
            currentNode = currentNode.next;
        }
        return nodes;
    }
}
