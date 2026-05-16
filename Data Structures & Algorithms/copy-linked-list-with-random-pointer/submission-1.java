/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node dummy = head;

        while(dummy != null) {
            Node copy = new Node(dummy.val);
            map.put(dummy, copy);
            dummy = dummy.next;
        }

        dummy = head;

        while(dummy != null) {
            Node copy = map.get(dummy);
            copy.next = map.get(dummy.next);
            copy.random = map.get(dummy.random);
            dummy = dummy.next;
        }

        return map.get(head);



    }
}
