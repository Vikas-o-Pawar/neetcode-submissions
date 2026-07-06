class LRUCache {
    Map<Integer, ListNode> map;
    int capacity;
    ListNode head = new ListNode(0, 0);
    ListNode tail = new ListNode(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(); 
        head.next = tail;
        tail.prev = head;   
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        ListNode lruNode = map.get(key);
        moveToStart(lruNode);
        return lruNode.val;
    }
    
    public void put(int key, int value) {
        // the value can exist already, replace it
        if(map.containsKey(key)) {
            ListNode lru = map.get(key);
            lru.val = value;
            moveToStart(lru);
            return;
        }

        // the capacity is complete; remove the node used least
        if(map.size() == capacity) {
            ListNode lru = tail.prev;
            map.remove(lru.key);
            removeLast();
        }

        ListNode nn = new ListNode(key, value);
        map.put(key, nn);
        addToStart(nn);
        return;        
    }

    public void addToStart(ListNode node) {
        ListNode tempHead = head.next;
        head.next = node;
        node.prev = head;

        node.next = tempHead;
        tempHead.prev = node;
    }

    public void moveToStart(ListNode node) {
        if (node.prev == head) return;

        // detach
        node.prev.next = node.next;
        node.next.prev = node.prev;

        // move to front
        addToStart(node);
    }

    public void removeLast() {
        if(tail.prev != head) {
            ListNode newPrev = tail.prev.prev;
            ListNode remPrev = tail.prev;

            newPrev.next = tail;
            tail.prev = newPrev;

            remPrev.prev = remPrev.next = null;            
        }
    }

    public class ListNode {
        int key;
        int val;
        ListNode prev = null;
        ListNode next = null;

        public ListNode(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }
}
