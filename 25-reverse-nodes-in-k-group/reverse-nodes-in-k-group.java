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
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;

        ListNode curr = head , prev = null;
        int i = k , check = 0;

        while (curr != null) {
            curr = reverseGroup(curr , k);
            if (check++ == 0) head = curr;
            else prev.next = curr;

            while (curr != null && i-- > 0) {
                prev = curr;
                curr = curr.next;
            }
            i = k;
        }

        return head;
    }

    public ListNode reverseGroup(ListNode head , int k) {
        int i = k;
        ListNode prev = null , curr = head;
        ListNode next = null;
        if (curr != null) next = curr.next;

        while (curr != null && i > 0) {
            i--;
            curr = curr.next;
        }
        if (i > 0) return head;
        i = k;
        curr = head;

        while (i-- > 0) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (i != 0 ) next = next.next;
        }

        head.next = curr;
        return prev;
    }
}