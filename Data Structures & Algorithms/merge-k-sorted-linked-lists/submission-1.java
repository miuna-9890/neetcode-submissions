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
        if (lists.length == 0 || lists == null) {
            return null;
        }
        for (int i = 1; i < lists.length; i++) {
            lists[i] = mergeTwoLists(lists[i], lists[i-1]);
        }
        return lists[lists.length - 1];
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode ans = new ListNode();
        ListNode dummy = ans;
        while (a != null && b != null) {
            if (a.val < b.val) {
                dummy.next = a;
                dummy = dummy.next;
                a = a.next;
            } else {
                dummy.next = b;
                dummy = dummy.next;
                b = b.next;
            }
        }

        if (a != null) {
            dummy.next = a;
        }

        if (b != null) {
            dummy.next = b;
        }

        return ans.next;
    }
}
