class LRUCache {
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insert(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            insert(node);
            if (map.size() > capacity) {
                Node r = head.next;
                remove(r);
                map.remove(r.key);
            }
        }
        
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        
    }

    public void insert(Node node) {
        Node temp = tail.prev;
        temp.next = node;
        node.prev = temp;

        node.next = tail;
        tail.prev = node;
    }

    public class Node {
        int key;
        int value;

        Node prev;
        Node next;

        public Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }
}
