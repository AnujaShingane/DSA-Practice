class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    
    public MedianFinder() {
        right = new PriorityQueue<>();
        left = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(left.size() == right.size()){  //odd element
            right.add(num);
            left.add(right.remove());
        }else{  //even element
            left.add(num);
            right.add(left.remove());
        }
    }
    
    public double findMedian() {
        if(left.size() == right.size()){  //even no of elements
            return (left.peek()+right.peek())/2.0;
        }else{  // odd no of elements
            return left.peek()*1.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */