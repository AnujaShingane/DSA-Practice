class MyCircularQueue {
    Deque<Integer> dq;
    int k;

    public MyCircularQueue(int k) {
        this.k = k;
        dq = new ArrayDeque<>();
    }
    
    public boolean enQueue(int value) {
        if(dq.size() < k){
            dq.addLast(value);
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if(dq.isEmpty())return false;
        dq.removeFirst();
        return true;
    }
    
    public int Front() {
        if(dq.isEmpty())return -1;
        int ele = dq.peekFirst();
        return ele;
    }
    
    public int Rear() {
        if(dq.isEmpty())return -1;
        int ele = dq.peekLast();
        return ele;
    }
    
    public boolean isEmpty() {
        if(dq.isEmpty())return true;
        return false;
    }
    
    public boolean isFull() {
        if(dq.size() == k)return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */