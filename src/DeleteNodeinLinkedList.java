/*
https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class DeleteNodeinLinkedList {

    /*
    like i did in last semester in "Linked List" lab
     */
    public static void solution(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
