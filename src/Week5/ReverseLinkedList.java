//https://leetcode.com/problems/reverse-linked-list
package Week5;

import java.util.Stack;

public class ReverseLinkedList {

    //We can use two listNode and sign curr.next = pre;
    //This is the solution i did by myself
    public ListNode solution(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode curr = head;
        stack.push(curr);
        System.out.println("Push: "+curr.val);
        while (curr.next != null) {
            System.out.println("Push: "+curr.next.val);
            stack.push(curr.next);
            curr = curr.next;
        }
        head = curr;
        while (!stack.isEmpty()) {
            System.out.println("Out : "+stack.peek().val);
            curr.next = stack.pop();
            curr = curr.next;
        }
        return head;
    }

    //best approach
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

}
