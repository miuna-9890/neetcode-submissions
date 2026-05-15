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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode secondHalf = new ListNode();

        while (fast != null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        secondHalf = slow.next;
        slow.next = null; //disconnect

        //reverse

        ListNode prev = null;
        ListNode curr = secondHalf;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode reversed = prev;
        ListNode first = head;

        while (reversed != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = reversed.next;

            first.next = reversed;
            reversed.next = temp1;

            first = temp1;
            reversed = temp2;
        }
        
    }
}
