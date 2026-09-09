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

        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode result = lists[0];

        for (int i = 1; i < lists.length; i++) {
            result = merge(result, lists[i]);
        }

        return result;
    }

    ListNode merge(ListNode l1, ListNode l2) {

        ListNode temp = new ListNode(0);
        ListNode end = temp;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                end.next = l1;
                l1 = l1.next;
            } else {
                end.next = l2;
                l2 = l2.next;
            }

            end = end.next;
        }

        if (l1 != null) {
            end.next = l1;
        }

        if (l2 != null) {
            end.next = l2;
        }

        return temp.next;
    }
}