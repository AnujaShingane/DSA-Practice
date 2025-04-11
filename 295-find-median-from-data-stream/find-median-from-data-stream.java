class MedianFinder {
    PriorityQueue<Integer> left ;
    PriorityQueue<Integer> right ;
    
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.size() == right.size()){ //coming oddth ele
            right.add(num);
            left.add(right.remove());
        }else{ // eventh ele coming
            left.add(num);
            right.add(left.remove());
        }
    }
    
    public double findMedian() {
        if(left.size() == right.size()){
            return (left.peek() + right.peek())*1.0/2 ;
        }else{
            return left.peek() * 1.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */