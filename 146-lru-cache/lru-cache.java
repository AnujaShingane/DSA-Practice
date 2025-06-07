class Node{
    int key,value;
    Node prev,next;

    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    Map<Integer,Node> map = new HashMap<>();
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(map.get(key));
            insertAfterHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key,value);
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }
        insertAfterHead(node);
    }

    void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void insertAfterHead(Node node){
        map.put(node.key,node);
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */