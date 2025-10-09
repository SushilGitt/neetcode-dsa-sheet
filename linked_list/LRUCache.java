
class Node {
    int key, value;
    Node prev, next;

    public Node(int k, int v) {
        key = k;
        value = v;
        prev = null;
        next = null;
    }
}

class LRUCache {

    int cap;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    HashMap <Integer, Node> map;

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    private void addNode(Node n) {
        Node afterHead = head.next;
        n.prev = head;
        n.next = afterHead;
        head.next = n;
        afterHead.prev = n;
    }

    private void deleteNode(Node n) {
        Node prevNode = n.prev;
        Node nextNode = n.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        deleteNode(node);
        addNode(node);

        return node.value;
    }
    
    public void put(int key, int val) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = val;
            deleteNode(node);
            addNode(node);
        }
        else {
            if(cap == map.size()) {
                Node node = tail.prev;
                map.remove(node.key);
                deleteNode(node);
            }

            Node node = new Node(key, val);
            map.put(key, node);
            addNode(node);
        }
    }
}