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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null, curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                boolean isFirst = false;
                if (curr == head) isFirst = true;
                while (curr.next != null && curr.val == curr.next.val) curr = curr.next;
                if (isFirst) prev = curr;
                prev.next = curr.next;
                curr = prev.next;
                if (isFirst) head = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return head;
    }
}