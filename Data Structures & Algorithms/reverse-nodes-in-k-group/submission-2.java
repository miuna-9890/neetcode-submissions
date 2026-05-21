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
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode groupPrev = dummy;

        while(true) {

            ListNode kth = getKth(groupPrev, k);
            if (kth == null) {
                break;
            }

            // reverse node

            ListNode groupNext = kth.next;
            ListNode curr = groupPrev.next;
            ListNode prev = groupNext;

            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode newHead = kth;
            ListNode oldHead = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = oldHead;
        }

        return dummy.next;
    }

    public ListNode getKth(ListNode node, int k) {
        while (k > 0 && node != null) {
            node = node.next;
            k--;
        }
        return node;
    }
}
