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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        int size = lists.length;

        for (int i = 0 , j = 0 ; i < size ; i++) {
            if (size == 1) break;

            lists[i] = merge2Lists(lists[j] , lists[j+1]);
            j += 2;

            if (j == size - 1 || j == size){
                if (j == size - 1) {
                    lists[i] = merge2Lists(lists[i] , lists[j]);
                }
                size = i + 1;
                j = 0;
                i = -1;
            }
        }

        return lists[0];
    }

    public ListNode merge2Lists(ListNode list1 , ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = list1 , curr1 = list1 , curr2 = list2;
        if (list1.val > list2.val) {
            head = list2;
            curr2 = curr2.next;
        } else {
            curr1 = curr1.next;
        }
        ListNode curr = head;

        while (curr1 != null && curr2 != null) {
            if (curr1.val < curr2.val) {
                curr.next  =curr1;
                curr1 = curr1.next;
            } else {
                curr.next = curr2;
                curr2 = curr2.next;
            }

            curr = curr.next;
        }

        if (curr1 != null) {
            curr.next = curr1;
        }
        if (curr2 != null) {
            curr.next = curr2;
        }

        return head;
    }
}