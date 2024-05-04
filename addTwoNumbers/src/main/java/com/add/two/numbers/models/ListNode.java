package com.add.two.numbers.models;

import java.util.Objects;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     public ListNode(int val) { this.val = val; }
     public ListNode(int val, ListNode next) { this.val = val; this.next = next; }


     @Override
     public String toString() {
          if (next == null) return String.valueOf(val);
          return  val + "," + next;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          ListNode listNode = (ListNode) o;
          return val == listNode.val && Objects.equals(next, listNode.next);
     }

     @Override
     public int hashCode() {
          return Objects.hash(val, next);
     }
}
