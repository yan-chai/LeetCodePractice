/*
https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {


    /*
     * This is the code write by myself
     * append is the help method
     * Traverse each node of ListNode (L1, L2), add the number
     * of each node, add 1 if more than 10, and add in "result"
     * Node after calculation.
     * Time: O(n^2); Space: O(1);
     * */
    public static void append(ListNode node, ListNode newNode) {
        ListNode temp = node.next;
        if(temp == null) {
            node.next = newNode;
            return;
        }else {
            append(temp, newNode);
        }
    }

    public static ListNode solution(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode temp = null;
        int sum = 0;
        boolean carry = false;
        int v1 = 0;
        int v2 = 0;
        for(;;) {
            if(l1 == null && l2 == null && carry == false) {
                break;
            }
            v1 = l1 == null ? 0 : l1.val;
            v2 = l2 == null ? 0 : l2.val;
            sum = v1 + v2;
            if(carry) {
                sum = sum + 1;
            }
            if(sum > 9) {
                sum = sum % 10;
                carry = true;
            }else {
                carry = false;
            }
            temp = new ListNode(sum);
            if(result == null) {
                result = temp;
            }else {
                append(result, temp);
            }
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null ) {
                l2 = l2.next;
            }
        }
        return result;
    }

    /*
     * This is the code write after I see the solution (dummyHead solution)
     * Time: O(n); Space: O(n);
     * */

    public ListNode bestSolution(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}
