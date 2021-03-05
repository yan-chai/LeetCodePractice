//https://leetcode.com/problems/reverse-nodes-in-k-group/
package week6;

import Week5.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class ReverseNodesInKGroup {

    public static ListNode solution(ListNode head, int k) {
        // corner case
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode start = head;
        ListNode end = head;
        // append reversed linkedlist to tail
        ListNode tail = dummy;
        int count = k;
        while (start != null) {
            while (count > 1 && end != null) {
                end = end.next;
                count--;
            }
            // not enough node left, just return
            if (end == null) {
                tail.next = start;
                return dummy.next;
            }
            // still enough node reverse(start : end)
            ListNode next = end.next;
            end.next = null;
            // append reversed to tail and update tail
            tail.next = reverse(start);
            tail = start;
            // initial state for next iteration
            start = next;
            end = next;
            count = k;
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode n = solution(n1, 3);
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }
}
