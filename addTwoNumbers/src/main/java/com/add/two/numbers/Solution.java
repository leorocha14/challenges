package com.add.two.numbers;

import com.add.two.numbers.models.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        List<Integer> nodes = new ArrayList<>();
        nodes.add(l1.val);
        ListNode currentNode = l1.next;
        while (currentNode != null) {
            nodes.add(currentNode.val);
            currentNode = currentNode.next;
        }

        List<Integer> reversedNodes = nodes.reversed();

        StringBuffer sb = new StringBuffer();
        reversedNodes.forEach(sb::append);

        Integer firstNumber = Integer.valueOf(sb.toString());

        nodes.clear();

        nodes.add(l2.val);
        currentNode = l2.next;
        while (currentNode != null) {
            nodes.add(currentNode.val);
            currentNode = currentNode.next;
        }

        reversedNodes = nodes.reversed();

        sb = new StringBuffer();
        reversedNodes.forEach(sb::append);

        Integer secondNumber = Integer.valueOf(sb.toString());

        int sumOfTheNumbers = firstNumber + secondNumber;

        char[] sumAsCharArray = String.valueOf(sumOfTheNumbers).toCharArray();

        ListNode sumAsListNode = new ListNode(Integer.parseInt(String.valueOf(sumAsCharArray[sumAsCharArray.length - 1])));

        currentNode = sumAsListNode;
        for (int i = sumAsCharArray.length - 2; i >= 0; i--) {
            currentNode.next = new ListNode();
            currentNode = currentNode.next;
            currentNode.val = Integer.parseInt(String.valueOf(sumAsCharArray[i]));
        }

        return sumAsListNode;
    }
}
