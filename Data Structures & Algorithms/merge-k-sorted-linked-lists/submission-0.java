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
        if (lists.length == 0) {
            return null;
        }
        ListNode merged = lists[0];
        for (int i = 1; i < lists.length; i++) {
            merged = mergeTwoLists(merged, lists[i]);
        }
        return merged;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(1);
        ListNode ans = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ans.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                ans.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            ans = ans.next;
        }
        if (l1 != null) {
            ans.next = l1;
        } 

        if (l2 != null) {
            ans.next = l2;
        }  
        return dummy.next;     
    }
}
